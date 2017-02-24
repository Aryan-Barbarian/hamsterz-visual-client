package aryan.barbaryan;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class VisualClient extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture jetTexture;
	private Sprite sprite;

	@Override
	public void create() {
		batch = new SpriteBatch();
		jetTexture = new Texture(Gdx.files.internal("data/jet.png"));
		sprite = new Sprite(jetTexture);
	}

	@Override
	public void dispose() {
		batch.dispose();
		jetTexture.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(jetTexture, 100, 100);
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
