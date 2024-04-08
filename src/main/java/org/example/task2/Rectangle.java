package org.example.task2;

/**
 * Class for Rectangle
 */
public class Rectangle extends Figure{

    private double length;
    private double width;

    /**
     * No-args constructor
     */
    public Rectangle() {
    }

    /**
     * Constructor for Rectangle
     *
     * @param background - background color
     * @param border - border color
     * @param length - length
     * @param width - width
     */
    public Rectangle(String background, String border, double length, double width) {
        super(background, border);
        this.length = length;
        this.width = width;
        super.perimeter = countPerimeter(this);
        super.square = countSquare(this);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "perimeter=" + perimeter +
                ", square=" + square +
                ", background='" + background + '\'' +
                ", border='" + border + '\'' +
                '}';
    }
}
