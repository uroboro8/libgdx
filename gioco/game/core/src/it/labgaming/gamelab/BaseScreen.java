package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public abstract class BaseScreen implements Screen {

    protected Stage mainStage;
    protected  Stage uiStage;

    public BaseScreen(){
        mainStage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        uiStage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));


        initialize();
    }

    public abstract void initialize();

    public abstract void update(float dt);

    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        uiStage.act(dt);
        mainStage.act(dt);

        update(dt);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();
        uiStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        mainStage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
