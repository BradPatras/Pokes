package pokes;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import pokes.model.poke.*;

public class MainGame {
	private static Random confusionDice = new Random();
	private static int CONFUSION_DAMAGE = 15;
	
	public static void main(String[] args) {
		Poke player1Poke;
		Poke player2Poke;
		boolean gameIsOver = false;
		Scanner inputScanner = new Scanner(System.in);
		
		ArrayList<Poke> pokes = getPokes();
		
		System.out.println("====================================");
		System.out.println("====| Welcome to Poke battles! |====");
		System.out.println("====================================\n\n");
		
		System.out.println("Player 1, choose your Poke (Enter a number)");
		System.out.println("+--------------------------+");		
		for (int i = 0; i<pokes.size(); i++){
			System.out.println(" | "+ i + ": " + pokes.get(i).name);
		}
		int player1Choice = Integer.parseInt(inputScanner.nextLine());
		player1Poke = pokes.remove(player1Choice);
		System.out.println("Player 1 chose " + player1Poke.name + "!\n");
		
		System.out.println("Player 2, choose your Poke (Enter a number)");
		System.out.println("+--------------------------+");
		for (int i = 0; i<pokes.size(); i++){
			System.out.println(" | "+ i + ": " + pokes.get(i).name);
		}
		int player2Choice = Integer.parseInt(inputScanner.nextLine());
		player2Poke = pokes.remove(player2Choice);
		System.out.println("Player 2 chose " + player2Poke.name + "!\n");
		
		System.out.println("Let the battle begin!");
		System.out.println("+--------------------------+");	
		
		int round = 1;
		
		//play rounds until there's a winner
		while(playRound(round++, player1Poke,player2Poke,inputScanner) == false);
		
		System.out.println("====================================");
		System.out.println("\n\nThe battle is over!! "+ getWinner(player1Poke,player2Poke).name + " wins it all!!");
		
		inputScanner.close();	
	}
	
	/**
	 * 
	 * @param round integer representing the current round
	 * @param player1Poke player 1s poke
	 * @param player2Poke player 2s poke
	 * @param inputScanner scanner being used for user input
	 * @return
	 */
	private static boolean playRound(int round, Poke player1Poke, Poke player2Poke, Scanner inputScanner){
		printRound(round);
		
		//Player 1s turn
		printStatus(player1Poke, player2Poke);
		System.out.println("Player 1, what would you like "+ player1Poke.name +" to do?");
		takeTurn(player1Poke, player2Poke, inputScanner);
		
		//check for a winner, if there is a winner then stop the round and return true
		if (getWinner(player1Poke,player2Poke) != null){
			return true;
		}
		
		//Player 2s turn
		printStatus(player1Poke,player2Poke);
		System.out.println("Player 2, what would you like "+ player2Poke.name +" to do?");
		takeTurn(player2Poke, player1Poke, inputScanner);
		
		//if get winner doesn't return null, then there must be a winner
		return getWinner(player1Poke,player2Poke) != null;
		
	}
	
	private static void takeTurn(Poke current, Poke opponent, Scanner inputScanner){
		for(int i=0; i<current.getMoves().size(); i++){
			System.out.println(" |"+i + ": " + current.getMoves().get(i).name);
		}
		
		Move move = current.getMoves().get(Integer.parseInt(inputScanner.nextLine()));
		
		//handle confusion, and attack
		if(current.isConfused){
			System.out.println(current.name + " is confused...");
			if(confusionDice.nextInt(100) <50){
				System.out.println("It hurt itself in confusion");
				current.hp -= CONFUSION_DAMAGE;
			} else {
				System.out.print(move.resound() + " " + current.name + " used " + move.name + "! ");
				System.out.println(move.apply(opponent));
			}
		} else {
			System.out.print(move.resound() + " " + current.name + " used " + move.name + "! ");
			System.out.println(move.apply(opponent));
		}
	}
	
	/*
	 * print the header for the start of a round
	 */
	private static void printRound(int round){
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("+==========================+");
		if(round < 10) System.out.println("+------ Round "+round+" -----------+");
		else System.out.println("+------ Round "+round+" ----------+");
		System.out.println("+==========================+");
	}
	
	/*
	 * print the status of the two pokemon
	 */
	private static void printStatus(Poke player1Poke, Poke player2Poke){
		System.out.println("+--------------------------+");
		System.out.println("||Player 1's " + player1Poke.name + "HP: " + player1Poke.hp + (player1Poke.isConfused ? " CONFUSED" : ""));
		System.out.println("||Player 2's " + player2Poke.name + "HP: " + player2Poke.hp+ (player2Poke.isConfused ? " CONFUSED" : ""));
		System.out.println("+--------------------------+\n");
	}
	
	/**
	 * Method checks the two pokes and it returns a winner IF one of them are fainted, otherwise it returns null
	 * @param p1 poke
	 * @param p2 different poke
	 * @return The winning poke if there is one, otherwise null
	 */
	private static Poke getWinner(Poke p1, Poke p2){
		if(p1.hp <= 0){
			return p2;
		} else if(p2.hp <=0){
			return p1;	
		} else {
			return null;
		}
	}
	
	private static ArrayList<Poke> getPokes(){
		ArrayList<Poke> pokes = new ArrayList<>();
		pokes.add(new Squirtmander());
		pokes.add(new Eletini());
		return pokes;
	}

}
