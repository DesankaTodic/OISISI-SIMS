package actions;

import gui.listeners.MyWindowListener;

public class ActionManager {
	private NewProjectAction newProjectAction;
	private NewDocumentAction newDocumentAction;
	private NewPageAction newPageAction;
	private NewGraphicSlotAction newGraphicSlotAction;
	private NewTextSlotAction newTextSlotAction;
	private DeleteAction deleteAction;
	private OpenProjectAction openProjectAction;
	private SaveProjectAction saveProjectAction;
	private CascadeAction cascadeAction;
	private TileHorizontallyAction tileHorizontallyAction;
	private TileVerticallyAction tileVerticallyAction;
	private MatrixProjectViewAction matrixProjectViewAction;
	private UndoAction undoAction;
	private RedoAction redoAction;
	private DeleteElementAction deleteElementAction;
	private AboutDialogAction aboutDialogAction;
	private EditCopyAction editCopyAction;
	private EditCutAction editCutAction;
	private EditPasteAction editPasteAction;
	private MyWindowListener myWindowListener;

	public ActionManager(){
		newProjectAction = new NewProjectAction();
		newDocumentAction = new NewDocumentAction();
		newPageAction = new NewPageAction();
		newGraphicSlotAction = new NewGraphicSlotAction();
		newTextSlotAction = new NewTextSlotAction();
		deleteAction = new DeleteAction();
		openProjectAction = new OpenProjectAction();
		saveProjectAction = new SaveProjectAction();
		cascadeAction = new CascadeAction();
		tileHorizontallyAction = new TileHorizontallyAction();
		tileVerticallyAction = new TileVerticallyAction();
		matrixProjectViewAction = new MatrixProjectViewAction();
		undoAction = new UndoAction();
		redoAction = new RedoAction();
		deleteElementAction = new DeleteElementAction();
		aboutDialogAction = new AboutDialogAction();
		editCopyAction = new EditCopyAction();
		editCutAction = new EditCutAction();
		editPasteAction = new EditPasteAction();
		myWindowListener=new MyWindowListener();
	}
	public EditCopyAction getEditCopyAction() {
		return editCopyAction;
	}
	public EditCutAction getEditCutAction() {
		return editCutAction;
	}
	public EditPasteAction getEditPasteAction() {
		return editPasteAction;
	}
	public AboutDialogAction getAboutDialogAction() {
		return aboutDialogAction;
	}
	
	public RedoAction getRedoAction() {
		return redoAction;
	}
	public DeleteElementAction getDeleteElementAction() {
		return deleteElementAction;
	}
	public CascadeAction getCascadeAction() {
		return cascadeAction;
	}
	public UndoAction getUndoAction() {
		return undoAction;
	}
	public MatrixProjectViewAction getMatrixProjectViewAction() {
		return matrixProjectViewAction;
	}
	public TileVerticallyAction getTileVerticallyAction() {
		return tileVerticallyAction;
	}
	public TileHorizontallyAction getTileHorizontallyAction() {
		return tileHorizontallyAction;
	}
	public SaveProjectAction getSaveProjectAction() {
		return saveProjectAction;
	}
	public OpenProjectAction getOpenProjectAction() {
		return openProjectAction;
	}
	public DeleteAction getDeleteAction() {
		return deleteAction;
	}
	public NewTextSlotAction getNewTextSlotAction() {
		return newTextSlotAction;
	}
	public NewGraphicSlotAction getNewGraphicSlotAction() {
		return newGraphicSlotAction;
	}
	public NewPageAction getNewPageAction() {
		return newPageAction;
	}
	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}
	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}
	public MyWindowListener getMyWindowListener() {
		return myWindowListener;
	}

}
