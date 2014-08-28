package garden.soil.inprogress;

import java.io.InputStream;

public class Resource {
	private String name;
	
	public Resource(String newName)
	{
		name = newName;
	}
	
	public ResourceHandle createHandle(InputStream input, long size, ResourceCache cache)
	{
		return null;
	}
}
