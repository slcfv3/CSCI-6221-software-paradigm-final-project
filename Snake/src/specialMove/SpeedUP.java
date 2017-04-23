package specialMove;

public class SpeedUP extends Special {

	int interval;
	double changeRate;
	
	@Override
	public void specialMove(int interval, double changeRate, boolean pauseState) {
		// TODO Auto-generated method stub
		
		interval *= changeRate; 
		
	}

}
