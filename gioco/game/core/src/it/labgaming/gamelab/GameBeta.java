package it.labgaming.gamelab;

//4.
/*//Begin 4.1.
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameBeta extends ApplicationAdapter
{
    protected Stage mainStage;

    @Override
    public void create()
    {
        mainStage = new Stage();
        initialize();
    }

    public void initialize() { }

    @Override
    public void render()
    {
        float dt = Gdx.graphics.getDeltaTime();

        //Act method.
        mainStage.act(dt);

        //Defined by user.
        update(dt);

        //Clear the screen.
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Draw the graphics.
        mainStage.draw();
    }

    public void update(float dt) { }

    @Override
	public void dispose () {
	}
}
//End 4.1.*/



//4.7.
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class GameBeta extends ApplicationAdapter
{
    protected Stage mainStage;
    protected  Stage uiStage;
    protected Stage winStage;
    @Override
    public void create()
    {
        mainStage = new Stage();
        uiStage = new Stage();
        initialize();
    }

    public abstract void initialize();

    @Override
    public void render()
    {
        float dt = Gdx.graphics.getDeltaTime();

        //Act method.
        mainStage.act(dt);

        //Defined by user.
        update(dt);

        //Clear the screen.
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Draw the graphics.
        mainStage.draw();
        uiStage.draw();
    }

    public abstract void update(float dt);

    @Override
    public void dispose () {
    }
}