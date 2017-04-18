package event;

import java.util.EventObject;

public class ModelUpdateEvent{
	private boolean add = false;
	private boolean remove = false;
	private Object o = null;
	
	public ModelUpdateEvent(Object o,boolean add,boolean remove)
	{
		this.o = o;
		this.add = add;
		this.remove = remove;
	}
	public void setAdd(boolean add){
		this.add = add;
	}
	public void setRemove(boolean remove){
		this.remove = remove;
	}
	public boolean getAdd(){
		return add;
	}
	public boolean getRemove(){
		return remove;
	}
	public Object getObject(){
		return o;
	}
}
