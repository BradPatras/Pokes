package pokes.model.poke;

import java.util.ArrayList;

import pokes.Move;
import pokes.Poke;
import pokes.model.move.ConfuseRay;
import pokes.model.move.FireSmack;

public class Squirtmander extends Poke {

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
