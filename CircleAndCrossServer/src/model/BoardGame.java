/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Element of Circle and Cross Game. Describes gameboard parameters like number
 * of columns, number of rows, number needed to reach to win, board values
 *
 * @author Tomasz Staśko
 * @version 1.0
 */
public class BoardGame {

    /**
     * counter of moves
     */
    private int counterOfMoves;

    /**
     * gameboard
     */
    private char[][] board;

    /**
     * number of columns
     */
    private int numberOfColumns;

    /**
     * number of rows
     */
    private int numberOfRows;

    /**
     * number needed to reach to win
     */
    private int numberWhenWins;

    /**
     * Non argument constructor
     */
    public BoardGame() {
        numberOfRows = 0;
        numberOfColumns = 0;
        board = null;
        numberWhenWins = 0;
        counterOfMoves = 0;
    }

    /**
     * Argument constructor
     *
     * @param newNumberOfRows length of rows
     * @param newNumberOfColumns length of columns
     * @param newNumberWhenWins number of symbols which is need to win
     */
    public BoardGame(int newNumberOfRows, int newNumberOfColumns, int newNumberWhenWins) {
        board = new char[newNumberOfRows][newNumberOfColumns];
        numberOfRows = newNumberOfRows;
        numberOfColumns = newNumberOfColumns;
        numberWhenWins = newNumberWhenWins;
        counterOfMoves = 0;
    }

    /**
     * Setter for component board. Fills the gameboard with dots.
     *
     * @param numberOfRows length of rows
     * @param numberOfColumns length of columns
     */
    public void setBoard(int numberOfRows, int numberOfColumns) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                this.board[i][j] = '.';
            }
        }
    }

    /**
     * creator for component board
     *
     * @param numberOfRows length of rows
     * @param numberOfColumns length of columns
     */
    public void createBoard(int numberOfRows, int numberOfColumns) {
        board = new char[numberOfRows][numberOfColumns];
    }

    /**
     * Setter for one precised field in board component
     *
     * @param row number of row
     * @param column number of column
     * @param symbol char which you want to set in the field
     */
    public void setBoardField(int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    /**
     * Setter for numberOfColumns component
     *
     * @param numberOfColumns number of columns
     */
    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * Setter for numberOfRows component
     *
     * @param numberOfRows number of rows
     */
    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    /**
     * Setter for numberWhenWins component
     *
     * @param numberWhenWins number of symbols which is need to win
     */
    public void setNumberWhenWins(int numberWhenWins) {
        this.numberWhenWins = numberWhenWins;
    }

    /**
     * Setter for counterofMoves component
     *
     * @param counterOfMoves number of symbols which is need to win
     */
    public void setCounterOfMoves(int counterOfMoves) {
        this.counterOfMoves = counterOfMoves;
    }

    /**
     * Getter for counterOfMoves component
     *
     * @return number of columns
     */
    public int getCounterOfMoves() {
        return counterOfMoves;
    }

    /**
     * Getter for board component
     *
     * @return board component
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Getter for numberOfColumns component
     *
     * @return number of columns
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * Getter for numberOfRows component
     *
     * @return number of rows
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Getter fornumberWhenWins component
     *
     * @return number of symbols which is need to win
     */
    public int getNumberWhenWins() {
        return numberWhenWins;
    }

    /**
     * Creating new game by filling whole boardgame with dots
     *
     */
    public void fillingTheGameBoard() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                board[i][j] = '.';
            }
        }
    }

    /**
     * Checks if user can put his symbol in given by him coordinates in
     * boardgame
     *
     * @param coordinateX coordinate of X
     * @param coordinateY coordinate of Y
     * @param symbol user's symbol
     * @return true if user can put symbol, false if he can't
     */
    public boolean playerMovement(int coordinateX, int coordinateY, char symbol) {
        if (board[coordinateX][coordinateY] == '.') {
            board[coordinateX][coordinateY] = symbol;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if given field resulted in victory in game
     *
     * @param coordinateX number of row
     * @param coordinateY number of column
     * @return true if vicotry has been detected, false if hasn't been
     */
    public boolean isWin(int coordinateX, int coordinateY) {
        if (isWinSlant(coordinateX, coordinateY) == true
                || isWinColumn(coordinateX, coordinateY) == true
                || isWinRow(coordinateX, coordinateY) == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if given field resulted in victory in slant
     *
     * @param coordinateX number of row
     * @param coordinateY number of column
     * @return true if vicotry has been detected, false if hasn't been
     */
    public boolean isWinSlant(int coordinateX, int coordinateY) {
        char symbol = board[coordinateX][coordinateY];
        int counter = 1;
        int tempCoordinateX = coordinateX;
        int tempCoordinateY = coordinateY;

        //checking slant /
        //up
        while (coordinateX > 0 && coordinateY < numberOfColumns - 1) {
            coordinateX--;
            coordinateY++;
            if (board[coordinateX][coordinateY] == symbol) {
                counter++;
            } else {
                break;
            }
        }
        coordinateX = tempCoordinateX;
        coordinateY = tempCoordinateY;
        //down
        while (coordinateX < numberOfRows - 1 && coordinateY > 0) {
            coordinateX++;
            coordinateY--;
            if (board[coordinateX][coordinateY] == symbol) {
                counter++;
            } else {
                break;
            }
        }
        if (counter >= numberWhenWins) {
            return true;
        } else {
            //checking slant \
            coordinateX = tempCoordinateX;
            coordinateY = tempCoordinateY;
            counter = 1;

            //up
            while (coordinateX > 0 && coordinateY > 0) {
                coordinateX--;
                coordinateY--;
                if (board[coordinateX][coordinateY] == symbol) {
                    counter++;
                } else {
                    break;
                }
            }
            coordinateX = tempCoordinateX;
            coordinateY = tempCoordinateY;
            //down
            while (coordinateX < numberOfRows - 1 && coordinateY < numberOfColumns - 1) {
                coordinateX++;
                coordinateY++;
                if (board[coordinateX][coordinateY] == symbol) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter >= numberWhenWins) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Checks if given field resulted in victory in column
     *
     * @param coordinateX number of row
     * @param coordinateY number of column
     * @return true if vicotry has been detected, false if hasn't been
     */
    public boolean isWinColumn(int coordinateX, int coordinateY) {
        char symbol = board[coordinateX][coordinateY];
        int counter = 1;
        int tempCoordinateX = coordinateX;

        while (coordinateX < numberOfRows - 1) {
            coordinateX++;
            if (board[coordinateX][coordinateY] == symbol) {
                counter++;
            } else {
                break;
            }
        }
        coordinateX = tempCoordinateX;
        while (coordinateX > 0) {
            coordinateX--;
            if (board[coordinateX][coordinateY] == symbol) {
                counter++;
            } else {
                break;
            }
        }
        if (counter >= numberWhenWins) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if given field resulted in victory in row
     *
     * @param coordinateX number of row
     * @param coordinateY number of column
     * @return true if vicotry has been detected, false if hasn't been
     */
    public boolean isWinRow(int coordinateX, int coordinateY) {
        char symbol = board[coordinateX][coordinateY];
        int counter = 1;
        int tempCoordinateY = coordinateY;

        while (coordinateY < numberOfColumns - 1) {
            coordinateY++;
            if (board[coordinateX][coordinateY] == symbol) {
                counter++;
            } else {
                break;
            }
        }
        coordinateY = tempCoordinateY;
        while (coordinateY > 0) {
            coordinateY--;
            if (board[coordinateX][coordinateY] == symbol) {
                counter++;
            } else {
                break;
            }
        }
        if (counter >= numberWhenWins) {
            return true;
        } else {
            return false;
        }
    }

}
