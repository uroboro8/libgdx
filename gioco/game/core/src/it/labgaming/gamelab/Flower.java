package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Flower extends BaseActor{
    public Flower(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("flower.png");
    }
}
