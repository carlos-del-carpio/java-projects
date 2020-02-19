public class Player {
    private String name;
    private Piece piece;
    private int playerNumber;

    public Player(String name, String value, int playerNumber) {
        this.name = name;
        this.piece = new Piece(value);
        this.playerNumber = playerNumber;
    }

    public String getName(){
        return name;
    }

    public String getValue(){
        return piece.getValue();
    }
}