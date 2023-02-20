package geometri;

import java.awt.Color;

/**
 * The Square class extends GeometricalObject and represents a square object 
 * with a specified position, side length and color. The position is defined as 
 * the position of the upper left corner of the square.
 *
 * @author (Carl Hjalmarsson/David Högberg)
 */
public class Square extends Rectangle {

	/**
	 * Creates a square object with position (x,y) and a specified side length and color.
	 * 
	 * @param x Distance right from origo.
	 * @param y Distance down from origo.
	 * @param side The side length of the square.
	 * @param c The specified color of the square as an object of <tt>java.awt.Color</tt>.
	 * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
	 */
	public Square(int x, int y, int side, Color c) throws IllegalPositionException {
		super(x, y, side, side, c);
	}
	
	/**
	 * Creates a Square object with the same position as another geometric object, 
	 * and a specified side length and color.
	 * 
	 * @param f GeometricalForm object.
	 * @param side The side length of the square.
	 * @param c The specified color of the square as an object of <tt>java.awt.Color</tt>.
	 */
	public Square(GeometricalForm f, int side, Color c) {
		super(f, side, side, c);
	}

}
