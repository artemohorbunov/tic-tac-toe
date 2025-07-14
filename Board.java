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

	public boolean checkWin() { // DO NEXT
		for (int i = 0; i < board.size(); i++) {

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
	    if (isOpen(position)) {
	        board.set(position, symbol);
	        return true;                 // move accepted
	    } else {
	        System.out.println("\nThat square is already filled!");
	        return false;                // move rejected
	    }
	}


	public void computersMove(char opponentsSymbol) { // Randomly pick an index from board and make a move if it's open
		if (opponentsSymbol == 'X') {
			computersSymbol = 'O';
		} else {
			computersSymbol = 'X';
		}
		do {
			random = (int) (Math.random() * board.size()); // Generate a random number 0-8
			isOpen(random);
		} while (!isOpen(random));
		makeMove(random, computersSymbol);
	}

	public ArrayList<Character> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<Character> board) {
		this.board = board;
	}
}