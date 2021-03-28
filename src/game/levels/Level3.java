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

public class Level3  extends GameLevel {
    private SoundClip gameMusic;

    /**
     * Intro to level3 of the game.
     * <p>
     * It set's the the level and the game to the world.
     *
     * @param  game describes the level3 game.
     * @return Returns the Game and level3 to the world.
     */
    public Level3(Game game){
        //the base class will create the soldier, infiltrator
        //and the infiltratorEncounter
        super(game);

        try {
            gameMusic = new SoundClip("data/B3.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
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
        ground.setFillColor(Color.YELLOW);

        //make the platform
        Shape platform1Shape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 0.5f));

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(8, 3.5f));

        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));

        HealthKit kit = new HealthKit(this);
        kit.setPosition(new Vec2(8,4));

        HealthKit kit2 = new HealthKit(this);
        kit2.setPosition(new Vec2(-9,1));

        //create some pickups (GRENADE)
        for (int i=0; i<3; i++){
            Body grenade = new HandGrenade(this);
            grenade.setPosition(new Vec2(-5+i*2f,0));
        }
    }
    @Override
    public boolean isComplete() {
        return getSoldier().getGainCount() == 3;
    }

    @Override
    public Image paintBackground() {
        Image background = new ImageIcon("data/WAR3.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }
}