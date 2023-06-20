package Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Game.Game;
import Screens.GamePanel;

public class ObjectManager {
	
	private ArrayList<Object> objects = new ArrayList<>();
	private final static String[] objectTypes = {"healthBoost", "speedBoost", "bulletSpeedBoost", "damageBoost", "gold"};
	
	public Object createObject(String type, int percentage, int startX, int endX, int startY, int endY, int speedX, int speedY) {
		Object newObject = null;
		switch (type) {
			case "healthBoost":
				newObject = new BoostHealth(percentage, startX, endX, startY, endY, speedX, speedY);
				break;
			case "speedBoost":
				newObject = new BoostSpeed(percentage, startX, endX, startY, endY, speedX, speedY);
				break;
			case "bulletSpeedBoost":
				newObject = new BoostBulletSpeed(percentage, startX, endX, startY, endY, speedX, speedY);
				break;
			case "damageBoost":
				newObject = new BoostDamage(percentage, startX, endX, startY, endY, speedX, speedY);
				break;
			case "gold":
				newObject = new Gold(percentage, startX, endX, startY, endY, speedX, speedY);
				break;
			default:
				break;
		}
		return newObject;
	}
	
	public void addObject(Object object) {
		objects.add(object);
	}
	
	public void drawObject(Graphics2D g2) {
		for(int i=0; i < objects.size(); i++) {
			Object object = objects.get(i);
			
			if(!Game.gameManager.getAnimationManager().isObjectAnimation()) {
				g2.drawImage(object.getImage1() , object.getPosX(), object.getPosY(), object.getWidth(), object.getHeight(), null);			
			}
			else if(Game.gameManager.getAnimationManager().isObjectAnimation()) {
				g2.drawImage(object.getImage2() , object.getPosX(), object.getPosY(), object.getWidth(), object.getHeight(), null);			
			}
		}
	}
	
	public void update() {
		
		if(objects.size() == 0) {
			return;
		}
		
		int boostSpeedX = Game.gameManager.getLevelManager().getLevel().getBoostSpeedX();
		int boostSpeedY = Game.gameManager.getLevelManager().getLevel().getBoostSpeedY();
	
		for(int i=0; i < objects.size(); i++) {
			Object object = objects.get(i);
			
			int speedX = object.getSpeedX() == 0 ? 0 : object.getSpeedX() > 0 ? object.getSpeedX() + boostSpeedX : object.getSpeedX() - boostSpeedX;
			int speedY = object.getSpeedY() == 0 ? 0 : object.getSpeedY() > 0 ? object.getSpeedY() + boostSpeedY : object.getSpeedY() - boostSpeedY;
		
			if(object.getPosX() + speedX <= object.getStartX() || object.getPosX() + speedX + object.getWidth() * 2 >= object.getEndX()) {	
				object.setSpeedX(object.getSpeedX() * -1);
			}
			
			if(object.getPosY() + speedY <= object.getStartY() || object.getPosY() + speedY + object.getHeight() * 2 >= object.getEndY()) {	
				object.setSpeedY(object.getSpeedY() * -1);
			}
			
			if(object.getPosY() > GamePanel.screenHeight) {
				objects.remove(i);
				object = null;
				continue;
			}
			
			object.setPosX(object.getPosX() + speedX);
			object.setPosY(object.getPosY() + speedY);
			
			object.setCollisionArea();
		}
	}
	
	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2))
		{
		    return true;
		}
		return false;
	}
	
	public ArrayList<Object> getObjects(){
		return objects;
	}
	
	public void doObjectTask(Object object) {
		if(object instanceof BoostHealth) {
			Game.gameManager.getShipManager().boostHealth(object);
		}
		else if(object instanceof BoostSpeed) {
			Game.gameManager.getShipManager().boostSpeed(object);
		}
		else if(object instanceof BoostBulletSpeed) {
			Game.gameManager.getShipManager().boostBulletSpeed(object);
		}
		else if(object instanceof BoostDamage) {
			Game.gameManager.getShipManager().boostDamage(object);
		}
		else if(object instanceof Gold) {
			Game.gameManager.getPlayerManager().collectGold(object);
		}
	}
	
	public String[] getObjectTypes() {
		return objectTypes;
	}
}
