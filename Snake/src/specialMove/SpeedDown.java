package specialMove;

public class SpeedDown extends Special {

	@Override
	public int specialMove(int interval, double changeRate, boolean pauseState) {
		// TODO Auto-generated method stub
		interval /= changeRate;
		return interval;
	}

}
