import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	// reads input and interacts with player movement
	
	private Player p1;
	private static boolean up1 = false;
	private static boolean down1 = false;
	
	private Player p2;
	private static boolean up2 = false;
	private static boolean down2 = false;

	public KeyInput(Player pl1, Player pl2) {
		p1 = pl1;
		p2 = pl2;	
	}
	
	public void keyPressed(KeyEvent e) {
		// get pressed keys data
		int key = e.getKeyCode();
		System.out.println(key);
		
		if (key == KeyEvent.VK_UP) {
			p2.switchDirection(-1);
			up2 = true;
		}
		
		if (key == KeyEvent.VK_DOWN) {
			p2.switchDirection(1);
			down2 = true;
		}
		
		if (key == KeyEvent.VK_W) {
			p1.switchDirection(-1);
			up1 = true;
		}
		
		if (key == KeyEvent.VK_S) {
			p1.switchDirection(1);
			down1 = true;
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		// get released data
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			up2 = false;
		}
		
		if (key == KeyEvent.VK_DOWN) {
			System.out.println("downnn");
			down2 = false;
		}
		
		if (key == KeyEvent.VK_W) {
			up1 = false;
		}
		
		if (key == KeyEvent.VK_S) {
			down1 = false;
		}
		
		// makes it to not lag
		if (!up1 && !down1) {
			p1.stop();
		}
		if (!up2 && !down2) {
			p2.stop();
		}
	}
	
	// get functions
	public static boolean getUp1() {
		return up1;
	}
	
	public static boolean getDown1() {
		return down1;
	}
	
	public static boolean getUp2() {
		return up2;
	}
	
	public static boolean getDown2() {
		return down2;
	}
}
