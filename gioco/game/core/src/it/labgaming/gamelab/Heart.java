package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Heart extends  BaseActor{

    public Heart(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("heart.png");
    }

    public void removeHeart()
    {
        clearActions();
        addAction( Actions.after( Actions.removeActor() ) );
    }

}