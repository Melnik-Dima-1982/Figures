package com.melnik.figuresFX.drawUtils;

import com.melnik.figuresFX.controller.figures.Figure;
import com.melnik.projectExceptions.NullLinkException;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

import static com.melnik.figuresFX.FiguresFxApp.AppLogger;

public class Drawer <T extends Figure & DrawAble> {

    List<T> figures;

    public Drawer(List<T> figures) {
        if (figures == null){
            AppLogger.error(new NullLinkException().getMessage());
        }
        this.figures = figures;
    }

    public void drawFigures (GraphicsContext gc) {
        for (T figure: figures) {
            if (figure!= null){
                figure.draw(gc);
            } else {
                try {
                    throw new NullLinkException();
                } catch (NullLinkException e) {
                    AppLogger.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
