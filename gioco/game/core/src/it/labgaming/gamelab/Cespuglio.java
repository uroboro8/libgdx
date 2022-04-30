package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Cespuglio extends BaseActor{

    public Cespuglio(float x, float y, Stage s)
    {
        super(x, y, s);
        loadTexture("cespuglio.png");
        setBoundaryPolygon(8);
    }
}
