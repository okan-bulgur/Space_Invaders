package Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Game.Game;
import Screens.GamePanel;
import Objects.Object;

public class LevelManager extends Thread {
	private boolean isStop = false;
	private int levelPercentage = 0;
	private int levelCounter = 0;
	private int levelSpeed = 100;
	private final int x = 60;
	
	private int gameLevel;
	private Levels level;
	
	private ArrayList<Object> objectsByPercentage = new ArrayList<>(); 
	protected HashMap<String, Integer> maxObjectCount = new HashMap<>(); 

	@Override
	public void run() {
		double drawInterval = 1000000000/x;
		double nextDrawTime = System.nanoTime() + drawInterval; 
		setLevelPercentage(0);
		createLevel();
		declareMaxCount();
		setObjectsByPercentage();
		while (!isStop) {
			generateObjectByPercentage();
			levelCounter++;
			if(levelCounter % levelSpeed == 0) {
				level.runLevel();
				setLevelPercentage(getLevelPercentage() + 1);
			}
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createLevel() {
		switch (gameLevel) {
		case 1:
			setLevel(new Level1());
			break;
		case 2:
			setLevel(new Level2());
			break;
		case 3:
			setLevel(new Level3());
			break;
		default:
			break;
		}
	}
	
	public int getLevelPercentage() {
		return levelPercentage;
	}
	
	public void setLevelPercentage(int levelPercentage) {
		this.levelPercentage = levelPercentage;
	}
	
	public int getGameLevel() {
		return this.gameLevel;
	}
	
	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}
		
	public void levelStop() {
		isStop = true;
	}
	
	public void setLevel(Levels level) {
		this.level = level;
	}
	
	public Levels getLevel() {
		return level;
	}
	
	public void declareMaxCount() {
		String[] objectTypes = Game.gameManager.getObjectManager().getObjectTypes();
		Random random = new Random();
		maxObjectCount.clear();
		for(String type : objectTypes) {
			for(Integer num : level.getObjectMaxNum()) {
				maxObjectCount.put(type, random.nextInt(num)+1);				
			}
		}
	}
	
	public void setObjectsByPercentage() {
		Random random = new Random();
		
		int num;
		int percentage;
		int startX;
		int endX;
		int speedX;
		int speedY;
		
		for ( String key : maxObjectCount.keySet() ) {
			num = maxObjectCount.get(key);
			for	(int i=0 ; i<num ; i++) {
				percentage = random.nextInt(100);
				startX = random.nextInt(GamePanel.screenWidth);
				endX = random.nextInt(GamePanel.screenWidth);
				endX = endX >= startX ? endX : startX;
				speedX = random.nextInt(level.getMaxSpeedX());
				speedY = random.nextInt(level.getMaxSpeedY()) + 1;
				
				Object newObject = Game.gameManager.getObjectManager().createObject(key, percentage, startX, endX, 0, GamePanel.screenHeight*2, speedX, speedY);
				newObject.setBoostTime(newObject.getBoostTime() - level.getBoostTimeDelay());;
				objectsByPercentage.add(newObject);
			}
		}
	}
	
	public void generateObjectByPercentage() {
		Object obj;
		for(int i=0 ; i < objectsByPercentage.size() ; i++) {
			obj = objectsByPercentage.get(i);
			if(obj.getPercentage() == levelPercentage) {
				Game.gameManager.getObjectManager().addObject(obj);
				objectsByPercentage.remove(i);
			}
		}
	}
}