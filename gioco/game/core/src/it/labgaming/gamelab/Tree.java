package it.labgaming.gamelab;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Tree extends BaseActor{

    public Tree(float x, float y, Stage s)
    {
        super(x, y, s);
        loadTexture("tree.png");
       /* Action spin = Actions.rotateBy(30, 1);
        this.addAction( Actions.forever(spin) );*/
    }
}
