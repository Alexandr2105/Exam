package by.techmeskills.figuresfx.controller;

import by.techmeskills.figuresfx.FiguresFxApp;
import by.techmeskills.figuresfx.drawutils.Drawer;
import by.techmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private static final Logger logger = LogManager.getLogger(FiguresFxApp.class);
    private ArrayList<Figure> figures;
    private Random random;
    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws CustomException {
        Figure figure = null;
        switch (random.nextInt(5)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(Figure.FIGURE_TYPE_CIRCLE, x, y, random.nextInt(3), Color.BLUE, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(Figure.FIGURE_TYPE_RECTANGLE, x, y, random.nextInt(3), Color.AQUAMARINE, random.nextInt(60), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(Figure.FIGURE_TYPE_TRIANGLE, x, y, random.nextInt(3), Color.GOLD, random.nextInt(70));
                break;
            case Figure.FIGURE_TYPE_STAR:
                figure = new Star(Figure.FIGURE_TYPE_STAR, x, y, random.nextInt(3), Color.GREEN, random.nextInt(25));
                break;
            case Figure.FIGURE_TYPE_OCTAGON:
                figure = new Octagon(Figure.FIGURE_TYPE_OCTAGON, x, y, random.nextInt(3), Color.RED, random.nextInt(25));
                break;
            default:
                logger.error("Такой фигуры не существует!");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) throws CustomException {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}
