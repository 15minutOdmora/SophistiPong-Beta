
import java.awt.Color;
import java.awt.event.*;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FirstPage extends Main {

	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH * 9/16;
	
	JButton startGameButton = new JButton("Start Game");
	private JLabel imagelabel;
	
	JButton ok1 = new JButton("Ok");  
	JButton reset = new JButton("Reset");  
	JButton back = new JButton("Back");  
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel labeBack = new JLabel();
	
	JTextField textfield1 = new JTextField();
	JTextField textfield2 = new JTextField();
	JTextField textfield3 = new JTextField();
	JTextField textfield4 = new JTextField();
	JTextField textfield5 = new JTextField();
	
	
	public FirstPage(JFrame frame) {
		// frame settings
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(WIDTH,HEIGHT + 50);    
		frame.setLayout(null);    
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // is centered
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// image label
		imagelabel = new JLabel();
		imagelabel.setIcon(new ImageIcon("src" + File.separator + "Logo.png"));
		imagelabel.setBounds(275, 0,1000,200);
		// buttons bounds
		startGameButton.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 130, 120, 30);   
		ok1.setBounds((int) (WIDTH / 2 + 50), 320, 50, 30); 
		reset.setBounds(WIDTH / 2 + 20, 360, 80, 30);
		
		// labels: text and bounds
		label1.setText("Ball size");
		label1.setBounds(WIDTH/2 - 100, 200, 100, 30);
		
		label2.setText("Ball speed");
		label2.setBounds(WIDTH/2 - 100, 230, 100, 30);
		
		label3.setText("Player height");
		label3.setBounds(WIDTH/2 - 100, 260, 100, 30);
		
		label4.setText("Player speed");
		label4.setBounds(WIDTH/2 - 100, 290, 100, 30);
		
		label5.setText("Rebound spin");
		label5.setBounds(WIDTH/2 - 100, 320, 100, 30);
	
		// text field input: text and bounds
		textfield1.setBounds(WIDTH/2, 200, 40, 30);
		textfield1.setText(Integer.toString(bSize));
		
		textfield2.setBounds(WIDTH/2, 230, 40, 30);
		textfield2.setText(Integer.toString(bSpeed));
		
		textfield3.setBounds(WIDTH/2, 260, 40, 30);
		textfield3.setText(Integer.toString(pSize));
		
		textfield4.setBounds(WIDTH/2, 290, 40, 30);
		textfield4.setText(Integer.toString(pSpeed));
		
		textfield5.setBounds(WIDTH/2, 320, 40, 30);
		textfield5.setText(Integer.toString(bSpin));
		
		
		startGameButton.addActionListener(new ActionListener() {
			// start game button action
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Game();
			}
		});
		
		ok1.addActionListener(new ActionListener() {
			// gets info from text fields, and updates data
			@Override
			public void actionPerformed(ActionEvent arg0) {
					String text1 = textfield1.getText().toString();
					int number1 = Integer.parseInt(text1);
					
					String text2 = textfield2.getText().toString();
					int number2 = Integer.parseInt(text2);
					
					String text3 = textfield3.getText().toString();
					int number3 = Integer.parseInt(text3);
					
					String text4 = textfield4.getText().toString();
					int number4 = Integer.parseInt(text4);
					
					String text5 = textfield5.getText().toString();
					int number5 = Integer.parseInt(text5);
					
					bSize = number1;
					bSpeed = number2;
					pSize = number3;
					pSpeed = number4;
					bSpin = number5;
			}       
	      });
		
		reset.addActionListener(new ActionListener() {
			// resets all data
			public void actionPerformed(ActionEvent arg0) {
					Main.resetData();	
					textfield1.setText(Integer.toString(bSize));
					textfield2.setText(Integer.toString(bSpeed));
					textfield3.setText(Integer.toString(pSize));
					textfield4.setText(Integer.toString(pSpeed));
					textfield5.setText(Integer.toString(bSpin));
			}          
		  });

		// add everything on frame
		frame.add(imagelabel);
		frame.add(label1); frame.add(label2); frame.add(label3); frame.add(label4); frame.add(label5);
		frame.add(textfield1); frame.add(textfield2); frame.add(textfield3); frame.add(textfield4); frame.add(textfield5);
		frame.add(ok1);     
		frame.add(reset);
		frame.add(startGameButton);
		frame.repaint();
	}
	

	public static void main(String[] args) {
		new FirstPage(null);
	}
}