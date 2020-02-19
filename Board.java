import java.util.*;
import java.util.Scanner;

public class Board {
    private String[] board;
    private String currentBoardState = (" 1 | 2 | 3 \n" + "___|___|___\n" + " 4 | 5 | 6 \n" + "___|___|___\n" + " 7 | 8 | 9 \n"
    + "   |   |   \n");
    private ArrayList<Integer> winningSpots = new ArrayList<Integer>();
    private Integer pieceCount = 0;

    public Board() {
        board = new String[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = "";
        }
    }

    public void printCurrentBoardState() {
        System.out.print(currentBoardState);
    }

    public String[] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println(Arrays.toString(board));
    }

    public Integer getPieceCount(){
        return pieceCount;
    }

    public void makeYourMove(String value) {
        Scanner in = new Scanner(System.in);
        int selection;

        printCurrentBoardState();
        
        do {
            System.out.print("Where do you want your next piece? ");
            selection = in.nextInt();
        } while (board[selection - 1].equals("X") || board[selection - 1].equals("O"));

        board[selection - 1] = value;
        currentBoardState = currentBoardState.replace(Integer.toString(selection), value.toString());
        printCurrentBoardState();
        pieceCount ++;
    }

    public Boolean hasWon(String value) {
        Boolean won = false;
        for (int i = 0; i < 9; i++) {
            if (board[i].equals(value)) {
                this.winningSpots.add((i + 1));
            }
        }
        System.out.println(winningSpots.toString());

        for (Integer num : winningSpots){
            
            do {
                switch(num){
                    case 1: 
                        System.out.println("Case of 1");
                        if((winningSpots.contains(5))){
                            System.out.println("It's got a 5");
                        }
                        if (winningSpots.contains(9)){
                            System.out.println("It's got a 9");
                        }

                        if((winningSpots.contains(5) && winningSpots.contains(9))){
                            System.out.println("You should be winning bro!");
                        }
                        if ((winningSpots.contains(2) && winningSpots.contains(3))){
                            won = true;
                        } else if (winningSpots.contains(4) && winningSpots.contains(7)){
                            won = true;
                        }  else if (winningSpots.contains(5) && winningSpots.contains(9)){
                            System.out.println("We're here");
                            won = true;
                        }
                        break;
                    case 2:
                        System.out.println("Case of 2");
                        if ((winningSpots.contains(5) && winningSpots.contains(8))){
                            won = true;
                        }
                        break;
                    case 3: 
                        System.out.println("Case of 3");
                        if ((winningSpots.contains(5) && winningSpots.contains(7)) || (winningSpots.contains(6) && winningSpots.contains(9))){
                            won = true;
                        }
                        break;
                    case 4: 
                        System.out.println("Case of 4");
                        if ((winningSpots.contains(5) && winningSpots.contains(6))){
                            won = true;
                        }
                        break;
                    case 7: 
                        System.out.println("Case of 7");
                        if ((winningSpots.contains(8) && winningSpots.contains(9))){
                            won = true;
                        }
                        break;
                    default:
                        System.out.println("Else");
                        won = false;
                } 
            } while(won == false);
        winningSpots.clear();

        return won;
    }
}