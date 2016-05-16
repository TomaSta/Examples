/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * Exception which informs if there are no spots on server for connect
 *
 * @author Tomasz Staśko
 * @version 1.0
 *
 */
public class NoMoreSpotsException extends Exception {

    /**
     * Constructor
     */
    public NoMoreSpotsException() {
        super();
    }

}
