package game;

import city.cs.engine.UserView;
import city.cs.engine.World;


import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;
    public Image back;
    public GameLevel l;
    /**
     * A world in which a game can be viewed.
     * <p>
     * It get's the gameview.
     *
     * @param  l describes the game level.
     * @param  width of the View.
     * @param  height of the view.
     * @return Returns the view of the game.
     */

    public GameView(GameLevel l, int width, int height) {
        super(l, width, height);
        this.l = l;
        //background = new ImageIcon("data/Military.png").getImage();
    }
    /**
     * Background of the game.
     * <p>
     * It set's the background between different levels.
     *
     * @param  background describes the background of the image.
     * @return Set's the background of the game.
     */
    public void setBack(Image background) {
        this.back= background;

    }
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(back, 3, 3, this);
    }

    @Override
    protected void paintForeground(Graphics2D g){
        g.setColor(Color.YELLOW);
        g.drawString("Healthified: " +l.getSoldier().getGainCount() ,30,30);
        g.drawString("Killings: " +l.getSoldier().getLiveCount(),30,60);
    }}


