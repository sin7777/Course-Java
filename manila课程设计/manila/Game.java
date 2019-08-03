package manila;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Player[] players;
	private Boat[] boats;
	private Random dice_generator;
	private Scanner reader;
	
	private static final int ROUND_NUMBER = 3;
	private static final int SEA_LENGTH = 5;
	
	// Do not modify the constructor except for player names
	public Game(){
		int[] prices1 = {3,4,5,5};
		int[] prices2 = {2,3,3};
		int[] prices3 = {3,4,5};
		Position[] pos1 = new Position[prices1.length];
		Position[] pos2 = new Position[prices2.length];
		Position[] pos3 = new Position[prices3.length];
		
		for(int i=0;i<prices1.length;i++){
			pos1[i] = new Position(prices1[i]);
		}
		for(int i=0;i<prices2.length;i++){
			pos2[i] = new Position(prices2[i]);
		}
		for(int i=0;i<prices3.length;i++){
			pos3[i] = new Position(prices3[i]);
		}
		
		Boat s1 = new Boat("Silk", 36, pos1);
		Boat s2 = new Boat("Coco",18, pos2);
		Boat s3 = new Boat("Jade", 30, pos3);
		this.boats = new Boat[3];
		boats[0] = s1;
		boats[1] = s2;
		boats[2] = s3;
		
		this.dice_generator = new Random();
		this.reader = new Scanner(System.in);
		
		this.players = new Player[3];
		this.players[0] = new Player("Lilei", 0);
		this.players[1] = new Player("Lucy", 1);
		this.players[2] = new Player("Lily", 2);
	}

	public int rollDice(){
		//TODO return a integer between 1 and 6
	}
	
	public void showCurrentState(){
		for(Boat s : this.boats){
			String res;
			res = "The "+s.getCargo_name()+" boat ("+s.getCargo_value()+"): [ ";
			for(Position pos: s.getPos_list()){
				if(pos.getSailorID() == -1)
					res += pos.getPrice()+"$ ";
				else
					res += this.players[pos.getSailorID()].getName()+" ";
			}
			
			res += "].";
			res += "The boat is at: "+s.getPos_in_the_sea(); 
			System.out.println(res);
		}
	}
	
	public void runGame() {
		for(int r=1;r<=ROUND_NUMBER;r++){
			System.out.println("Round "+r+":");
			
			// Show current state for the boats
			showCurrentState();
			
			// For each player, choose an available position on any boat
			// pay for that position
			for(Player p : this.players){
				System.out.println("For player "+p.getName()+", please choose a boat:");
				//TODO
			}
			
			// roll the dice to move the boats
			for(Boat s : this.boats){
				s.move(this.rollDice());
			}
		}
		
		// to see the final results
		calculateProfits();
		
		// to see the winner
		showWinner();
		
	}
	
	public void calculateProfits(){
		// see if boats have got to the harbor
		// share the money by selling the cargo
		//TODO
	}
	
	public void showWinner(){
		//TODO to find who is the winner
		System.out.println("The winner is: "+this.players[winner_id].getName());
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		
		g.runGame();
	}

}
