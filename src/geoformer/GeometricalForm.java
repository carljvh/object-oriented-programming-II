package geometri;

import java.awt.*;

/**
 * This interface describes drawable geometrical forms. Each form contains of: A
 * rectangle surrounding the form as narrowly as possible defined by its width
 * and height, the position of the upper left corner of the surrounding
 * rectangle, and a colour given as an object of <tt>java.awt.Color</tt>.
 * <p>
 * Furthermore, the forms may be compared. First the areas of the forms are
 * compared and if the areas are equal then the the perimeters are compared. The
 * area and the perimeter of a <tt>Point</tt> are 0. The area of a <tt>Line</tt>
 * is 0 and its perimeter is the double length of the line.
 * <p>
 * The forms may be moved, but may not be modified in any other way. Only
 * positive x and y coordinates are allowed for the position. Negative values
 * for the coordinates gives an <tt>IllegalPositionException</tt>, which is
 * declared in this package.
 * <p>
 * Finally, the forms may be compared for equality, where all components except
 * the positions of the forms are compared.
 *
 * @author (Bror Bjerner/Christer Carlsson/Uno Holmer)
 * @version (nov 2017)
 */
public interface GeometricalForm extends Comparable<GeometricalForm> {

       /**
        * Get the area of this form rounded to closest integer.
        *
        * @return the computed area.
        */
       int getArea();

       /**
        * The method <tt>compareTo</tt> compares the area and perimeter of the forms to
        * decide if the given geometrical form is less or greater than this object. If
        * they have the same area, the perimeter decides.
        * 
        * @param f The geometrical form to compare with.
        * @return An integer smaller than 0 if this form is smaller than the form given
        *         as argument, 0 if the sizes are equal, and a positive integer
        *         otherwise.
        */
       int compareTo(GeometricalForm f);

       /**
        * Fill the area of the form at the position of the form with the color of the
        * form.
        *
        * @param g A graphic pen to draw with.
        */
       void fill(Graphics g);

       /**
        * Get the colour of this form.
        *
        * @return the colour of this form.
        */

       Color getColor();

       /**
        * Get the width of the surrounding rectangle of this form.
        *
        * @return the width.
        */
       int getWidth();

       /**
        * Get the height of the surrounding rectangle of this form.
        *
        * @return the x coordinate.
        */
       int getHeight();

       /**
        * Get the x coordinate of the position of this form.
        *
        * @return the x coordinate.
        */
       int getX();

       /**
        * Get the y coordinate of the position of this form.
        *
        * @return the y coordinate.
        */
       int getY();

       /**
        * Move the form the given distances. Check if the new coordinates are legal and
        * if they are, set the position to the new coordinates. Otherwise an
        * <tt>IllegalPositionException</tt> is thrown. Origo is (0,0) and only positive
        * coordinates are legal.
        *
        * @param dx move the form dx points to the right.
        * @param dy move the form dy points down.
        * @throws IllegalPositionException if any coordinate becomes negative.
        */
       void move(int dx, int dy) throws IllegalPositionException;

       /**
        * Get the perimeter of this form rounded to closest integer.
        *
        * @return the computed perimeter.
        */
       int getPerimeter();

       /**
        * Place the form on given coordinates. Check if the coordinates are legal.
        * Origo is (0,0) and only positive coordinates are legal. If they are legal,
        * update the position with the new coordinates. Otherwise an
        * <tt>IllegalPositionException</tt> is thrown.
        *
        * @param x Distance right from origo.
        * @param y Distance down from origo.
        * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
        */
       void place(int x, int y) throws IllegalPositionException;

}
