package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Rectangle class extends GeometricalObject and represents a rectangle object 
 * with a specified position, width, height and color. The position is defined as 
 * the position of the upper left corner of the rectangle.
 *
 * @author (Carl Hjalmarsson/David Högberg)
 */
public class Rectangle extends GeometricalObject {

	/**
	 * Creates a Rectangle object with position (x,y) and a specified width, height and color.
	 * 
	 * @param x Distance right from origo.
	 * @param y Distance down from origo.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The specified color of the rectangle as an object of <tt>java.awt.Color</tt>.
	 * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
	 */
	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
		super(x, y, width, height, c);
	}
	
	/**
	 * Creates a Rectangle object with the same position as another geometric object, 
	 * and a specified width, height and color.
	 * 
	 * @param f GeometricalForm object.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The specified color of the rectangle as an object of <tt>java.awt.Color</tt>.
	 */
	public Rectangle(GeometricalForm f, int width, int height, Color c) {
		super(f, width, height, c);
	}

	@Override
	public int getArea() {
		return getWidth()*getHeight();
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public int getPerimeter() {
		return 2*getWidth() + 2*getHeight();
	}

}
