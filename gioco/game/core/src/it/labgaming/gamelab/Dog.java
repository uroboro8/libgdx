package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Dog extends  BaseActor {

    private int speed=5;
    private int direction;

    String[] top = {"dog-up-1.png", "dog-up-2.png", "dog-up-3.png"};;
    String[] left = {"dog-left-1.png", "dog-left-2.png", "dog-left-3.png"};;
    String[] right = {"dog-right-1.png", "dog-right-2.png", "dog-right-3.png"};
    String[] bottom = {"dog-bottom-1.png", "dog-bottom-2.png", "dog-bottom-3.png"};;

    Animation<TextureRegion> animTop;
    Animation<TextureRegion> animLeft;
    Animation<TextureRegion> animRight;
    Animation<TextureRegion> animBottom;

    public Dog(float x, float y, Stage s) {
        super(x, y, s);

        animTop =  loadAnimationFromFiles(top, 0.1f, true);
        animBottom =  loadAnimationFromFiles(bottom, 0.1f, true);
        animRight =  loadAnimationFromFiles(right, 0.1f, true);
        animLeft =  loadAnimationFromFiles(left, 0.1f, true);

        setAnimation(animRight);

        this.setDirection(0);
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

        if(direction == Dog.RIGHT) {
            //anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(animRight);
            this.moveBy(speed,0);
        }

        if(direction == Dog.BOTTOM) {
           //anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(animBottom);
            this.moveBy(0,-speed);

        }
        if(direction == Dog.LEFT) {
            //anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(animLeft);
            this.moveBy(-speed,0);

        }

        if(direction == Dog.TOP) {
            //anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(animTop);
            this.moveBy(0,speed);
        }
    }

    public void setSquarePath(float offSetX1,float offSetX2,float offSetY){
        if(this.getX() >= this.getSpawnX() + offSetX1 && this.getY() == this.getSpawnY()) {
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Dog.BOTTOM);
        }
        else if(this.getX() == this.getWaypointX() && this.getY() <= this.getWaypointY() - offSetY){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Dog.LEFT);
        }
        else if(this.getX() <= this.getWaypointX() - offSetX2 && this.getY() == this.getWaypointY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Dog.TOP);
        }
        else if( this.getY() >= this.getSpawnY()){
            this.setWaypoint(this.getX(),this.getY());
            this.setDirection(Dog.RIGHT);
        }
    }

}
