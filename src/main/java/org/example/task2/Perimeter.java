package org.example.task2;

/**
 * Perimeter interface
 */
public interface Perimeter {

    default double countPerimeter(Figure  figure){
        if(figure instanceof Circle){
            return 2 * Math.PI * ((Circle) figure).getRadius();
        }
        if(figure instanceof Rectangle){
            return (((Rectangle) figure).getLength() + ((Rectangle) figure).getWidth()) * 2;
        }
        if(figure instanceof Triangle){
            return ((Triangle) figure).getSideAB() + ((Triangle) figure).getSideBC() + ((Triangle) figure).getSideCA();
        }
        throw new RuntimeException();
    }
}
