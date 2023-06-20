package Ships;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Game.Character;
import Screens.GamePanel;

public class Ship extends Character {
	
	
	private String name;
	private int posX = GamePanel.tileSize * 11;
	private int posY = GamePanel.tileSize * 10;
	private int width = GamePanel.tileSize;
	private int height = GamePanel.tileSize;
	
	private BufferedImage shipImg;
	private BufferedImage shipBackFireImg1;
	private BufferedImage shipBackFireImg2;
	
	private String shipImgPath;
	private String shipBackFireImgPath1;
	private String shipBackFireImgPath2;	
	private String bulletImgPath1 = "/img/bullet_player_1.png";
	private String bulletImgPath2 = "/img/bullet_player_2.png";
	private String damageBoostBulletImgPath1 = "/img/damageBoostBullet_1.png";
	private String damageBoostBulletImgPath2 = "/img/damageBoostBullet_2.png";
	private String speedBoostBulletImgPath1 = "/img/speedBoostBullet_1.png";
	private String speedBoostBulletImgPath2 = "/img/speedBoostBullet_2.png";
	
	protected boolean isTakeDamage = false;
	protected int damageAnimationTime = 1500;
	
	public Ship(String name) {
		setShipName(name);
		setPosX(posX);
		setPosY(posY);
		setSizeWidth(width);
		setSizeHeight(height);
		setCollisionArea();
		setIsTakeDamage(isTakeDamage);
		setDamageAnimationTime(damageAnimationTime);
		setBulletImgPath(bulletImgPath1, bulletImgPath2);
		setDamageBoostBulletImgPath(damageBoostBulletImgPath1, damageBoostBulletImgPath2);
		setSpeedBoostBulletImgPath(speedBoostBulletImgPath1, speedBoostBulletImgPath2);
		setDefaultBulletImg();
		setPropertyOfShip();
	}
	
	public void setPropertyOfShip() {
		JSONParser jsonParser = new JSONParser();
		File file = new File("ships.json");

        try {
        	FileReader fileReader = new FileReader(file);
        	BufferedReader reader = new BufferedReader(fileReader);
        	String line;
        	while ((line = reader.readLine()) != null) {
                Object obj = jsonParser.parse(line);
                JSONObject userJson = (JSONObject) obj;
                String shipName = (String) userJson.get("name");
                
                if(name.equals(shipName)) {
                	long health = (long) userJson.get("health");
                	long damage = (long) userJson.get("damage");
                	long speedX = (long) userJson.get("speedX");
                	long speedY = (long) userJson.get("speedY");
                	long bulletSpeedX = (long) userJson.get("bulletSpeedX");
                	long bulletSpeedY = (long) userJson.get("bulletSpeedY");
                	String shootingType = (String) userJson.get("shootingType");
                	String shipImgPath = (String) userJson.get("shipImgPath");
                	String shipBackFireImgPath1 = (String) userJson.get("shipBackFireImgPath1");
                	String shipBackFireImgPath2 = (String) userJson.get("shipBackFireImgPath2");
                	
                	setHealth((int)health);
            		setDamage((int)damage);
            		setSpeedX((int)speedX);
            		setSpeedY((int)speedY);
            		setBulletSpeedX((int)bulletSpeedX);
            		setBulletSpeedY((int)bulletSpeedY);
            		setShootingType(shootingType);
            		setShipImgPath(shipImgPath, shipBackFireImgPath1, shipBackFireImgPath2);
            		setShipImg();
            		
            		break;
                }
        	}
        	fileReader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
	}
	
	public void setShipName(String shipName) {
		this.name = shipName;
	}
	
	public String getShipName() {
		return name;
	}
	
	public void setShipImgPath(String shipImgPath, String shipBackFireImgPath1, String shipBackFireImgPath2) {
		this.shipImgPath = shipImgPath;
		this.shipBackFireImgPath1 = shipBackFireImgPath1;
		this.shipBackFireImgPath2 = shipBackFireImgPath2;
	}
	
	public void setBulletImgPath(String bulletImgPath1, String bulletImgPath2) {
		this.bulletImgPath1 = bulletImgPath1;
		this.bulletImgPath2 = bulletImgPath2;
	}
		
	public void setDamageBoostBulletImgPath(String damageBoostBulletImgPath1, String damageBoostBulletImgPath2) {
		this.damageBoostBulletImgPath1 = damageBoostBulletImgPath1;
		this.damageBoostBulletImgPath2 = damageBoostBulletImgPath2;
	}
	
	public void setSpeedBoostBulletImgPath(String speedBoostBulletImgPath1, String speedBoostBulletImgPath2) {
		this.speedBoostBulletImgPath1 = speedBoostBulletImgPath1;
		this.speedBoostBulletImgPath2 = speedBoostBulletImgPath2;
	}
	
	public void setShipImg() {
		try {
			shipImg = ImageIO.read(getClass().getResourceAsStream(shipImgPath));
			shipBackFireImg1 = ImageIO.read(getClass().getResourceAsStream(shipBackFireImgPath1));
			shipBackFireImg2 = ImageIO.read(getClass().getResourceAsStream(shipBackFireImgPath2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getShipImg() {
		return shipImg;
	}

	public BufferedImage getShipBackFireImg1() {
		return shipBackFireImg1;
	}
	
	public BufferedImage getShipBackFireImg2() {
		return shipBackFireImg2;
	}
	
	public void setDefaultBulletImg() {
		setBulletImg(bulletImgPath1, bulletImgPath2);
	}
	
	public void setDamageBoostBulletImg() {
		setBulletImg(damageBoostBulletImgPath1, damageBoostBulletImgPath2);
	}
	
	public void setSpeedBoostBulletImg() {
		setBulletImg(speedBoostBulletImgPath1, speedBoostBulletImgPath2);
	}
	
	public void setDamageAnimationTime(int damageAnimationTime) {
		this.damageAnimationTime = damageAnimationTime;
	}
	
	public void setIsTakeDamage(boolean isTakeDamage) {
		this.isTakeDamage = isTakeDamage;
	}
	
	public boolean isTakeDamage() {
		return isTakeDamage;
	}

	public void setTakeDamage() {
		new Thread (new Runnable() 
		{	
			@Override
			public void run()
		    {
		        try {
		        	isTakeDamage = true;
					Thread.sleep(damageAnimationTime);
					isTakeDamage = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     
		    }
		}).start();
	}
}