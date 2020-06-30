import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Player extends Main{
	
	private int x, y;                       // position 
	private int vel = 0;					// velocity (direction and size)
	private int speed = pSpeed;				// speed size
	private int width = 25, height = pSize; // player sizes
	private int score = 0;                  // score
	private Color color;                    
	private boolean left;					// if left or right player
	
	public Player(Color c, boolean left) {
		// set position depending on player(left or right)
		color = c;
		this.left = left;
		
		if (left)
			x = 0;
		else
			x = Game.WIDTH - width;
		
		y = Game.HEIGHT / 2 - height / 2;
	}
	
	public void addPoint() {
		// adds a point to player
		score++;
	}

	public void draw(Graphics g) {
		// draw player
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		// draw score
		int sx;
		String scoreText = Integer.toString(score);
		Font font = new Font("Symbol BOLD", Font.PLAIN, 35);  // score number size = 35
		
		int strWidth = g.getFontMetrics(font).stringWidth(scoreText) + 1;
		int padding = 25; // distance between center line and each score
		
		if (left)
			sx = Game.WIDTH / 2 - padding - strWidth;
		else 
			sx = Game.WIDTH / 2 + padding;
		
		g.setFont(font);
		g.drawString(scoreText, sx, 600);
	}

	public void update(Ball b) {
		// update position
		y = Game.ensureRange(y += vel, 0, Game.HEIGHT - height);
		
		// get ball position
		int ballX = b.getX();
		int ballY = b.getY();
		
		// ball collision with left player
		if (left) {
			if (ballX <= x + width) {
				if ((ballY + b.size) >= y & ballY  <= y + height) {
					b.collisionLeft();
					b.spin(left);
				}
			}
			
		// ball collision with right player
		} else {
			if (ballX + b.size >= x - width) {
				if (ballY + b.size >= y & ballY <= y + height) {
					b.collisionRight();
					b.spin(left);
				}
			}
		}
	}

	public void switchDirection(int direction) {
		vel = speed * direction;
	}
	
	public void stop() {
		vel = 0;
	}
}