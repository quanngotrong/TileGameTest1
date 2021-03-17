package application;
	
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import application.gfx.Assets;
import application.gfx.GameCamera;
import application.input.KeyManager;
import application.input.MouseManager;
import application.settings.Setting;
import application.states.GameState;
import application.states.State;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;


public class Game extends Application {
	private Handler handler;
	private int width, height;
	public String title;

	private long start;
	private long timePerUpDate;
	private double delta = 0;
	private Assets assets;
	
	//display
	private GraphicsContext gc;
	
	//setting
	private Setting setting;
	
	//States
	private State gameState;
	private State menuState;
	
	//camera
	private GameCamera gameCamera;
	
	//event
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	public Game() throws IOException {
		handler = new Handler(this);
		setting = new Setting(handler);
		
		//game loop
		start = System.nanoTime();
		timePerUpDate = 1000000000/ setting.getFps();
		
		//asserts
		assets = new Assets();
		
		//size
		width = setting.getWidth();
		height = setting.getHeight();
		
		//state
		gameState = new GameState(handler);
		State.setState(gameState);
		
		//camera
		gameCamera = new GameCamera(handler, 0,0);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		initUI(primaryStage);
	}
	
	private void initUI(Stage primaryStage) {
		try {
			System.out.println("hah");
			primaryStage.setTitle("Tile game");
			
			Group root = new Group();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			Canvas canvas = new Canvas(width,height);
			root.getChildren().add(canvas);
			
			gc = canvas.getGraphicsContext2D();
			
			//begin loop
			AnimationTimer timer = new MyTimer();
			timer.start();
			
			primaryStage.show();
			primaryStage.setResizable(false);
			System.out.println("he");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private class MyTimer extends AnimationTimer{

		@Override
		public void handle(long now) {
			doHandle(now);
		}
		
		private void doHandle(long now) {
			double time = (now - start)/timePerUpDate;
			delta += time;
			
			if(delta >= 1) {
				update();
				render(gc);
				delta --;
			}
		}
		
	}
	
	private void update() {
//		keyManager.update();
		
		if(State.getState() != null) {
			State.getState().update();
		}
	}
	
	private void render(GraphicsContext gc) {
		
		if(State.getState() != null) {
			State.getState().render(gc);
		}
		
	}
	
	public void launchGame(String[] args) {
		launch(args);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public GraphicsContext getGc() {
		return gc;
	}

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		// TODO Auto-generated method stub
		return mouseManager;
	}
}
