import java.util.Scanner;

public class TicTacToe {
    static Player playerOne;
    static Player playerTwo;
    static Player currentTurn;
    static Board board = new Board();

    public static void main(String args[]) {
        createPlayers();
        engine();
    }

    public static void createPlayers() {
        String name;
        String value = "";
        int choice;

        Scanner in = new Scanner(System.in);
        System.out.print("Player One, what is your name? ");
        name = in.nextLine();

        do {
            System.out.print("1. X\n2. O\nChoose your piece : ");
            choice = in.nextInt();
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            value = "X";
        } else if (choice == 2) {
            value = "O";
        }

        TicTacToe.playerOne = new Player(name, value, 1);
        name = "";

        System.out.print("\nPlayer Two, what is your name? ");
        name = in.next();
        if (value.equals("X")) {
            value = "O";
        } else if (value.equals("O")) {
            value = "X";
        }

        TicTacToe.playerTwo = new Player(name, value, 2);

        System.out.println("\n" + playerOne.getName() + ", you are Player One and will be using " + playerOne.getValue() + ".");
        System.out.println(playerTwo.getName() + ", you are Player One and will be using " + playerTwo.getValue() + ".");
        System.out.println("\n\nLET THE GAME BEGIN");
        currentTurn = playerOne;
    }

    public static void engine() {

        do {
            if(currentTurn.equals(playerOne)) {
                currentTurn = playerTwo;
            } else if (currentTurn.equals(playerTwo)){
                currentTurn = playerOne;
            } else {
                currentTurn = playerOne;
            }
            
            if (currentTurn.equals(playerOne)) {
                System.out.println(playerOne.getName() + " it's your turn.\n");
                board.makeYourMove(playerOne.getValue());
            } else if (currentTurn.equals(playerTwo)) {
                System.out.println(playerTwo.getName() + " it's your turn.\n");
                board.makeYourMove(playerTwo.getValue());
            }
        } while (board.hasWon(currentTurn.getValue()) == false && board.getPieceCount() < 9);

        if (board.hasWon(currentTurn.getValue()) == false && board.getPieceCount() == 9){
            System.out.println("It's a Draw");
        } else {
            System.out.println(currentTurn.getName() + " has won!");
        }
    }
}