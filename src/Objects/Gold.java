package Objects;

import Screens.GamePanel;

public class Gold extends Object {

	private int height = GamePanel.tileSize;
	private int width = GamePanel.tileSize;	
	private int boost = 1;
	private String imgPath1 = "/img/healthBoost_1.png";
	private String imgPath2 = "/img/healthBoost_2.png";

	public Gold(int percentage, int startX, int endX, int startY, int endY, int speedX, int speedY) {
		setPercentage(percentage);
		setPosX(startX);
		setPosY(startY);
		setStartX(startX);
		setEndX(endX);
		setStartY(startY);
		setEndY(endY);
		setSpeedX(speedX);
		setSpeedY(speedY);
		setHeight(height);
		setWidth(width);   
		setBoost(boost);
		setImgPath1(imgPath1);
		setImgPath2(imgPath2);
		setImage1();
		setImage2();		
		setCollisionArea();
	}
	
}