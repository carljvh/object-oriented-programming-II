package orig2017.v7;

import java.beans.*;

/**
 * Factory class for available games.
 */
public class ReversiFactory implements IGameFactory {
	PropertyChangeListener scoreView;

	/**
	 * Returns an array with names of games this factory can create. Used by GUI
	 * list available games.
	 */
	@Override
	public String[] getGameNames() {
		return new String[] {"Gold", "Reversi"};
	}

	/**
	 * Returns a new model object for the game corresponding to its Name.
	 * 
	 * @param gameName
	 *            The name of the game as given by getGameNames()
	 * @throws IllegalArgumentException
	 *             if no such game
	 */
	@Override
	public GameModel createGame(final String gameName) {
		if (gameName.equals("Gold")) {
			return new GoldModel();
		} else if (gameName.equals("Reversi")) {
			this.scoreView = new ReversiScoreView();
			
			ReversiModel model = new ReversiModel();
			model.addObserver(this.scoreView);
			return model;
		}

		throw new IllegalArgumentException("No such game: " + gameName);
	}
}
