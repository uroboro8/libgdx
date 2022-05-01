package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Food extends  BaseActor{

    private boolean collected;

   public static int MEAT = 0;
    public static int CAKE = 1;
    public static int HAMBURGER = 2;
    public static int ORANGE = 3;

    public Food(float x, float y, Stage s,int type) {
        super(x, y, s);

        switch(type){
            case 0:
                loadTexture("meat.png");
                break;
            case 1:
                loadTexture("cake.png");
                break;
            case 2:
                loadTexture("hamburger.png");
                break;
            case 3:
                loadTexture("orange.png");
                break;
            default:
                loadTexture("meat.png");
                break;
        }

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

