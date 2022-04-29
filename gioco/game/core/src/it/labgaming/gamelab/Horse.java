package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Horse extends BaseActor{

    private int speed=1;
    private int direction;

    String[] top = {"horse-up-1.png", "horse-up-2.png", "horse-up-3.png"};;
    String[] left = {"horse-left-1.png", "horse-left-2.png", "horse-left-3.png"};;
    String[] right = {"horse-right-1.png", "horse-right-2.png", "horse-right-3.png"};
    String[] bottom = {"horse-bottom-1.png", "horse-bottom-2.png", "horse-bottom-3.png"};;
    Animation<TextureRegion> anim;

    public Horse(float x, float y, Stage s) {
        super(x, y, s);

        loadAnimationFromFiles(bottom, 0.1f, true);
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

        if(direction == Horse.RIGHT) {
            anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(anim);
            this.moveBy(speed,0);
        }

        if(direction == Horse.BOTTOM) {
            anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,-speed);

        }
        if(direction == Horse.LEFT) {
            anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(anim);
            this.moveBy(-speed,0);

        }

        if(direction == Horse.TOP) {
            anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,speed);
        }
    }
}
