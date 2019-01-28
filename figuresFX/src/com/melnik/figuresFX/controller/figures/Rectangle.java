package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Figure {

    private double length;
    private double width;

    public Rectangle(double cx, double cy, double lineWeight, Color color) {
        super(Figure.FIGURE_TYPE_RECTANGLE, cx, cy, lineWeight, color);
    }

    public Rectangle(double cx, double cy, double lineWeight, Color color, double length, double width) {
        this(cx, cy, lineWeight, color);
        this.length = length < 15 ? 10 : length;
        this.width = width < 10 ? 10 : width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.length, length) == 0 &&
                Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWeight);
        gc.setStroke(color);
        gc.strokeRect(cx - (length / 2), cy - (width / 2), length, width);
    }
}
