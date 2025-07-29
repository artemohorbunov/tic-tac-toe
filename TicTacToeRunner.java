import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeRunner {

	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game(board); // Passing existing board to game class
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to Tic Tac Toe!");
		char playerSymbol;
		boolean win;
		boolean full;
		boolean userMoved = false;
		do {
			System.out.print("\nWould you like to play for X or O ?: ");
			playerSymbol = input.next().charAt(0);
			playerSymbol = Character.toUpperCase(playerSymbol);
		} while (playerSymbol != 'X' && playerSymbol != 'O');
		do {
			board.displayBoard();
			try {
				System.out.print("\nEnter a position from 1-9: ");
				int position = input.nextInt();
				userMoved = game.makeMove(position, playerSymbol); // User move
				// If user inputs anything other than numbers 1-9 this will catch it
			} catch (InputMismatchException | IndexOutOfBoundsException e) {
				System.out.println("\nOnly numbers from 1-9!");
				input.nextLine(); // Clear the buffer to avoid an infinite loop
			}
			win = game.checkWin(playerSymbol); // Check if there's a win
			full = game.isFull(); // Check if board is full
			if (full && !win) {
				System.out.println("Draw!");
			}
			if (win) {
				System.out.println("\nPlayer " + playerSymbol + " WON!");
				break;
			}
			// Let PC move if a user successfully moved and there isn't a win or full-board
			if (userMoved && !win && !full) {
				if (game.computersMove(playerSymbol)) { // PC move
					break;
				}
			}
		} while (!win && !full);
		board.displayBoard();
		input.close();
	}
}
