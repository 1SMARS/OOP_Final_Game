package com.example.javafx_game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape {

    public Rectangle rectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLayoutX(200);
        rectangle.setLayoutY(550);
        rectangle.setHeight(30);
        rectangle.setWidth(120);
        rectangle.setFill(Color.BLACK);
        return rectangle;
    }
}
