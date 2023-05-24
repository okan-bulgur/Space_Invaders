package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	private boolean upPress, downpress, rightPress, leftpress, spacePress;
	
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPress = true;
		}
		if(code == KeyEvent.VK_S) {
			downpress = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPress = true;
		}
		if(code == KeyEvent.VK_A) {
			leftpress = true;
		}
		if(code == KeyEvent.VK_SPACE) {
			spacePress = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPress = false;
		}
		if(code == KeyEvent.VK_S) {
			downpress = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPress = false;
		}
		if(code == KeyEvent.VK_A) {
			leftpress = false;
		}
		if(code == KeyEvent.VK_SPACE) {
			spacePress = false;
		}
	}
	
	public boolean isUpPress() {
		return upPress;
	}

	public void setUpPress(boolean upPress) {
		this.upPress = upPress;
	}

	public boolean isDownpress() {
		return downpress;
	}

	public void setDownpress(boolean downpress) {
		this.downpress = downpress;
	}

	public boolean isRightPress() {
		return rightPress;
	}

	public void setRightPress(boolean rightPress) {
		this.rightPress = rightPress;
	}

	public boolean isLeftpress() {
		return leftpress;
	}

	public void setLeftpress(boolean leftpress) {
		this.leftpress = leftpress;
	}
	
	public boolean isSpacepress() {
		return spacePress;
	}

	public void setSpacepress(boolean spacePress) {
		this.spacePress = spacePress;
	}


}
