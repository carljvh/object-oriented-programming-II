/**
 * 
 */
package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class implementing the GeometricalForm interface.
 * 
 * @author (Carl Hjalmarsson/David Högberg)
 */
public abstract class GeometricalObject implements GeometricalForm {
	private int x, y, width, height;
	private Color color;

	/**
	 * Initializes a GeometricalObject with position (x,y) and a specified width,
	 * height and color.
	 * 
	 * @param x      Distance right from origo.
	 * @param y      Distance down from origo.
	 * @param width  The width of the object.
	 * @param height The height of the object.
	 * @param c      The specified color of the object as an object of
	 *               <tt>java.awt.Color</tt>.
	 * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
	 */
	protected GeometricalObject(int x, int y, int width, int height, Color c) throws IllegalPositionException {
		if (x < 0 || y < 0)
			throw new IllegalPositionException("Illegal position!");

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = c;
	}

	/**
	 * Initializes a GeometricalObject with with the same position as another
	 * geometric object, and a specified width, height and color.
	 * 
	 * @param x      Distance right from origo.
	 * @param y      Distance down from origo.
	 * @param width  The width of the object.
	 * @param height The height of the object.
	 * @param c      The specified color of the object as an object of
	 *               <tt>java.awt.Color</tt>.
	 */
	protected GeometricalObject(GeometricalForm f, int width, int height, Color c) {
		this.x = f.getX();
		this.y = f.getY();
		this.width = width;
		this.height = height;
		this.color = c;
	}

	@Override
	public abstract int getArea();

	@Override
	public int compareTo(GeometricalForm f) {
		if (this.getArea() > f.getArea()) {
			return 1;
		} else if (this.getArea() < f.getArea()) {
			return -1;
		} else {
			if (this.getPerimeter() > f.getPerimeter()) {
				return 1;
			} else if (this.getPerimeter() < f.getPerimeter()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	@Override
	public abstract void fill(Graphics g);

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		if (x + dx < 0 || y + dy < 0)
			throw new IllegalPositionException("Illegal position!");

		this.x = x + dx;
		this.y = y + dy;
	}

	@Override
	public abstract int getPerimeter();

	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if (x < 0 || y < 0)
			throw new IllegalPositionException("Illegal position!");

		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;

		GeometricalObject other = (GeometricalObject) o;
		return this.width == other.width && this.height == other.height && this.color.equals(other.color);
	}

	@Override
	public int hashCode() {
		return 7 * this.width + 11 * this.height;
	}
}
