package it.labgaming.gamelab;

//4.2.
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


//Begin 4.3.
//public class GameClass extends ApplicationAdapter {
public class GameClass extends GameBeta {
	//End 4.3.



	private Player player;
	private House house;
	private Background background;
	private ActorBeta winMessage;
	private Whirlpool whirlpool;

	private boolean win;


	//Begin 4.3.5.
	//private Stage mainStage;
	//End 4.3.5.



	private ImageButton buttonRight;
	private ImageButton buttonLeft;
	private ImageButton buttonTop;
	private ImageButton buttonBottom;
	//private TextButton.TextButtonStyle textButtonStyle;

	@Override
	public void initialize()
	{
		Gdx.input.setInputProcessor(mainStage);

		background = new Background(0,0,mainStage);

		house = new House(380,Gdx.graphics.getHeight()-250,mainStage);
		Tree tree = new Tree(1000,Gdx.graphics.getHeight()-350,mainStage);

		player = new Player(20,20,mainStage);
		player.setDirection(Player.IDLE);
		player.setAnimationPaused(true);


		buttonRight = new ImageButton(textureToDrawable(new Texture(Gdx.files.internal("buttonRight.png"))));
		buttonRight.setSize(200,162);
		buttonRight.setPosition(Gdx.graphics.getWidth() - 250,162);
		buttonRight.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Press a Button");
				player.setDirection(Player.IDLE);
				player.setAnimationPaused(true);
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Pressed Text Button");
				player.setAnimationPaused(false);
				player.setDirection(Player.RIGHT);
				return true;
			}

		});

		buttonLeft = new ImageButton(textureToDrawable(new Texture(Gdx.files.internal("buttonLeft.png"))));
		buttonLeft.setSize(200,162);
		buttonLeft.setPosition(Gdx.graphics.getWidth() - 250 -200,162);
		buttonLeft.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Press a Button");
				player.setDirection(Player.IDLE);
				player.setAnimationPaused(true);
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Pressed Text Button");
				player.setAnimationPaused(false);
				player.setDirection(Player.LEFT);
				return true;
			}
		});

		buttonTop = new ImageButton(textureToDrawable(new Texture(Gdx.files.internal("buttonUp.png"))));
		buttonTop.setSize(162,200);
		buttonTop.setPosition(Gdx.graphics.getWidth() - 250 - 80,162 + 100);
		buttonTop.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Press a Button");
				player.setDirection(Player.IDLE);
				player.setAnimationPaused(true);
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Pressed Text Button");
				player.setAnimationPaused(false);
				player.setDirection(Player.TOP);
				return true;
			}
		});

		buttonBottom = new ImageButton(textureToDrawable(new Texture(Gdx.files.internal("buttonDown.png"))));
		buttonBottom.setSize(162,200);
		buttonBottom.setPosition(Gdx.graphics.getWidth() - 250 - 80,20);
		buttonBottom.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Press a Button");
				player.setDirection(Player.IDLE);
				player.setAnimationPaused(true);
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("#INFO", "Pressed Text Button");
				player.setAnimationPaused(false);
				player.setDirection(Player.BOTTOM);
				return true;
			}
		});

		//mainStage.addActor(buttonUp);
		mainStage.addActor(buttonRight);
		mainStage.addActor(buttonLeft);
		mainStage.addActor(buttonTop);
		mainStage.addActor(buttonBottom);
	}


private TextureRegionDrawable textureToDrawable(Texture buttonTexture){
	TextureRegion buttonTextureRegion = new TextureRegion(buttonTexture);
	TextureRegionDrawable buttonRegionDrawable = new TextureRegionDrawable(buttonTextureRegion);
	return buttonRegionDrawable;
}
	//Begin 4.6.
	//render() removed.
	@Override
	public void update(float dt)
	{
		//Check win condition: turtle must be overlapping starfish.

	}
	//End 4.6.
}

//TILL 37.