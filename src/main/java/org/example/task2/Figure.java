package org.example.task2;

/**
 * Class for Figure
 */
public abstract class Figure implements Perimeter, Square{

    protected String background;
    protected String border;
    protected double perimeter;
    protected double square;
    /**
     * No-args constructor
     */
    public Figure() {
    }

    /**
     * Constructor for Figure
     *
     * @param background - background color
     * @param border - border color
     */
    public Figure(String background, String border) {
        this.background = background;
        this.border = border;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }
}
