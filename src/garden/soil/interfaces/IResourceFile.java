package garden.soil.interfaces;

import garden.soil.inprogress.Resource;

public interface IResourceFile {
	public boolean open();
	public int getResourceSize(Resource r);
	public int getResource(Resource r);
	public void close();
}
