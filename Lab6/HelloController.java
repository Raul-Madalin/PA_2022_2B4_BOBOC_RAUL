package com.example.lab6;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Slider rowNumber;

    @FXML
    private Slider columnNumber;

    @FXML
    private GridPane gridPane;

    @FXML
    private Stage stage;

    private Player playerRed;
    private Player playerBlue;
    private Game mainGame;

    public void createGridPane() {
        playerRed = new Player(Color.RED);
        playerBlue = new Player(Color.BLUE);
        mainGame = new Game(playerRed, playerBlue, gridPane, rowNumber, columnNumber);
        int board[][] = new int[(int) ((rowNumber.getValue() * 2) - 1)][(int) ((columnNumber.getValue() * 2) - 1)];

        for (int i = 0; i < (rowNumber.getValue() * 2) - 1; i++)
            for (int j = 0; j < (columnNumber.getValue() * 2) - 1; j++) {
                Random rand = new Random();
                int randomLine = rand.nextInt(2);

                if (i % 2 == 0 && j % 2 == 0) {
                    Circle circle = new Circle(10, Color.WHITE);
                    gridPane.add(circle, j, i);
                    //board[i][j] = 1;
                }

                if (i % 2 != j % 2 && randomLine == 1) {
                    if (i % 2 == 1) {
                        Text vertical = new Text("|");
                        gridPane.add(vertical, j, i);
                        board[i - 1][j] = 1;
                        board[i + 1][j] = 1;
                    } else {
                        Text horizontal = new Text("|");
                        horizontal.setRotate(90);
                        gridPane.add(horizontal, j, i);
                        board[i][j - 1] = 1;
                        board[i][j + 1] = 1;
                    }
                }
            }
        mainGame.setBoard(board);
        mainGame.start();
    }

    @FXML
    private void clickGrid(MouseEvent e) {
        int[][] board = mainGame.getBoard();

        for( Node node: gridPane.getChildren()) {
            if( node instanceof Circle) {
                if( node.getBoundsInParent().contains(e.getX(),  e.getY())) {
                    if (playerRed.isTurn()) {
                        ((Circle) node).setFill(Color.RED);
                        playerRed.setTurn(false);
                        playerBlue.setTurn(true);
                    }
                    else {
                        ((Circle) node).setFill(Color.BLUE);
                        playerRed.setTurn(true);
                        playerBlue.setTurn(false);
                    }
                }
            }
        }
    }

    public void clickSave() {
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage((int)gridPane.getWidth() + 20, (int)gridPane.getHeight() + 20);
                gridPane.snapshot(null, writableImage);
                // TODO
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showSaveDialog(stage);
    }
}