package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Figure {

    private double length;
    private double width;

    public Rectangle(double cx, double cy, double lineWeight, Color color) {
        super(Figure.FIGURE_TYPE_RECTANGLE, cx, cy, lineWeight, color);
    }

    public Rectangle(double cx, double cy, double lineWeight, Color color, double length, double width) {
        this(cx, cy, lineWeight, color);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWeight);
        gc.setStroke(color);
        gc.strokeRect(cx - (length/2), cy - (width/2), length, width);
    }
}
