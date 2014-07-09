	/* PROBLEM STATEMENT
	 * A lot of people are snooping on you and reading your texts. You plan to encrypt it using a transposition cipher. Write a program that can both encrypt and decrypt the messages. It will accept a string, and a choice of whether to encrypt or decrypt it. 
	 *
	 * Transposition cipher works by changing the position of the letters in the sentence. Break down the sentence into a square [Floor value. For 9 characters it is 3x3, for 12 it is 3x3 + 3, for 14 it is 3x3 + 5] (If there are extra characters, add them to the bottom of the square and convert them to *) and use the algorithm to get the encrypted and decrypted text.
	 *
	 * For Example:
 	 * “lets go geocaching” can be broken into :
	 *
	 * l e t s
	 * g o g e 
	 * o c a c 
	 * h i n g
	 * 
	 * The encrypted text will be lgoheocitgansecg.
	 * 
	 * HRUNDOEDGEWYOD*AOIU* can be broken into :
	 * 
	 * H R U N D
	 * O E D G E
	 * W Y O D *
	 * A O I U *
	 * 
	 * The decrypted text will be HOWAREYOUDOINGDUDE.
	 *
	 */



import java.lang.Math;
import java.util.*;

public class Answer {
	
	public static void main(String[] args){
		
			// Take the input string that has to be decrypted or encrypted
			// and store it as the "inputString"
		Scanner sc =  new Scanner(System.in);
		String inputString = sc.nextLine();
		
		
		
		
			// The inputstring may have white spaces in between
			// we remove the whitespaces and store the new string 
			// with the whitespaces removed as the "formattedString"
		String formattedString;
		formattedString = inputString.replaceAll("\\s", "");// Removes the whitespaces
		
		
		
		
			// Then we find out the length of the "formattedString" 
			// this will give us the idea of what the size of the matrix should be
		int stringLength = 0;
		stringLength = formattedString.length();
		
		
		
			// Since the matrix has to be a square matrix + additional rows we find
			// the size of the square matrix by taking the square root of the length
		double takeSqrt;
		takeSqrt = Math.sqrt(stringLength);
		
		
		
		
			// The base integer of the square root will give us the number of columns 
			// that have to be taken for the matrix
			// and the number of rows that have to be there for the decryption is 
			// obtained by dividing the length of the input and the number of columns
		int column,row;
		column = (int) takeSqrt;
		row = stringLength/column;
		
		
			// Creating the object for the Solver class to get the encrypted/decrypted string
			// the Solver class contains methods to encrypt and decrypt the input string(formattedString)
		Solver getSolution = new Solver();
		
		
			// check for '*' in the input string
			// if the input string(formattedString) contains the "*" character, then
			// it means that the string has to be decrypted and it is done using the "decrypt"
			// method in the Solver object which returns the decrypted string.
			// else if the input string(formattedString) doesn't contain the "*" character
			// it means that it either is to be encrypted or the encrypted string length is 
			// a perfect square and therefore the same process will work to decrypt the string 
			// if it has a perfect square length and it is done using the "encrypt" method 
			// in the Solver object which returns an encrypted or decrypted string.
			// if the stringLength is equal to the number of cells in the matrix and if the matrix 
			// is not a square matrix then it is impossible to determine whether to encrypt or decrypt
			// the string hence we give out both the cases.
		if(stringLength == (row*column) && row !=  column){
			System.out.println("Encrypted: " + getSolution.encrypt(formattedString, column, row, stringLength));
			System.out.println("Decrypted: " + getSolution.decrypt(formattedString, column, row));
			
		}
		else if(formattedString.contains("*") == true){
			
			System.out.println(getSolution.decrypt(formattedString, column, row));
		}
		else{
			System.out.println(getSolution.encrypt(formattedString, column, row, stringLength));
		}
	}

	}
