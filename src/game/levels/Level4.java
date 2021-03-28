package game.levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.*;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.*;
import java.awt.*;
import java.awt.print.Book;
import java.io.IOException;

public class Level4  extends GameLevel {
    private SoundClip gameMusic;

    /**
     * Intro to level4 of the game.
     * <p>
     * It set's the the level and the game to the world.
     *
     * @param  game describes the level4 game.
     * @return Returns the Game and level4 to the world.
     */
    public Level4(Game game){
        //the base class will create the soldier, infiltrator
        //and the infiltratorEncounter
        super(game);

        try {
            gameMusic = new SoundClip("data/B4.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //we still need to set the positions of the soldier
        //and infiltrator
        getSoldier().setPosition(new Vec2(-13, -14));
        getInfiltrator().setPosition(new Vec2(14,-14));

        //we're setting up Pickup here though we could
        //also add it to the GameLevel class
        getSoldier().addCollisionListener(new Pickup(getSoldier()));
        getInfiltrator().addCollisionListener(new Pickup(getSoldier()));
        getHandGrenade().addCollisionListener(new Pickup(getSoldier()));
        getHealthKit().addCollisionListener(new Pickup(getSoldier()));

        // make the ground
        Shape shape = new BoxShape(35, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15f));

        //make the platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-12, 0.3f));

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(8, 3.5f));

        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-3, 5.5f));

        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));

        //make some kits
        HealthKit kit = new HealthKit(this);
        kit.setPosition(new Vec2(8,4));

        HealthKit kit2 = new HealthKit(this);
        kit2.setPosition(new Vec2(-3,6));

        //create some pickups (books)
        for (int i=0; i<3; i++){
            Body grenade = new HandGrenade(this);
            grenade.setPosition(new Vec2(-5+i*2f,0));
        }


    }
    @Override
    public boolean isComplete() {
        return getSoldier().getGainCount() == 2;
    }

    @Override
    public Image paintBackground() {
        Image background = new ImageIcon("data/WAR4.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level4";
    }
}