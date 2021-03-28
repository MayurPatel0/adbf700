package game.levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Game;
import game.GameLevel;
import game.HandGrenade;
import game.Pickup;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Level1  extends GameLevel implements ActionListener {

    private SoundClip gameMusic;
    //private Soldier soldier;
    //private Infiltrator infiltrator;
    private Random rand;
    /**
     * Intro to level1 of the game.
     * <p>
     * It set's the the level and the game to the world.
     *
     * @param  game describes the level1 game.
     * @return Returns the Game and level to the world.
     */
    public Level1(Game game){
        //the base class will create the soldier,infiltrator
        //and the InfiltratorEncounter
        super(game);

        try {
            gameMusic = new SoundClip("data/Background.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //Background of the game.
        Shape shape = new BoxShape(35, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15.0f));

        Shape platform1Shape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 0.5f));

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(8, 3.5f));

        Shape platform4Shape = new BoxShape(3, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform1.setPosition(new Vec2(-5, -3f));

        Shape wallShape = new BoxShape(0.5f, 10f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-18.5f, -6));

        Shape wallShape2 = new BoxShape(0.2f, 10f);
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(17.5f, 9));

        Shape wallShape3 = new BoxShape(0.2f, 0.2f);
        StaticBody wall3 = new StaticBody(this, wallShape);
        wall3.setPosition(new Vec2(17.5f, -20));

        getSoldier().setPosition(new Vec2(-13, -14));
        getInfiltrator().setPosition(new Vec2(0,-14));

        getSoldier().addCollisionListener(new Pickup(getSoldier()));
        getInfiltrator().addCollisionListener(new Pickup(getSoldier()));

        getHandGrenade().addCollisionListener(new Pickup(getSoldier()));
        getHealthKit().addCollisionListener(new Pickup(getSoldier()));


        for (int i = 0; i<1;i++){
            HandGrenade grenade = new HandGrenade(this);
            grenade.setPosition(new Vec2(i*10-5,6));
            //getgrenade.addCollisionListener(new Pickup(soldier));
        }
        Timer t = new Timer (5000,this);
        t.start();

        rand = new Random();

    }

    @Override
    public boolean isComplete() {

         return getSoldier().getGainCount() == 1;

    }

     @Override
    public Image paintBackground() {
         Image background = new ImageIcon("data/Military.png").getImage();
         return background;
     }

    @Override
    public String getLevelName() {
        return "Level1";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HandGrenade h = new HandGrenade(this);
        h.setPosition(new Vec2(rand.nextFloat()*10, 5));
    }
}

