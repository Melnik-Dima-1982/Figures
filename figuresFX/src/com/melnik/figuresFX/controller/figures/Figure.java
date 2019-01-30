package com.melnik.figuresFX.controller.figures;

import com.melnik.figuresFX.drawUtils.DrawAble;
import com.melnik.projectExceptions.InvalidParametrsException;
import com.melnik.projectExceptions.NullLinkException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.melnik.figuresFX.FiguresFxApp.AppLogger;

public abstract class Figure implements DrawAble {
    public static final int FIGURE_TYPE_CIRCLE = 0;
    public static final int FIGURE_TYPE_RECTANGLE = 1;
    public static final int FIGURE_TYPE_TRIANGLE = 2;
    public static final int FIGURE_TYPE_MY = 3;
    public static final int FIGURE_TYPE_MOUSE = 4;

    private int type;

    protected double cx;
    protected double cy;
    protected double lineWeight;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWeight, Color color) {
        if (type < 0 && lineWeight <= 0) {
            try {
                throw new InvalidParametrsException();
            } catch (InvalidParametrsException e) {
                AppLogger.error(e);
                e.printStackTrace();
            }
        }
        if (color == null) {
            try {
                throw new NullLinkException();
            } catch (NullLinkException e) {
                AppLogger.error(e);
                e.printStackTrace();
            }
        }
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

    public abstract void draw(GraphicsContext gc);
}
