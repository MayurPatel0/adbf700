package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class SoldierController extends KeyAdapter {

    private static final float WALKING_SPEED = 4;
    private final Game game;
    private Soldier soldier;
    /**
     * Controller for the Body(soldier).
     * <p>
     * It help's to control the the soldier.
     *
     * @param  s describes the soldier/body in the game.
     * @param  game describes the game.
     * @return Returns the Game and soldier to the world.
     */
    public SoldierController(Soldier s, Game game){
        this.game = game;
       this.soldier = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            soldier.exit(0);
        } else if (code == KeyEvent.VK_UP) {
            Vec2 v = soldier.getLinearVelocity();
            if (Math.abs(v.y)<0.01f){
                soldier.jump(15);
            }
        }else if (code==KeyEvent.VK_A) {
            soldier.startWalking(-WALKING_SPEED);
        }else if (code==KeyEvent.VK_D){
            soldier.startWalking(+WALKING_SPEED);
        }
        else if (code == KeyEvent.VK_S){
            //System.out.println("Save");
            try {
                GameSaverLoader.save(game.getLevel, "data/save,txt" );
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_L){
            System.out.println("Load");
        }
        else if(code == KeyEvent.VK_SPACE){
            System.out.println("drop bomb");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            soldier.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            soldier.stopWalking();
        }
    }

    public void updateSoldier(Soldier soldier){
        this.soldier = soldier;
    }


}