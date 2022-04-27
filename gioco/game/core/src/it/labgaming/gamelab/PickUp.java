package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class PickUp extends BaseActor
{
    public PickUp(float x, float y, Stage s)
    {
        super(x,y,s);

        loadAnimationFromSheet("collect.png", 4, 5, 0.1f, false);
    }

    public void act(float dt)
    {
        super.act(dt);

        if ( isAnimationFinished() )
            remove();
    }
}