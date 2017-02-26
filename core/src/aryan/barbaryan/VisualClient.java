package aryan.barbaryan;

import actor.Actor;
import actor.Hamster;

import aryan.barbaryan.entities.EntityVisual;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import actor.Entity;
import core.World;
import location.Grid;
import location.GridLocation2D;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class VisualClient extends ApplicationAdapter {
	private SpriteBatch batch;
	private Set<Entity> entitiesAdded;
	private PriorityQueue<EntityVisual> drawQueue;
	private World world;


	@Override
	public void create() {
		batch = new SpriteBatch();
		drawQueue = new PriorityQueue<EntityVisual>();
		entitiesAdded = new HashSet<Entity>();

		Grid<GridLocation2D> grid = new Grid<GridLocation2D>();
		world = new World(grid);

		Hamster zg1 = new Hamster(world, grid);
		Hamster zg2 = new Hamster(world, grid);
		Hamster zg3 = new Hamster(world, grid);
		// TODO: Fix this nonesense with the different locations
		GridLocation2D loc1 = GridLocation2D.getLocation(5, 5);
		GridLocation2D loc2 = GridLocation2D.getLocation(3, 5);
		GridLocation2D loc3 = GridLocation2D.getLocation(3, 7);

		world.addMember(zg1, loc1, true); // TODO: shouldn't have to deal with canMove
		world.addMember(zg2, loc2, true);
		world.addMember(zg3, loc3, true);
	}

	@Override
	public void dispose() {
		batch.dispose();
		TextureHelper.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		// Update world
		world.turn();

		// Get new actors (if any)
		Map<Actor, GridLocation2D> actorToLoc = world.getDisplayInfoByMember();
		for (Actor actor : actorToLoc.keySet()) {
			if (this.entitiesAdded.contains(actor)) {
				// DO nothing
			} else {
//				GridLocation2D actorLoc = actorToLoc.get(actor); // TODO: Is this info wasted?
				// TODO: Add isntance variable in visual so we can have it cache the location now and not have to look it up again later
				EntityVisual vis = castToEntityVisual(actor);
				drawQueue.add(vis);

			}
		}

		// Actually draw them
		batch.begin();

		for (EntityVisual vis : this.drawQueue) {
			GridLocation2D currLoc = vis.getLocation();
			// TODO: make a better drawing method
			int tileSize = 15; // pixels
			int rX = currLoc.x * tileSize;
			int rY = currLoc.y * tileSize;
			batch.draw(vis.getTexture(), rX, rY);
		}
//		batch.draw(jetTexture, 100, 100);
		batch.end();
	}

	public EntityVisual castToEntityVisual(Entity rawEntity) {
		// TODO: Priority
		return new EntityVisual(rawEntity);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
