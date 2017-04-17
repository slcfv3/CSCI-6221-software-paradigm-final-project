package homemadeSnake;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener {

	Motion motion;
	
	public Control(Motion motion){
		this.motion=motion;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int Code= e.getKeyCode();
		if(motion.running){
			switch(Code){
			case KeyEvent.VK_UP:
				motion.changeDirect(Motion.UP);
				break;
			case KeyEvent.VK_DOWN:
                motion.changeDirect(Motion.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                motion.changeDirect(Motion.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                motion.changeDirect(Motion.RIGHT);
                break;
          
            case KeyEvent.VK_W:
                motion.quickUp();
                break;
           
            case KeyEvent.VK_S:
                motion.quickDown();
                break;
            
            case KeyEvent.VK_P:
                motion.freeze();
                break;
            default:
			}
		}
		
		if (Code == KeyEvent.VK_R) {
            motion.reset();
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
