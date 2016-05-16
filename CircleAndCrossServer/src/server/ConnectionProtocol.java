/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import model.BoardGame;
import model.Player;

/**
 * The protocol class 
 *
 * @author Toamsz Staśko
 * @version 1.0
 */
class ConnectionProtocol extends Thread {

    /**
     * socket representing connection to the client
     */
    private Socket socket;
    /**
     * buffered input character stream
     */
    private BufferedReader in;
    /**
     * Formatted output character stream
     */
    private PrintWriter out;
    /**
     * game board
     */
    private BoardGame boardGame;
    /**
     * player datas
     */
    private Player player;

    /**
     * The constructor of instance of the ConnectionProtocol class. Use the socket as
     * a parameter.
     *
     * @param socket socket representing connection to the client
     * @throws IOException
     */
    public ConnectionProtocol(Socket socket) throws IOException {
        boardGame = new BoardGame(3, 3, 3);
        player = new Player();
        boardGame.fillingTheGameBoard();
        this.socket = socket;
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Method that runs the service
     */
    public void run() {
        try {
            while (true) {
                String str = in.readLine();

                if (str.toUpperCase().equals("NEW GAME")) {
                    boardGame.fillingTheGameBoard();
                    boardGame.setCounterOfMoves(0);
                    out.println("New game has began");

                }
                if (str.toUpperCase().equals("MOVE")) {
                    playersMove();
                }

                if (str.toUpperCase().equals("HOW MANY MOVES")) {
                    out.println("Ready to send counter of moves");
                    out.println(boardGame.getCounterOfMoves());
                }

                if (str.toUpperCase().equals("WHOSE ROUND")) {
                    out.println("Ready to send which player should make move");
                    if (boardGame.getCounterOfMoves() % 2 == 0) {
                        out.println("0");

                    } else {
                        out.println("X");
                    }
                }

                if (str.toUpperCase().equals("CHECK IF WIN")) {
                    checkIfWin();
                }

                if (str.toUpperCase().equals("QUIT")) {
                    break;
                }
            }
            out.println("Server is closing!");
        } catch (IOException ex) {
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
            }
        }
    }

    /**
     * Method to make players move on server
     *
     * @throws IOException communication exception
     */
    private void playersMove() throws IOException {
        boardGame.setCounterOfMoves((boardGame.getCounterOfMoves() + 1));
        out.println("Ready to make a move");
        if (in.readLine().equals("Start sending players move")) {
            player.setCoordinateX(Integer.parseInt(in.readLine()));
            out.println("Got row");

            player.setCoordinateY(Integer.parseInt(in.readLine()));
            out.println("Got column");

            player.setSymbol(in.readLine().charAt(0));
            out.println("Got symbol");

            boardGame.setBoardField(player.getCoordinateX(), player.getCoordinateY(), player.getSymbol());

            out.println("Move has been made");
        }
    }

    /**
     * Method for checking on server if player who made move won the game
     *
     * @throws IOException communication exception
     */
    private void checkIfWin() throws IOException {

        out.println("Ready to check");

        player.setCoordinateX(Integer.parseInt(in.readLine()));
        out.println("Got row");

        player.setCoordinateY(Integer.parseInt(in.readLine()));
        out.println("Got column");

        player.setSymbol(in.readLine().charAt(0));
        out.println("Got symbol");

        out.println(boardGame.isWin(player.getCoordinateX(), player.getCoordinateY()));

    }

}
