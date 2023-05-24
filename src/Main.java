//Imports the scanner class
import java.util.*;
public class Main {
	public static void main(String[] args) {
		//Defines the scanner class as input
		Scanner input = new Scanner(System.in);

		//Creates a 2d array of tictactoe boards
		TicTacToeBoard[][] game = new TicTacToeBoard[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				game[i][j] = new TicTacToeBoard();
			}
		}

		//Selects the middle boards as the starting board and tells player one to go first
		game[1][1].setSeclection(true);
		boolean player1turn = true;

		//Prints out the board and adds the x and y to a broad scope
		printBoard(game);
		int x = 1;
		int y = 1;

		// Initializes the last board variables at a high scope
		int lastx = 1;
		int lasty = 1;

		//Continues to play until there is a winner
		while(!isWinner(game)){
			if(player1turn){
				System.out.println("Player 1's turn");
				System.out.println("Input your spot: ");
				int spot = input.nextInt();
				int[] xy = convert(spot);
				x = xy[0];
				y = xy[1];
				game[lastx][lasty].setSpot(x, y, "X");
				game[lastx][lasty].setSeclection(false);
				lastx = x;
				lasty = y;
				game[lastx][lasty].setSeclection(true);
				printBoard(game);
				player1turn = false;
			}
			else{
				System.out.println("Player 2's turn");
				System.out.println("Input your spot: ");
				int spot = input.nextInt();
				int[] xy = convert(spot);
				x = xy[0];
				y = xy[1];
				game[lastx][lasty].setSpot(x, y, "O");
				game[lastx][lasty].setSeclection(false);
				lastx = x;
				lasty = y;
				game[lastx][lasty].setSeclection(true);
				printBoard(game);
				player1turn = true;
			}
		}
		if(player1turn){
			System.out.println("Player 2 wins!");
		}
		else{
			System.out.println("Player 1 wins!");
		}
	}

	//Prints out the board by getting the line of every board
	public static void printBoard(TicTacToeBoard[][] game) {
		System.out.println("|-------|-------|-------|");
		for(int i = 0; i < 3; i++){
			String[][] game1 = game[i][0].getBoard();
			String[][] game2 = game[i][1].getBoard();
			String[][] game3 = game[i][2].getBoard();

			String game1Color = game[i][0].colorReturn();
			String game2Color = game[i][1].colorReturn();
			String game3Color = game[i][2].colorReturn();

			String white = "\u001B[0m";

			for(int y = 0; y < 3; y++){
				System.out.println("| " + game1Color + game1[y][0] + " " + game1[y][1] + " " + game1[y][2] + white +" | " + game2Color + game2[y][0] + " " + game2[y][1] + " " + game2[y][2] + white + " | " + game3Color + game3[y][0] + " " + game3[y][1] + " " + game3[y][2] + white + " |");
			}
			System.out.println("|-------|-------|-------|");
		}
	}


	//Creates a string with all the winning possibles and checks if x or o matches any of them
	public static boolean isWinner(TicTacToeBoard[][] game) {
		for (int a = 0; a < 8; a++) {
			String line = switch (a) {
				case 0 -> game[0][0].getWinner() + game[0][1].getWinner() + game[0][2].getWinner();
				case 1 -> game[1][0].getWinner() + game[1][1].getWinner() + game[1][2].getWinner();
				case 2 -> game[2][0].getWinner() + game[2][1].getWinner() + game[2][2].getWinner();
				case 3 -> game[0][0].getWinner() + game[1][0].getWinner() + game[2][0].getWinner();
				case 4 -> game[0][1].getWinner() + game[1][1].getWinner() + game[2][1].getWinner();
				case 5 -> game[0][2].getWinner() + game[1][2].getWinner() + game[2][2].getWinner();
				case 6 -> game[0][0].getWinner() + game[1][1].getWinner() + game[2][2].getWinner();
				case 7 -> game[0][2].getWinner() + game[1][1].getWinner() + game[2][0].getWinner();
				default -> null;
			};

			//For X winner
			if (line.equals("XXX")) {
				return true;
			}

			// For O winner
			else if (line.equals("OOO")) {
				return true;
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				if(game[i][j].getWinner().equals(" ")){
					return false;
				}
			}
		}
		return false;
	}

	//Converts the player input to a row and coloum selection
	public static int[] convert(int number){
		return switch (number) {
			case 1 -> new int[]{0, 0};
			case 2 -> new int[]{0, 1};
			case 3 -> new int[]{0, 2};
			case 4 -> new int[]{1, 0};
			case 5 -> new int[]{1, 1};
			case 6 -> new int[]{1, 2};
			case 7 -> new int[]{2, 0};
			case 8 -> new int[]{2, 1};
			case 9 -> new int[]{2, 2};
			default -> new int[]{0, 0};
		};
	}
}