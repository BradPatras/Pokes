package model;

import java.util.ArrayList;

public class Eletini extends Poke {

	@Override
	public ArrayList<Move> getMoves() {
		ArrayList<Move> moves = new ArrayList<>();
		moves.add(new Thunder());
		moves.add(new FurySwipes());
		return moves;
	}
	
	public Eletini(){
		super("Eletini");
	}

}
