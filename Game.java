import java.util.ArrayList;

public class Game {
	char player2Symbol;
	private int random;
	private Board board;

	Game(Board board) {
		this.board = board;
	}

	public boolean checkWin(char symbol) {
		// Check first row 1,2,3
		if (board.getBoard().get(0) == symbol && board.getBoard().get(1) == symbol
				&& board.getBoard().get(2) == symbol) {
			return true;
		}
		// Check second row 4,5,6
		if (board.getBoard().get(3) == symbol && board.getBoard().get(4) == symbol
				&& board.getBoard().get(5) == symbol) {
			return true;
		}
		// Check third row 7,8,9
		if (board.getBoard().get(6) == symbol && board.getBoard().get(7) == symbol
				&& board.getBoard().get(8) == symbol) {
			return true;
		}
		// Check first column 1,4,7
		if (board.getBoard().get(0) == symbol && board.getBoard().get(3) == symbol
				&& board.getBoard().get(6) == symbol) {
			return true;
		}
		// Check second column 2,5,8
		if (board.getBoard().get(1) == symbol && board.getBoard().get(4) == symbol
				&& board.getBoard().get(7) == symbol) {
			return true;
		}
		// Check third column 3,6,9
		if (board.getBoard().get(2) == symbol && board.getBoard().get(5) == symbol
				&& board.getBoard().get(8) == symbol) {
			return true;
		}
		// Check diagonal 1,5,9
		if (board.getBoard().get(0) == symbol && board.getBoard().get(4) == symbol
				&& board.getBoard().get(8) == symbol) {
			return true;
		}
		// Check diagonal 3,5,7
		if (board.getBoard().get(2) == symbol && board.getBoard().get(4) == symbol
				&& board.getBoard().get(6) == symbol) {
			return true;
		}

		return false;
	}

	public boolean isOpen(int position) {
		if (board.getBoard().get(position) == 'X' || board.getBoard().get(position) == 'O') {
			return false;
		} else {
			return true;
		}
	}

	public boolean isFull() {
		for (Character c : board.getBoard()) {
			if (Character.isDigit(c)) { // If true this spot isn't filled
				return false;
			}
		}
		System.out.println("\nBoard is now full!");
		return true;
	}

	public boolean makeMove(int position, char symbol) {
		position--; // Change position to reflect 0-based indexing
		if (isOpen(position)) {
			board.setBoard(position, symbol);
			return true; // move accepted
		} else {
			System.out.println("\nThat square is already filled!");
			return false; // move rejected
		}
	}

	public void changeSymbol(char player1Symbol) { // Handle turns for both PC and 2nd player
		if (player1Symbol == 'X') {
			player2Symbol = 'O';
		} else {
			player2Symbol = 'X';
		}
	}

	public boolean computersMove(char player1Symbol) {
		// Randomly pick an index from board and make a move if it's open
		changeSymbol(player1Symbol);
		do {
			random = (int) (Math.random() * ((ArrayList<Character>) board.getBoard()).size()); // Generate a random
																								// number 0-8
		} while (!isOpen(random));
		makeMove(random + 1, player2Symbol); // +1 because makeMove() uses 1-based indexing
		boolean pcWin = checkWin(player2Symbol);
		if (pcWin) {
			System.out.println("\nComputer player " + player2Symbol + " WON!");
			return true;
		}
		return false;
	}

	public char getPlayer2Symbol() {
		return player2Symbol;
	}
}