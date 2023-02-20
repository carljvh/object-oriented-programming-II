package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Point class extends GeometricalObject and represents a point object 
 * with a specified position and color. 
 *
 * @author (Carl Hjalmarsson/David Högberg)
 */
public class Point extends GeometricalObject {

	/**
	 * Creates a Point object with position (x,y) and a specified color.
	 * 
	 * @param x Distance right from origo.
	 * @param y Distance down from origo.
	 * @param c The specified color of the circle as an object of <tt>java.awt.Color</tt>.
	 * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
	 */
	public Point(int x, int y, Color c) throws IllegalPositionException {
		super(x, y, 0, 0, c);
	}
	
	/**
	 * Creates a Point object with the same position as another geometric object, 
	 * and a specified color.
	 * 
	 * @param f GeometricalForm object.
	 * @param c The specified color of the point as an object of <tt>java.awt.Color</tt>.
	 */
	public Point(GeometricalForm f, Color c) {
		super(f, 0, 0, c);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The area of a Point is always 0.
	 */
	@Override
	public int getArea() {
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX(), getY(), getX(), getY());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The perimeter of a Point is always 0.
	 */
	@Override
	public int getPerimeter() {
		return 0;
	}

}
