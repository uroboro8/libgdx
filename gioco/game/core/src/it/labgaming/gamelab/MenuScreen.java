package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuScreen extends BaseScreen {

    private boolean isFirstTime;
    private ImageButton buttonPlay;
    private ImageButton quitButton;
    private Music music;

    public void initialize(){
        Gdx.input.setInputProcessor(uiStage);
        music = Gdx.audio.newMusic(Gdx.files.internal("menu-music.wav"));
        music.setVolume(1f);
        music.setLooping(false);
        music.play();

        isFirstTime=false;
        BaseActor background = new BaseActor(0,0,mainStage);
        background.loadTexture("menu-background.png");
        background.setSize(mainStage.getWidth(), mainStage.getHeight());
        

        BaseActor logo = new BaseActor(Gdx.graphics.getWidth() /2 - 400 ,Gdx.graphics.getHeight()  - 300,mainStage);
        logo.loadTexture("logo-1.png");

        buttonPlay = new ImageButton(textureToDrawable(new Texture(Gdx.files.internal("play.png"))));
        buttonPlay.setPosition(Gdx.graphics.getWidth()/2 - buttonPlay.getWidth()/2 ,Gdx.graphics.getHeight()/2 - buttonPlay.getHeight()/3);
        buttonPlay.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Press a Button");
                isFirstTime=true;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Pressed Text Button");

                return true;
            }
        });

        quitButton = new ImageButton(textureToDrawable(new Texture(Gdx.files.internal("quit.png"))));
        quitButton.setPosition(Gdx.graphics.getWidth()/2 - quitButton.getWidth()/2 ,Gdx.graphics.getHeight()/2 - quitButton.getHeight() /2 - buttonPlay.getHeight());
        quitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Press a Button");
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Pressed Text Button");
                return true;
            }
        });

        uiStage.addActor(quitButton);
        uiStage.addActor(buttonPlay);
    }

    @Override
    public void update(float dt) {
        if(isFirstTime) {
            music.stop();
            music.dispose();
            GameManager.setActiveScreen(new MainLevel());
        }
    }

    private TextureRegionDrawable textureToDrawable(Texture buttonTexture){
        TextureRegion buttonTextureRegion = new TextureRegion(buttonTexture);
        TextureRegionDrawable buttonRegionDrawable = new TextureRegionDrawable(buttonTextureRegion);
        return buttonRegionDrawable;
    }

}
