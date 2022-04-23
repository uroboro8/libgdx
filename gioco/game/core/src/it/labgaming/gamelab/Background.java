package it.labgaming.gamelab;


import com.badlogic.gdx.scenes.scene2d.Stage;


public class Background extends BaseActor {

    public Background(float x, float y, Stage s)
    {
        super(x,y,s);

        String[] filenames = {"background.png"};
        loadTexture("background.png");
    }
}
