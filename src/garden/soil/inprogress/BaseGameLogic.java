package garden.soil.inprogress;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import garden.soil.unfiled.ActorParameters;
import garden.soil.unfiled.ProcessManager;
import garden.soil.unfiled.Process;
import garden.soil.mathphysics.RandomNumberGenerator;
import garden.soil.mathphysics.UnsignedInteger;
import garden.soil.interfaces.IActor;
import garden.soil.interfaces.IGameLogic;
import garden.soil.interfaces.IGamePhysics;
import garden.soil.interfaces.IGameView;

public abstract class BaseGameLogic implements IGameLogic {

	protected GameCodeApp parent;
	protected ProcessManager processManager;
	protected RandomNumberGenerator randomNum;
	protected List<IGameView> gameViews;
	protected Map<UnsignedInteger,IActor> actorList;
	protected int lastActorId;
	protected BaseGameState currentState;
	protected int expectedPlayers;
	protected int expectedRemotePlayers;
	protected int expectedAI;
	protected PathingGraph pathingGraph;
	//protected EventListenerPtr AIEventListener;
	protected boolean amProxy;
	protected int remotePlayerId;
	protected boolean renderDiagnostics;
	protected IGamePhysics physics;
	
	public BaseGameLogic(GameCodeApp newParent, Map<String,Object> gameObjects)
	{
		parent = newParent;
		lastActorId = 0;
		processManager = new ProcessManager();
		randomNum = new RandomNumberGenerator();
		randomNum.Randomize();
		currentState = BaseGameState.BGS_Initializing;
		amProxy = false;
		renderDiagnostics = false;
		expectedPlayers = 0;
		expectedRemotePlayers = 0;
		expectedAI = 0;
		pathingGraph = PathingGraph.createPathingGraph();
		//AIEventListener;
		
	}
	
	@Override
	public void close()
	{
		gameViews.clear();
		if(processManager != null)
		{
			processManager.close();
		}
		//release actors in subclass
	}
	
	@Override
	public IActor getActor(UnsignedInteger actorId) {
		return actorList.get(actorId);
	}

	@Override
	public boolean addActor(IActor newActor, ActorParameters params) {
		if(newActor.getId() == null || this.getActor(newActor.getId()) != null)
		{
			return false;
		}
		actorList.put(newActor.getId(), newActor);
		return true;
	}

	@Override
	public boolean moveActor(UnsignedInteger actorId, Mat4x4 mat) {
		IActor toMove = actorList.get(actorId);
		if(toMove != null)
		{
			toMove.setMatrix(mat);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeActor(UnsignedInteger actorId) {
		if(amProxy)
		{
			return false;
		}
		if(this.getActor(actorId) != null)
		{
			physics.removeActor(actorId);
			actorList.remove(actorId);
			return true;
		}
		return false;
	}

	@Override
	public boolean loadGame(String gameName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onUpdate(float time, float elapsedTime) {
		int deltaMilliseconds = (int) (elapsedTime * 1000.0f);
		switch(currentState)
		{
			case BGS_Initializing:
				this.changeState(BaseGameState.BGS_MainMenu);
				break;
				
			case BGS_LoadingGameEnvironment:
				if(parent.loadGame())
				{
					this.changeState(BaseGameState.BGS_SpawnAI);
				}
				else
				{
					parent.abortGame();
				}
				break;
				
			case BGS_WaitingForPlayers:
				break;
				
			case BGS_Running:
				processManager.updateProcesses(deltaMilliseconds);
				break;
				
			case BGS_MainMenu:
				break;
				
			case BGS_SpawnAI:
				if(this.expectedAI == 0)
				{
					this.changeState(BaseGameState.BGS_Running);
				}
				break;
				
			default:
				//TODO: include exception for unknown state
		}
		
		for(int index = 0; index < gameViews.size(); index++)
		{
			gameViews.get(index).onUpdate(deltaMilliseconds);
		}
		//TODO: trigger update event for everyone else, like script functions
	}

	@Override
	public void changeState(BaseGameState newState) {
		if(newState == BaseGameState.BGS_WaitingForPlayers)
		{
			//remove main menu
			gameViews.remove(0);
			
			//Note: split screen support would require this to change
			expectedPlayers = 1;
			expectedRemotePlayers = parent.getOptions().getExpectedPlayers() - 1;
			expectedAI = parent.getOptions().getNumAIs();
			
			if(parent.getOptions().getGameHost().length() > 0)
			{
				this.setProxy(true);
				expectedAI = 0;//server will create these
				expectedRemotePlayers = 0;//server will make these
				/*TODO: network stuff
				 * ClientSocketManager client = new ClientSocketManager();
				 * if (!pClient->Connect())
			{
				// Throw up a main menu
				VChangeState(BGS_MainMenu);
				return;
			}
			g_pApp->m_pBaseSocketManager = pClient;
				 */
			}
			else if(expectedRemotePlayers > 0)
			{
				/*
				 * BaseSocketManager *pServer = GCC_NEW BaseSocketManager();
			if (!pServer->Init())
			{
				// Throw up a main menu
				VChangeState(BGS_MainMenu);	
				return;
			}

			pServer->AddSocket(new GameServerListenSocket(g_pApp->m_pOptions->m_listenPort));
			g_pApp->m_pBaseSocketManager = pServer;
				 */
				
			}
		}
		currentState = newState;
		if(!amProxy)
		{
			//eventmanager code - safeQueEvent( IEventDataPtr(GCC_NEW EvtData_Game_State(m_State)) );
		}
	}
	
	public void togglePause(boolean active)
	{
		//TODO: this whole body fo code belongs in the view, not the game,
		//and it should fire off a pause event to all listeners
		
		if(active)
		{
			//resetTimer();
			//TODO: pause audio here
		}
		else
		{
			//TODO: resume audio here
		}
	}
	
	
	public void renderDiagnostics()
	{
		if(renderDiagnostics)
		{
			physics.renderDiagnostics();
		}
	}
	
	@Override
	public void setProxy(boolean proxy)
	{
		amProxy = proxy;
	}
	
	public int getNewActorID()
	{
		return lastActorId++;
	}
	
	public UnsignedInteger getRandomActor(List<UnsignedInteger> ignoreMe)
	{
		UnsignedInteger choice = null;
		while(choice == null)
		{
			choice = randomNum.Random(UnsignedInteger.valueOf(actorList.size()));
			if(ignoreMe != null && ignoreMe.size() > 0)
			{
				for(int index = 0; index < ignoreMe.size(); index++)
				{
					if(ignoreMe.get(index).longValue() == choice.longValue())
					{
						choice = null;
						index = ignoreMe.size();
					}
				}
			}
		}
		return choice;
	}
	
	public PathingGraph getPathingGraph()
	{
		return pathingGraph;
	}
	
	public RandomNumberGenerator getRandomNumberGenerator()
	{
		return randomNum;
	}
	
	@Override
	public void buildInitalScene()
	{
		
	}
	
	
	public void addView(IGameView view, int actorId)
	{
		//Make sure all views have non-zero ids
		int viewId = gameViews.size();
		gameViews.add(view);
		UnsignedInteger[] toSend = {UnsignedInteger.valueOf(actorId)};
		view.onAttach(UnsignedInteger.valueOf(viewId), Arrays.asList(toSend));
		view.onRestore();
	}
	
	public void removeView(IGameView view)
	{
		gameViews.remove(view);
	}
	
	public IGamePhysics getGamePhysics()
	{
		return physics;
	}
	
	public void attachProcess(Process newProcess)
	{
		if(processManager != null)
		{
			processManager.attach(newProcess);
		}
	}
}
