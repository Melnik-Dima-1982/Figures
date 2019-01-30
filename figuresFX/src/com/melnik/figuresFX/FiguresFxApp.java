package com.melnik.figuresFX;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class FiguresFxApp extends Application {
    public static final Logger AppLogger = LogManager.getLogger(FiguresFxApp.class.getName());

    public static void main(String[] args) {
        AppLogger.info("Start application");
        launch();
        AppLogger.info("Final application");
    }

    @Override
    public void start(Stage window) { //
        window.setTitle("FiguresFx");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/MainScreenView.fxml"));
        } catch (IOException e) {
            AppLogger.error(e);
            e.printStackTrace();
        }
        window.setScene(new Scene(root, 1024, 600));
        window.setResizable(false);
        window.show();
    }
}
