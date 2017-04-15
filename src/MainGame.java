

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.*;

public class MainGame {
	
	public static void main(String[] args) {
		final int CONFUSION_DAMAGE = 15;
		
		Poke player1Poke;
		Poke player2Poke;
		boolean gameIsOver = false;
		Scanner inputScanner = new Scanner(System.in);
		Random confusionDice = new Random();
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
		
		String winner = "";
		int round =1;
		while(!gameIsOver){
			System.out.println("\n\n\n");
			System.out.println("+==========================+");
			if(round < 10) System.out.println("+------ Round "+round+" -----------+");
			else System.out.println("+------ Round "+round+" ----------+");
			System.out.println("+==========================+");
			
			//Player 1s turn
			System.out.println("+--------------------------+");
			System.out.println("||Player 1's " + player1Poke.name + "HP: " + player1Poke.hp);
			System.out.println("||Player 2's " + player2Poke.name + "HP: " + player2Poke.hp);
			System.out.println("+--------------------------+\n");
			System.out.println("Player 1, what would you like "+ player1Poke.name +" to do?");
			for(int i=0; i<player1Poke.getMoves().size(); i++){
				System.out.println(" |"+i + ": " + player1Poke.getMoves().get(i).name);
			}
			Move player1Move = player1Poke.getMoves().get(Integer.parseInt(inputScanner.nextLine()));
			
			//handle confusion, and attack
			if(player1Poke.isConfused){
				System.out.println(player1Poke.name + " is confused...");
				if(confusionDice.nextInt(100) <50){
					System.out.println("It hurt itself in confusion");
					player1Poke.hp -= CONFUSION_DAMAGE;
				} else {
					System.out.print(player1Move.resound() + " " + player1Poke.name + " used " + player1Move.name + "! ");
					System.out.println(player1Move.apply(player2Poke));
				}
			} else {
				System.out.print(player1Move.resound() + " " + player1Poke.name + " used " + player1Move.name + "! ");
				System.out.println(player1Move.apply(player2Poke));
			}
			
			//check for a winner
			if(player1Poke.hp <= 0){
				winner = "Player 2";
				gameIsOver = true;
				break;
			} else if(player2Poke.hp <=0){
				winner = "Player 1";
				gameIsOver = true;
				break;	
			}
			
			
			//Player 2s turn
			System.out.println("+--------------------------+");
			System.out.println("||Player 1's " + player1Poke.name + "HP: " + player1Poke.hp);
			System.out.println("||Player 2's " + player2Poke.name + "HP: " + player2Poke.hp);
			System.out.println("+--------------------------+\n");
			System.out.println("Player 2, what would you like "+ player2Poke.name +" to do?");
			for(int i=0; i<player2Poke.getMoves().size(); i++){
				System.out.println(" |"+i + ": " + player2Poke.getMoves().get(i).name);
			}
			Move player2Move = player2Poke.getMoves().get(Integer.parseInt(inputScanner.nextLine()));
			
			//handle confusion, and attack
			if(player2Poke.isConfused){
				System.out.println(player2Poke.name + " is confused...");
				if(confusionDice.nextInt(100) <50){
					System.out.println("It hurt itself in confusion");
					player2Poke.hp -= CONFUSION_DAMAGE;
				} else {
					System.out.print(player2Move.resound() + " " + player2Poke.name + " used " + player2Move.name + "! ");
					System.out.println(player1Move.apply(player2Poke));
				}
			} else {
				System.out.print(player2Move.resound() + " " + player2Poke.name + " used " + player2Move.name + "! ");
				System.out.println(player2Move.apply(player1Poke));
			}
			
			//check for a winner
			if(player1Poke.hp <= 0){
				winner = "Player 2";
				gameIsOver = true;
				break;
			} else if(player2Poke.hp <=0){
				winner = "Player 1";
				gameIsOver = true;
				break;	
			}
			
			round++;
		}
		
		System.out.println("\n\n The battle is over!! "+ winner + " wins it all!!");
		inputScanner.close();	
	}
	
	private static ArrayList<Poke> getPokes(){
		ArrayList<Poke> pokes = new ArrayList<>();
		pokes.add(new Squirtmander());
		pokes.add(new Eletini());
		return pokes;
	}

}
