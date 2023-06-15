package Aliens;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Game.Game;
import Screens.GamePanel;

public class AliensManager {

	private ArrayList<Alien> aliens = new ArrayList<>();
		
	private static int bulletDelayCounter = 0;
	
	public ArrayList<Alien> getAliens(){
		return aliens;
	}
	
	public void createAlien(String type, int posX, int endPosX, int posY, int endPosY, int speedX, int speedY, int bulletSpeedX, int bulletSpeedY, int bulletDelay) {
		Alien newAlien = null;
		switch (type) {
		case "alien1":
			newAlien = new Alien1(posX, endPosX, posY, endPosY, speedX, speedY, bulletSpeedX, bulletSpeedY, bulletDelay);
			break;
		case "alien2":
			newAlien = new Alien2(posX, endPosX, posY, endPosY, speedX, speedY, bulletSpeedX, bulletSpeedY, bulletDelay);
			break;
		case "alien3":
			newAlien = new Alien3(posX, endPosX, posY, endPosY, speedX, speedY, bulletSpeedX, bulletSpeedY, bulletDelay);
			break;
		case "alien4":
			newAlien = new Alien4(posX, endPosX, posY, endPosY, speedX, speedY, bulletSpeedX, bulletSpeedY, bulletDelay);
			break;
		case "alien5":
			newAlien = new Alien5(posX, endPosX, posY, endPosY, speedX, speedY, bulletSpeedX, bulletSpeedY, bulletDelay);
			break;
		case "alien6":
			newAlien = new Alien6(posX, endPosX, posY, endPosY, speedX, speedY, bulletSpeedX, bulletSpeedY, bulletDelay);
			break;
		default:
			return;
		}
		aliens.add(newAlien);
	}
	
	public void drawCharacter(Graphics2D g2) {
		for(int i=0 ; i < aliens.size() ; i++) {
			Alien alien = aliens.get(i);
			if(alien.isTakeDamage() && !Game.gameManager.getAnimationManager().isAlienAnimation()) {
				AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
				g2.setComposite(composite);
			}
			if(!Game.gameManager.getAnimationManager().isAlienAnimation()) {
				g2.drawImage(alien.getAliensImg1() , alien.getPosX(), alien.getPosY(), alien.getSizeWidth(), alien.getSizeHeight(), null);			
			}
			else if(Game.gameManager.getAnimationManager().isAlienAnimation()) {
				g2.drawImage(alien.getAliensImg2() , alien.getPosX(), alien.getPosY(), alien.getSizeWidth(), alien.getSizeHeight(), null);	
			}
			if (alien.isTakeDamage() && !Game.gameManager.getAnimationManager().isAlienAnimation()) {
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); 
			}
		}
	}
	
	public void update() {
		bulletDelayCounter++;
		
		if (aliens.size() == 0) {
			return;			
		}

		int boostSpeedX = Game.gameManager.getLevelManager().getLevel().getBoostSpeedX();
		int boostSpeedY = Game.gameManager.getLevelManager().getLevel().getBoostSpeedY();
		
		for(int i=0 ; i < aliens.size() ; i++) {
			Alien alien = aliens.get(i);
			
			int speedX = alien.getSpeedX() == 0 ? 0 : alien.getSpeedX() > 0 ? alien.getSpeedX() + boostSpeedX : alien.getSpeedX() - boostSpeedX;
			int speedY = alien.getSpeedY() == 0 ? 0 : alien.getSpeedY() > 0 ? alien.getSpeedY() + boostSpeedY : alien.getSpeedY() - boostSpeedY;
			
			if(alien.getPosX() + speedX <= alien.getStartX() || alien.getPosX() + speedX + alien.getSizeWidth() * 2 >= alien.getEndX()) {	
				alien.setSpeedX(alien.getSpeedX() * -1);
			}
			
			if(alien.getPosY() + speedY <= alien.getStartY() || alien.getPosY() + speedY + alien.getSizeHeight() * 2 >= alien.getEndY()) {	
				alien.setSpeedY(alien.getSpeedY() * -1);
			}
			
			if(alien.getPosY() > GamePanel.screenHeight) {
				aliens.remove(i);
				alien = null;
				continue;
			}
			
			alien.setPosX(alien.getPosX() + speedX);
			alien.setPosY(alien.getPosY() + speedY);
			
			alien.setCollisionArea();
			
			if(bulletDelayCounter % alien.getBulletCreateDelay() == 0) {
				Game.gameManager.getShootingManager().shooting(alien);
			}			
		}
		
	}
	
	public void takeDamage(Alien alien, int damage) {
		alien.setHealth(alien.getHealth() - damage);
		alien.setTakeDamage();
		if(isDead(alien)) {
			Game.gameManager.getGamePanel().getSound().deathEffect();
			aliens.remove(alien);
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
