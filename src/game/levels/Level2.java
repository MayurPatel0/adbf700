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

public class Level2  extends GameLevel {
    private SoundClip gameMusic2;

    /**
     * Intro to level2 of the game.
     * <p>
     * It set's the the level and the game to the world.
     *
     * @param  game describes the level2 game.
     * @return Returns the Game and level 2to the world.
     */
    public Level2(Game game){
        //the base class will create the soldier, infiltrator
        //and the infiltratorEncounter
        super(game);

        try {
            gameMusic2 = new SoundClip("data/B2.wav");   // Open an audio input stream
            gameMusic2.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //we still need to set the positions of the soldier
        //and infiltrator
        getSoldier().setPosition(new Vec2(-13, -14));
        getInfiltrator().setPosition(new Vec2(4,-14));

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

        //platform

        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));
        wall1.setFillColor(Color.CYAN);

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));
        wall2.setFillColor(Color.GREEN);

        HealthKit kit = new HealthKit(this);
        kit.setPosition(new Vec2(8,7));

        //create some pickups (GRENADE)
        for (int i=0; i<2; i++){
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
        Image background = new ImageIcon("data/WAR2.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level2";
    }
}
