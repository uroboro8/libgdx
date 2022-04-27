package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;


public class House extends BaseActor
{
    public House(float x, float y, Stage s)
    {
        super(x, y, s);
        loadTexture("house.png");
        setBoundaryPolygon(8);
    }
}

