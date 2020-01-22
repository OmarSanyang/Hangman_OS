import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

public class Dictionary {
	private String[] wordList = new String [211];
	private SecureRandom randomNumbers;
	
	

	
	public Dictionary () throws IOException{
		readFile();
		
	}//end of first constructor
	
	public void readFile() throws IOException{
		
		 Scanner fileScan = new Scanner(new File("handman.txt"));
		 for(int i = 0;i<212;i++) {
			 wordList[i]= fileScan.next();
		 }
	}//end of readFile 
	
	public String chooseWord() throws IOException {
		int i = randomNumbers.nextInt(212);
		return wordList[i];
	}
}//end class 
