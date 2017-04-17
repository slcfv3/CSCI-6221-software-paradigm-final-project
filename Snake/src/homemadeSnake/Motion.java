package homemadeSnake;

import specialMove.Pause;
import specialMove.SpeedDown;
import specialMove.SpeedUP;

public class Motion {

	int interval = 190;                     // time interval in ms
    double changeRate = 0.75;              // the rate of changing speed
    boolean pauseState = false;            //to illustrate if the snake is paused
    
    boolean running=false;
    int direct=6;
    
    public static final int UP = 6;
    public static final int DOWN = 8;
    public static final int LEFT = 5;
    public static final int RIGHT = 7;
    
    SpeedUP speedUP;
	SpeedDown speedDown;
	Pause pause;
    
    public void changeDirect(int newDirect){
    	if (direct % 2 != newDirect % 2) {
            direct = newDirect;
        }
    }

    public void quickUp(){
    	speedUP.specialMove(interval, changeRate, pauseState);
    }
    
    public void quickDown(){
    	speedDown.specialMove(interval, changeRate, pauseState);
    }
    
    public void freeze(){
    	pause.specialMove(interval, changeRate, pauseState);
    }
    
    public void reset(){
    	
    }
}
