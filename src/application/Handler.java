package application;

import application.gfx.GameCamera;
import application.input.KeyManager;
import application.input.MouseManager;
import application.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	private KeyManager keyManager;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void setKeyManager(KeyManager keyManager) {
		this.keyManager = keyManager;
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public World getWorld() {
		// TODO Auto-generated method stub
		return world;
	}
	
}
