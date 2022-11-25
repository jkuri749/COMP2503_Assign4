package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * Class that decodes a letter message based on tree level 
 * @author joshuakuriakose
 *
 */
public class MorseDecoder {
	BinaryTree<Character> charCode;

	/**
	 * sets charCode to null creates a tree using the file name
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public MorseDecoder(String fileName) throws FileNotFoundException {
		charCode = new BinaryTree<Character>(null);
		createTree(fileName);

	}

	/**
	 * reads the file and changes each letter to a symbol
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	private void createTree(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		String letter;
		String code;
		while (input.hasNextLine()) {
			letter = input.next();
			code = input.next();
			placeCode(charCode, letter.charAt(0), code);
		}
		input.close();
	}

	/**
	 * goes through the tree based of the starting symbol and places it according to
	 * left or right
	 * 
	 * @param m
	 * @param charToPlace
	 * @param code
	 */
	private void placeCode(BinaryTree<Character> m, char charToPlace, String code) {
		char firstCharInCode;
		if (code.equals(".")) {
			BinaryTree<Character> n = new BinaryTree<Character>(charToPlace);
			m.setLeft(n);
		} else if (code.equals("-")) {
			BinaryTree<Character> n = new BinaryTree<Character>(charToPlace);
			m.setRight(n);
		} else {
			firstCharInCode = code.charAt(0);
			code = code.substring(1);
			if (firstCharInCode == '.') {
				placeCode(m.getLeft(), charToPlace, code);
			} else {
				placeCode(m.getRight(), charToPlace, code);
			}
		}
	}

	/**
	 * prints out each symbol and letter
	 */
	public void print() {
		Iterator<Character> it = charCode.iterator();

		while (it.hasNext())
			System.out.print(it.next() + " ");
	}

	/**
	 * calls the decode method and passes in a coded symbol
	 * 
	 * @param code
	 * @return letter that was decoded
	 */
	public char decode(String code) {
		return decoder(charCode, code);
	}

	/**
	 * looks through the tree and returns the letter for each symbol
	 * 
	 * @param m
	 * @param code
	 * @return letter that is decoded
	 */
	private char decoder(BinaryTree<Character> m, String code) {
		char firstCharInCode;
		char decodedChar;

		if (code.equals("")) // at the node containing letter
		{
			decodedChar = m.getRootElement();
		} else {
			firstCharInCode = code.charAt(0);
			code = code.substring(1);

			if (firstCharInCode == '.')
				decodedChar = decoder(m.getLeft(), code);
			else
				decodedChar = decoder(m.getRight(), code);
		}

		return decodedChar;
	}
}