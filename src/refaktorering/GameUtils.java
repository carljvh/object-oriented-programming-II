package orig2017.v7;

public class GameUtils {

	/**
	 * Set the tile on a specified position in the gameboard.
	 * 
	 * @param gameboard
	 * 			  The gameboard matrix.
	 * @param pos
	 *            The position in the gameboard matrix.
	 * @param tile
	 *            The type of tile to paint in specified position
	 */
	protected static void setGameboardState(final GameTile[][] gameboard, 
			final Position pos, final GameTile tile) {
		setGameboardState(gameboard, pos.getX(), pos.getY(), tile);
	}

	/**
	 * Set the tile on a specified position in the gameboard.
	 * 
	 * @param gameboard
	 * 			  The gameboard matrix.
	 * @param x
	 *            Coordinate in the gameboard matrix.
	 * @param y
	 *            Coordinate in the gameboard matrix.
	 * @param tile
	 *            The type of tile to paint in specified position
	 */
	protected static void setGameboardState(final GameTile[][] gameboard, 
			final int x, final int y, final GameTile tile) {
		gameboard[x][y] = tile;
	}
}
