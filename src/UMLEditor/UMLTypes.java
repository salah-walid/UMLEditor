package UMLEditor;

public enum UMLTypes {
	DiagrammeEtatTransition("Diagramme Etat Transition"),
	DiagrammeDeClass("Diagramme De Class"),
	DiagrammeDObjets("Diagramme D'objets"),
	DiagrammeCasDUtilisatsion("Diagramme Cas D'utilisatsion");
	
	private String name;
	
	UMLTypes(String name){
		this.name = name;
	}
	
	public String toString(){
		
		return this.name;
		
	}
}
