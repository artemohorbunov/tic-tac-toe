import java.util.Scanner;

public class TicTacToeRunner {

	public static void main(String[] args) {
		Board board = new Board();
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to Tic Tac Toe!");
		char playerSymbol;
		do {
			System.out.print("\nWould you like to play for X or O ?: ");
			playerSymbol = input.next().charAt(0);
			playerSymbol = Character.toUpperCase(playerSymbol);
		} while (playerSymbol != 'X' && playerSymbol != 'O');
		do {
			board.displayBoard();
			System.out.print("\nEnter a position from 1-9: ");
			int position = input.nextInt();
			position--;
			boolean userMoved = board.makeMove(position, playerSymbol); // User move
			if (userMoved) { // Only let PC make a move if a user successfully moved
				board.computersMove(playerSymbol); // PC move
			}
		} while (!board.checkWin());

	}

}
