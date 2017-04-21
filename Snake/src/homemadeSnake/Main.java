package homemadeSnake;

import java.util.Observer;

public class Main {
	public static void main(String[] args){
	

			       Motion motion = new Motion(20,30);
			       Control control = new Control(motion);
			       View view = new View(motion,control);
			       motion.addObserver((Observer) view);
			      
			       (new Thread(motion)).start();
			   }
			}
	


