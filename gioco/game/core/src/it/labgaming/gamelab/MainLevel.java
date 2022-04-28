package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainLevel extends BaseScreen{

    private Player player;
    private Background background;
    private boolean win;

    private ImageButton buttonRight;
    private ImageButton buttonLeft;
    private ImageButton buttonTop;
    private ImageButton buttonBottom;

    @Override
    public void initialize()
    {
        Gdx.input.setInputProcessor(uiStage);

        setupWorld();

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

        uiStage.addActor(buttonRight);
        uiStage.addActor(buttonLeft);
        uiStage.addActor(buttonTop);
        uiStage.addActor(buttonBottom);
    }

    private void setupWorld() {
        background = new Background(0,0,mainStage);
        BaseActor.setWorldBounds(background);

        new House(600,Gdx.graphics.getHeight()-550,mainStage);

        new Tree(900,Gdx.graphics.getHeight()-550,mainStage);
        new Tree(350,Gdx.graphics.getHeight()-550,mainStage);
        new Tree(750,Gdx.graphics.getHeight()-300,mainStage);
        new Tree(500,Gdx.graphics.getHeight()-300,mainStage);

        new Dog(500,500,mainStage);

        new Food(1000,1000,mainStage);
        new Food(1000,1500,mainStage);
        new Food(2200,1000,mainStage);
        player = new Player(700,Gdx.graphics.getHeight()-620,mainStage);
        player.setDirection(Player.IDLE);
        player.setAnimationPaused(true);
    }


    private TextureRegionDrawable textureToDrawable(Texture buttonTexture){
        TextureRegion buttonTextureRegion = new TextureRegion(buttonTexture);
        TextureRegionDrawable buttonRegionDrawable = new TextureRegionDrawable(buttonTextureRegion);
        return buttonRegionDrawable;
    }

    @Override
    public void update(float dt)
    {

        for (BaseActor tree : BaseActor.getList(mainStage, "Tree"))
            player.preventOverlap(tree);

        for (BaseActor house : BaseActor.getList(mainStage, "House"))
            player.preventOverlap(house);

        for (BaseActor dogActor : BaseActor.getList(mainStage, "Dog")) {
            Dog dog = (Dog) dogActor;
            player.preventOverlap(dog);
            if(dog.getX() == dog.getSpawnX() + 100 && dog.getY() == dog.getSpawnY()) {
                dog.setWaypoint(dog.getX(),dog.getY());
                dog.setDirection(1);
            }
            else if(dog.getX() == dog.getWaypointX() && dog.getY() == dog.getWaypointY() - 100){
                dog.setWaypoint(dog.getX(),dog.getY());
                dog.setDirection(2);
            }
            else if(dog.getX() == dog.getWaypointX() - 100 && dog.getY() == dog.getWaypointY()){
                dog.setWaypoint(dog.getX(),dog.getY());
                dog.setDirection(3);
            }
            else if(dog.getX() == dog.getSpawnX() && dog.getY() == dog.getSpawnY()){
                dog.setWaypoint(dog.getX(),dog.getY());
                dog.setDirection(0);
            }
        }

        for (BaseActor foodActor : BaseActor.getList(mainStage, "Food")) {
            Food food = (Food) foodActor;

            if (player.overlaps(food) && !food.isCollected()) {
                food.collect();
                PickUp pickup = new PickUp(0, 0, mainStage);
                pickup.centerAtActor(food);
            }
        }

        if (BaseActor.count(mainStage, "Food") == 0 && !win) {
            win = true;
            BaseActor youWinMessage = new BaseActor(0, 0, mainStage);
            youWinMessage.loadTexture("you-win.png");
            youWinMessage.centerAtActor(player);
            youWinMessage.setOpacity(0);
            youWinMessage.addAction(Actions.delay(1));
            youWinMessage.addAction(Actions.after(Actions.fadeIn(1)));
        }
    }

}
