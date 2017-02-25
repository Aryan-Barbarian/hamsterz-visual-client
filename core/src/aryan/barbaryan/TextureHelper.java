package aryan.barbaryan;

import actor.Entity;
import location.Direction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aryan on 2/23/2017.
 */
public class TextureHelper {

    public static Map<String, Texture> textureCache = new HashMap<String, Texture>();

//    public TextureHelper() {
//        textureCache = new HashMap<String, Texture>();
//    }


    public static Texture getTexture(String textureKey) {
        Texture ans = null;
        if (!textureCache.containsKey(textureKey)) {
            // entityType.png
            ans = new Texture(Gdx.files.internal(textureKey + ".png"));
            textureCache.put(textureKey, ans);
        } else {
            ans = textureCache.get(textureKey);
        }
        return ans;
    }

    public static Texture getGeneralTexture(String entityType) {
        return getTexture(entityType);
    }

    public static Texture getDirectedTexture(String entityType, Direction direction) {
        String dirString = "up";
        switch (direction) {
            case EAST:
                dirString = "right";
                break;
            case WEST:
                dirString = "left";
                break;
            case SOUTH:
                dirString = "down";
                break;
        }
        String textureKey = entityType + "-" + dirString;
        return getTexture(textureKey);
    }

    public static void dispose() {
        for (Texture tex : textureCache.values())
            tex.dispose();
    }
}
