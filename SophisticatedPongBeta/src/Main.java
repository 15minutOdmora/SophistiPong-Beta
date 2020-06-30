import javax.swing.JFrame;

public class Main {
	// Main class, saves all game data which are passed on.
	static JFrame frame = new JFrame("SophistiPong");
	
	public static int bSpeed = 9; // ball speed
	public static int bSize = 16; // ball size
	public static int pSize = 100; // player size
	public static int pSpeed = 7; // player speed
	public static int bSpin = 15; // Spin on ball after it rebounds of a moving player
	
	public static void resetData() {
		// resets all game data
		bSpeed = 9;
		bSize = 16;
		pSize = 100;
		pSpeed = 7;
		bSpin = 15;
	}
	
	public static void main(String[] args) {  
		new FirstPage(frame);
	}
}
