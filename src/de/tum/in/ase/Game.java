package de.tum.in.ase;

import java.util.Scanner;

public class Game {
    //TODO: implement the constructor, getters and setters for all the attributes
    //TODO: implement the move methods
    //TODO: implement a boolean method "isWon()" which checks if the game has ended (the player has won)
    //TODO: finally runGame()
    private GameBoard gameBoard;
    private Hero hero;
    public Game(int sizeX, int sizeY) {

        GameBoard g = new GameBoard(sizeX, sizeY);
        Hero h = new Hero();

        setHero(h);
        setGameBoard(g);

        int heroX = getHero().getPosX();
        int heroY = getHero().getPosY();

        char heroChar = 'H';

        getGameBoard().set(heroX, heroY, heroChar);

    }

    public void moveLeft(){

        if(0 < getHero().getPosX()){
            char dummyChar = '_';
            int heroPosY = getHero().getPosY();
            int heroPosX = getHero().getPosX();

            char heroChar = getGameBoard().get(heroPosX, heroPosY);

            getGameBoard().set(heroPosX, heroPosY, dummyChar);

            int heroPosNewX = getHero().getPosX()-1;

            getGameBoard().set(heroPosNewX, heroPosY, heroChar);

            getGameBoard().printGameBoard();

        } else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }

    }

    public void moveDown(){

        if(getHero().getPosX() < getGameBoard().getSizeX()-1){

            char dummyChar = '_';
            int heroPosY = getHero().getPosY();
            int heroPosX = getHero().getPosX();

            char heroChar = getGameBoard().get(heroPosX, heroPosY);

            getGameBoard().set(heroPosX, heroPosY, dummyChar);

            int heroPosNewX = getHero().getPosX()+1;

            getGameBoard().set(heroPosNewX, heroPosY, heroChar);

            getGameBoard().printGameBoard();

        } else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }

    }

    public void moveUp() {

        if(0 < getHero().getPosY()){

            char dummyChar = '_';
            int heroPosY = getHero().getPosY();
            int heroPosX = getHero().getPosX();

            char heroChar = getGameBoard().get(heroPosX, heroPosY);

            getGameBoard().set(heroPosX, heroPosY, dummyChar);

            int heroPosNewY = getHero().getPosY()-1;

            getGameBoard().set(heroPosX, heroPosNewY, heroChar);

            getGameBoard().printGameBoard();

        } else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }

    }

    public void moveRight() {

        if(getHero().getPosY() < getGameBoard().getSizeY()-1){

            char dummyChar = '_';
            int heroPosY = getHero().getPosY();
            int heroPosX = getHero().getPosX();

            char heroChar = getGameBoard().get(heroPosX, heroPosY);

            getGameBoard().set(heroPosX, heroPosY, dummyChar);

            int heroPosNewY = getHero().getPosY()+1;

            getGameBoard().set(heroPosX, heroPosNewY, heroChar);

            getGameBoard().printGameBoard();

        } else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }

    }

    public boolean isWon(){
        int heroPosY = getHero().getPosY();
        int heroPosX = getHero().getPosX();
        char heroChar = getGameBoard().get(heroPosX, heroPosY);

        if (heroChar == getGameBoard().get(heroPosX, heroPosY)) {
            return true;
        }

        return false;

    }

    public void runGame(){

        getGameBoard().printGameBoard();

        do {

            Scanner s = new Scanner(System.in);
            System.out.println("Please enter the first letter of the desired direction:");
            String input = s.nextLine().toLowerCase();

            switch(input) {
                case "l":
                    moveLeft();
                    break;
                case "r":
                    moveRight();
                    break;
                case "u":
                    moveUp();
                    break;
                case "d":
                    moveDown();
                    break;
                default:
                    System.out.println("This input is not recognized, please enter again!");
            }

        } while (isWon());

        System.out.println("Hero has reached the goal!");

    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    //You can run your game on main after you've implemented runGame()
    public static void main(String[] args) {
        Game game = new Game(3, 3);
        game.runGame();
    }


}
