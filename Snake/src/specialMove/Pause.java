package specialMove;

public class Pause extends Special{
	
	
	@Override
	public void specialMove(int interval, double changeRate, boolean pauseState) {
		// TODO Auto-generated method stub
		pauseState = !pauseState;
	}

}
