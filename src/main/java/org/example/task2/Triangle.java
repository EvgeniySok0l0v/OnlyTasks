package org.example.task2;

/**
 * Class for Triangle
 */
public class Triangle extends Figure{

    private double sideAB;
    private double sideBC;
    private double sideCA;
    /**
     * No-args constructor
     */
    public Triangle() {
    }

    /**
     * Constructor for Triangle
     *
     * @param background - background color
     * @param border - border color
     * @param sideAB - sideAB
     * @param sideBC - sideBC
     * @param sideCA - sideCA
     */
    public Triangle(String background, String border, double sideAB, double sideBC, double sideCA) {
        super(background, border);
        this.sideAB = sideAB;
        this.sideBC = sideBC;
        this.sideCA = sideCA;
        super.perimeter = countPerimeter(this);
        super.square = countSquare(this);
    }

    public double getSideAB() {
        return sideAB;
    }

    public void setSideAB(double sideAB) {
        this.sideAB = sideAB;
    }

    public double getSideBC() {
        return sideBC;
    }

    public void setSideBC(double sideBC) {
        this.sideBC = sideBC;
    }

    public double getSideCA() {
        return sideCA;
    }

    public void setSideCA(double sideCA) {
        this.sideCA = sideCA;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "perimeter=" + perimeter +
                ", square=" + square +
                ", background='" + background + '\'' +
                ", border='" + border + '\'' +
                '}';
    }
}
