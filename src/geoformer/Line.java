package geometri;

import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

/**
 * The Line class extends GeometricalObject and represents a line object 
 * with a specified start- and end position and color. 
 *
 * @author (Carl Hjalmarsson/David Högberg)
 */
public class Line extends GeometricalObject {
	private int xdir;
	private int ydir;

	/**
	 * Creates a Line object with start position (x1,y1), end position (x2,y2) and a specified color.
	 * 
	 * @param x1 Distance right from origo for start position.
	 * @param y1 Distance down from origo for start position.
	 * @param x2 Distance right from origo for end position.
	 * @param y2 Distance down from origo for end position.
	 * @param c The specified color of the line as an object of <tt>java.awt.Color</tt>.
	 * @throws <tt>IllegalPositionException</tt> if any coordinate is negative.
	 */
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
		super(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1), c);
		
		this.xdir = checkDirection(x1, x2);
		this.ydir = checkDirection(y1, y2);
	}
	
	/**
	 * Creates a Line object with start- and end position given by two other geometric objects, 
	 * and with a specified color.
	 * 
	 * @param f1 GeometricalForm object.
	 * @param f2 GeometricalForm object.
	 * @param c The specified color of the Line as an object of <tt>java.awt.Color</tt>.
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
		super(f1, Math.abs(f2.getX()-f1.getX()), Math.abs(f2.getY()-f1.getY()), c);
		
		this.xdir = checkDirection(f1.getX(), f2.getX());
		this.ydir = checkDirection(f1.getY(), f2.getY());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The area of a Line is always 0.
	 */
	@Override
	public int getArea() {
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		int x2 = getX() + this.xdir * getWidth();
		int y2 = getY() + this.ydir * getHeight();
		
		g.setColor(getColor()); 
		g.drawLine(getX(), getY(), x2, y2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The perimeter of a Line is calculated as two times its length. 
	 */
	@Override
	public int getPerimeter() {
		int a = getWidth();
		int b = getHeight();
		return (int) (2*Math.sqrt(a*a + b*b) + 0.5);
	}

	private int checkDirection(int x1, int x2) {
		if (x1 < x2) {
			return 1;
		} else if (x1 == x2) {
			return 0;
		} else {
			return -1;
		}
	}
}
