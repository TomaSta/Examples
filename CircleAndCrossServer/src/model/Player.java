/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Element of Circle and Cross Game. Describes player's parameters like symbol
 * and which field is currently chosen
 *
 * @author Tomasz Staśko
 * @version 1.0
 */
public class Player {

    /**
     * symbol which user want to play with
     */
    private char symbol;

    /**
     * number of row
     */
    private int coordinateX;

    /**
     * number of column
     */
    private int coordinateY;

    /**
     * Setter for coordinateX component
     *
     * @param coordinateX number of row
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * Setter for coordinateY component
     *
     * @param coordinateY number of column
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * Setter for symbol component
     *
     * @param symbol symbol which user want to play with
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Getter for symbol component
     *
     * @return symbol which user want to play with
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Getter for coordinateX component
     *
     * @return number of row
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * Getter for coordinate Y component
     *
     * @return number of column
     */
    public int getCoordinateY() {
        return coordinateY;
    }

}
