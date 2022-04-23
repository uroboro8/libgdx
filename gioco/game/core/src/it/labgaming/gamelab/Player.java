//3.
//3.1.
package it.labgaming.gamelab;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Player extends BaseActor
{
    public static int IDLE=0;
    public static int LEFT=1;
    public static int TOP=2;
    public static int RIGHT=3;
    public static int BOTTOM=4;

    private int direction=0;
    private int speed=3;

    public Player(float x, float y, Stage s)
    {
        super(x,y,s);

        /*String[] filenames =
                {"turtle-1.png", "turtle-2.png", "turtle-3.png",
                        "turtle-4.png", "turtle-5.png", "turtle-6.png"}; */

        String[] filenames = {"a1.png","a2.png","a3.png"};

        loadAnimationFromFiles(filenames, 0.1f, true);
        //End 2.0.



        setDirection(Player.IDLE);

        setAcceleration(400);
        setMaxSpeed(200);
        setDeceleration(200);
    }


    public void setDirection(int d)
    {
        direction=d;
    }

    public void act(float dt)
    {
        super.act(dt);

        if(direction== Player.LEFT)
        {
            this.moveBy(-speed, 0);
            //setDirection(Turtle.IDLE);
            String[] filenames = {"a1-left.png","a2-left.png","a3-left.png"};
            Animation<TextureRegion> anim = loadAnimationFromFiles(filenames,0.1f,true);
            setAnimation(anim);
        }
        else if(direction== Player.TOP)
        {
            this.moveBy(0, speed);
            //setDirection(Turtle.IDLE);
            String[] filenames = {"a1-up.png","a2-up.png","a3-up.png"};
            Animation<TextureRegion> anim = loadAnimationFromFiles(filenames,0.1f,true);
            setAnimation(anim);
        }
        else if(direction== Player.RIGHT)
        {
            this.moveBy(speed, 0);
            //setDirection(Turtle.IDLE);
            String[] filenames = {"a1.png","a2.png","a3.png"};
            Animation<TextureRegion> anim = loadAnimationFromFiles(filenames,0.1f,true);
            setAnimation(anim);
        }
        else if(direction== Player.BOTTOM)
        {
            this.moveBy(0, -speed);
            String[] filenames = {"a1-down.png","a2-down.png","a3-down.png"};
            Animation<TextureRegion> anim = loadAnimationFromFiles(filenames,0.1f,true);
            setAnimation(anim);
            //setDirection(Turtle.IDLE);
        }
/*
        if(direction==Turtle.LEFT) {
           accelerateAtAngle(180);
            //accelerateAtAngle(90);
           /* String[] filenames = {"a1-left.png","a2-left.png","a3-left.png"};
            Animation<TextureRegion> anim = loadAnimationFromFiles(filenames,0.1f,true);
            setAnimation(anim); */
  /*      }
        else if(direction==Turtle.TOP)
            accelerateAtAngle(90);
        else if(direction==Turtle.RIGHT) {
            accelerateAtAngle(0);
        }
        else if(direction==Turtle.BOTTOM)
            accelerateAtAngle(270);

        applyPhysics(dt);

        setAnimationPaused( !isMoving() );

        if ( getSpeed() > 0 )
            setRotation( getMotionAngle() );

        */
    }
}