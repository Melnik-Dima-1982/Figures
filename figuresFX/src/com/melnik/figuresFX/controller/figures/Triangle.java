package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Figure {
    static final public int kolicestvoVershin = 3;
    static final public double [] x_es =  new double[kolicestvoVershin];
    static final public double [] y_es =  new double[kolicestvoVershin];

    private  double lengthOfside;

    public Triangle(double cx, double cy, double lineWeight, Color color) {
        super(Figure.FIGURE_TYPE_TRIANGLE, cx, cy, lineWeight, color);
    }

    public Triangle(double cx, double cy, double lineWeight, Color color, double lengthOfside) {
        this (cx, cy, lineWeight, color);
        this.lengthOfside = lengthOfside;
    }

    private void createMassivi (){
        x_es[0] = cx;
        y_es [0] = cy - ((2*lengthOfside/3)*(Math.cbrt(3/4)));

        x_es[0] = cx - lengthOfside/2;
        y_es [0] = cy - ((1*lengthOfside/3)*(Math.cbrt(3/4)));

        x_es[0] = cx - lengthOfside/2;
        y_es [0] = cy + ((1*lengthOfside/3)*(Math.cbrt(3/4)));
    }

    @Override
    public void draw(GraphicsContext gc) {
        createMassivi();
        gc.setLineWidth(lineWeight);
        gc.setStroke(color);
        gc.strokePolygon(x_es, y_es,kolicestvoVershin);
    }
}
