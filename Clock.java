import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Clock implements ActionListener
{
	private Timer timer;
	private int timeIncr;  // in milliseconds
	//private Room room;
	private RoomTestController rtc;

	/**
	 *	Creates a timer object with the given data
	 *	@param theFruitonField the listener for the timer
	 *	@param dt the interval duration time in milliseconds that timer fires
	 */
	public Clock(RoomTestController test, int dt)
	{
		//room = r;
		rtc = test;
		timeIncr = dt;
		timer = new Timer(timeIncr, this);
	}

	/**
	 *	Starts the timer
	 */
	public void start()
	{
		timer.start();
	}

	/**
	 *	Stops the timer
	 */
	public void stop()
	{
		timer.stop();
	}

	/**
	 *	Called automatically when the timer fires.
	 *	@param e contains the action event
	 */
	public void actionPerformed(ActionEvent e)
	{
	}

	public void restartClock(RoomTestController controller, int timeInc)
	{
	}
}
