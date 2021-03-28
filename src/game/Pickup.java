package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import javax.swing.*;
import java.awt.*;

public class Pickup implements CollisionListener {

    //private HealthKit kit;
    private final Soldier soldier;
    public Pickup(Soldier s){
        this.soldier = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof HandGrenade && e.getReportingBody() instanceof Soldier) {
            //System.out.println("Picked up");
            this.soldier.decrementLiveCount();
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof HealthKit && e.getReportingBody() instanceof Soldier) {
            this.soldier.incrementGainCount();
            e.getOtherBody().destroy();}}
}


