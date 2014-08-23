package garden.soil.inprogress;

import java.util.Map;

import garden.soil.unfiled.GameParameters;
import garden.soil.mathphysics.UnsignedInteger;
import garden.soil.interfaces.IScreenElement;

public abstract class GameCodeApp {
	
	protected boolean isRunning;
	protected boolean quitRequested;
	protected boolean amQuitting;
	protected Rectangle windowRect;
	protected int colorDepth;
	protected FontHandler fontHandler;
	protected int hasModalDialog;
	protected BaseGameLogic gameLogic;
	protected GameParameters options;
	protected ResourceCache resCache;
	protected String saveGameDirectory;
	protected EventManager eventManager;
	
	public GameCodeApp()
	{
		
	}
	
	protected int Modal(IScreenElement element, int defaultAnswer)
	{
		
	}
	
	protected int pumpUntilMessage(UnsignedInteger msgEnd, UnsignedInteger param, long longParam)
	{
		
	}
	
	protected int eatSpecificMessages(UnsignedInteger msgType, Map<String, Object> lParam, Map<String, Object> wParam)
	{
		
	}
	
	public abstract String getGameTitle();
	
	public abstract String getGameAppDirectory();
	
	public abstract Object getIcon();//TODO: replace Object with image type
	
	/*TODO: this seems to be the activity class in Android. look at combining this methods with android equivilents
	// Win32 Specific Stuff
	HWND GetHwnd();
	HINSTANCE GetInstance() { return m_hInstance; }
	virtual bool InitInstance(HINSTANCE hInstance, LPWSTR lpCmdLine, HWND hWnd = NULL, int screenWidth = SCREEN_WIDTH, int screenHeight = SCREEN_HEIGHT);	
	void ParseCommandLine(LPWSTR lpCmdLine);

	static LRESULT CALLBACK MsgProc( HWND hWnd, UINT uMsg, WPARAM wParam, LPARAM lParam, bool* pbNoFurtherProcessing, void *pUserContext );
	static int Ask(const int question);
	bool HasModalDialog() { return m_HasModalDialog!=0; }
	void ForceModalExit() { PostMessage(GetHwnd(), MSG_END_MODAL, 0, QUIT_NO_PROMPT);	}

	LRESULT OnDeviceChange(int eventType);
	LRESULT OnDisplayChange(int colorDepth, int width, int height);
	LRESULT OnPowerBroadcast(int event);
	LRESULT OnSysCommand(WPARAM wParam, LPARAM lParam);
	LRESULT OnClose();

	// Game Application actions
	LRESULT OnAltEnter();
	LRESULT OnNcCreate(LPCREATESTRUCT cs);

	std::wstring GetString(const int nID);				
	FontHandler const *GetFontHandler() { return m_pFontHandler; }

	// DirectX Specific Stuff
	static HRESULT CALLBACK OnResetDevice( IDirect3DDevice9* pd3dDevice, const D3DSURFACE_DESC* pBackBufferSurfaceDesc, void *pUserContext  );
	static void    CALLBACK OnLostDevice(void *pUserContext);
	static bool CALLBACK IsDeviceAcceptable( D3DCAPS9* pCaps, D3DFORMAT AdapterFormat, D3DFORMAT BackBufferFormat, bool bWindowed, void* pUserContext );
	static bool CALLBACK ModifyDeviceSettings( DXUTDeviceSettings* pDeviceSettings, const D3DCAPS9* pCaps, void* pUserContext );
	static void CALLBACK OnUpdateGame( double fTime, float fElapsedTime, void *pUserContext );
	static void CALLBACK OnRender( IDirect3DDevice9* pd3dDevice, double fTime, float fElapsedTime, void *pUserContext );
	static HRESULT CALLBACK OnCreateDevice( IDirect3DDevice9* pd3dDevice, const D3DSURFACE_DESC* pBackBufferSurfaceDesc, void* pUserContext );
	static void CALLBACK OnDestroyDevice( void* pUserContext );

	static CDXUTDialogResourceManager g_DialogResourceManager; // manager for shared resources of dialogs
	*/
	
	
	
	public abstract BaseGameLogic createGameAndView();
	public abstract boolean loadGame();
	
	
	
	public abstract boolean isMinimumInstall();
	
	public String CDCheckFile()
	{
		
	}
	
	public boolean fileExistes(String searchFile)
	{
		
	}
	
	
	public void registerBaseGameEvents()
	{
		
	}
	
	//BaseSocketManager baseSocketManager;
	
	//Main loop processing
	public void abortGame()
	{
		amQuitting = true;
	}
	
	public int getExitCode()
	{
		
	}
	
	public boolean isRunning()
	{
		return isRunning;
	}
	
	public void setQuitting(boolean quitting)
	{
		amQuitting = quitting;
	}

	public GameParameters getOptions() {
		return options;
	}
}
