package orig2017.v7;

import java.beans.PropertyChangeListener;

public interface IObservable {
	
	/**
	 *
	 */
	public void addObserver(PropertyChangeListener observer);
	
	/**
	 *
	 */
	public void removeObserver(PropertyChangeListener observer);
}
