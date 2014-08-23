package garden.soil.unfiled;

import java.io.InputStream;

import garden.soil.interfaces.IParameters;

public class GameParameters implements IParameters {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2713281580388199931L;

	protected boolean useHardwareAccel;
	protected boolean usePageFlipping;
	protected boolean useDithering;
	protected boolean useAntialiasing;
	protected boolean useEdgeAntiAliasing;
	protected boolean useVRAM;
	protected boolean runFullSpeed;
	protected boolean useTexturePerspective;
	protected float soundEffectsVolume;
	protected float musicVolume;
	protected int expectedPlayers;
	protected int listenPort;
	protected String gameHost;
	protected int numAIs;
	protected int maxAIs;
	protected int maxPlayers;
	
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean initalize(InputStream input) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUseHardwareAccel() {
		return useHardwareAccel;
	}

	public void setUseHardwareAccel(boolean useHardwareAccel) {
		this.useHardwareAccel = useHardwareAccel;
	}

	public boolean isUsePageFlipping() {
		return usePageFlipping;
	}

	public void setUsePageFlipping(boolean usePageFlipping) {
		this.usePageFlipping = usePageFlipping;
	}

	public boolean isUseDithering() {
		return useDithering;
	}

	public void setUseDithering(boolean useDithering) {
		this.useDithering = useDithering;
	}

	public boolean isUseAntialiasing() {
		return useAntialiasing;
	}

	public void setUseAntialiasing(boolean useAntialiasing) {
		this.useAntialiasing = useAntialiasing;
	}

	public boolean isUseEdgeAntiAliasing() {
		return useEdgeAntiAliasing;
	}

	public void setUseEdgeAntiAliasing(boolean useEdgeAntiAliasing) {
		this.useEdgeAntiAliasing = useEdgeAntiAliasing;
	}

	public boolean isUseVRAM() {
		return useVRAM;
	}

	public void setUseVRAM(boolean useVRAM) {
		this.useVRAM = useVRAM;
	}

	public boolean isRunFullSpeed() {
		return runFullSpeed;
	}

	public void setRunFullSpeed(boolean runFullSpeed) {
		this.runFullSpeed = runFullSpeed;
	}

	public boolean isUseTexturePerspective() {
		return useTexturePerspective;
	}

	public void setUseTexturePerspective(boolean useTexturePerspective) {
		this.useTexturePerspective = useTexturePerspective;
	}

	public float getSoundEffectsVolume() {
		return soundEffectsVolume;
	}

	public void setSoundEffectsVolume(float soundEffectsVolume) {
		this.soundEffectsVolume = soundEffectsVolume;
	}

	public float getMusicVolume() {
		return musicVolume;
	}

	public void setMusicVolume(float musicVolume) {
		this.musicVolume = musicVolume;
	}

	public int getExpectedPlayers() {
		return expectedPlayers;
	}

	public void setExpectedPlayers(int expectedPlayers) {
		this.expectedPlayers = expectedPlayers;
	}

	public int getListenPort() {
		return listenPort;
	}

	public void setListenPort(int listenPort) {
		this.listenPort = listenPort;
	}

	public String getGameHost() {
		return gameHost;
	}

	public void setGameHost(String gameHost) {
		this.gameHost = gameHost;
	}

	public int getNumAIs() {
		return numAIs;
	}

	public void setNumAIs(int numAIs) {
		this.numAIs = numAIs;
	}

	public int getMaxAIs() {
		return maxAIs;
	}

	public void setMaxAIs(int maxAIs) {
		this.maxAIs = maxAIs;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

}
