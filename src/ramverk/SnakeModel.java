package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Snake game where a green snake aims to collect red apples that appear one by 
 * one. For each collected apple, the snake's tail grows in length. The goal is 
 * to collect as many apples as possible, and the game is over if the snake leaves 
 * the game board or if it hits its own tail. 
 */
public class SnakeModel extends GameModel {
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
		NONE(0, 0);

		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}
	
	/** Graphical representation of an apple. */
	private static final GameTile APPLE_TILE = new RoundTile(Color.RED);

	/** Graphical representation of the snake head */
	private static final GameTile SNAKE_HEAD = new RoundTile(Color.GREEN);
	
	/** Graphical representation of a snake tail section */
	private static final GameTile SNAKE_TAIL = new RectangularTile(Color.GREEN);

	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();
	
	/** The position of the apple. */
	private Position applePos = new Position(0,0);
	
	/** The position(s) of the snake. */
	private final Deque<Position> snakePos = new ArrayDeque<Position>();

	/** The direction of the snake. */
	private Directions direction = Directions.NORTH;

	/** The number of apples found. */
	private int score;
	
	/**
	 * Constructor that create a new model for the snake game.
	 */
	public SnakeModel() {
		Dimension size = getGameboardSize();

		// Blank out the whole game board.
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}

		// Insert the snake head in the middle of the game board.
		this.snakePos.addFirst(new Position(size.width / 2, size.height / 2));
		setGameboardState(this.snakePos.getFirst(), SNAKE_HEAD);
		
		// Insert apple into the game board.
		addApple();
	}
	
	/**
	 * Insert another apple into the game board.
	 */
	private void addApple() {
		Position newApplePos;
		Dimension size = getGameboardSize();
		
		// Loop until a blank position is found and ...
		do {
			newApplePos = new Position((int) (Math.random() * size.width),
									   (int) (Math.random() * size.height));
		} while (!isPositionEmpty(newApplePos));

		// ... add a new apple to the empty tile.
		setGameboardState(newApplePos, APPLE_TILE);
		// Change apple position.
		applePos = newApplePos;
	}
	
	/**
	 * Return whether the specified position is empty.
	 * 
	 * @param pos
	 *            The position to test.
	 * @return <code>true</code> if position is empty.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}
	
	/**
	 * Update the direction of the snake according to the user's key press.
	 * The new direction cannot be the opposite of the current direction.
	 */
	private void updateDirection(final int key) {
		if (key == KeyEvent.VK_LEFT && this.direction != Directions.EAST)
			this.direction = Directions.WEST;
		else if (key == KeyEvent.VK_UP && this.direction != Directions.SOUTH)
			this.direction = Directions.NORTH;
		else if (key == KeyEvent.VK_RIGHT && this.direction != Directions.WEST)
			this.direction = Directions.EAST;
		else if (key == KeyEvent.VK_DOWN && this.direction != Directions.NORTH)
			this.direction = Directions.SOUTH;
	}
	
	/**
	 * Get next position of the snake.
	 */
	private Position getNextSnakePos() {
		return new Position(
			this.snakePos.getFirst().getX() + this.direction.getXDelta(),
			this.snakePos.getFirst().getY() + this.direction.getYDelta());
	}

	/**
	 * This method is called repeatedly so that the game can update its state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	@Override
	public void gameUpdate(final int lastKey) throws GameOverException {
		updateDirection(lastKey);
		
		// Add tail section to the previous position.
		setGameboardState(this.snakePos.getFirst(), SNAKE_TAIL);
		// Erase tail end.
		setGameboardState(this.snakePos.getLast(), BLANK_TILE);
		
		// Change snake head position.
		this.snakePos.addFirst(getNextSnakePos());

		// Game over if out of bounds or if the snake hits its own tail.
		if (isOutOfBounds(this.snakePos.getFirst()) ||
				getGameboardState(this.snakePos.getFirst()) == SNAKE_TAIL)
			throw new GameOverException(this.score);
		
		// Draw snake head at the new position.
		setGameboardState(this.snakePos.getFirst(), SNAKE_HEAD);

		// If the snake is at the apple position, add tail section and new apple
		if (applePos.equals(this.snakePos.getFirst())) {
			setGameboardState(this.snakePos.getLast(), SNAKE_TAIL);
			this.score++;
			addApple();
		// Else remove last position. 
		} else
			this.snakePos.removeLast();
	}

	/**
	 * Test if a position is outside the game board.
	 * 
	 * @param pos The position to test.
	 * @return <code>false</code> if the position is outside the playing field, <code>true</code> otherwise.
	 */
	private boolean isOutOfBounds(Position pos) {
		return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
					|| pos.getY() < 0 || pos.getY() >= getGameboardSize().height;
	}

}
