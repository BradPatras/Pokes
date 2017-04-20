package pokes.model.poke;

import java.util.ArrayList;

import pokes.Move;
import pokes.Poke;
import pokes.model.move.FurySwipes;
import pokes.model.move.Thunder;

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
