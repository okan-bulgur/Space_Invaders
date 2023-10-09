package Game;

import Ships.Ship;

public class ShootingManager {
	
	
	public void shooting(Character character) {
		
		int bulletSpeedX;
		int bulletSpeedY;
		
		if(character instanceof Ship) {
			bulletSpeedX = character.getBulletSpeedX();
			bulletSpeedY = character.getBulletSpeedY();
			Game.sound.shootEffect();
		}
		else {
			int boostBulletSpeedX = Game.gameManager.getLevelManager().getLevel().getBoostBulletSpeedX();
			int boostBulletSpeedY = Game.gameManager.getLevelManager().getLevel().getBoostBulletSpeedY();

			bulletSpeedX = character.getBulletSpeedX() == 0 ? 0 : ( character.getBulletSpeedX() > 0 ? character.getBulletSpeedX() + boostBulletSpeedX : character.getBulletSpeedX() - boostBulletSpeedX );
			bulletSpeedY = character.getBulletSpeedY() == 0 ? 0 : ( character.getBulletSpeedY() > 0 ? character.getBulletSpeedY() + boostBulletSpeedY : character.getBulletSpeedY() - boostBulletSpeedY );			
		}
		
		switch (character.getShootingType()) {
		
			case "vertical_up":
				Game.gameManager.getBulletManager().createBullet(character, 0, bulletSpeedY);
				break;
				
			case "vertical_down":
				Game.gameManager.getBulletManager().createBullet(character, 0, -bulletSpeedY);
				break;
				
			case "vertical_double":

				Game.gameManager.getBulletManager().createBullet(character, 0, bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, 0, -bulletSpeedY);
				break;
				
			case "horizontal_right":

				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, 0);
				break;
	
			case "horizontal_left":

				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, 0);
				break;
				
			case "horizontal_double":

				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, 0);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, 0);
				break;
				
			case "both_vertical_horizontal":

				Game.gameManager.getBulletManager().createBullet(character, 0, bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, 0, -bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, 0);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, 0);
				break;
				
			case "shotgunDown":

				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, 0);
				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, -bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, -bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, 0);
				Game.gameManager.getBulletManager().createBullet(character, 0, -bulletSpeedY);
				break;
				
			case "shotgunUp":

				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, 0);
				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, 0);
				Game.gameManager.getBulletManager().createBullet(character, 0, bulletSpeedY);
				break;
				
			case "cross":		

				Game.gameManager.getBulletManager().createBullet(character,bulletSpeedX, bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, -bulletSpeedY);				
				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, -bulletSpeedY);
				break;	
			
			default:
				break;
		}
	}	
}


