/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exception.NoMoreSpotsException;

/**
 * This class checks if there are any free spots on server
 *
 * @author Toamsz Staśko
 * @version 1.0
 */
public class ThreadPool {

    /**
     * Number of maximum threads that can be run on server
     */
    private int maxNumberOfThreads;
    private int currentNumberOfThreads;

    public ThreadPool(int maxNumberOfThreads, int currentNumberOfThreads) {
        this.maxNumberOfThreads = maxNumberOfThreads;
        this.currentNumberOfThreads = currentNumberOfThreads;
    }

    /**
     * setter
     *
     * @param currentNumberOfThreads current number of threads
     */
    public void setCurrentNumberOfThreads(int currentNumberOfThreads) {
        this.currentNumberOfThreads = currentNumberOfThreads;
    }

    /**
     * getter
     *
     * @return curremt number of threads
     */
    public int getCurrentNumberOfThreads() {
        return currentNumberOfThreads;
    }

    /**
     * setter
     *
     * @param maxNumberOfThreads max number of threads
     */
    public void setMaxNumberOfThreads(int maxNumberOfThreads) {
        this.maxNumberOfThreads = maxNumberOfThreads;
    }

    /**
     * getter
     *
     * @return max number of threads
     */
    public int getMaxNumberOfThreads() {
        return maxNumberOfThreads;
    }

    /**
     * Method that checks if there are any spots left
     *
     * @throws exception.NoMoreSpotsException if there is no emtpy spot
     */
    public void checkSpots() throws NoMoreSpotsException {
        if (currentNumberOfThreads > maxNumberOfThreads) {
            throw new NoMoreSpotsException();
        }
    }
}
