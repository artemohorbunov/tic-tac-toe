import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	private ArrayList<Character> board = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));

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

	public ArrayList<Character> getBoard() {
		return board;
	}

	public void setBoard(int position, char symbol) {
		board.set(position, symbol);
	}
}