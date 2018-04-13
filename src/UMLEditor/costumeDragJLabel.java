package UMLEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;


public class costumeDragJLabel extends JLabel implements MouseListener{
	private UMLStatesType Type;
	public static costumeTransferHandler h = new costumeTransferHandler();
	
	public costumeDragJLabel(String Label,UMLStatesType type){
		super(Label);
		setBackground(new Color(169, 169, 169));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setPreferredSize(new Dimension(85, 85));
		//this.setBackground(UIManager.getColor(arg0));
		this.setOpaque(true);
		Type = type;
		
		this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.setTransferHandler(h);
		this.addMouseListener(this);
		
	}
	
	public UMLStatesType getType(){
		
		return Type;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//this.setBackground(Color.WHITE);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//setBackground(new Color(169, 169, 169));
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JComponent lab = (JComponent)e.getSource();
		TransferHandler handle = lab.getTransferHandler();
		handle.exportAsDrag(lab, e, TransferHandler.MOVE);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
