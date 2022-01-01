package com.example.javafx_game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleShape {

    public Circle circle() {
        Circle circle = new Circle();
        circle.setLayoutX(random(0, 400));
        circle.setLayoutY(1);
        circle.setRadius(6);
        circle.setFill(Color.BLACK);
        return circle;
    }

    public int random(int min, int max) {
        return (int)(Math.random() * max + min);
    }
}
