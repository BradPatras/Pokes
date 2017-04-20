package pokes;

public abstract class Move {
	public String name;
	public abstract String apply(Poke target);
	public abstract String resound();
	
	public Move(String name){
		this.name = name;
	}
}
