package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameOverScreen extends BaseScreen{

    private boolean isFirstTime;

    public void initialize(){
        Gdx.input.setInputProcessor(mainStage);
        isFirstTime=false;
        BaseActor background = new BaseActor(0,0,mainStage);
        background.loadTexture("GameOver.png");
        background.setSize(mainStage.getWidth(), mainStage.getHeight());

        background.addListener(new InputListener(){
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

    }

    @Override
    public void update(float dt) {
        if(isFirstTime)
            GameManager.setActiveScreen( new MenuScreen() );
    }

}