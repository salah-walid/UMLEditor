package UMLEditor;

public enum UMLlinkType {
	Assosiation("Assosiation"),
	HeritageEtNormale("Heritage / lien normal"),
	aggregation("Aggregation"),
	composition("Composition"),
	include("Include"),
	extend("Extend");
	
private String name;
	
	UMLlinkType(String name){
		this.name = name;
	}
	
	public String toString(){
		
		return this.name;
		
	}
	
}
