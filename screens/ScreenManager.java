package screens;

public class ScreenManager {
	
	private Screen screen;
	
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	public void showScreen() {
		screen.createScreen();
	}
}
