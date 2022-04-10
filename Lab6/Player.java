package com.example.lab6;

import javafx.scene.paint.Color;

public class Player {
    private Color playerColor;
    private boolean turn;

    public Player(Color playerColor) {
        this.playerColor = playerColor;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}

