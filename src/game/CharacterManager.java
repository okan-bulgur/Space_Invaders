package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class CharacterManager implements ICollision {

	public abstract void drawCharacter(Graphics2D g2);
	
	public abstract void update();
	
	@Override
	public boolean isCollision(Rectangle area1, Rectangle area2) {
		if(area1.intersects(area2))
		{
		    return true;
		}
		return false;
	}
	
}
