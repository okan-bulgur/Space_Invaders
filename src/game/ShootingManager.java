package game;

public class ShootingManager {
	
	
	public void shooting(Character character) {
		
		int bulletSpeedX = character.getBulletSpeedX();
		int bulletSpeedY = character.getBulletSpeedY();
		
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
				
			case "shotgun":

				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, 0);
				Game.gameManager.getBulletManager().createBullet(character, -bulletSpeedX, -bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, -bulletSpeedY);
				Game.gameManager.getBulletManager().createBullet(character, bulletSpeedX, 0);
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


