package com.sahej.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame  {
	
	public GameFrame() { //constructor is called when an object is created and also it is the right 
						 // place to initialize things.  
		Board board = new Board();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Game Dev in Java");
		this.setResizable(false);
		this.setSize(1400,1050);
		add(board);
		this.setVisible(true);
		this.setLocationRelativeTo(null);// brings gameframe to the centre.
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame(); //GameFrame object is created here and used above as 
										   //constructor
		
		
		
	}

}
