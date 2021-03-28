package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter {

    private final GameLevel level;
    private final GameView view;
    /**
     * Mousehandler/ use of the mouse in the game.
     * <p>
     * It set's the the level and the game to the world.
     *
     * @param  w describes the levels of the game.
     * @param  v describes the gameview of the game.
     * @return Returns the view  and level to the world.
     */
    public MouseHandler(GameLevel w, GameView v){
        level = w;
        view = v;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        HandGrenade grenade = new HandGrenade (level);
        Point mousePoint = e.getPoint();
        Vec2 worldPoint = view.viewToWorld(mousePoint);
        grenade.setPosition(worldPoint);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
