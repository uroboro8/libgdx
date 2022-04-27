package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Food extends  BaseActor{

    private boolean collected;

    public Food(float x, float y, Stage s) {
        super(x, y, s);

        loadTexture("food.png");

        setBoundaryPolygon(8);

        collected = false;

    }

    public boolean isCollected()
    {
        return collected;
    }

    public void collect()
    {
        collected = true;
        clearActions();
        addAction( Actions.fadeOut(1) );
        addAction( Actions.after( Actions.removeActor() ) );
    }

}

