package org.example.task2;

/**
 * Class for Circle
 */
public class Circle extends Figure {

    private double radius;
    /**
     * No-args constructor
     */
    public Circle() {
    }

    /**
     * Constructor for Circle
     *
     * @param background - background color
     * @param border - border color
     * @param radius - radius
     */
    public Circle(String background, String border, double radius) {
        super(background, border);
        this.radius = radius;
        super.perimeter = countPerimeter(this);
        super.square = countSquare(this);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "perimeter=" + perimeter +
                ", square=" + square +
                ", background='" + background + '\'' +
                ", border='" + border + '\'' +
                '}';
    }
}
