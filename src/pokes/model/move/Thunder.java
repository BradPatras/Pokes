package pokes.model.move;

import java.util.Random;

import pokes.Move;
import pokes.Poke;

public class Thunder extends Move {

	@Override
	public String apply(Poke target) {
		Random acc = new Random();
		
		if(acc.nextInt(100)<65){
			target.hp -= 35;
			return "";
		} else {
			return "The attack missed!";
		}
	}

	@Override
	public String resound() {
		return "CRRRRAAACKKKK";
	}
	
	public Thunder(){
		super("Thunder");
	}

}
