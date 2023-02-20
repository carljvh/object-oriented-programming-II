package geometri;

import java.awt.Color;

/**
 * The Circle class extends GeometricalObject and represents a circle object 
 * with a specified position, diameter and color. The position is defined as 
 * the position of the upper left corner of a rectangle surrounding the object 
 * as narrowly as possible. 
 *
 * @author (Carl Hjalmarsson/David Högberg)
 */
public class Circle extends Oval {

	/**
	 * Creates a Circle object with position (x,y) and a specified diameter and color.
	 * 
	 * @param x Distance right from origo.
	 * @param y Distance down from origo.
	 * @param diameter The diameter of the circle.
	 * @param c The specified color of the circle as an object of <tt>java.awt.Color</tt>.
	 * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
	 */
	public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
		super(x, y, diameter, diameter, c);
		place(x,y);	// throws exception
	}
	
	/**
	 * Creates a Circle object with the same position as another geometric object, 
	 * and a specified diameter and color.
	 * 
	 * @param f GeometricalForm object.
	 * @param diameter The diameter of the circle.
	 * @param c The specified color of the circle as an object of <tt>java.awt.Color</tt>.
	 */
	public Circle(GeometricalForm f, int diameter, Color c) {
		super(f, diameter, diameter, c);
	}

}
