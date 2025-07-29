import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeRunner {

	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game(board); // Passing existing board to game class
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to Tic Tac Toe!");
		char player1Symbol;
		byte mode;
		boolean win;
		boolean full;
		boolean userMoved = false;
		do {
			System.out.print("\nWho would you like to play against:\n1.Computer\n2.Another player\n");
			mode = input.nextByte();
			System.out.print("\nWould you like to play for X or O ?: ");
			player1Symbol = input.next().charAt(0);
			player1Symbol = Character.toUpperCase(player1Symbol);
		} while (player1Symbol != 'X' && player1Symbol != 'O');
		do {
			board.displayBoard();
			try {
				System.out.print("\nEnter a position from 1-9: ");
				int position = input.nextInt();
				userMoved = game.makeMove(position, player1Symbol); // User move
				// If user inputs anything other than numbers 1-9 this will catch it
			} catch (InputMismatchException | IndexOutOfBoundsException e) {
				System.out.println("\nOnly numbers from 1-9!");
				input.nextLine(); // Clear the buffer to avoid an infinite loop
			}
			win = game.checkWin(player1Symbol); // Check if there's a win
			full = game.isFull(); // Check if board is full
			if (full && !win) {
				System.out.println("Draw!");
			}
			congratulations(win, player1Symbol);
			// Let PC move if a user successfully moved and there isn't a win or full-board
			// Skip PC move if user chose another player mode 2
			if (userMoved && !win && !full && mode == 1) {
				win = game.computersMove(player1Symbol);
				if (win) { // PC move
					congratulations(win, game.getPlayer2Symbol());
					break; // If PC won break out of the game loop
				}
			}
			if (mode == 2) { // Handles second player logic
				board.displayBoard();
				System.out.print("\nSecond player enter a position from 1-9: ");
				int position = input.nextInt();
				game.changeSymbol(player1Symbol);
				game.makeMove(position, game.getPlayer2Symbol());
				win = game.checkWin(game.getPlayer2Symbol()); // Check if there's a win
				congratulations(win, game.getPlayer2Symbol());
			}
		} while (!win && !full);
		board.displayBoard();
		input.close();
	}
	
	private static boolean congratulations(boolean winner, char symbol) {
		if (winner) {
			System.out.println("\nPlayer " + symbol + " WON!");
			return true;
		}
		return false;
	}
}
