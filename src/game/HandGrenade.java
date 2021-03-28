package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class HandGrenade extends DynamicBody {

    /**
     * Setting the size of the body.
     */
    private static final Shape grenadeShape = new CircleShape(2);

    /**
     * Sound of the music, when it collides.
     */
    private static SoundClip ExplosionSound;

//sound played during grenade, soldier collision
    static {
        try {
            ExplosionSound = new SoundClip("data/Explosion.wav");
            System.out.println("Loading grenade sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Setting the image of the hand grenade.
     */
    private static final BodyImage image =
            new BodyImage("data/Grenade.png", 2f);
    /**
     * Bodies(Handgrenade) are situated.
     * <p>
     * It ammends handgrenades to the game world.
     *
     * @param  w describes the handgrenade to be used in the world.
     * @return Returns the Handgrenade to the world.
     */
    public HandGrenade(World w) {
        super(w,grenadeShape);
        addImage(image);

    }
    @Override
    public void destroy()
    {
        ExplosionSound.play();
        super.destroy();
    }
}

