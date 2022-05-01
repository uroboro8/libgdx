package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bear extends  BaseActor {

    private int speed=3;
    private int direction;

    private int count;

    String[] top = {"bear-up-1.png", "bear-up-2.png", "bear-up-3.png"};;
    String[] left = {"bear-left-1.png", "bear-left-2.png", "bear-left-3.png"};;
    String[] right = {"bear-right-1.png", "bear-right-2.png", "bear-right-3.png"};
    String[] bottom = {"bear-bottom-1.png", "bear-bottom-2.png", "bear-bottom-3.png"};;

    Animation<TextureRegion> animTop;
    Animation<TextureRegion> animLeft;
    Animation<TextureRegion> animRight;
    Animation<TextureRegion> animBottom;


    public Bear(float x, float y, Stage s,int count) {
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

        if(direction == Bear.RIGHT) {
            //anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(animRight);
            this.moveBy(speed,0);
        }
        if(direction == Bear.BOTTOM) {
            //anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(animBottom);
            this.moveBy(0,-speed);

        }
        if(direction == Bear.LEFT) {
            //anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(animLeft);
            this.moveBy(-speed,0);

        }
        if(direction == Bear.TOP) {
            //anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(animTop);
            this.moveBy(0,speed);
        }
    }

    public void setSquarePath(float offSetX1,float offSetX2,float offSetY){
        if(this.getX() >= this.getSpawnX() + offSetX1 && this.getY() == this.getSpawnY()) {
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Bear.BOTTOM);
        }
        else if(this.getX() == this.getWaypointX() && this.getY() <= this.getWaypointY() - offSetY){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Bear.LEFT);
        }
        else if(this.getX() <= this.getWaypointX() - offSetX2 && this.getY() == this.getWaypointY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Bear.TOP);
        }
        else if( this.getY() >= this.getSpawnY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Bear.RIGHT);
        }
    }

    public void setXPath(float OffSetX){
        if(this.getX() >= this.getSpawnX() + OffSetX && this.getY() == this.getSpawnY())
            this.setDirection(Bear.LEFT);
        else if(this.getX() <= this.getSpawnX() && this.getY() == this.getSpawnY())
            this.setDirection(Bear.RIGHT);
    }
    public void setYPath(float OffSetY){
        if(this.getY() >= this.getSpawnY() )
            this.setDirection(Bear.BOTTOM);
        else if(this.getY() <= this.getSpawnY() - OffSetY)
            this.setDirection(Bear.TOP);
    }
}
