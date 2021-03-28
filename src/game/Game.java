/**
 * @author  Mayur, patel , mayur.patel.3@city.ac.uk
 * @version Version1.0
 * @since march 2021
 */




package game;
import java.awt.*;
import java.util.logging.Level;

import city.cs.engine.SoundClip;
import game.levels.*;

import javax.swing.JFrame;

//
 // A world with some bodies.
 //
public class Game {

    public GameLevel getLevel;
    //public GameLevel getLevel;
    // The World in which the bodies move and interact.
    private GameLevel level;

    // A graphical display of the world (a specialised JPanel)
    private final GameView view;

    private final SoldierController controller;

    //private HandGrenade handGrenade;

    public SoundClip gameMusic;

    // Initialise a new Game.
    public Game() {


        // initialize level to Level1
        level = new Level1(this);

        view = new GameView(level, 800, 600);
        view.setZoom(20);
        view.setBack(level.paintBackground());

        //view.addMouseListener(new MouseHandler(level, view));

        controller = new SoldierController(level.getSoldier(), this);
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        final JFrame frame = new JFrame("WAR");
        frame.add(view);

        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);

        frame.pack();

        frame.setVisible(true);

        frame.addKeyListener(new SoldierController(level.getSoldier(), this));

       // JFrame debugView = new DebugViewer(level, 600, 600);

        level.start();

    }
    public GameLevel getLevel(){return level;}
    public GameView getView(){return view; }


    public void setLevel(GameLevel level){
        this.level.stop();
        this.level = level;
        view.setWorld(this.level);
        this.level.start();
    }
    /**
     * Going from one level to next level.
     */
    public void goToNextLevel(){

        if (level instanceof Level1){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level2) {
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
            //System.out.println("Well done! Game complete.");
            //System.exit(0);
        }
        else if (level instanceof Level3) {
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level4) {
            //System.out.println("Well done! Game complete.");
            //System.exit(0);
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
    }
        else if (level instanceof Level5) {
            System.out.println("Well done! Game complete.");
            System.exit(0);
    }}
//Pause Button
    /**
     * Pausing the game.
     */
    public void pause(){
        level.stop();
        gameMusic.pause();
    }
//Resume Button
    /**
     * Resuming the game.
     */
    public void resume(){
        level.start();
        //gameMusic.resume();
    }
//Restart Button
    /**
     * Restarting the game.
     */
    public void restart() {
        if (level instanceof Level1) {
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            //view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
        } else if (level instanceof Level2) {
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
        } else if (level instanceof Level3) {
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
        } else if (level instanceof Level4) {
            //System.out.println("Well done! Game complete.");
            //System.exit(0);
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            //change the controller to control the
            //student in the new world
            view.setBack(level.paintBackground());
            controller.updateSoldier(level.getSoldier());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level5) {
            System.out.println("Well done! Game complete.");
            System.exit(0);

    }}  public void startLevel1() { }
    public void startLevel2() { }
    public void startLevel3() {
    }
    public void startLevel4() {
    }
    public void startLevel5() {
    }

        public static void main (String[]args){

            new Game();
        }



}