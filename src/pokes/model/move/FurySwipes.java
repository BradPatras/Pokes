package pokes.model.move;

import java.util.Random;

import pokes.Move;
import pokes.Poke;

public class FurySwipes extends Move {

	@Override
	public String apply(Poke target) {
		int hits = 0;
		Random r = new Random();
		for(int i =0;i<4; i++){
			if(r.nextBoolean()) hits++;
		}
		target.hp -= (10 * hits);
		return "It hit " + hits + (hits==1? " time!":" times!");
	}

	@Override
	public String resound() {
		return "SHHHHHWWOOOOO";
	}
	
	public FurySwipes(){
		super("Fury Swipes");
	}

}
