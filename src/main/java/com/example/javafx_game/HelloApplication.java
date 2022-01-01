package com.example.javafx_game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class HelloApplication extends Application {

    AnimationTimer animationTimer;
    List<Circle> fallingCircle = new ArrayList<>();
    Pane root = new Pane();
    int mouse;
    int fallingTime = 7;
    Rectangle block;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), event -> {
            CircleShape circleShape = new CircleShape();
            fallingCircle.add(circleShape.circle());
            root.getChildren().add((fallingCircle.get(fallingCircle.size() -1)));
        }));

        timeline.setCycleCount(1000);
        timeline.play();
        animationTimer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {

                block.setLayoutX(mouse);

                for(int i = 0; i < fallingCircle.size(); i++) {
                    (fallingCircle.get(i)).setLayoutY((fallingCircle.get(i)).getLayoutY() + fallingTime + (fallingCircle.get(i)).getLayoutY() / 150 );
                    if(((fallingCircle.get(i)).getLayoutX() > block.getLayoutX() && (fallingCircle.get(i)).getLayoutX() < block.getLayoutX() + 120) &&
                            (fallingCircle.get(i)).getLayoutY() >= 550) {
                        root.getChildren().remove((fallingCircle.get(i)));
                        fallingCircle.remove(i);
                    }

                    else if((fallingCircle.get(i)).getLayoutY() >= 590) {
                        root.getChildren().remove(fallingCircle.get(i));
                        fallingCircle.remove(i);
                    }
                }
            }
        };

        animationTimer.start();
        RectangleShape rectangleShape = new RectangleShape();
        block = rectangleShape.rectangle();
        root.getChildren().addAll(block);
        Scene scene = new Scene(root, 600, 600, Color.BLUEVIOLET);
        scene.setOnMouseMoved(e -> mouse = (int) e.getX());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
