package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Cinghiale extends  BaseActor {

    private int speed=5;
    private int direction;

    String[] top = {"cinghiale-top-1.png", "cinghiale-top-2.png", "cinghiale-top-3.png"};;
    String[] left = {"cinghiale-left-1.png", "cinghiale-left-2.png", "cinghiale-left-3.png"};;
    String[] right = {"cinghiale-right-1.png", "cinghiale-right-2.png", "cinghiale-right-3.png"};
    String[] bottom = {"cinghiale-bottom-1.png", "cinghiale-bottom-2.png", "cinghiale-bottom-3.png"};;
    Animation<TextureRegion> anim;

    public Cinghiale(float x, float y, Stage s) {
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

        if(direction == Cinghiale.RIGHT) {
            anim = loadAnimationFromFiles(right, 0.1f, true);
            setAnimation(anim);
            this.moveBy(speed,0);
        }
        if(direction == Cinghiale.BOTTOM) {
            anim = loadAnimationFromFiles(bottom, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,-speed);

        }
        if(direction == Cinghiale.LEFT) {
            anim = loadAnimationFromFiles(left, 0.1f, true);
            setAnimation(anim);
            this.moveBy(-speed,0);

        }
        if(direction == Cinghiale.TOP) {
            anim = loadAnimationFromFiles(top, 0.1f, true);
            setAnimation(anim);
            this.moveBy(0,speed);
        }
    }

}
