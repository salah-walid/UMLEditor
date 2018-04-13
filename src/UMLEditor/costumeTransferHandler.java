package UMLEditor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class costumeTransferHandler extends TransferHandler{
	
	private UMLStatesType type;
	
	public boolean canImport(TransferHandler.TransferSupport info) {
	    if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
	      return false;
	    }
	    return true;
	  }

	  public boolean importData(TransferHandler.TransferSupport support){
	    if(!canImport(support))
	      return false;
	    
	    costumeDropComponent pan = (costumeDropComponent)support.getComponent();
	    UMLJlabel Class = new UMLJlabel(type, support.getDropLocation().getDropPoint().x, support.getDropLocation().getDropPoint().y, pan);
	    
		
		pan.add(Class);
		pan.setComponentZOrder(Class, 0);

	    return false;
	  }


	  protected Transferable createTransferable(JComponent c) {
		this.type = ((costumeDragJLabel)c).getType();
	    return new StringSelection(((costumeDragJLabel)c).getType().toString());
	  }

	  public int getSourceActions(JComponent c) {
	    return MOVE;
	  }  
}