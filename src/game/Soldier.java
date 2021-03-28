package game;

import city.cs.engine.*;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

public class Soldier extends Walker {
    private static final Shape studentShape = new PolygonShape(0.27f,2.25f, 2.17f,1.16f, 0.94f,-2.0f, -1.27f,-2.39f, -1.34f,1.7f, -0.4f,2.33f);
    private static final BodyImage image = new BodyImage("data/Soldier.png", 5.0F);
    private int liveCount;
    private int gainCount;
    /**
     * World of Bodies(soldier).
     * <p>
     * It ammends soldier to the game world.
     *
     * @param  world describes the world of the game in which the soldier would be ammended.
     * @return Returns the world with soldier.
     */

    public Soldier(World world) {
        super(world, studentShape);
      this.addImage(image);
       this.liveCount=10;

    }
    public int getLiveCount() {
        return this.liveCount;
    }
// Decrement in live count if one of the grenades are touched.
    public void decrementLiveCount(){
        --this.liveCount;
        System.out.println("WASTED LIFE ="+ this.liveCount);
    }

    public int getGainCount() {
        return this.gainCount;
    }
// Increment in live count if Kit is touched.
    public void incrementGainCount(){
       ++this.gainCount;
        System.out.println("Power=" + this.gainCount);
    }

    public void exit(int i) {
    }

}



