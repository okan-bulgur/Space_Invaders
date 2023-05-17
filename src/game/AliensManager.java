package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

public class AliensManager extends CharacterManager{

	private ArrayList<Alien> aliens = new ArrayList<>();
	
	private static int spriteCounter = 0;
	private static int spriteNum = 0;
	
	public void createAlien(String type) {
		Alien newAlien = new Alien(type);
		aliens.add(newAlien);
	}
	
	public void drawCharacter(Graphics2D g2) {
		Iterator<Alien> itr = aliens.listIterator();
		while (itr.hasNext()) {
			Alien alien = itr.next();
			
			if(spriteNum == 0) {
				g2.drawImage(alien.getAliensImg1() , alien.getPosX(), alien.getPosY(), GameManager.tileSize, GameManager.tileSize, null);			
			}
			else if(spriteNum == 1) {
				g2.drawImage(alien.getAliensImg2() , alien.getPosX(), alien.getPosY(), GameManager.tileSize, GameManager.tileSize, null);	
			}
		}
	}
	
	@Override
	public void update() {

		if (aliens.size() == 0) {
			return;			
		}
		
		Iterator<Alien> itr = aliens.listIterator();
		while (itr.hasNext()) {
			Alien alien = itr.next();
			
			if(alien.getPosX() + alien.getSpeed() >= GameManager.screeWidth || alien.getPosX() + alien.getSpeed() <= 0) {	
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
	
	public void takeDamage(Alien alien) {
		alien.setHealth(alien.getHealth() - 1);
		if(isDead(alien)) {
			alien = null;
			System.gc();
		}
	}
	
	public boolean isDead(Alien alien) {
		return alien.getHealth() == 0;
	}

	@Override
	public void collisionDetector() {
		// TODO Auto-generated method stub
		
	}
	
}
