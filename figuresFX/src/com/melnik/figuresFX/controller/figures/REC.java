package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class REC {

    public void drawRec(GraphicsContext gc) {
        gc.setLineWidth(2.5);
        gc.setStroke(Paint.valueOf("black"));
        gc.strokeRect(200,200, 300, 300);
    }

    public void drawOval (GraphicsContext gc){
        gc.setLineWidth(2.5);
        gc.setStroke(Paint.valueOf("yellow"));
        gc.strokeOval(200,200, 50,300);
    }
}
