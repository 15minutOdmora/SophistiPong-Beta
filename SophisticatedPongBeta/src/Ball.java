import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Main {
	
	public int size = bSize;
	
	private float x, y;           // position 
	private float dx, dy;		  // x, y change ()
	private int fi;               // angle of vector 
	private int initialDFi = 20;  // initial Fi +- (for when game starts/restarts)
	public float v = bSpeed;      // ball velocity
	public int ballSpin = bSpin;  // Fi change after collision with player(if moving)
	
	
	public Ball() {
		reset();
	}

	private void reset() {
		// resets to initial position
		x = Game.WIDTH / 2 - size / 2;
		y = Game.HEIGHT / 2 - size / 2;
		fi = randomStrartingFi();
	}
	
	
	private int randomStrartingFi() {
		// generates a random Fi value(degrees) in the bounds (340, 20) ||  (160, 200)
		boolean side = false;
		if (Math.random() - 0.5 >= 0)
			side = true;
		
		if (side) {
			// ball goes to the left player
			return ((int) ((Math.random() - 0.5) * 2 * initialDFi)) + 180;
		} else {
			// ball goes to the right player
			int temp = ((int) ((Math.random() - 0.5) * 2 * initialDFi));
			return 360 + temp;
		}
	}
	
	// get functions 
	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}
	
	public int getFi() {
		return (int) fi;
	}
	
	public void addToFi(int add) {
		fi += add;
	}
	
	
	public void spin(boolean left) {
		// check player movement to add 'ball spin'
		// adds and angle of ballSpin to Fi in the moving direction of player
		
		if (left) { // if left player
			
			boolean up1 = KeyInput.getUp1();
			boolean down1 = KeyInput.getDown1();
			
			if (up1 & !down1)
				fi += ballSpin;
				
			if (down1 & !up1)
				fi -= ballSpin;
				
		} else { // right player
			
			boolean up2 = KeyInput.getUp2();
			boolean down2 = KeyInput.getDown2();
			
			if (up2 & !down2)
				fi -= ballSpin;
				
			if (down2 & !up2)
				fi += ballSpin;
	
		}
		
	}
	
	
	public int degreeControl(int deg) {
		// Check and set degrees so that 0 <= deg < 360
		if (deg % 360 == 0)
			return 0;
			
		else if (deg > 360)
			return deg % 360;
		
		else if (deg < 360)
			return 360 + deg % 360;
		
		else {
			return 0;
			}
	}

	public void collisionLeft() {
		// Fi update, collision with left player
		if (fi >= 180)
			fi += 2 * (270 - fi);
		else 
			fi -= 2 * fi - 180;
	}

	public void collisionRight() {
		// Fi update, collision with right player 
		if (fi >= 0 & fi < 90)
			fi += 180 - 2 * fi;
		else 
			fi -= 2 * (fi - 270);
		
	}
	
	public void draw(Graphics g) {
		// draw ball
		g.setColor(Color.white);
		g.fillOval(Math.round(x), Math.round(y), size * 2, size * 2);
		
	}

	public void update(Player player1, Player player2) {
		// update movement
		fi = degreeControl(fi);
		dx = (float) (v * Math.cos(Math.toRadians(fi)));
		dy = (float) (v * Math.sin(Math.toRadians(fi)) * -1); // y-axis is reversed ==> -1
		x += dx;
		y += dy;
		
		// collision with bottom 
		if (y + size * 2 >= Game.HEIGHT)
			if (fi <= 270)
				fi -= 2 * fi - 360;
			else
				fi += 2 * (360 - fi);
		// collision with top
		if (y <= 0)
			fi += 360 - (2 * fi);
		
		// collision with right/left, add point, reset ball
		if (x + size * 2 >= Game.WIDTH) {
			player1.addPoint();
			reset();
		} 
		if (x <= 0) {
			player2.addPoint();
			reset();
		}
	}
}