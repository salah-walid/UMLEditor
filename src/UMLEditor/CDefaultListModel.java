package UMLEditor;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class CDefaultListModel<E> extends DefaultListModel<E> {

	private ArrayList<UMLlink> links = new ArrayList<>();
	
	public void addElement(E e, UMLlink link){
		
		super.addElement(e);
		links.add(link);
		
	}
	
	public UMLlink getLink(int index){
		
		return links.get(index);
		
	}
	
	public E remove(int index){
		
		links.remove(index);
		return super.remove(index);
		
	}
	
}
