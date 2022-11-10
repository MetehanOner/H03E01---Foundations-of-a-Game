package de.tum.in.ase;

public class GameBoard {
    // TODO: Implement the GameBoard class
    private int sizeX;
    private int sizeY;

    private char[][] boardMatrix;

    public GameBoard(int sizeX, int sizeY) {

        if(sizeX < 3){
            setSizeX(3);
        } else {
            setSizeX(sizeX);
        }

        if(sizeY < 3){
            setSizeY(3);
        } else {
            setSizeY(sizeY);
        }

        char[][] board = new char[sizeX][sizeY];
        setBoardMatrix(board);

        char initTable = '_';
        for(int i = 0; i < sizeY ; i++){
            for(int j = 0; j < sizeX; j++){
                getBoardMatrix()[j][i] = initTable;
            }
        }

        char heroChar = 'H';
        getBoardMatrix()[0][0] = heroChar;

        char goalChar = 'G';
        getBoardMatrix()[sizeX-1][sizeY-1] = goalChar;

    }

    public char get(int x, int y) {

        if(x < getSizeX() && y < getSizeY()){
            return getBoardMatrix()[x][y];
        } else {
            return '\0';
        }

    }

    public void set(int x, int y, char value) {

        if(x < getSizeX() && y < getSizeY()){
            getBoardMatrix()[x][y] = value;
        }

    }

    public void printGameBoard() {
        for(int i = 0; i < getBoardMatrix().length ; i++){
            System.out.println(getBoardMatrix()[i]);
        }
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public char[][] getBoardMatrix() {
        return boardMatrix;
    }

    public void setBoardMatrix(char[][] boardMatrix) {
        this.boardMatrix = boardMatrix;
    }
}
