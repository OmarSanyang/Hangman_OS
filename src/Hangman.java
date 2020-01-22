import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hangman {

	private int wins;
	private int losses;
	private String currentWord;
	private Dictionary dictionary = new Dictionary();
	private int RW = 0;
	private int RL = 0;
	
	public Hangman() throws IOException {
		
		currentWord = dictionary.chooseWord();
		
	}//end of Hangman constructor 
	
	private void loadWL() throws IOException{
		
		Scanner fScan = new Scanner(new File("handnad.txt"));
		while (fScan.hasNextInt()) {
			int W = fScan.nextInt();
			int L = fScan.nextInt();
			System.out.println("Number of times wins: "+ wins +"Number of losses: " + losses);
			
		}
		
	}//end of loadWL constructor
	
	private void writeWL() throws IOException{
		Scanner fScan = new Scanner(new File("handnad.txt"));
		int W = fScan.nextInt();
		int L = fScan.nextInt();
		
		int Twins = W + wins;
		int Tlosses = L + losses;
		
		FileWriter writer = new FileWriter("handnad.txt", false);
		writer.write(" " + Twins + " " + Tlosses);
		writer.close();
		
	}//end of writeWl constructor 

	
	public void playGame() throws IOException{
		
		int guesses = 5;
		ArrayList<Character> word = new ArrayList<Character>();
		for(int c = 0; c > currentWord.length();c++)
			word.add('-');

		Scanner sc = new Scanner(System.in);
		System.out.println("<<START>>");
		System.out.println("\tWould You Like to Play Hangman Y/N?");
		char player = sc.next().charAt(0);
	     while (player == 'Y' || player == 'y') {
	       wins = 0;
	       losses = 0;
	       System.out.println("\nYou have " + guesses + "Incorrect Guesses left.");
	       if(guesses > 0) {
	    	   for (int i = 0; i < word.size();i++) {
	    	   System.out.print(word.get(i) + " ");
	  
	       }

	       System.out.print("\n What is your guess?");
	       String Player = sc.next();
	       if(Player.equals(currentWord)) {
	    	   RW++;
	    	   wins++;
	    	   System.out.println("\n \\nYou guessed the correct word, You won!");
	    	   System.out.println(" You had" + RW + " win and " + RL + " losses this round.");
	    	   writeWL();
	    	   loadWL();
	    	   
	    	   System.out.println("\nWould you like to play again Y/N?");
	    	   player = sc.next().charAt(0);
	    	   currentWord = dictionary.chooseWord();
	    	   word.clear();
	    	   for(int i = 0; i < currentWord.length();i++)
	    		   word.add('-');
	    	   guesses = 5;
	    	   
	       }
	       else {
	    	   char guess= Player.charAt(0);
	    	   int g = 0;
	    	   for (int j = 0; j < currentWord.length();j++) {
	    		
	    		   if(guess == currentWord.charAt(j)) {
		    		   word.set(j, guess);
		    		   g++;
	    	
	    	   		}
	    	   }
	    	   if(g == 0) {
	    		   guesses --;
	    	
	    	   }
	    	   String wC = " ";
    		   for (Character i : word) {
    			   wC += i;
    		   }
    			   if(wC.equals(currentWord)) {
    				   System.out.println("\n" + currentWord);
    				   RW++;
    				   wins++;
    				   System.out.println("\n You Won!");
    		    	   System.out.println(" You had" + RW + " win and " + RL + " losses this round.");
    		    	   writeWL();
    		    	   loadWL();
    		    	   System.out.println("\nWould you like to play again Y/N?");
    		    	   player = sc.next().charAt(0);
    		    	   currentWord = dictionary.chooseWord();
    		    	   word.clear();
    		    	   
    		    	   for(int l = 0; l < currentWord.length();l++) {
    		    		   word.add('-');
    		    	   guesses = 5;
    			   }
	    	   
    			   }
	       
	       else {
	    	   RL++;
	    	   losses++;
	    	   System.out.println("\nYou are out of guesses, You lost,\nThe word was " + currentWord);
	    	   System.out.println(" You had" + RW + " win and " + RL + " losses this round.");
	    	   writeWL();
	    	   loadWL();
	    	   System.out.println("\nWould you like to play again Y/N?");
	    	   player = sc.next().charAt(0);
	    	   currentWord = dictionary.chooseWord();
	    	   word.clear();
	    	   for(int l = 0; l < currentWord.length();l++) {
	    		   word.add('-');
	    	   guesses = 5;
	    	   }
	       }
    			   if (player != 'Y' || player != 'y') {
    				   System.out.println("\n\t<<END>>");
    			   }
	      
		
	}//end of playGame constructor 

	  }//end of class