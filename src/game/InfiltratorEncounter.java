package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class InfiltratorEncounter implements CollisionListener {
    /**
     * Game level called.
     */
    private final GameLevel level;
    /**
     * game class called.
     */
    private final Game game;
    /**
     * Collision between two dynamic bodies
     * <p>
     * It set's the the level and the game to the world.
     *
     * @param  level describes the levels of the game.
     * @param  game describes the game.
     * @return Returns the Game and level to the world.
     */
    public InfiltratorEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if soldier collided with infiltrator and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Infiltrator
                && level.isComplete()){
            e.getOtherBody().destroy();
            game.goToNextLevel();
        }
    }
}
