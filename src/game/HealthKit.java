package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class HealthKit extends DynamicBody {
    //private static final Shape grenadeShape = new PolygonShape(0.95f,2.3f, 1.91f,-1.08f, 0.38f,-2.16f, -1.21f,-2.22f, -1.93f,-0.71f, -1.58f,0.93f, -0.94f,2.25f, 0.9f,2.32f);
    /**
     * Setting the size of the body.
     */
    private static final Shape kitShape = new CircleShape(2);
    /**
     * Sound of the music, when it collides.
     */
    private static SoundClip kitSound;

    //sound played during kit,soldier collision
    static {
        try {
            kitSound = new SoundClip("data/kit.wav");
            System.out.println("Loading kit sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * Setting the image of the health kit.
     */
    private static final BodyImage image =
            new BodyImage("data/Kit.gif", 2f);
    /**
     * Bodies(Healthkit) are situated.
     * <p>
     * It ammends healthkits to the game world.
     *
     * @param  w describes the healthkit to be used in the world.
     * @return Returns the Healthkit to the world.
     */
    public HealthKit(World w) {
        super(w,kitShape);
        addImage(image);

    }

    @Override
    public void destroy()
    {
        kitSound.play();
        super.destroy();
    }
}
