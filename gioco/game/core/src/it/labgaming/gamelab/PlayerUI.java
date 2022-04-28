package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class PlayerUI extends  BaseActor{

    public PlayerUI(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("ui-player.png");
    }
}
