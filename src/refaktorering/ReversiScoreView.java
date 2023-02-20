package orig2017.v7;

import java.beans.*;

public class ReversiScoreView implements PropertyChangeListener {
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if (evt.getSource().getClass() == ReversiModel.class 
				&& evt.getPropertyName().equals("Score")) {
			ReversiModel model = (ReversiModel) evt.getSource();
			
			System.out.println("Black score: " + model.getBlackScore());
			System.out.println("White score: " + model.getWhiteScore());
			System.out.println("Turn: " + model.getTurnColor().toString() + '\n');
		}
	}
}
