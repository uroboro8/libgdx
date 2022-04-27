package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Dog extends  BaseActor {

    private int speed=1;
    private int direction;

    String[] top = {"dog-up-1.png", "dog-up-2.png", "dog-up-3.png"};;
    String[] left = {"dog-left-1.png", "dog-left-2.png", "dog-left-3.png"};;
    String[] right = {"dog-right-1.png", "dog-right-2.png", "dog-right-3.png"};
    String[] bottom = {"dog-bottom-1.png", "dog-bottom-2.png", "dog-bottom-3.png"};;
    Animation<TextureRegion> anim;

    public Dog(float x, float y, Stage s) {
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

        if(direction == 0) {
            anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(anim);
            this.moveBy(speed,0);
        }

        if(direction == 1) {
            anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,-speed);

        }
        if(direction == 2) {

            anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(anim);
            this.moveBy(-speed,0);

        }

        if(direction == 3) {

            anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,speed);
        }
    }


}
