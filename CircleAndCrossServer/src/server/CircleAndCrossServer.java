/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import exception.NoMoreSpotsException;
import model.ThreadPool;

/**
 * The main class of the multithreaded server
 *
 * @author Tomasz Staśko
 * @version 1.0
 */
public class CircleAndCrossServer {

    /**
     * port number
     */
    static final int PORT = 8888;

    /**
     * The main application method
     *
     * @param args the command line arguments
     * @throws java.io.IOException communication exception
     *
     */
    public static void main(String args[]) throws IOException {
        ThreadPool threadPool = new ThreadPool(1, 0);
        ServerSocket server;

        server = new ServerSocket(PORT);

        System.out.println("Server started");

        try {
            while (true) {
                threadPool.setCurrentNumberOfThreads(threadPool.getCurrentNumberOfThreads() + 1);
                threadPool.checkSpots();
                Socket socket = server.accept();
                System.out.println("Connected");

                try {
                    new ConnectionProtocol(socket).start();
                } catch (IOException e) {
                    socket.close();
                    System.err.println(e.getMessage());
                }
            }
        } catch (NoMoreSpotsException ex) {
            Logger.getLogger(CircleAndCrossServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            server.close();
        }
    }

}
