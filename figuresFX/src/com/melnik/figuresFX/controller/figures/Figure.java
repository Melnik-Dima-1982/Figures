package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure {
    public static final int FIGURE_TYPE_CIRCLE = 0;
    public static final int FIGURE_TYPE_RECTANGLE = 1;
    public static final int FIGURE_TYPE_TRIANGLE = 2;

    private int type;

    protected double cx;
    protected double cy;
    protected double lineWeight;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWeight, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWeight = lineWeight;
        this.color = color;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public void setLineWeight(double lineWeight) {
        this.lineWeight = lineWeight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public double getLineWeight() {
        return lineWeight;
    }

    public Color getColor() {
        return color;
    }

    public abstract void draw (GraphicsContext gc);
}
