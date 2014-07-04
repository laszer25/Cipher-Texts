import java.lang.Math;
import java.util.*;

public class Answer {

	public static void main(String[] args){
		Scanner sc =  new Scanner(System.in);
		String inputstring = sc.nextLine();
		String formattedstring;
		formattedstring = inputstring.replaceAll("\\s", "");// Removes the whitespaces
		
		//Length of the input string without whitespaces
		int stringlength = 0;
		stringlength = formattedstring.length();
		
		//check if the length belongs to which square
		double takesqrt;
		takesqrt = Math.sqrt(stringlength);
		
		//find out the length of column and row
		int column,row;
		column = (int) takesqrt;
		row = stringlength/column;
		
		
		//check for '*'
		if(formattedstring.contains("*") == true){
			decrypt(formattedstring,column,row,stringlength);
		}
		else{
			encrypt(formattedstring,column,row,stringlength);
		}
	}

	private static void encrypt(String formattedstring, int column, int row, int stringlength) {
		// TODO Auto-generated method stub
		
		
		// check for extra character which is more than perfect matrix to fill in '*'
		if(stringlength > row*column){
			row++;
		}
		
		//fill in the '*' to the end of the block
		for(int i = 0; i< ((row*column)-stringlength); i++){
			formattedstring = formattedstring+"*";
		}
		
		//create matrix for the rows and columns
		char[][] matrix = new char[row][column];
		
		//intiate counter to iterate through the values of the modified formattedstring
		int itercount = 0;
		
		// access two dimensional matrix
		for(int i = 0; i < row; i++){//for row

			for( int j = 0; j < column ; j++){// for column
				//insert data into matrix
				matrix[i][j] = formattedstring.charAt(itercount);
				itercount++;
			}
		}
		
		// access the matrix for printing
		for( int j = 0; j < column ; j++){//for column
			for(int i = 0; i < row; i++){// for row
					
				System.out.print(matrix[i][j]);
			}
		}
	}

	private static void decrypt(String formattedstring, int column, int row, int stringlength) {
		// TODO Auto-generated method stub
				
				//create matrix for the rows and columns
				char[][] matrix = new char[column][row];
				
				//intiate counter to iterate through the values of the modified formattedstring
				int itercount = 0;
				
				// access two dimensional matrix
				for(int i = 0; i < column; i++){//for row

					for( int j = 0; j < row ; j++){// for column
						//insert data into matrix
						
						matrix[i][j] = formattedstring.charAt(itercount);
						itercount++;
					}
				}
				String result = "";
				itercount = 0;
				// access the matrix for printing
				for( int j = 0; j < row ; j++){//for column
					for(int i = 0; i < column; i++){// for row
							//storing the decrypted string in result matrix
						result = result+matrix[i][j];
					}
				}		
				// replacing the '*' characters
				String finalstring = result.replace('*', ' ');
				//printing the final result
				System.out.println(finalstring);
	}
}
