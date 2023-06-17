package Objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.ICanCollision;

public class Object implements ICanCollision {
	
	private int posX;
	private int posY;
	private int startX;
	private int endX;
	private int startY;
	private int endY;
	private int speedX;
	private int speedY;
	private int height;
	private int width;
	private int boost;
	private int boostTime;
	private int percentage;
	private Rectangle collisionArea;	
	private BufferedImage image1;
	private BufferedImage image2;
	private String imgPath1;
	private String imgPath2;
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public int getSpeedX() {
		return speedX;
	}
	
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
	public int getSpeedY() {
		return speedY;
	}
	
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public BufferedImage getImage1() {
		return image1;
	}
	
	public void setBoost(int boost) {
		this.boost = boost;
	}
	
	public int getBoost() {
		return boost;
	}
	
	public void setBoostTime(int boostTime) {
		this.boostTime = boostTime;
	}
	
	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getBoostTime() {
		return boostTime;
	}
	
	public void setImage1() {
		try {
			this.image1 = ImageIO.read(getClass().getResourceAsStream(imgPath1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage2() {
		return image2;
	}
	
	public void setImage2() {
		try {
			this.image2 = ImageIO.read(getClass().getResourceAsStream(imgPath2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getImgPath1() {
		return imgPath1;
	}
	
	public void setImgPath1(String imgPath1) {
		this.imgPath1 = imgPath1;
	}
	
	public String getImgPath2() {
		return imgPath2;
	}
	
	public void setImgPath2(String imgPath2) {
		this.imgPath2 = imgPath2;
	}
	
	public void setCollisionArea(Rectangle collisionArea) {
		this.collisionArea = collisionArea;
	}
	
	@Override
	public void setCollisionArea() {
		collisionArea = new Rectangle();
		collisionArea.x = posX;
		collisionArea.y = posY;
		collisionArea.width = width;
		collisionArea.height = height;
	}
	
	@Override
	public Rectangle getCollisionArea() {
		return collisionArea;
	}
}
