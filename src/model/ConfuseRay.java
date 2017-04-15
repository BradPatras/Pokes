package model;

public class ConfuseRay extends Move {

	@Override
	public String apply(Poke target) {
		target.isConfused = true;
		return target.name + " is now confused!";	
	}

	@Override
	public String resound() {
		return "BRRRWOWOWOWOW";
	}
	
	public ConfuseRay(){
		super("Confuse Ray");
	}

}
