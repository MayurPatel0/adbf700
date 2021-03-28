package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiveFocus implements MouseListener {
    /**
     * View of the Game.
     */
    private final GameView view;
    /**
     * Focuses on the view of the game.
     * <p>
     * To use it has listener to mouse/keyboard.
     *
     * @param  v description of the view of the game.
     * @return the view of the game.
     */
    public GiveFocus(GameView v){
        this.view = v;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
