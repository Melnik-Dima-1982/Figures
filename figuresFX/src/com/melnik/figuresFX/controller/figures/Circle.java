package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Figure {

    private double radius;

    public Circle(double cx, double cy, double lineWeight, Color color) {
        super(Figure.FIGURE_TYPE_CIRCLE, cx, cy, lineWeight, color);
    }

    public Circle(double cx, double cy, double lineWeight, Color color, double radius) {
        this(cx, cy, lineWeight, color);
        this.radius = radius < 15 ? 15 : radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWeight);
        gc.setStroke(color);
        gc.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);

    }
}