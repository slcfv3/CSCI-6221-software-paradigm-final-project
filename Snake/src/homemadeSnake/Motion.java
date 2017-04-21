package homemadeSnake;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

import javax.swing.JOptionPane;

import specialMove.Pause;
import specialMove.SpeedDown;
import specialMove.SpeedUP;


public class Motion extends Observable implements Runnable {

	boolean[][] boolmatrix;
	LinkedList snake=new LinkedList();
	Node food;
	int xMax;
	int yMax;
	
	int score=0;
	
	int interval = 190;                     // time interval in ms
    double changeRate = 0.75;              // the rate of changing speed
    boolean pauseState = false;            //to illustrate if the snake is paused
    
    boolean running=false;
    int direct=8;
    
    public static final int UP = 6;
    public static final int DOWN = 8;
    public static final int LEFT = 5;
    public static final int RIGHT = 7;
    
    SpeedUP speedUP;
	SpeedDown speedDown;
	Pause pause;
    
	public Motion(int xMax, int yMax){
		this.xMax=xMax;
		this.yMax=yMax;
		reset();
	}
	
	public void reset(){
	    	direct=Motion.DOWN;
	    	interval= 190;
	    	pauseState=false;
	    	score=0;
	    	
	    	boolmatrix=new boolean[xMax][];
	    	for(int i = 0; i<xMax; ++i){
	    		boolmatrix[i]=new boolean[yMax];
	    		Arrays.fill(boolmatrix, false);
	    	}
	    	
	    	int initialLength=xMax>20? 10:xMax/2;
	    	snake.clear();
	    	
	    	for(int j=0; j<initialLength; ++j){
	    		int x=xMax/2+j;
	    		int y=yMax/2;
	    		
	    		snake.addLast(new Node(x,y));
	    		boolmatrix[x][y]=true;
	    	}
	    	
	    	food=generateFood();
	    	boolmatrix[food.x][food.y]=true;
	    }
	 
	private Node generateFood(){
		int x=0;
		int y=0;
		
		do{
			Random ran=new Random();
			x=ran.nextInt(xMax);
			y=ran.nextInt(yMax);
		} while(boolmatrix[x][y]);
		return new Node(x,y);
	}
	public void changeDirect(int newDirect){
    	if (direct % 2 != newDirect % 2) {
            direct = newDirect;
        }
    }
	
	public boolean goOn(){
		Node n= (Node) snake.getFirst();
		int x=n.x;
		int y=n.y;
		
		switch(direct){
		case UP:
			y--;
			break;
		case DOWN:
			y++;
			break;
		case LEFT:
		    x--;
		    break;
		case RIGHT:
			x++;
			break;
				
		}
		
		if((x>=0&&x<xMax) && (y>=0&&y<yMax)){
			if (boolmatrix[x][y]){
				if(x==food.x && y==food.y){
					snake.addFirst(food);
					score+=10;
					
					food=generateFood();
					boolmatrix[food.x][food.y]=true;
					return true;
					
				} else{
					return false;
				} 
			}else{
				snake.addFirst(new Node(x,y));
				boolmatrix[x][y]=true;
				n= (Node) snake.removeLast();
			    boolmatrix[n.x][n.y]=false;
			    return true;
			}
		}
		return false;
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
    
   
    public void run(){
    	running= true;
    	while(running){
    		try{
    			Thread.sleep(interval);
    			
    		} catch(Exception e){
    			break;
    		}
    	
    	if (!pauseState){
    		if (goOn()){
    			setChanged();
    			notifyObservers();
    			
    			
    		}else {
    			JOptionPane.showMessageDialog(null,
                        "You failed",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
    		}
    	}
    }
    	running =false;
}
class Node {
	int x;
	int y;
	public Node(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
	}

}
}

