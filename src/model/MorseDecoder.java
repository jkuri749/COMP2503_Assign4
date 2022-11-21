package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class MorseDecoder
{
	BinaryTree<Character> intCode;

    public MorseDecoder(String fileName) throws FileNotFoundException {
        intCode = new  BinaryTree<Character>(null);
        createTree(fileName);
    }

    private void createTree(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        String letter;
        String code;

        while (in.hasNextLine()) {
            letter = in.next();
            code = in.next();
            placeCode (intCode, letter.charAt(0), code);
        }
        in.close();
    }
    
    public char decode(String code) {   
        return decoder(intCode, code);
    }
    
    private void placeCode(BinaryTree<Character> m, char charToPlace, String code) {
        char firstCharInCode;

        if (code.equals("-")) {   
            BinaryTree<Character> n = new  BinaryTree<Character>(charToPlace);
            m.setLeft(n);
        }
        else if (code.equals(".")) {
            BinaryTree<Character> n = new  BinaryTree<Character>(charToPlace);
            m.setRight(n);            
        }
        else {
            firstCharInCode = code.charAt(0);
            code = code.substring(1);
            if (firstCharInCode == '-')
            { 
                placeCode (m.getLeft(), charToPlace, code);
            }
            else
            { 
                placeCode (m.getRight(), charToPlace, code);
            }                
        }
    }
    
    private char decoder(BinaryTree<Character> m, String code) {   
        char firstCharInCode;
        char decodedChar;

        if (code.equals(""))   // at the node containing letter
        {
            decodedChar = m.getRootElement();
            //System.out.print(decodedChar);
        }
        else
        {
            firstCharInCode = code.charAt(0);
            code = code.substring(1);
            
            if (firstCharInCode == '+')   // go left
                decodedChar = decoder(m.getLeft(), code);
            else
                decodedChar = decoder(m.getRight(), code);
        }
        //System.out.println(decodedChar);
        return decodedChar;
    }
}