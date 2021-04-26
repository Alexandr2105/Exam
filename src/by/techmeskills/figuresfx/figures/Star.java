package by.techmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Star extends Figure {
    private double dot;


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setFill(color);
        graphicsContext.fillPolygon(new double[]{cx, cx - 3 * dot, cx + 4 * dot, cx - 4 * dot, cx + 3 * dot},
                new double[]{cy - 4 * dot, cy + 4 * dot, cy - dot, cy - dot, cy + 4 * dot}, 5);
    }

    public Star(int type, double cx, double cy, double lineWidth, Color color, double dot) {
        super(type, cx, cy, lineWidth, color);
        this.dot = dot < 5 ? 5 : dot;
    }

    public double getDot() {
        return dot;
    }

    public void setDot(double dot) {
        this.dot = dot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Double.compare(star.dot, dot) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot);
    }

    @Override
    public String toString() {
        return "Star{" +
                "cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                ", dot=" + dot +
                '}';
    }
}
