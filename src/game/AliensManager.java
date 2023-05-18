package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import screens.GamePanel;

public class AliensManager {

	private ArrayList<Alien> aliens = new ArrayList<>();
	
	private Bulletmanager bulletmanager;	
	private static int spriteCounter = 0;
	private static int spriteNum = 0;
	
	public AliensManager(Bulletmanager bulletmanager) {
		this.bulletmanager = bulletmanager;
	}
	
	public void createAlien(String type) {
		Alien newAlien = new Alien(type);
		aliens.add(newAlien);
	}
	
	public ArrayList<Alien> getAliens(){
		return aliens;
	}
	
	public void drawCharacter(Graphics2D g2) {
		Iterator<Alien> itr = aliens.listIterator();
		while (itr.hasNext()) {
			Alien alien = itr.next();
			
			if(spriteNum == 0) {
				g2.drawImage(alien.getAliensImg1() , alien.getPosX(), alien.getPosY(), alien.getSizeWidth(), alien.getSizeHeight(), null);			
			}
			else if(spriteNum == 1) {
				g2.drawImage(alien.getAliensImg2() , alien.getPosX(), alien.getPosY(), alien.getSizeWidth(), alien.getSizeHeight(), null);	
			}
		}
	}
	
	public void update() {

		if (aliens.size() == 0) {
			return;			
		}
		
		Iterator<Alien> itr = aliens.listIterator();
		while (itr.hasNext()) {
			Alien alien = itr.next();
			
			if(alien.getPosX() + alien.getSpeed() >= GamePanel.screeWidth || alien.getPosX() + alien.getSpeed() <= 0) {	
				alien.setSpeed(alien.getSpeed() * -1);
			}
			
			alien.setPosX(alien.getPosX() + alien.getSpeed());
			
			alien.setCollisionArea();
			
		}
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
	
	public void takeDamage(Alien alien, int damage, ListIterator<Alien> alienItr) {
		alien.setHealth(alien.getHealth() - damage);
		if(isDead(alien)) {
			alienItr.remove();
			alien = null;
		}
	}
	
	public boolean isDead(Alien alien) {
		return alien.getHealth() == 0;
	}

	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2))
		{
		    return true;
		}
		return false;
	}

}
