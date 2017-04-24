package homemadeSnake;
	import javax.swing.*;
	import java.awt.*;
	import java.util.Iterator;
	import java.util.LinkedList;
	import java.util.Observable;
	import java.util.Observer;


	 class View implements Observer {
	    Control control = null;
	    Motion motion = null;

	    JFrame mainFrame;
	    Canvas paintCanvas;
	    JLabel labelScore;

	    public static final int canvasWidth = 400;
	    public static final int canvasHeight = 600;

	    public static final int nodeWidth = 20;
	    public static final int nodeHeight = 20;

	    public View(Motion motion, Control control) {
	        this.motion = motion;
	        this.control = control;

	        mainFrame = new JFrame("GreedSnake");

	        Container cp = mainFrame.getContentPane();

	        // create the title of the game
	        labelScore = new JLabel("Score:");
	        cp.add(labelScore, BorderLayout.NORTH);

	        // create the game zone
	        paintCanvas = new Canvas();
	        paintCanvas.setSize(canvasWidth + 1, canvasHeight + 1);
	        paintCanvas.addKeyListener(control);
	        cp.add(paintCanvas, BorderLayout.CENTER);

	        // create the hint
	        JPanel panelButtom = new JPanel();
	        panelButtom.setLayout(new BorderLayout());
	        JLabel labelHelp;
	        labelHelp = new JLabel("W for accelerating, S for slowing down;", JLabel.CENTER);
	        panelButtom.add(labelHelp, BorderLayout.NORTH);
	        labelHelp = new JLabel("R for start;", JLabel.CENTER);
	        panelButtom.add(labelHelp, BorderLayout.CENTER);
	        labelHelp = new JLabel("P for pause", JLabel.CENTER);
	        panelButtom.add(labelHelp, BorderLayout.SOUTH);
	        cp.add(panelButtom, BorderLayout.SOUTH);

	        // add the listener to the control
	        mainFrame.addKeyListener(control);
	        mainFrame.pack();
	        mainFrame.setResizable(false);
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mainFrame.setVisible(true);
	    }
	
	   void MoveToPrint() {
	        Graphics g = paintCanvas.getGraphics();

	        //draw background
	        g.setColor(Color.WHITE);
	        g.fillRect(0, 0, canvasWidth, canvasHeight);

	        // draw the snake
	        g.setColor(Color.PINK);
	        LinkedList na = motion.snake;
	        Iterator it = na.iterator();
	        while (it.hasNext()) {
	            Node n = (Node) it.next();
	            drawNode(g, n);
	        }

	        // draw the food
	        g.setColor(Color.green);
	        Node n = motion.food;
	        drawNode(g, n);

	        updateScore();
	    }

	    private void drawNode(Graphics g, Node n) {
	        g.fillRect(n.x * nodeWidth,
	                n.y * nodeHeight,
	                nodeWidth - 1,
	                nodeHeight - 1);
	    }
	    public void updateScore() {
	        String s = "Score: " + motion.score;
	        labelScore.setText(s);
	    }
	    public void update(Observable o, Object arg) {
	        MoveToPrint();
	    
	}

	}
	