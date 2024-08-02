package com.sahej.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
	public int speed; 
	public int x;
	public int y;
	public int h;
	public int w;
	
	ImageIcon image;
	
	public void draw(Graphics pen) {
		pen.drawImage(image.getImage(), x, y, w, h,  null);
	}
}
