/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A class that connects server and client
 *
 * @author Tomasz Staśko
 * @version 1.0
 */
public class TCPClientConnection {

    /**
     * socket representing connection to the client
     */
    private final Socket socket;
    /**
     * buffered input character stream
     */
    private final BufferedReader in;
    /**
     * Formatted output character stream
     */
    private final PrintWriter out;

    /**
     * Default constructor
     */
    public TCPClientConnection() {
        socket = null;
        in = null;
        out = null;
    }

    /**
     * The constructor of instance of the Connection class. Use the socket as a
     * parameter
     *
     * @param socket socket representing connection to the client
     * @throws IOException communication exception
     */
    public TCPClientConnection(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * A method for sending players move to server from client
     *
     * @param row number of row
     * @param column number of column
     * @param symbol players symbol
     * @throws IOException communication exception
     */
    public void sendPlayersMove(int row, int column, char symbol) throws IOException {
        out.println("MOVE");

        while (!in.readLine().equals("Ready to make a move")) {
        }
        out.println("Start sending players move");
        out.println(row);
        while (!in.readLine().equals("Got row")) {
        }

        out.println(column);
        while (!in.readLine().equals("Got column")) {
        }

        out.println(symbol);
        while (!in.readLine().equals("Got symbol")) {
        }

        while (!in.readLine().equals("Move has been made")) {
        }
    }

    /**
     * Metod for getting the counter of moves
     *
     * @return counter of moves
     * @throws IOException communication exception
     */
    public int getCounterOfMoves() throws IOException {
        out.println("HOW MANY MOVES");
        while (!in.readLine().equals("Ready to send counter of moves")) {
        }
        return (Integer.parseInt(in.readLine()));
    }

    /**
     * Method for getting whose round is
     *
     * @return whose round is
     * @throws IOException communication exception
     */
    public String getWhoseRound() throws IOException {
        out.println("WHOSE ROUND");
        while (!in.readLine().equals("Ready to send which player should make move")) {
        }
        return in.readLine();
    }

    /**
     * A method for checking if players move caused win
     *
     * @param row number of row
     * @param column number of column
     * @param symbol players symbol
     * @return true if cause wind fale if not
     * @throws IOException communication exception
     */
    public boolean checkIfWin(int row, int column, char symbol) throws IOException {
        out.println("CHECK IF WIN");

        while (!in.readLine().equals("Ready to check")) {
        }

        out.println(row);
        while (!in.readLine().equals("Got row")) {
        }

        out.println(column);
        while (!in.readLine().equals("Got column")) {
        }

        out.println(symbol);
        while (!in.readLine().equals("Got symbol")) {
        }

        return Boolean.parseBoolean(in.readLine());
    }

    /**
     * Method used for creating new game
     *
     * @throws IOException communication exception
     */
    public void newGame() throws IOException {
        out.println("NEW GAME");
        while (!in.readLine().equals("New game has began")) {
        }
    }

    /**
     * Method that allows to gently close the connection with server
     *
     * @throws IOException communication exception
     */
    public void closeConnection() throws IOException {
        out.println("QUIT");
        socket.close();
    }
}
