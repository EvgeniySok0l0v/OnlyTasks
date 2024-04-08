package org.example.task2;


/**
 * Square interface
 */
public interface Square {

    default double countSquare(Figure figure){
        if(figure instanceof Circle){
            return Math.PI * ((Circle) figure).getRadius() * ((Circle) figure).getRadius();
        }
        if(figure instanceof Rectangle){
            return (((Rectangle) figure).getLength() * ((Rectangle) figure).getWidth());
        }
        if(figure instanceof Triangle){
            //формула герона
            double p = (((Triangle) figure).getSideAB()
                    + ((Triangle) figure).getSideBC()
                    + ((Triangle) figure).getSideCA()) / 2;
            return Math.sqrt(p *
                    (p - ((Triangle) figure).getSideAB()) *
                    (p - ((Triangle) figure).getSideBC()) *
                    (p - ((Triangle) figure).getSideCA()));
        }
        throw new RuntimeException();
    }
}
