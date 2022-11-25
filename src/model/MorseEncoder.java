package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class to encode messages
 * 
 * @author Joshua
 */
public class MorseEncoder
{
	String[] codes;
	Scanner fileReader;

	/**
	 * constructor that controls the methods used for encoding
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
    public MorseEncoder(String fileName) throws FileNotFoundException
    {
    	codes = new String[26];
		readCodes(fileName);

    }
    
    /**
	 * converts letter --> morse.
	 * 
	 * @param letter
	 * @return encoded character
	 */
    public String encode(char letter) {
		int x = letter;
		return codes[x - 65];

	}

    /**
	 * reads from the text file and changes it to the symbols.
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
    private void readCodes(String fileName) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(fileName));
        String l;
        String c;
        
        while (in.hasNextLine())
        {
            l = in.next();
            c = in.next();
            int e = l.charAt(0) - 65;
            codes[e] = c;
        }
        in.close();
    }
    
    /**
	 * Prints encoded items
	 */
    public void print() {   
    	int cl = 26;
        for (int i = 0; i < cl; i++) {
        	System.out.println(codes[i]);
        }
    }
   
}
