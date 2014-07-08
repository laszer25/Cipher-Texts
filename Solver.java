
public class Solver {

	public String  encrypt(String formattedString, int column, int row, int stringLength) {
		
			
		
			// check for extra character which is more than perfect matrix to fill in '*'
			// if there are extra characters that doesn't have a row we add a new row
		if(stringLength > row*column){
			row++;
		}
		
		
		
		
			// fill in the '*' to the end of the string so that the left over space 
			// in the extra row can be filled with "*"'s
		for(int i = 0; i< ((row*column)-stringLength); i++){
			formattedString = formattedString+"*";
		}
		
		
		
			// create the matrix for with the given number of rows and columns
		char[][] matrix = new char[row][column];
		
		
		
			// initiate a counter to iterate through the values of the "formattedString"
			// to  keep track of the index of the characters in the string
		int iterCount = 0;
		
		
		
			// now we fill the matrix with the given string such that the characters are
			// filled in row after row from the formattedString
		for(int i = 0; i < row; i++){	//for row
			for( int j = 0; j < column ; j++){	// for column
					//insert data into matrix
				matrix[i][j] = formattedString.charAt(iterCount);
				iterCount++;
			}
		}
		
		
		
			// Create a string to store the encrypted result in
		String result = "";

		
		
			// The encryption is done by reading the string column after column
			// instead of reading the string row after row and storing the encrypted string 
			// in the result string
		for( int j = 0; j < column ; j++){//for column
			for(int i = 0; i < row; i++){// for row
					
				result =  result+matrix[i][j];
			}
		}
		
		
		
			// return the encrypted string
		return result;
	}

	public String decrypt(String formattedString, int column, int row) {
		
		
		
			// create the matrix for with the given number of rows and columns
		char[][] matrix = new char[column][row];
		
		
		
			//initiate a counter to keep the index of the while decrypting formattedString
		int iterCount = 0;

		
		
			// Fill the matrix with the input string column after column with the 
			// characters that are there in the input string that is to be decrypted
		for(int i = 0; i < column; i++){	//for row
				for( int j = 0; j < row ; j++){	// for column
					//insert data into matrix
				matrix[i][j] = formattedString.charAt(iterCount);
				iterCount++;
				}
			}
		
		
		
			// Create a string to store the decrypted result in
		String result = "";
			
		
		
		
			// The decryption is done by reading the characters in the matrix
			// row after row and storing the characters in the result string
		for( int j = 0; j < row ; j++){	//for column
			for(int i = 0; i < column; i++){	// for row
						//storing the decrypted string in result string
					result = result+matrix[i][j];
				}
			}		
		
		
		
		
			// replacing the '*' characters in the decrypted string with white spaces
			// to give the final decrypted string "finalString"
		String finalString = result.replace('*', ' ');
		
		
		
			// Return the decrypted string
		return finalString;
	}

}
