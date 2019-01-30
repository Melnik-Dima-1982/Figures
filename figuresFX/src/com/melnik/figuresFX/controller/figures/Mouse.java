package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Mouse extends Figure {
    public Mouse(double cx, double cy, double lineWeight, Color color) {
        super(Figure.FIGURE_TYPE_MOUSE, cx, cy, lineWeight, color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWeight);
        gc.setStroke(color);
        gc.strokeOval(cx - 30, cy - 30, 60,60);
        double []  x1 = {cx - 20,cx - 13,cx - 8.54};
        double []  y1 = {cy - 22.36,cy - 40,cy - 28.76};
        gc.strokePolyline(x1, y1, x1.length);
        double []  x2 = {cx + 20,cx + 13,cx + 8.54};
//        double []  y2 = {cy - 22.36,cy - 40,cy - 28.76};
        gc.strokePolyline(x2, y1, x2.length);
        double []  x3 = {cx,cx + 5.73,cx + 3.34, cx + 1.43, cx + 10.77, cx + 22.58, cx +20};
        double []  y3 = {cy + 19.17,cy + 20.68,cy + 27.75, cy + 33.84, cy + 33.95, cy +34.68, cy + 40.1};
        gc.strokePolyline(x3, y3, x3.length);
    }
}
