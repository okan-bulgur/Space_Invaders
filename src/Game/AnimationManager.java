package Game;

import java.util.Timer;
import java.util.TimerTask;

public class AnimationManager {
	
	private boolean playerAnimation = true;
	private boolean alienAnimation = true;
	private boolean bulletAnimation = true;
	private boolean objectAnimation = true;
	
	private int playerAnimationDelay = 100;
	private int alienAnimationDelay = 200;
	private int bulletAnimationDelay = 100;
	private int objectAnimationDelay = 100;
	
	private Timer animationTimer = null;
	private TimerTask playerTask = null;
	private TimerTask alienTask = null;
	private TimerTask bulletTask = null;
	private TimerTask objectTask = null;
	
	public AnimationManager() {
		startAnimations();
	}
	
	public void startAnimations() {
		animationTimer = new Timer();
		
		playerTask = new TimerTask() {
			@Override
			public void run() {
				playerAnimation = !playerAnimation;
			}
		};
		
		alienTask = new TimerTask() {
			@Override
			public void run() {
				alienAnimation = !alienAnimation;
			}
		};
		
		bulletTask = new TimerTask() {
			@Override
			public void run() {
				bulletAnimation = !bulletAnimation;
			}
		};
		
		objectTask = new TimerTask() {
			@Override
			public void run() {
				objectAnimation = !objectAnimation;
			}
		};
		
		animationTimer.schedule(playerTask, 0, playerAnimationDelay);
		animationTimer.schedule(alienTask, 0, alienAnimationDelay);
		animationTimer.schedule(bulletTask, 0, bulletAnimationDelay);
		animationTimer.schedule(objectTask, 0, objectAnimationDelay);
	}
	
	public boolean isPlayerAnimation() {
		return playerAnimation;
	}
	
	public boolean isAlienAnimation() {
		return alienAnimation;
	}

	public boolean isBulletAnimation() {
		return bulletAnimation;
	}
	
	public boolean isObjectAnimation() {
		return objectAnimation;
	}
	
}
