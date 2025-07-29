# CLI Tic Tac Toe

A simple console-based implementation of the classic **Tic Tac Toe** game written in Java. Play against a basic computer opponent directly in your terminal.

## 📌 Features

- Player vs Computer mode
- Turn-based gameplay
- Input validation and error handling
- Win and draw detection
- Basic AI (random open spot selection)

## 🛠️ Technologies Used

- Java (JDK 24+ recommended)
- No external libraries
- Console-based interface

## 🎮 How to Play

1. Clone the repository:

```
   git clone https://github.com/artemohorbunov/tic-tac-toe.git
   cd tic-tac-toe
```

2. Compile and run the project:

```
   javac TicTacToeRunner.java Board.java Game.java
   java TicTacToeRunner
```

4. Follow the terminal prompts:

   * Choose your symbol (`X` or `O`)
   * Enter a position (1–9) to make your move
   * Computer will automatically respond with a move

## 🧩 Game Logic

* The game ends when either the player or the computer wins
* If the board is filled without a winner, the game is declared a draw

## 🚧 Future Improvements

* Player vs Player mode
* GUI version (JavaFX or Swing)
* Score tracking or stats

## 🤝 Contributing

Pull requests are welcome. Feel free to fork the repo and submit improvements, bug fixes, or enhancements.

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

Created by [@artemohorbunov](https://github.com/artemohorbunov)
