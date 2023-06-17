package Objects;

import Screens.GamePanel;

public class BoostDamage extends Object{

	private int height = GamePanel.tileSize;
	private int width = GamePanel.tileSize;	
	private int boost = 5;
	private int boosTime = 3000;
	private String imgPath1 = "/img/damageBoost_1.png";
	private String imgPath2 = "/img/damageBoost_2.png";

	public BoostDamage(int startX, int endX, int startY, int endY, int speedX, int speedY) {
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
		setBoostTime(boosTime);
		setImgPath1(imgPath1);
		setImgPath2(imgPath2);
		setImage1();
		setImage2();		
		setCollisionArea();
	}
}
