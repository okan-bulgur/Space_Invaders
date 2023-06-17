package Game;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	private Clip clip;
	private URL gameStart;
	private URL gameOver;
	private URL won;
	private URL shoot;
	private URL damage;
	private URL playerDamage;
	private URL death;
	private URL newHighscore;
	private URL buttonClick;
	private URL message;
	private URL collectObject;
	
	public Sound() {
		gameStart = getClass().getResource("/sounds/game_start.wav");
		gameOver = getClass().getResource("/sounds/game_over.wav");
		won = getClass().getResource("/sounds/won.wav");
		shoot = getClass().getResource("/sounds/shooting.wav");
		damage = getClass().getResource("/sounds/damage.wav");
		playerDamage = getClass().getResource("/sounds/player_damage.wav");
		death = getClass().getResource("/sounds/death.wav");
		newHighscore = getClass().getResource("/sounds/new_high_score.wav");
		buttonClick = getClass().getResource("/sounds/button_click.wav");
		message = getClass().getResource("/sounds/message.wav");
		collectObject = getClass().getResource("/sounds/collect_object.wav");
	}
	
	public void gameStartEffect() {
		play(gameStart);
	}
	
	public void gameOverEffect() {
		play(gameOver);
	}
	
	public void wonEffect() {
		play(won);
	}
	
	public void shootEffect() {
		play(shoot);
	}
	
	public void damageEffect() {
		play(damage);
	}
	
	public void playerDamageEffect() {
		play(playerDamage);
	}
	
	public void deathEffect() {
		play(death);
	}
	
	public void newHighscoreEffect() {
		play(newHighscore);
	}
	
	public void buttonClickEffect() {
		play(buttonClick);
	}
	
	public void messageEffect() {
		play(message);
	}
	
	public void collectObjectEffect() {
		play(collectObject);
	}

	private void play(URL url) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e){
		}
	}
}
