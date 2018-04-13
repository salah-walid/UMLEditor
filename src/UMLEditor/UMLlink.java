package UMLEditor;
import java.awt.Point;

public class UMLlink{
	
	private UMLJlabel UMLstart;
	private UMLJlabel UMLend;
	private UMLlinkType linkType;
	
	public UMLlink(UMLJlabel UMLstart, UMLJlabel UMLend, UMLlinkType linkType){
		
		this.UMLstart = UMLstart;
		this.UMLend = UMLend;
		this.linkType = linkType;
		
	}
	

	public UMLlinkType getLinkType() {
		return linkType;
	}

	public void setLinkType(UMLlinkType linkType) {
		this.linkType = linkType;
	}

	public Point getStart() {
		return new Point(UMLstart.getX() +(UMLstart.getWidth() / 2),UMLstart.getY() + UMLstart.getHeight());
	}

	public Point getEnd() {
		return new Point(UMLend.getX() +(UMLend.getWidth() / 2),UMLend.getY());
	}

	public UMLJlabel getUMLstart() {
		return UMLstart;
	}

	public void setUMLstart(UMLJlabel uMLstart) {
		UMLstart = uMLstart;
	}

	public UMLJlabel getUMLend() {
		return UMLend;
	}

	public void setUMLend(UMLJlabel uMLend) {
		UMLend = uMLend;
	}
	
}
