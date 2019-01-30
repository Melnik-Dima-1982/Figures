package com.melnik.figuresFX.controller;

import com.melnik.figuresFX.controller.figures.*;
import com.melnik.figuresFX.drawUtils.Drawer;
import com.melnik.projectExceptions.UnknownTypeFigureException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import static com.melnik.figuresFX.FiguresFxApp.AppLogger;

public class MainScreenViewController implements Initializable {
    private List<Figure> figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;
        switch (random.nextInt(5)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(4), Color.DARKVIOLET, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(4), Color.GREEN, random.nextInt(100), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(4), Color.ORANGE, 60);
                break;
            case Figure.FIGURE_TYPE_MY:
                figure = new MyFigure(x, y, 3, Color.RED);
                break;
            case Figure.FIGURE_TYPE_MOUSE:
                figure = new Mouse(x, y, 3.0, Color.GRAY);
                break;
            default:
//                System.out.println("Unknow figure type");
                try {
                    throw new UnknownTypeFigureException();
                } catch (UnknownTypeFigureException e) {
                    AppLogger.info(e);
                    e.printStackTrace();
                }
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
        Drawer<Figure> drawer = new Drawer(figures);
        drawer.drawFigures(canvas.getGraphicsContext2D());
    }

    @FXML
    private void clearCanvas(MouseEvent mouseEvent) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
        AppLogger.info("Added " + figures.size() + " figures.");
        figures.clear();
    }
}
