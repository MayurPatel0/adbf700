package game;

import city.cs.engine.World;

import java.awt.*;

public abstract class GameLevel extends World {
    private final Soldier soldier;
    private final Infiltrator infiltrator;
    private final HandGrenade handGrenade;
    private final HealthKit kit;

    /**
     * Gamelevel
     * <p>
     * It dictates what elements are part of game and it's levels.
     *
     * @param  game contains the game class
     * @return game class contains all the necessary bodies inside the Game.
     */
    public GameLevel(Game game){
        //all levels have a soldier,infi
        //and the soldier needs to reach the infi
        //to complete the game (hence a infiEncounter)
        soldier = new Soldier(this);
        handGrenade= new HandGrenade(this);
        kit = new HealthKit(this);
        infiltrator = new Infiltrator(this);
        InfiltratorEncounter encounter = new InfiltratorEncounter(this, game);
        soldier.addCollisionListener(encounter);

    }

    public Soldier getSoldier(){
        return soldier;
    }
    public Infiltrator getInfiltrator(){
        return infiltrator;
    }

    public HandGrenade getHandGrenade(){
        return handGrenade;
    }
    public HealthKit getHealthKit(){
        return kit;
    }

    public abstract boolean isComplete();
    public abstract Image paintBackground();
    public abstract String getLevelName();

}
