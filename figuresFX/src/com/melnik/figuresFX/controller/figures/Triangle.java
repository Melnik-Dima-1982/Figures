package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    static final public int kolicestvoVershin = 3;
    static final public double[] x_es = new double[kolicestvoVershin];
    static final public double[] y_es = new double[kolicestvoVershin];

    private double lengthOfside;

    public Triangle(double cx, double cy, double lineWeight, Color color) {
        super(Figure.FIGURE_TYPE_TRIANGLE, cx, cy, lineWeight, color);
    }

    public Triangle(double cx, double cy, double lineWeight, Color color, double lengthOfside) {
        this(cx, cy, lineWeight, color);
        this.lengthOfside = lengthOfside < 20 ? 20 : lengthOfside;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.lengthOfside, lengthOfside) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengthOfside);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "lengthOfside=" + lengthOfside +
                '}';
    }

    private void makePointsOfTriangle() {
        x_es[0] = cx;
        y_es[0] = cy - lengthOfside / 2.0;

        x_es[1] = cx + lengthOfside / 2.0;
        y_es[1] = cy + lengthOfside / 2.0;

        x_es[2] = cx - lengthOfside/2.0;
        y_es[2] = cy + lengthOfside / 2.0;
    }

    @Override
    public void draw(GraphicsContext gc) {
        makePointsOfTriangle();
        gc.setLineWidth(lineWeight);
        gc.setStroke(color);
        gc.strokePolygon(x_es, y_es, kolicestvoVershin);
    }
}
