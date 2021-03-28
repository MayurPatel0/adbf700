package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Infiltrator extends Walker {
    private static final Shape studentShape = new PolygonShape(
            0.83f,2.12f, 1.63f,-0.35f, 1.2f,-2.21f, -1.24f,-2.13f, -1.41f,1.42f, -0.57f,2.27f);
    /**
     * Setting the image and height of the infiltrator(body).
     */
    private static final BodyImage image =
            new BodyImage("data/Infiltrator.png", 5f);
    /**
     * Sound of the music, when it collides.
     */
    private static SoundClip infiSound;
    static {
        try {
            infiSound = new SoundClip("data/Kill.wav");
            System.out.println("Loading Enemy sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * Bodies(Infiltrator) are situated.
     * <p>
     * It ammends infiltrator to the game world.
     *
     * @param  world describes the infiltrator to be used in the world.
     * @return Returns the infiltrator to the world.
     */
    public Infiltrator(World world) {
        super(world, studentShape);
        addImage(image);}

    @Override
    public void destroy()
    {
        infiSound.play();
        super.destroy();
    }
}





