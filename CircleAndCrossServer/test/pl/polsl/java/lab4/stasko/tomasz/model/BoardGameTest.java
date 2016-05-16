/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.lab4.stasko.tomasz.model;

import model.BoardGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for BoardGame class
 *
 * @author Tomasz Staśko
 * @version 1.0
 */
public class BoardGameTest {

    public BoardGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of fillingTheGameBoard method, of class BoardGame.
     */
    @Test
    public void testFillingTheGameBoard() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.fillingTheGameBoard();
        char[][] tab = new char[3][3];

        //THEN
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tab[i][j] = '.';

                assertEquals(boardGame.getBoard()[i][j], tab[i][j]);
            }
        }
    }

    /**
     * Test of playerMovement method, of class BoardGame.
     */
    @Test
    public void testPlayerMovement() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoard(3, 3);
        boardGame.playerMovement(1, 1, 'X');

        //THEN
        assertFalse(boardGame.playerMovement(1, 1, 'O'));
    }

    /**
     * Test of isWinSlant method, of class BoardGame for wrong datas in slant
     * "/"
     */
    @Test
    public void testFalseIsWinSlant() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 2, 'X');
        boardGame.setBoardField(2, 0, 'X');
        boardGame.setBoardField(1, 1, 'O');

        //THEN
        assertFalse(boardGame.isWinSlant(1, 1));

    }

    /**
     * Test of isWinSlant method, of class BoardGame for correct datas in slant
     * "/"
     */
    @Test
    public void testTrueIsWinSlant() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 2, 'X');
        boardGame.setBoardField(2, 0, 'X');
        boardGame.setBoardField(1, 1, 'X');

        //THEN
        assertTrue(boardGame.isWinSlant(1, 1));

    }

    /**
     * Test of isWinSlant method, of class BoardGame for wrong datas in slant
     * "\"
     */
    @Test
    public void testFalseBackIsWinSlant() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 0, 'X');
        boardGame.setBoardField(2, 2, 'X');
        boardGame.setBoardField(1, 1, 'O');

        //THEN
        assertFalse(boardGame.isWinSlant(1, 1));

    }

    /**
     * Test of isWinSlant method, of class BoardGame for correct datas in slant
     * "\"
     */
    @Test
    public void testTrueBackIsWinSlant() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 0, 'X');
        boardGame.setBoardField(2, 2, 'X');
        boardGame.setBoardField(1, 1, 'X');

        //THEN
        assertTrue(boardGame.isWinSlant(1, 1));

    }

    /**
     * Test of isWinRow method, of class BoardGame for wrong datas in row
     */
    @Test
    public void testFalseIsWinRow() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 0, 'X');
        boardGame.setBoardField(0, 1, 'X');
        boardGame.setBoardField(0, 2, '0');

        //THEN
        assertFalse(boardGame.isWinRow(0, 2));

    }

    /**
     * Test of isWinRow method, of class BoardGame for correct datas in row
     */
    @Test
    public void testTrueIsWinRow() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 0, 'X');
        boardGame.setBoardField(0, 1, 'X');
        boardGame.setBoardField(0, 2, 'X');

        //THEN
        assertTrue(boardGame.isWinRow(0, 2));

    }

    /**
     * Test of isWinColumn method, of class BoardGame for wrong datas in column
     */
    @Test
    public void testFalseIsWinColumn() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 0, 'X');
        boardGame.setBoardField(1, 0, 'X');
        boardGame.setBoardField(2, 0, '0');

        //THEN
        assertFalse(boardGame.isWinColumn(1, 0));

    }

    /**
     * Test of isWinColumn method, of class BoardGame for correct datas in
     * column
     */
    @Test
    public void testTrueIsWinColumn() {
        //GIVEN
        BoardGame boardGame = new BoardGame(3, 3, 3);

        //WHEN
        boardGame.setBoardField(0, 0, 'X');
        boardGame.setBoardField(1, 0, 'X');
        boardGame.setBoardField(2, 0, 'X');

        //THEN
        assertTrue(boardGame.isWinColumn(1, 0));

    }

}
