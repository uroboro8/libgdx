package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Whirlpool extends BaseActor
{
    //Begin 2.1.
    public Whirlpool(float x, float y, Stage s)
    {
        super(x,y,s);

        loadAnimationFromSheet("whirlpool.png", 2, 5, 0.1f, false);
    }

    public void act(float dt)
    {
        super.act(dt);

        if ( isAnimationFinished() )
            remove();
    }
    //End 2.1.
}