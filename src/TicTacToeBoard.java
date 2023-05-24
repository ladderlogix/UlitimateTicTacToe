public class TicTacToeBoard {
	private String[][] board;
	private String winner;
	private boolean Seclection = false;

	//Constructer for the class which sets a number into all the board positions
	public TicTacToeBoard(){
		winner = "";
		board = new String[3][3];
		int number = 1;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				board[i][j] = String.valueOf(number);
				number++;
			}
		}
	}

	//Changes what is at a spot
	public void setSpot(int x, int y, String player){
		board[x][y] = player;
		checkIfWin();
	}

	public String[][] getBoard() {
		return board;
	}

	public String getWinner() {
		return winner;
	}

	//Checks if there is a winner on the board by making a string and checking what it equals
	private void checkIfWin(){
		for (int a = 0; a < 8; a++) {
			String line = switch (a) {
				case 0 -> board[0][0] + board[0][1] + board[0][2];
				case 1 -> board[1][0] + board[1][1] + board[1][2];
				case 2 -> board[2][0] + board[2][1] + board[2][2];
				case 3 -> board[0][0] + board[1][0] + board[2][0];
				case 4 -> board[0][1] + board[1][1] + board[2][1];
				case 5 -> board[0][2] + board[1][2] + board[2][2];
				case 6 -> board[0][0] + board[1][1] + board[2][2];
				case 7 -> board[0][2] + board[1][1] + board[2][0];
				default -> null;
			};

			//For X winner
			if (line.equals("XXX")) {
				winner = "X";
			}

			// For O winner
			else if (line.equals("OOO")) {
				winner = "O";
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				if(board[i][j].equals(" ")){
					return;
				}
			}
		}
	}

	//Controls what appears red
	public void setSeclection(boolean seclection) {
		Seclection = seclection;
	}

	//Returns what color is need for the board
	public String colorReturn(){
		if(Seclection){
			return "\u001B[31m";
		}
		else{
			return "\u001B[30m";
		}
	}
}
