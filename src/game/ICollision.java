package game;

import java.awt.Rectangle;

public interface ICollision {
	
	public boolean isCollision(Rectangle area1, Rectangle area2);
	
	public void collisionDetector();
}
