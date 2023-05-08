package screens;

public class ScreenManager {
	
	private Screen screen;
	
	public void setScreen(Screen screen) {
		this.screen = screen;
		showScreen();
	}
	
	private void showScreen() {
		screen.createScreen();
	}
	
	
}
