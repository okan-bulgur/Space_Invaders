package Player;

import Game.Game;
import Users.User;
import Objects.Object;

public class PlayerManager{
	
	private User user = null;
	private Player player = null;
	
	private boolean highScoreChecker = true;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void createPlayer () {
		player = new Player(user);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void addScore() {
		player.setScore(player.getScore() + (player.getShip().getDamage() * Game.gameManager.getLevelManager().getLevel().getHitScore()));
		if(player.getScore() > user.getHighScore() && highScoreChecker) {
			Game.sound.newHighscoreEffect();
			Game.gameManager.getGamePanel().displayNewHighScoreUser();
			highScoreChecker = false;
		}
	}

	public void changeHighScore(User user, int score) {
		if(user.getHighScore() < score) {
			user.setHighScore(score);
			Game.fileManager.setNewPropertyOfUser(user);
			Game.fileManager.addHighScore(user.getUsername(), score);
		}
	}	
	
	public void collectGold(Object object) {
		user.setGoldAmount(user.getGoldAmount() + object.getBoost());
	}
}
