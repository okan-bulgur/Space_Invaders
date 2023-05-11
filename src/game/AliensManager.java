package game;

import java.awt.Graphics2D;

public class AliensManager {

	private Aliens alien = null;
	
	private static int spriteCounter = 0;
	private static int spriteNum = 0;
	
	public AliensManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void createAlien(String type) {
		alien = new Aliens(type);
	}
	
	public Aliens getAliens() {
		return alien;
	}
	
	public void drawAlien(Graphics2D g2, int tileSize) {
		if(spriteNum == 0) {
			g2.drawImage(alien.getAliensImg1() , alien.getPosX(), alien.getPosY(), tileSize, tileSize, null);			
		}
		else if(spriteNum == 1) {
			g2.drawImage(alien.getAliensImg2() , alien.getPosX(), alien.getPosY(), tileSize, tileSize, null);	
		}
	}
	
	public void update(int width) {
		
		if(alien.getPosX() + alien.getSpeed() >= width || alien.getPosX() + alien.getSpeed() <= 0) {	
			alien.setSpeed(alien.getSpeed() * -1);
		}

		alien.setPosX(alien.getPosX() + alien.getSpeed());
		
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 0;
			}
			else {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
}
