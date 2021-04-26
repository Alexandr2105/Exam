package by.techmeskills.figuresfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;


public class FiguresFxApp extends Application {
    private static final Logger logger = LogManager.getLogger(FiguresFxApp.class);

    @Override
    public void start(Stage window) {
        try {
            window.setTitle("FXFigures");
            Parent root = FXMLLoader.load(getClass().getResource("/view/mainScreenView.fxml"));
            window.setScene(new Scene(root, 1024, 600));
            window.setResizable(false);
            window.show();
        } catch (IOException e) {
            logger.error("Файл ничего не содержит");
        }
    }

    public static void main(String[] args) {
        logger.info("Программа запущена");
        launch();
        logger.info("Программа закрыта");
    }
}
