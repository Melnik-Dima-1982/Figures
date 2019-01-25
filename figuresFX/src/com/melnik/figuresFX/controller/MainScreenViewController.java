package com.melnik.figuresFX.controller;

import com.melnik.figuresFX.controller.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private Figure[] figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println("mainScreenController");
        figures = new Figure[1];
        random = new Random(System.currentTimeMillis());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
//        REC rec = new REC();
//        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
//        Rectangle rectangle = new Rectangle(10,10, 2.5, Color.color(0.7, 0.3, 0.3),50,50);
//        Triangle triangle = new Triangle(10,10,2.5, Color.CORNFLOWERBLUE);
//        triangle.draw(canvas.getGraphicsContext2D());
//        rectangle.draw(canvas.getGraphicsContext2D());
//        rec.drawRec(canvas.getGraphicsContext2D());
//        rec.drawOval(canvas.getGraphicsContext2D());
    }

    private void addFigure(Figure figure) {
        if (figures[figures.length - 1] == null) {
            figures[figures.length - 1] = figure;
            return;
        }
        Figure[] tmp = new Figure[figures.length + 1];
        int index = 0;
        for (; index < figures.length; index++) {
            tmp[index] = figures[index];
        }
        tmp[index] = figure;
        figures = tmp;
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;
        switch (random.nextInt(3)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(4), Color.CORNFLOWERBLUE, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(4), Color.CORNFLOWERBLUE, random.nextInt(100),random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(4), Color.CORNFLOWERBLUE,60);
                break;
            default:
                System.out.println("Unknow figure type");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
        for (Figure figure : figures) {
            if (figure != null) {
                figure.draw(canvas.getGraphicsContext2D());
            }
        }
    }
}
