package model;

import java.io.FileNotFoundException;

/**
 * has all the methods to convert a normal sentence into morse code
 * 
 * @author Joshua
 * @author Gurman
 */
public class MorseMessageEncoder
{
	MorseEncoder e;
    String s = "";
    
    /**
     * Encodes a message
     * 
     * @param message
     * @throws Exception
     */
    public void encodeMessage(String message) throws Exception {
    	
    	String[] words = message.toUpperCase().split(" ");
    	
		for (int i = 0; i < words.length; i++) {
			
			for (int j = 0; j < words[i].length(); j++) {
				
				words[i].charAt(j);
				System.out.print(encoded(words[i].charAt(j)));
				System.out.print(" ".repeat(3));
			}
			
			System.out.print(" ".repeat(7));
		}
    }
    
    /**
	 * encodes a letter
	 * 
	 * @param code
	 * @returns encoded letter
	 * @throws FileNotFoundException
	 */
	private String encoded(char letter) throws FileNotFoundException {
		
		MorseEncoder encoder = new MorseEncoder("res/codes.txt");
		return encoder.encode(letter);
	}

}