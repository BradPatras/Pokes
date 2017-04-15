package model;

public class FireSmack extends Move {

	@Override
	public String apply(Poke target) {
		target.hp -= 20;
		return "";
	}
	
	@Override
	public String resound(){
		return "KERSMACKK";
	}
	
	public FireSmack(){
		super("Fire Smack");
	}

}
