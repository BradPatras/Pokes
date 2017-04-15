package model;

import java.util.ArrayList;

public abstract class Poke {
	public int hp = 100;
	public boolean isConfused;
	public String name;
	public abstract ArrayList<Move> getMoves();
	
	public Poke(String name){
		this.name = name;
	}
}
