package com.sahej.gaming;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.sahej.gaming.sprites.Enemy;
import com.sahej.gaming.sprites.Player;

public class Board extends JPanel{
	Timer timer;
	BufferedImage bgImage;
	Player player;
	Enemy enemies[] = new Enemy[3];
	
	
	public Board() {
		setSize(1400,790);
		loadbgImage();
		loadEnemies();
		gameLoop();
		player = new Player();
		
		bindEvents();
		setFocusable(true);
	}
	
	private void gameOver(Graphics pen) {
		
		if(player.outofScreen()) {
			pen.setFont(new Font("times", Font.BOLD, 30));
			pen.setColor(Color.RED);
			pen.drawString("Game Won",1500/2, 900/2);
			timer.stop();
			return;
		}
		
		
		for(Enemy enemy : enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("times", Font.BOLD, 30));
				pen.setColor(Color.RED);
				pen.drawString("Game Over",1500/2, 900/2);
				timer.stop();
				
			}
		}
	}
	
	private boolean isCollide(Enemy enemy) {
		int xDistance = Math.abs(player.x-enemy.x);
		int yDistance = Math.abs(player.y-enemy.y);
		int maxH = Math.max(player.h, enemy.h);
		int maxW = Math.max(player.w, enemy.w);
		return xDistance<=maxW-80 && yDistance <=maxH-80;
		
	}
	private void bindEvents() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not used, but must be implemented
            }

            @Override
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
                player.speed = 10;
            	}
            	else if(e.getKeyCode()==KeyEvent.VK_LEFT  ) {
                        player.speed = -10;
                    	}// Assuming there's a setSpeed method in Player class
           
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.speed = 0; // Assuming there's a setSpeed method in Player class
            }
        });
    }
	
	private void loadEnemies() {
		int x = 400;
		int gap =350;
		int speed = 5;
		for(int i =0;i<enemies.length;i++) {
			enemies[i]= new Enemy(x, speed);
			x = x+gap;
			speed +=5;
		}
	}
	
	private void gameLoop() {
		timer = new Timer(50, (e)->repaint());
		timer.start();
	}
	
	
	private void loadbgImage() {
		try {
			bgImage = ImageIO.read(Board.class.getResource("game-bg.jpg"));
		} catch (IOException e) {
			System.out.println("Bg Image Not Found");
			System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
	}
	
	private void printEnemies(Graphics pen) {
		for(Enemy enemy : enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}


	@Override // as it is coming from JPanel
	public void paintComponent(Graphics pen) {
		
		super.paintComponent(pen); //used to clean up
									//super se mai parent class ke paas jarha hu joki JPanel hai.
		//all printing logic written here
		
		pen.drawImage(bgImage, 0, 0,1400,790, null);
		player.draw(pen);
		player.move();
		printEnemies(pen);
		gameOver(pen);
	}
}