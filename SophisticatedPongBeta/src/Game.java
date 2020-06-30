import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferStrategy;

public class Game  extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -8921419424614180143L;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH * 9/16;
	
	public boolean running = false;
	private Thread gameThread;
	
	private Ball ball;
	private Player player1;
	private Player player2;
	

	public Game(){
		// setup and initialization
		canvasSetup();
		initialize();
		
		new Window("SophistiPong", this);
		
		this.addKeyListener(new KeyInput(player1, player2));
		this.setFocusable(true);
		
	}
	
	private void initialize() {
		// initializes ball
		ball = new Ball();
		
		// initialize players
		player1 = new Player(Color.white, true);
		player2 = new Player(Color.white, false);
		
		
	}

	private void canvasSetup() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT + 50));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT + 50));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT + 50));
	}
	

	@Override
	public void run() {
		// game timer taken from:  https://gist.github.com/AnatoliiStepaniuk/c6fe63bea242f05a52e8
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			if (running) draw();
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();
	}
	
	private void draw() {
		// initialize the drawing tools
		
		BufferStrategy buffer = this.getBufferStrategy();
		
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = buffer.getDrawGraphics();
		
		
		// draw background
		drawBackground(g);
		
		// draw ball
		ball.draw(g);
		
		// draw players and score
		player1.draw(g);
		player2.draw(g);
		
		// dispose, actually draw
		g.dispose();
		buffer.show();
		
	}

	private void drawBackground(Graphics g) {
		// draw background, set colors etc..
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT + 50);
		
		// lines
		g.setColor(Color.white);
		Graphics2D g2d = (Graphics2D) g;													// 15 pix on 15 pix off
		Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{15}, 0);
		Stroke stroke = new BasicStroke(2f);
		g2d.setStroke(dashed);
		g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
		g2d.setStroke(stroke);
		g2d.drawLine(0, HEIGHT, WIDTH, HEIGHT);
	}

	private void update() {
		// update ball
		ball.update(player1, player2);
		
		// update paddles
		player1.update(ball);
		player2.update(ball);
		
	}

	public void start() {
		// start new thread
		gameThread = new Thread(this);
		gameThread.start();
		running = true;
	}
	
	public void stop() {
		// stop thread
		try {
			gameThread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int ensureRange(int val, int min, int max) {
		// Ensures the range of the paddle
		return Math.min(Math.max(val, min), max);
	}
	
	
	public static void main(String[] args) {
		new Game();	
	}
}