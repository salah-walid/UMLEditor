package UMLEditor;

public enum UMLStatesType {
	Etat("etat"),
	EtatEnitial("etatEnitial"),
	EtatFinale("etatFinale"),
	Class("class"),
	Objet("objet"),
	Acteur("Acteur"),
	CasDutilisation("Cas"),
	System("system");

	private String name;
	
	UMLStatesType(String name){
		this.name = name;
	}
	
	public String toString(){
		
		return this.name;
		
	}
}
