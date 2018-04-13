package UMLEditor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class UMLJlabel extends JLabel implements MouseMotionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UMLStatesType Type;
	private int ComponentNumber;
	public int getComponentNumber() {
		return ComponentNumber;
	}

	public void setComponentNumber(int componentNumber) {
		ComponentNumber = componentNumber;
	}

	private String name;
	private String propriete;
	private String methode;
	private costumeDropComponent container;
	
	public UMLJlabel(UMLStatesType type, int x, int y, costumeDropComponent container){
		
		this.container = container;
		Type = type;
		container.addToNameCount();
		
		this.ComponentNumber = container.getNameCount();
		this.setName("Nom par defaut " + container.getNameCount());
		this.setProprite("");
		this.setMethodes("");
		
		this.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    this.setBackground(Color.WHITE);
		this.setHorizontalAlignment(JLabel.LEFT);
		this.setLocation((int)(x-(this.getWidth()/2)), (int)y-(this.getHeight()/2));
		repaintUML();
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void repaintUML(){
		switch(this.Type){
		case Etat:
			this.setText(this.name);
			this.setIconTextGap(BOTTOM);
			this.setHorizontalTextPosition(JLabel.CENTER);
			this.setVerticalTextPosition(JLabel.BOTTOM);
		    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    this.setOpaque(true);

		break;
		case EtatEnitial:
			this.setIcon(new ImageIcon("Images\\point.png"));
		    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		break;
		case EtatFinale:
			this.setIcon(new ImageIcon("Images\\pointAvecCercle.png"));
		    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		break;
		case Class:
			this.setText("<html><p style='width : 100px'>" + this.name + "<hr>" + this.propriete + "<hr>" + this.methode + "</p></html>");
		    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    this.setOpaque(true);

		break;
		case CasDutilisation:
			this.setText(this.name);
			this.setIconTextGap(BOTTOM);
			this.setHorizontalTextPosition(JLabel.CENTER);
			this.setVerticalTextPosition(JLabel.BOTTOM);
		    this.setBorder(new LineBorder(Color.BLACK, 3, true));
		    this.setOpaque(true);
		break;
		case Acteur:
			this.setIcon(new ImageIcon("Images\\stick-figure1.png"));
			this.setText(this.name);
		break;
		case Objet:
			this.setText("<html><p style='width : 100px'>" + this.name + "<hr>" + this.propriete + "<hr>" + this.methode + "</p></html>");
		    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    this.setOpaque(true);
		break;
		default:
			break;
		}

		this.setSize(this.getPreferredSize());
		container.repaint();
	}
	
	public void changeUMLDialog(){
		
	     new costumeDialogBox(null, "Modification de " + name, true, this);
		
	}
	
	public void removeComponent(){
		container.repaint();
		if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer ce diagramme uml, cela va supprimer tous les liens associés !!!","Suppresion", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION){
			container.remove(this);
			container.setSelection(null);
		}
		container.repaint();
		
	}
	
	
	public void removeAllLinks(){
		
		container.repaint();
		if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer tous les liens de ce diagramme uml !!!","Suppresion", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
			container.deleteLink(this);
		container.repaint();
		
	}
	
	public String getName(){
		
		return this.name;
		
	}
	
	public String getPropriete(){
		
		return this.propriete;
		
	}
	
	public String getMethode(){
		
		return this.methode;
		
	}
	public void setName(String name){
		
		this.name = name.replaceAll("\n", "<br>");
		
	}
	
	public void setProprite(String propriete){
		
		this.propriete = propriete.replaceAll("\n", "<br>");
		
	}
	
	public void setMethodes(String methode){
		
		this.methode = methode.replaceAll("\n", "<br>");
		
	}

	public UMLStatesType getType(){
		
		return Type;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			container.setComponentZOrder(this, 0);
			int x = this.getX() + (e.getX()-(this.getWidth()/2));
			int y = this.getY() + (e.getY()-(this.getHeight()/2));
			if(x<0)
				x = 0;
			else if(x > (container.getWidth() - this.getWidth()))
				x = container.getWidth() - this.getWidth();
			
			if(y<0)
				y = 0;
			else if(y > (container.getHeight() -  this.getHeight()))
				y = container.getHeight() - this.getHeight();
			
			
			this.setLocation(x, y);
			container.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		container.setComponentZOrder(this, 0);
		if (e.getClickCount() == 2 && !e.isConsumed() && SwingUtilities.isLeftMouseButton(e)) {
		     e.consume();
		     if(Type != UMLStatesType.EtatEnitial && Type != UMLStatesType.EtatFinale)
		    	 this.changeUMLDialog();
		}
		else if(SwingUtilities.isLeftMouseButton(e)){
			if(container.isEditLinkModeOn()){
				container.addLink(this);
				container.setEditLinkModeOn(false);
			}
		}		
		
		container.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		container.setSelection(this);
		if(SwingUtilities.isRightMouseButton(e)){
			
			JPopupMenu menu = new JPopupMenu();
			JMenuItem del = new JMenuItem("Supprimer");
			del.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					
					removeComponent();
					
				}
				
			});
			menu.add(del);
			
			JMenuItem delLinks = new JMenuItem("Supprimer tous les liens");
			delLinks.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					
					removeAllLinks();
					
				}
				
			});
			menu.add(delLinks);
			
			JMenuItem manageLinks = new JMenuItem("Gérer les liens");
			manageLinks.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					
					container.linkManage(UMLJlabel.this);
					
				}
				
			});
			menu.add(manageLinks);
			
			menu.addSeparator();
			
			JMenuItem lien = new JMenuItem("Lien normal/heritage");
			lien.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					
					container.setOrigin(UMLJlabel.this, UMLlinkType.HeritageEtNormale);
					container.repaint();
					
				}
				
			});
			menu.add(lien);
			if(this.Type == UMLStatesType.Class){
				JMenuItem lienAssociation = new JMenuItem("Association");
				lienAssociation.addActionListener(new ActionListener() {
	
					@Override
					public void actionPerformed(ActionEvent event) {
						
						container.setOrigin(UMLJlabel.this, UMLlinkType.Assosiation);
						container.repaint();
						
					}
					
				});
				menu.add(lienAssociation);
				
				JMenuItem lienAggregation = new JMenuItem("Aggrégation");
				lienAggregation.addActionListener(new ActionListener() {
	
					@Override
					public void actionPerformed(ActionEvent event) {
						
						container.setOrigin(UMLJlabel.this, UMLlinkType.aggregation);
						container.repaint();
						
					}
					
				});
				menu.add(lienAggregation);
				
				JMenuItem lienComposition = new JMenuItem("Composition");
				lienComposition.addActionListener(new ActionListener() {
	
					@Override
					public void actionPerformed(ActionEvent event) {
						
						container.setOrigin(UMLJlabel.this, UMLlinkType.composition);
						container.repaint();
						
					}
					
				});
				menu.add(lienComposition);
		}else if(this.Type == UMLStatesType.CasDutilisation){
			JMenuItem include = new JMenuItem("Include");
			include.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					
					container.setOrigin(UMLJlabel.this, UMLlinkType.include);
					container.repaint();
					
				}
				
			});
			menu.add(include);
			
			JMenuItem extend = new JMenuItem("Extend");
			extend.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					
					container.setOrigin(UMLJlabel.this, UMLlinkType.extend);
					container.repaint();
					
				}
				
			});
			menu.add(extend);
		}
			menu.show(e.getComponent(), e.getX(), e.getY());
			
		}
		
	}
}
