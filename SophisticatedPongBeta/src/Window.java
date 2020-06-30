import javax.swing.JFrame;

public class Window {
	// create game window, separate from FirstPage window
	public Window(String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null); // is centered to screen
		frame.setVisible(true);
		game.start();
	}
}

