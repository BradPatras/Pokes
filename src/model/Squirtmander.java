package model;

import java.util.ArrayList;

public class Squirtmander extends model.Poke {

	@Override
	public ArrayList<Move> getMoves() {
		ArrayList<Move> moves = new ArrayList<>();
		moves.add(new ConfuseRay());
		moves.add(new FireSmack());
		return moves;
	}
	
	public Squirtmander(){
		super("Squirtmander");
	}
	

}
