package com.melnik.figuresFX.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyFigure extends Figure {
    private double[] pointsOfX;
    private double[] getPointsOfY;
    private int amountOfPoints = 19;

    public MyFigure(double cx, double cy, double lineWeight, Color color) {
        super(Figure.FIGURE_TYPE_MY, cx, cy, lineWeight, color);
        pointsOfX = new double[amountOfPoints];
        getPointsOfY = new double[amountOfPoints];
    }


    private void makePoints() {
        pointsOfX[0] = cx;
        getPointsOfY[0] = cy;

        pointsOfX[1] = pointsOfX[0] - 30;
        getPointsOfY[1] = getPointsOfY[0] - 30;

        pointsOfX[2] = pointsOfX[1] - 30;
        getPointsOfY[2] = getPointsOfY[1] - 10;

        pointsOfX[3] = pointsOfX[2] - 30;
        getPointsOfY[3] = getPointsOfY[2] + 10;

        pointsOfX[4] = pointsOfX[3] - 20;
        getPointsOfY[4] = getPointsOfY[3] + 20;

        pointsOfX[5] = pointsOfX[4] - 5;
        getPointsOfY[5] = getPointsOfY[4] + 15;

        pointsOfX[6] = pointsOfX[5] + 5;
        getPointsOfY[6] = getPointsOfY[5] + 25;

        pointsOfX[7] = pointsOfX[6] + 25;
        getPointsOfY[7] = getPointsOfY[6] + 30;

        pointsOfX[8] = pointsOfX[7] + 45;
        getPointsOfY[8] = getPointsOfY[7] + 30;

        pointsOfX[9] = cx;
        getPointsOfY[9] = getPointsOfY[8] + 20;

        pointsOfX[10] = pointsOfX[9] + 40;
        getPointsOfY[10] = getPointsOfY[9] - 20;

        pointsOfX[11] = pointsOfX[10] + 45;
        getPointsOfY[11] = getPointsOfY[10] - 30;

        pointsOfX[12] = pointsOfX[11] + 25;
        getPointsOfY[12] = getPointsOfY[11] - 30;

        pointsOfX[13] = pointsOfX[12] + 5;
        getPointsOfY[13] = getPointsOfY[12] - 25;

        pointsOfX[14] = pointsOfX[13] - 5;
        getPointsOfY[14] = getPointsOfY[13] - 15;

        pointsOfX[15] = pointsOfX[14] - 20;
        getPointsOfY[15] = getPointsOfY[14] - 20;

        pointsOfX[16] = pointsOfX[15] - 30;
        getPointsOfY[16] = getPointsOfY[15] - 10;

        pointsOfX[17] = pointsOfX[16] - 30;
        getPointsOfY[17] = getPointsOfY[16] + 10;

        pointsOfX[18] = cx;
        getPointsOfY[18] = cy;
    }

    @Override
    public void draw(GraphicsContext gc) {
        makePoints();
        gc.setLineWidth(lineWeight);
        gc.setStroke(color);
        gc.strokePolyline(pointsOfX, getPointsOfY, amountOfPoints);
    }
}
