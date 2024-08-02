package com.sahej.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {
		
		
		public Enemy(int x, int speed) {	
			
			this.speed = speed;
			y = 50;
			this.x = x;
			w = 200;
			h = 200;
			
		image = new ImageIcon(Enemy.class.getResource("spider.gif"));
		}
		
		
		
		public void move() {
			if(y>900) {
				y = 0;
			}
			
			y = y + speed;
		}
		
}