package application;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.MorseMessageDecoder;
import model.MorseMessageEncoder;


public class MCodeApp 
{
    /**
     *  handles all the encoding and decoding menus using all the respective classes
     * @throws Exception 
     */
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(System.in);
        MorseMessageDecoder decoder = new  MorseMessageDecoder();
        MorseMessageEncoder encoder = new  MorseMessageEncoder();
        String message;
        char choice = ' ';

        do {
			System.out.print("\nEnter E (encode), D (decode) or Q(quit): ");
			try {
				choice = in.nextLine().toUpperCase().charAt(0);
				switch (choice) {
				case 'D':
					System.out.println("Enter the message you'd like to decode from Morse Code");
					message = in.nextLine();
					decoder.decodeMessage(message);
					break;
				case 'E':
					System.out.println("Enter the message you'd like to encode into Morse Code");
					message = in.nextLine();
					encoder.encodeMessage(message);
				default:
				}
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Invalid entry - try again");
			}
		} while (choice != 'Q');
    }
}
