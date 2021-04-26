package by.techmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    private double dot1;

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(color);
        graphicsContext.strokePolygon(new double[]{cx - dot1, cx + dot1, cx}, new double[]{cy + dot1, cy + dot1, cy - dot1}, 3);
    }

    public Triangle(int type, double cx, double cy, double lineWidth, Color color, double dot1) {
        super(type, cx, cy, lineWidth, color);
        this.dot1 = dot1 < 40 ? dot1 : 40;
    }

    public double getDot1() {
        return dot1;
    }

    public void setDot1(double dot1) {
        this.dot1 = dot1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.dot1, dot1) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot1);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                ", dot1=" + dot1 +
                '}';
    }
}

