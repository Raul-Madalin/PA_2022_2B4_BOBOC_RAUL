package com.example.lab6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Slider rowNumber;

    @FXML
    private Slider columnNumber;

    @FXML
    private GridPane gridPane;

    public void createGridPane() {
        for (int i = 0; i < rowNumber.getValue(); i++)
            for (int j = 0; j < columnNumber.getValue(); j++) {
                Circle circle = new Circle(10, Color.WHITE);
                gridPane.add(circle, 2 * j, 2 * i);
            }

    }

    @FXML
    private void clickGrid(MouseEvent e) {
        for( Node node: gridPane.getChildren()) {
            if( node instanceof Circle) {
                if( node.getBoundsInParent().contains(e.getX(),  e.getY())) {
                    ((Circle) node).setFill(Color.RED);
                }
            }
        }
    }
}