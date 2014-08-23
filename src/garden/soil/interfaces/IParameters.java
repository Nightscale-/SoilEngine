package garden.soil.interfaces;

import java.io.InputStream;
import java.io.Serializable;

public interface IParameters extends Serializable{
	public void close();
	public boolean initalize(InputStream input);
}
