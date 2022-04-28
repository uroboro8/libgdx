package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuScreen extends BaseScreen {

    private boolean isFirstTime;
    private ImageButton button;

    public void initialize(){
        Gdx.input.setInputProcessor(uiStage);
        isFirstTime=false;
        BaseActor background = new BaseActor(0,0,mainStage);
        background.loadTexture("menu-background.png");
        background.setSize(mainStage.getWidth(), mainStage.getHeight());

        button = new ImageButton(textureToDrawable(new Texture(Gdx.files.internal("start.png"))));
        button.setSize(1000,800);
        button.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        button.addListener(new InputListener(){
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

        uiStage.addActor(button);
    }

    @Override
    public void update(float dt) {
        if(isFirstTime)
            GameManager.setActiveScreen( new MainLevel() );
    }

    private TextureRegionDrawable textureToDrawable(Texture buttonTexture){
        TextureRegion buttonTextureRegion = new TextureRegion(buttonTexture);
        TextureRegionDrawable buttonRegionDrawable = new TextureRegionDrawable(buttonTextureRegion);
        return buttonRegionDrawable;
    }
}
