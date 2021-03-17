package application.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Assets {
	
	public static Image grass, house, bigGrass , tree, post;
	public static Image[] player_down,player_up, player_right, player_left;
	public static Image player_stand_down, player_stand_up, player_stand_right, player_stand_left;
	
	public Assets() throws IOException {
		init();
	}
	
	public void init() throws IOException {
		int playerW = 48;
		int playerH = 64;
		
		player_down = new Image[3];
		player_up = new Image[3];
		player_left = new Image[3];
		player_right = new Image[3];
		
		
		//statics
		BufferedImage sheet1 = ImageIO.read(getClass().getClassLoader().getResource("textures/tilemap4.png"));
		grass = crop(sheet1, 192,0,36,36);
		house = crop(sheet1, 0, 0 ,120, 144);
		bigGrass = crop(sheet1, 0, 144, 72, 72);
		post = crop(sheet1, 192, 108, 24, 36);
		tree = crop(sheet1, 120, 72, 72, 72);
		
		//creatures
		BufferedImage sheet2 = ImageIO.read(getClass().getClassLoader().getResource("textures/pokemon3.png"));
		player_stand_down = crop(sheet2,playerW, 0,playerW, playerH );
		player_stand_up = crop(sheet2,playerW, playerH,playerW, playerH );
		player_stand_right = crop(sheet2,playerW, playerH * 2,playerW, playerH );
		player_stand_left = crop(sheet2,playerW, playerH * 2,playerW, playerH);
		
		for(int i = 0; i < 3; i++) {
			player_down[i] = crop(sheet2, playerW * i, 0, playerW, playerH);
		}
		for(int i = 0; i < 3; i++) {
			player_left[i] = crop(sheet2, playerW * i, playerH, playerW, playerH);
		}
		for(int i = 0; i < 3; i++) {
			player_right[i] = crop(sheet2, playerW * i, playerH * 2, playerW, playerH);
		}
		for(int i = 0; i < 3; i++) {
			player_up[i] = crop(sheet2, playerW * i, playerH * 3, playerW, playerH);
		}
		
	}
	
	private Image crop(BufferedImage sheet, int x, int y, int height,int width) {
		BufferedImage o1 = sheet.getSubimage(x,y,height,width);
		Image o2 = new WritableImage(height,width);
		SwingFXUtils.toFXImage(o1, (WritableImage) o2);
		return o2;
	}
	
}
