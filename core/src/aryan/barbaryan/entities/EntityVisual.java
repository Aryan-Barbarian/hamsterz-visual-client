package aryan.barbaryan.entities;

import actor.Entity;
import aryan.barbaryan.TextureHelper;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Aryan on 2/23/2017.
 */
public class EntityVisual implements Comparable {
    private Entity entity;
    private Texture texture;
    public int priority;

    public EntityVisual(Entity entity) {
        this.entity = entity;
    }

    public Texture genTexture() {
        return TextureHelper.getGeneralTexture(this.entity.getName());
    }

    public Texture getTexture() {
        if (this.texture == null)
            this.texture = this.genTexture();
        return this.texture;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof EntityVisual) {
            return (this.priority - ((EntityVisual) o).priority);
        }
        System.err.println("Compared entity visual to something that's not an entity visual!");
        return 0;
    }
}
