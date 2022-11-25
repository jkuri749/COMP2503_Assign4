package model;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * takes in the users coded message and decodes it
 * 
 * @author Joshua
 */
public class MorseMessageDecoder 
{
	
//    MorseDecoder md;
    
    /**
    * decodes a message based on inputted String
    * 
    * @param message
    * @throws FileNotFoundException
    */
   public void decodeMessage(String message) throws FileNotFoundException {
		String coded;
		String[] words;
		String[] decodedLetters;

		Scanner sentenceReader = new Scanner(message);
		while (sentenceReader.hasNextLine()) {
			coded = sentenceReader.nextLine();
			words = coded.split(" ".repeat(7));

			for (String codedWord : words) {
				decodedLetters = codedWord.split(" ".repeat(3));
				for (String codedLetter : decodedLetters) {
					System.out.print(decoded(codedLetter));
				}
				System.out.print(" ");
			}
		}
		sentenceReader.close();
	}
   /**
    * calls and returns letter decoded message
    * 
    * @param c
    * @return decoded character 
    * @throws FileNotFoundException
    */
   private char decoded(String c) throws FileNotFoundException {
       MorseDecoder d = new MorseDecoder("res/codes.txt");
       return d.decode(c);
   }

}