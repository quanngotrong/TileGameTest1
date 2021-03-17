package application.entities;

import java.util.ArrayList;
import java.util.Comparator;

import application.Handler;
import application.entities.creatures.Player;
import javafx.scene.canvas.GraphicsContext;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() +a.getHeight() < b.getY() + b.getHeight()) {
				 return -1;
			}
			return 1;
		}
		
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void update() {
		for(int i = 0; i < entities.size() ; i ++) {
			Entity e = entities.get(i);
			e.update();
		}
		entities.sort(renderSorter);
	}
	
	public void render(GraphicsContext gc) {
		for(Entity e : entities) {
			e.render(gc);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
}
