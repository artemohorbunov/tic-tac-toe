import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	private ArrayList<Character> board = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
	private char computersSymbol;
	private int random;

	public void displayBoard() {
		System.out.println();
		for (int i = 0; i < 3; i++) { // 3 rows
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + board.get(i * 3 + j));
				if (j < 2)
					System.out.print(" |");
			}
			System.out.println();
			if (i < 2) {
				System.out.println("-----------");
			}
		}
	}

	public boolean checkWin(char symbol) {
		// Check first row 1,2,3
		if (board.get(0) == symbol && board.get(1) == symbol && board.get(2) == symbol) {
			return true;
		}
		// Check second row 4,5,6
		if (board.get(3) == symbol && board.get(4) == symbol && board.get(5) == symbol) {
			return true;
		}
		// Check third row 7,8,9
		if (board.get(6) == symbol && board.get(7) == symbol && board.get(8) == symbol) {
			return true;
		}
		// Check first column 1,4,7
		if (board.get(0) == symbol && board.get(3) == symbol && board.get(6) == symbol) {
			return true;
		}
		// Check second column 2,5,8
		if (board.get(1) == symbol && board.get(4) == symbol && board.get(7) == symbol) {
			return true;
		}
		// Check third column 3,6,9
		if (board.get(2) == symbol && board.get(5) == symbol && board.get(8) == symbol) {
			return true;
		}
		// Check diagonal 1,5,9
		if (board.get(0) == symbol && board.get(4) == symbol && board.get(8) == symbol) {
			return true;
		}
		// Check diagonal 3,5,7
		if (board.get(2) == symbol && board.get(4) == symbol && board.get(6) == symbol) {
			return true;
		}

		return false;
	}

	public boolean isOpen(int position) {
		if (board.get(position) == 'X' || board.get(position) == 'O') {
			return false;
		} else {
			return true;
		}
	}

	public boolean isFull() { // DO NEXT
		return false;
	}

	public boolean makeMove(int position, char symbol) {
		position--; // Change position to reflect 0-based indexing
		if (isOpen(position)) {
			board.set(position, symbol);
			return true; // move accepted
		} else {
			System.out.println("\nThat square is already filled!");
			return false; // move rejected
		}
	}

	public boolean computersMove(char opponentsSymbol) { // Randomly pick an index from board and make a move if it's
															// open
		if (opponentsSymbol == 'X') {
			computersSymbol = 'O';
		} else {
			computersSymbol = 'X';
		}
		do {
			random = (int) (Math.random() * board.size()); // Generate a random number 0-8
		} while (!isOpen(random));
		makeMove(random + 1, computersSymbol); // +1 because makeMove() uses 1-based indexing
		boolean pcWin = checkWin(computersSymbol);
		if (pcWin) {
			System.out.println("\nComputer player " + computersSymbol + " WON!");
			displayBoard();
			return true;
		}
		return false;
	}

	public ArrayList<Character> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<Character> board) {
		this.board = board;
	}
}