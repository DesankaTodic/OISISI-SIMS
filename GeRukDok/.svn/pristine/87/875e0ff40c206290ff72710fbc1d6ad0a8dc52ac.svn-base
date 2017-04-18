package commands;

import gui.MyFrame;

import java.util.ArrayList;


public class CommandManager{ //lista koja predstavlja stek na kome se nalaze konkretne izvrsene komande
	private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
	//pokazivac steka, sadrzi redni broj komande za undo / redo operaciju
	private int currentCommand = 0;
	
	/*
	 * Dodaje novu komandu na stek i poziva izvrsavanje komande
	 */
	public void addCommand(AbstractCommand command){
		while(currentCommand < commands.size())
			commands.remove(currentCommand);
		commands.add(command);
		doCommand();
	}
	
	
	/*
	 * Metoda koja poziva izvrsavanje konkretne komande 
	 */
	public void doCommand(){
		if(currentCommand < commands.size()){
			commands.get(currentCommand++).doCommand();
			MyFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
		}
		if(currentCommand==commands.size()){
			MyFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
		}
	}
	
	/*
	 * Metoda koja poziva redo konkretne komande
	 */
	public void undoCommand(){
		if(currentCommand > 0){
			MyFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
			commands.get(--currentCommand).undoCommand();
		}
		if(currentCommand==0){
			MyFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
		}
	}
	
}
	
