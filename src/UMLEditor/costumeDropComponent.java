package UMLEditor;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import IHM.Diagramme_pannel;

public class costumeDropComponent extends JPanel implements MouseMotionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x, y, originX, originY;
	private UMLJlabel start;
	private ArrayList<UMLlink> links;
	private UMLlinkType linkType;
	private boolean drawSystem;
	private String SystemName;
	private int nameCount = 0;
	private final int ARR_SIZE = 6;
	private boolean editLinkModeOn;
	
	private UMLJlabel selection = null;
	
	public UMLJlabel getSelection() {
		return selection;
	}

	public void setSelection(UMLJlabel selected) {
		
		((Diagramme_pannel)this.getParent()).highlight(selected);
		this.selection = selected;
		repaint();
	}
	
	public String getSystemName() {
		return SystemName;
	}

	public void setSystemName(String systemName) {
		SystemName = systemName;
	}
	
	public int getNameCount() {
		return nameCount;
	}
	
	
	public void addToNameCount() {
		this.nameCount++;
	}

	public costumeDropComponent(){
		editLinkModeOn = false;
		this.setTransferHandler(costumeDragJLabel.h);
		SystemName = "Sans nom";
		links = new ArrayList<UMLlink>();
		drawSystem =false;
		addMouseMotionListener(this);
		addMouseListener(this);
		
	}
	
	public boolean isEditLinkModeOn() {
		return editLinkModeOn;
	}

	public void setEditLinkModeOn(boolean editLinkModeOn) {
		this.editLinkModeOn = editLinkModeOn;
	}

	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		g.drawString("Zone de dessin", 5, 20);
		
		if(this.selection != null){
			
			g.setColor(Color.RED);
			g.drawRect(selection.getX() - 5, selection.getY() -5, selection.getWidth() + 10, selection.getHeight() + 10);
			g.setColor(Color.BLACK);
		}
		if(this.drawSystem){
			
			g.drawRect(this.getWidth()/4, 10, (this.getWidth()*3/4)-10, this.getHeight()-20);
			g.drawString("System : " + SystemName, (this.getWidth()/4) + 20, 25);
			g.drawLine(this.getWidth()/4, 35, this.getWidth()-10, 35);
			
		}
		if(editLinkModeOn)
			drawArrow(g,originX, originY, x, y, this.linkType);
		for(int i=0;i < links.size(); i++){
			
			drawArrow(g, links.get(i).getStart().getX(), links.get(i).getStart().getY(),links.get(i).getEnd().getX(),links.get(i).getEnd().getY(), links.get(i).getLinkType());
		}

	}
	
	private void drawArrow(Graphics g1, double x1, double y1, double x2, double y2, UMLlinkType type) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        double midx = (x1 + x2)/2, midy = (y1 + y2)/2;
        if(type == UMLlinkType.extend){
        	g.drawString("<<extend>>", (int)midx + 10, (int)midy);
        }else if(type == UMLlinkType.include){
        	g.drawString("<<include>>", (int)midx + 10, (int)midy);
        	
        }else if(type == UMLlinkType.Assosiation){
        	
        	g.drawString("Assosiation >", (int)midx + 10, (int)midy);
        	
        }
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);
        int rectWidth = 8;
        switch(type){
        
        	case HeritageEtNormale:
                g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                        new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
                g.setStroke(new BasicStroke(3));
                g.drawLine(0, 0, len, 0);
        	break;
        	case aggregation:
        		g.setStroke(new BasicStroke(3));
        		g.drawLine(rectWidth/2, 0, len, 0);
        		g.setStroke(new BasicStroke());
        		g.rotate(Math.toRadians(45));
        		g.drawRect(-rectWidth/2, -rectWidth/2, rectWidth, rectWidth);
        		
        	break;
        	case composition:
        		g.setStroke(new BasicStroke(3));
        		g.drawLine(rectWidth/2, 0, len, 0);
        		g.setStroke(new BasicStroke());
        		g.rotate(Math.toRadians(45));
        		g.fillRect(-rectWidth/2, -rectWidth/2, rectWidth, rectWidth);
        		
        	break;
        	case Assosiation:
        		
        		g.setStroke(new BasicStroke(3));
        		g.drawLine(rectWidth/2, 0, len, 0);
        	break;
        	case include:
        		g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                        new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g.setStroke(dashed);
           		g.drawLine(0, 0, len, 0);
        	break;
        	case extend:
        		
        		g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                        new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
                Stroke dashed2 = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g.setStroke(dashed2);
           		g.drawLine(0, 0, len, 0);
        	break;
        
        }
        
    }
	
	public void drawSystem(boolean drawSystem){
		
		this.drawSystem = drawSystem;
		
	}
	
	public void removeAll(){
		if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment vider le diagramme !!!","Suppresion", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION){
			super.removeAll();
			setSelection(null);
			links.removeAll(links);
			repaint();
		}
			
	}
	
	
	public void remove(Component c){
		
		super.remove(c);
		this.deleteLink(c);
		
	}
	
	
	public void deleteLink(Component uml){
			for(int i=0;i < links.size(); i++){
				
				if(links.get(i).getUMLstart() == uml || links.get(i).getUMLend() == uml){
					
					links.remove(i);
					i--;
					
				}
				
			}
			this.repaint();
		
	}
	
	public void deleteLink(UMLlink link){
		links.remove(link);
	
	}
	
	public ArrayList<UMLlink> getRelatedLinks(Component start){
		
		ArrayList<UMLlink> links2 = new ArrayList<UMLlink>();
		for(int i=0;i < links.size(); i++){
			
			if(links.get(i).getUMLstart() == start)
				links2.add(links.get(i));
			
		}
		return links2;
		
	}
	
	public ArrayList<UMLlink> getLinks(){
		
		return this.links;
		
	}
	
	public void linkManage(Component start){
		
		linkManagerMB m = new linkManagerMB(getRelatedLinks(start), this);
		m.setVisible(true);
		
	}
	
	public void addLink(UMLJlabel end){
		
		addLink(start, end);
		
	}
	
	public void addLink(UMLJlabel start, UMLJlabel end, UMLlinkType linkType){
		this.linkType = linkType;
		addLink(start, end);
	}
	
	public void addLink(UMLJlabel start, UMLJlabel end){

		if(start != end){
			for(int i=0;i < links.size(); i++){
				if(links.get(i).getUMLend() == end && links.get(i).getUMLstart() == start){
					JOptionPane.showConfirmDialog(null, "Ce lien existe déja","Erreur de lien", JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
					
				}
			}
			links.add(new UMLlink(start,end, this.linkType));
			
		}else{
			
			JOptionPane.showConfirmDialog(null, "Vous ne pouvez pas faire un lien vers le même objet","Erreur de lien", JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE);
			return;
			
		}
		this.repaint();
		
	}
	public void setOrigin(UMLJlabel start, UMLlinkType linkType){
		editLinkModeOn = true;
		this.linkType = linkType;
		this.start = start;
		originX = start.getX() + (start.getWidth() / 2);
		x = originX;
		originY = start.getY() + start.getHeight();
		y = originY;
		
	}
	
	 public  UMLJlabel getComponentIndex(int id) {
		    
		      
		      for (int i = 0; i < this.getComponentCount(); i++) {
		    	  UMLJlabel c = ((UMLJlabel)this.getComponent(i));
		        if (c.getComponentNumber() == id)
		          return c;
		      }
		    
		    return null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		this.repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		editLinkModeOn = false;
		setSelection(null);;
		this.repaint();
	}

	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
