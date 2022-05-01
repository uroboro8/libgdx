package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.audio.Music;

public abstract class BaseScreen implements Screen {

    protected Stage mainStage;
    protected  Stage uiStage;
    private Music music;
    public BaseScreen(){
        mainStage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        uiStage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));


        initialize();
    }

    public abstract void initialize();
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("start.ogg"));
        music.setVolume(0.2f);
        music.setLooping(false);
        music.play();
    }

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
