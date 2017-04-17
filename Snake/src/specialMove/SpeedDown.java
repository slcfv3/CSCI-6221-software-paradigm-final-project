package specialMove;

public class SpeedDown extends Special {

	@Override
	public void specialMove(int interval, double changeRate, boolean pauseState) {
		// TODO Auto-generated method stub
		interval /= changeRate;
	}

}
