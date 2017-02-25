package aryan.barbaryan;

import actor.Hamster;
import aryan.barbaryan.entities.EntityVisual;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import actor.Entity;
import core.Game;
import core.World;
import location.Grid;
import location.GridLocation2D;

import java.util.HashSet;
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
		world.addMember(zg2, loc1, true);
		world.addMember(zg3, loc1, true);
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

		batch.begin();

//		batch.draw(jetTexture, 100, 100);
		batch.end();
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
