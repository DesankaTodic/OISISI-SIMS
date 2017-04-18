package state;

import view.GraphicSlotView;

public class StateManager {
	private State currentState;
	
	
	CircleState circleState; 
	//LinkState linkState;
	RectangleState rectangleState;
	SelectState selectState;
	LassoState lassoState;
	
	public StateManager() {
		
	}
	
	public StateManager(GraphicSlotView med)
	{
		 
		circleState = new CircleState(med); 
		rectangleState=new RectangleState(med);
		selectState=new SelectState(med);
		lassoState=new LassoState(med);
     	currentState = selectState;
		//currentState = rectangleState;
	}
	
	public void setCircleState() { currentState = circleState; }
	public void setRectangleState(){ currentState = rectangleState; }
	public void setSelectState(){ currentState = selectState; }
	public void setLassoState(){ currentState = lassoState; }
	public State getCurrentState() {
		return currentState;
	}
}
