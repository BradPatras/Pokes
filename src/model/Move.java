package model;

public abstract class Move {
	public String name;
	public abstract String apply(Poke target);
	public abstract String resound();
	
	Move(String name){
		this.name = name;
	}
}
