//3.
//3.1.
package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Player extends BaseActor
{


    private int direction=0;
    private int prevDirection = 0;
    private int speed=3;

    String[] top = {"a1-up.png","a2-up.png","a3-up.png"};
    String[] left = {"a1-left.png","a2-left.png","a3-left.png"};
    String[] right = {"a1.png","a2.png","a3.png"};
    String[] bottom = {"a1-down.png","a2-down.png","a3-down.png"};
    Animation<TextureRegion> anim;

    public Player(float x, float y, Stage s)
    {
        super(x,y,s);

        //String[] filenames = {"a1.png","a2.png","a3.png"};
        String[] filenames = {"a1-down.png","a2-down.png","a3-down.png"};
        loadAnimationFromFiles(filenames, 0.1f, true);

        setDirection(Player.IDLE);
        setBoundaryPolygon(8);
    }

    public int getDirection(){
        return this.direction;
    }

    public void setDirection(int d)
    {
        direction=d;
    }

    public int getPrevDirection() {
        return prevDirection;
    }

    public void setPrevDirection(int prevDirection) {
        this.prevDirection = prevDirection;
    }

    public void act(float dt)
    {
        super.act(dt);

        if(direction== Player.LEFT)
        {
            this.moveBy(-speed, 0);
            anim = loadAnimationFromFiles(left,0.1f,true);
            setAnimation(anim);
        }
        else if(direction== Player.TOP)
        {
            this.moveBy(0, speed);
            anim = loadAnimationFromFiles(top,0.1f,true);
            setAnimation(anim);
        }
        else if(direction== Player.RIGHT)
        {
            this.moveBy(speed, 0);
        anim = loadAnimationFromFiles(right,0.1f,true);
            setAnimation(anim);
        }
        else if(direction== Player.BOTTOM)
        {
            this.moveBy(0, -speed);
            anim = loadAnimationFromFiles(bottom,0.1f,true);
            setAnimation(anim);

        }
        boundToWorld();
        alignCamera();
    }

    public void hit(Action moveBy){
        this.setAnimationPaused(true);
        this.clearActions();
        this.addAction(moveBy);
        //this.setAnimationPaused(false);
    }


}