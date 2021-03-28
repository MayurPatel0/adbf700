package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private final GameView view;
    private final Soldier soldier;
    public Tracker(GameView view, Soldier soldier) {
        this.view = view;
        this.soldier = soldier;
    }
    /**
     * It acts as Tracker for the game.
     * <p>
     * It set's the the level and the game to the world.
     *
     * @param  e describes the event method for the game.
     * @return Returns the view of the game tracking the bodies.
     */
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(soldier.getPosition().add(new Vec2(0,8)));
    }
}