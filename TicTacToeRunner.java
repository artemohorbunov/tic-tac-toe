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
			boolean userMoved = board.makeMove(position, playerSymbol); // User move
			boolean win = board.checkWin(playerSymbol); // Check if there's a win
			if (win) {
				System.out.println("\nPlayer " + playerSymbol + " WON!");
				board.displayBoard();
				break;
			}
			if (userMoved && !win) { // Only let PC make a move if a user successfully moved and there isn't a win
				if (board.computersMove(playerSymbol)) { // PC move
					break;
				}
			}
		} while (!board.checkWin(playerSymbol));

	}

}
