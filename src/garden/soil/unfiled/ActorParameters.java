package garden.soil.unfiled;

import java.io.InputStream;
import java.util.Vector;

import garden.soil.interfaces.IParameters;
import garden.soil.mathphysics.UnsignedInteger;

public class ActorParameters implements IParameters {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5636665853031265116L;
	
	private int size;
	private UnsignedInteger id;
	private Vector<Integer> position;
	private int actorType;

	public ActorParameters()
	{
		size = 0;
		id = new UnsignedInteger(0);
		position = new Vector<Integer>();
		position.add(Integer.valueOf(0));
		position.add(Integer.valueOf(0));
		position.add(Integer.valueOf(0));
		actorType = 0;
	}
	
	@Override
	public void close() {
		position.clear();
		id.assign(0);
	}

	@Override
	public boolean initalize(InputStream input) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public UnsignedInteger getId() {
		return id;
	}

	public void setId(UnsignedInteger id) {
		this.id = id;
	}

	public Vector<Integer> getPosition() {
		return position;
	}

	public void setPosition(Vector<Integer> position) {
		this.position = position;
	}

	public int getActorType() {
		return actorType;
	}

	public void setActorType(int actorType) {
		this.actorType = actorType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
