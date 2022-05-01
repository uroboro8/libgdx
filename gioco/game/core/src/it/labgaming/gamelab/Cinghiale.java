package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Cinghiale extends  BaseActor {

    private int speed=4;
    private int direction;

    private int count;

    String[] top = {"cinghiale-top-1.png", "cinghiale-top-2.png", "cinghiale-top-3.png"};;
    String[] left = {"cinghiale-left-1.png", "cinghiale-left-2.png", "cinghiale-left-3.png"};;
    String[] right = {"cinghiale-right-1.png", "cinghiale-right-2.png", "cinghiale-right-3.png"};
    String[] bottom = {"cinghiale-bottom-1.png", "cinghiale-bottom-2.png", "cinghiale-bottom-3.png"};;

    Animation<TextureRegion> animTop;
    Animation<TextureRegion> animLeft;
    Animation<TextureRegion> animRight;
    Animation<TextureRegion> animBottom;

    public Cinghiale(float x, float y, Stage s,int count) {
        super(x, y, s);
        this.count = count;

        animTop =  loadAnimationFromFiles(top, 0.1f, true);
        animBottom =  loadAnimationFromFiles(bottom, 0.1f, true);
        animRight =  loadAnimationFromFiles(right, 0.1f, true);
        animLeft =  loadAnimationFromFiles(left, 0.1f, true);

        setAnimation(animRight);
        setBoundaryPolygon(8);
        this.setDirection(0);
    }

    public int getCount(){
        return this.count;
    }

    public void setDirection(int d)
    {
        this.direction=d;
    }

    public int getDirection()
    {
        return this.direction;
    }

    public void act(float dt) {
        super.act(dt);

        if(direction == Cinghiale.RIGHT) {
            //anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(animRight);
            this.moveBy(speed,0);
        }
        if(direction == Cinghiale.BOTTOM) {
            //anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(animBottom);
            this.moveBy(0,-speed);

        }
        if(direction == Cinghiale.LEFT) {
            //anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(animLeft);
            this.moveBy(-speed,0);

        }
        if(direction == Cinghiale.TOP) {
            //anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(animTop);
            this.moveBy(0,speed);
        }
    }


    public void setSquarePath(float offSetX1,float offSetX2,float offSetY){
        if(this.getX() >= this.getSpawnX() + offSetX1 && this.getY() == this.getSpawnY()) {
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Cinghiale.BOTTOM);
        }
        else if(this.getX() == this.getWaypointX() && this.getY() <= this.getWaypointY() - offSetY){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Cinghiale.LEFT);
        }
        else if(this.getX() <= this.getWaypointX() - offSetX2 && this.getY() == this.getWaypointY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Cinghiale.TOP);
        }
        else if( this.getY() >= this.getSpawnY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Cinghiale.RIGHT);
        }
    }

    public void setXPath(float OffSetX){
        if(this.getX() >= this.getSpawnX() + OffSetX && this.getY() == this.getSpawnY())
            this.setDirection(Cinghiale.LEFT);
        else if(this.getX() <= this.getSpawnX() && this.getY() == this.getSpawnY())
            this.setDirection(Cinghiale.RIGHT);
    }
}
