package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bear extends  BaseActor {

    private int speed=5;
    private int direction;

    String[] top = {"bear-up-1.png", "bear-up-2.png", "bear-up-3.png"};;
    String[] left = {"bear-left-1.png", "bear-left-2.png", "bear-left-3.png"};;
    String[] right = {"bear-right-1.png", "bear-right-2.png", "bear-right-3.png"};
    String[] bottom = {"bear-bottom-1.png", "bear-bottom-2.png", "bear-bottom-3.png"};;
    Animation<TextureRegion> anim;

    public Bear(float x, float y, Stage s) {
        super(x, y, s);

        loadAnimationFromFiles(bottom, 0.1f, true);
        setBoundaryPolygon(8);
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

        if(direction == Bear.RIGHT) {
            anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(anim);
            this.moveBy(speed,0);
        }
        if(direction == Bear.BOTTOM) {
            anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,-speed);

        }
        if(direction == Bear.LEFT) {
            anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(anim);
            this.moveBy(-speed,0);

        }
        if(direction == Bear.TOP) {
            anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,speed);
        }
    }
}
