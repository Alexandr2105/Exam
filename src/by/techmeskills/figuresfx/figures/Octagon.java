package by.techmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Octagon extends Figure {
    private double dot;

    public Octagon(int type, double cx, double cy, double lineWidth, Color color, double dot) {
        super(type, cx, cy, lineWidth, color);
        this.dot = dot < 15 ? 15 : dot;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(color);
        graphicsContext.strokePolygon(new double[]{cx + dot, cx + 3 * dot, cx + 3 * dot, cx + dot, cx - dot, cx - 3 * dot, cx - 3 * dot, cx - dot},
                new double[]{cy + 3 * dot, cy + dot, cy - dot, cy - 3 * dot, cy - 3 * dot, cy - dot, cy + dot, cy + 3 * dot}, 8);
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
        Octagon octagon = (Octagon) o;
        return Double.compare(octagon.dot, dot) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot);
    }

    @Override
    public String toString() {
        return "Octagon{" +
                "cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                ", dot=" + dot +
                '}';
    }
}
