package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Cat extends BaseActor {

    private int speed=2;
    private int direction;

    String[] top = {"cat-up-1.png", "cat-up-2.png", "cat-up-3.png"};;
    String[] left = {"cat-left-1.png", "cat-left-2.png", "cat-left-3.png"};;
    String[] right = {"cat-right-1.png", "cat-right-2.png", "cat-right-3.png"};
    String[] bottom = {"cat-bottom-1.png", "cat-bottom-2.png", "cat-bottom-3.png"};;

    Animation<TextureRegion> animTop;
    Animation<TextureRegion> animLeft;
    Animation<TextureRegion> animRight;
    Animation<TextureRegion> animBottom;

    public Cat(float x, float y, Stage s) {
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

        if(direction == Cat.RIGHT) {
            //anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(animRight);
            this.moveBy(speed,0);
        }

        if(direction == Cat.BOTTOM) {
            //anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(animBottom);
            this.moveBy(0,-speed);

        }
        if(direction == Cat.LEFT) {
            //anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(animLeft);
            this.moveBy(-speed,0);

        }

        if(direction == Cat.TOP) {
            //anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(animTop);
            this.moveBy(0,speed);
        }
    }

    public void setXPath(float OffSetX){
        if(this.getX() >= this.getSpawnX() + OffSetX && this.getY() == this.getSpawnY())
            this.setDirection(Cat.LEFT);
        else if(this.getX() <= this.getSpawnX() && this.getY() == this.getSpawnY())
            this.setDirection(Cat.RIGHT);
    }
}