package com.example.lab6;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Random;
import java.util.stream.IntStream;

public class Game {
    private Player player1;
    private Player player2;
    private GridPane gridPane;
    private Slider rowNumber;
    private Slider columnNumber;
    private boolean firstMove;
    private int board[][];

    public Game(Player player1, Player player2, GridPane gridPane, Slider rowNumber, Slider columnNumber) {
        this.player1 = player1;
        this.player2 = player2;
        this.gridPane = gridPane;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public Slider getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Slider rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Slider getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(Slider columnNumber) {
        this.columnNumber = columnNumber;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void start() {
        System.out.println("Started");
        Random rand = new Random();
        int randomTurn = rand.nextInt(2);
        if (randomTurn == 0) {
            player1.setTurn(true);
            player2.setTurn(false);
        }
        else {
            player1.setTurn(false);
            player2.setTurn(true);
        }
        setFirstMove(true);
    }
}
