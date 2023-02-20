package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Oval class extends GeometricalObject and represents an oval object with a
 * specified position, width, height and color. The position is defined as the
 * position of the upper left corner of a rectangle surrounding the object as
 * narrowly as possible.
 *
 * @author (Carl Hjalmarsson/David Högberg)
 */
public class Oval extends GeometricalObject {

	/**
	 * Creates an Oval object with position (x,y) and a specified width, height and
	 * color.
	 * 
	 * @param x      Distance right from origo.
	 * @param y      Distance down from origo.
	 * @param width  The width of the oval.
	 * @param height The height of the oval.
	 * @param c      The specified color of the oval as an object of
	 *               <tt>java.awt.Color</tt>.
	 * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
	 */
	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException {
		super(x, y, width, height, c);
	}

	/**
	 * Creates an Oval object with the same position as another geometric object,
	 * and a specified width, height and color.
	 * 
	 * @param f      GeometricalForm object.
	 * @param width  The width of the oval.
	 * @param height The height of the oval.
	 * @param c      The specified color of the oval as an object of
	 *               <tt>java.awt.Color</tt>.
	 */
	public Oval(GeometricalForm f, int width, int height, Color c) {
		super(f, width, height, c);
	}

	@Override
	public int getArea() {
		double a = getWidth() / 2.0;
		double b = getHeight() / 2.0;
		return (int) (Math.PI * a * b + 0.5);
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public int getPerimeter() {
		double a = getWidth() / 2.0;
		double b = getHeight() / 2.0;
		return (int) (2 * Math.PI * Math.sqrt((a * a + b * b) / 2) + 0.5);
	}
}
