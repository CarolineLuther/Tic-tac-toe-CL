import java.util.Scanner;

public class Game {
    private final Board board;
    private final Scanner scanner;
    private char currentPlayer;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        currentPlayer = 'X';
    }

    public void start() {
        System.out.println("Välkommen till tre i rad!");
        while (true) {
            playOneGame();
            System.out.println("Startar upp en ny omgång...");
            board.reset();
        }
    }

    private void playOneGame() {
        while (true) {
            board.print();
            System.out.println("Spelare " + currentPlayer + ", Välj en position (1-9):");

            int move = getValidMove();
            board.placeMove(move, currentPlayer);

            if (board.checkWin(currentPlayer)) {
                board.print();
                System.out.println("Spelare " + currentPlayer + " Vinner!");
                return;
            }

            if (board.isFull()) {
                board.print();
                System.out.println("Spelet blev oavgjort!");
                return;
            }

            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private int getValidMove() {
        while (true) {
            String input = scanner.nextLine();

            try {
                int position = Integer.parseInt(input);
                if (board.isMoveValid(position)) {
                    return position;
                } else {
                    System.out.println("Ogiltigt drag, prova igen:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vänligen ange ett nummer mellan 1 och 9:");
            }
        }
    }
}
