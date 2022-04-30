package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;

public class MainLevel extends BaseScreen{

    private Player player;
    private Background background;
    private boolean win;

    private ImageButton buttonRight;
    private ImageButton buttonLeft;
    private ImageButton buttonTop;
    private ImageButton buttonBottom;

   private ArrayList<Heart> hearts;

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
                player.setPrevDirection(Player.RIGHT);
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
                player.setPrevDirection(Player.LEFT);
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
                player.setPrevDirection(Player.TOP);
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
                player.setPrevDirection(Player.BOTTOM);
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

        PlayerUI playerUI = new PlayerUI(0,Gdx.graphics.getHeight()-150,uiStage);

        Heart heart1 = new Heart(160,Gdx.graphics.getHeight()-110,uiStage);
        Heart heart2 = new Heart(250,Gdx.graphics.getHeight()-110,uiStage);
        Heart heart3 = new Heart(340,Gdx.graphics.getHeight()-110,uiStage);
        hearts = new ArrayList<>();
        hearts.add(heart1);
        hearts.add(heart2);
        hearts.add(heart3);

        uiStage.addActor(buttonRight);
        uiStage.addActor(buttonLeft);
        uiStage.addActor(buttonTop);
        uiStage.addActor(buttonBottom);
    }

    private void setupWorld() {
        background = new Background(0,0,mainStage);
        BaseActor.setWorldBounds(background);

        new House(800,Gdx.graphics.getHeight()-550,mainStage);

        new Tree(1100,Gdx.graphics.getHeight()-550,mainStage);
        new Tree(550,Gdx.graphics.getHeight()-550,mainStage);
        new Tree(950,Gdx.graphics.getHeight()-300,mainStage);
        new Tree(700,Gdx.graphics.getHeight()-300,mainStage);
        //new Tree(0,350,mainStage);
        //new Tree(250,350,mainStage);
        //new Tree(320,50,mainStage);
        //new Flower(600,0,mainStage);
        for (int i = 0; i <= Gdx.graphics.getWidth();i +=250) {
            new Tree(i,0,mainStage);
        }
        for (int i = 0; i <= Gdx.graphics.getWidth();i +=250) {
            new Tree(i,2150,mainStage);
        }
        for (int i = 0; i <= Gdx.graphics.getWidth()-250;i +=250) {
            new Tree(0,i,mainStage);
        }
        for (int i = 250; i <= Gdx.graphics.getWidth()-250;i +=250) {
            new Tree(2150,i,mainStage);
        }

        new Dog(700,500,mainStage);
        new Horse(350,1000,mainStage);

        new Cinghiale(1500,1500,mainStage);

        new Food(900,50,mainStage);
        new Food(1700,1300,mainStage);
        new Food(200,1800,mainStage);
        player = new Player(900,Gdx.graphics.getHeight()-620,mainStage);
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
                dog.setDirection(Dog.BOTTOM);
            }
            else if(dog.getX() == dog.getWaypointX() && dog.getY() == dog.getWaypointY() - 100){
                dog.setWaypoint(dog.getX(),dog.getY());
                dog.setDirection(Dog.LEFT);
            }
            else if(dog.getX() == dog.getWaypointX() - 100 && dog.getY() == dog.getWaypointY()){
                dog.setWaypoint(dog.getX(),dog.getY());
                dog.setDirection(Dog.TOP);
            }
            else if(dog.getX() == dog.getSpawnX() && dog.getY() == dog.getSpawnY()){
                dog.setWaypoint(dog.getX(),dog.getY());
                dog.setDirection(Dog.RIGHT);
            }
        }

        for (BaseActor horseActor : BaseActor.getList(mainStage, "Horse")) {
            Horse horse = (Horse) horseActor;
            player.preventOverlap(horse);
            if(horse.getX() == horse.getSpawnX() + 100 && horse.getY() == horse.getSpawnY()) {
                horse.setWaypoint(horse.getX(),horse.getY());
                horse.setDirection(Horse.BOTTOM);
            }
            else if(horse.getX() == horse.getWaypointX() && horse.getY() == horse.getWaypointY() - 300){
                horse.setWaypoint(horse.getX(),horse.getY());
                horse.setDirection(Horse.LEFT);
            }
            else if(horse.getX() == horse.getWaypointX() - 100 && horse.getY() == horse.getWaypointY()){
                horse.setWaypoint(horse.getX(),horse.getY());
                horse.setDirection(Horse.TOP);
            }
            else if(horse.getX() == horse.getSpawnX() && horse.getY() == horse.getSpawnY()){
                horse.setWaypoint(horse.getX(),horse.getY());
                horse.setDirection(Horse.RIGHT);
            }
        }

        for (BaseActor cinghialeActor : BaseActor.getList(mainStage, "Cinghiale")) {
            Cinghiale cinghiale = (Cinghiale) cinghialeActor;
            player.preventOverlap(cinghiale);
            if(cinghiale.getX() == cinghiale.getSpawnX() + 300 && cinghiale.getY() == cinghiale.getSpawnY()) {
                cinghiale.setWaypoint(cinghiale.getX(),cinghiale.getY());
                cinghiale.setDirection(Cinghiale.BOTTOM);
            }
            else if(cinghiale.getX() == cinghiale.getWaypointX() && cinghiale.getY() == cinghiale.getWaypointY() - 300){
                cinghiale.setWaypoint(cinghiale.getX(),cinghiale.getY());
                cinghiale.setDirection(Cinghiale.LEFT);
            }
            else if(cinghiale.getX() == cinghiale.getWaypointX() - 300 && cinghiale.getY() == cinghiale.getWaypointY()){
                cinghiale.setWaypoint(cinghiale.getX(),cinghiale.getY());
                cinghiale.setDirection(Cinghiale.TOP);
            }
            else if(cinghiale.getX() == cinghiale.getSpawnX() && cinghiale.getY() == cinghiale.getSpawnY()){
                cinghiale.setWaypoint(cinghiale.getX(),cinghiale.getY());
                cinghiale.setDirection(Cinghiale.RIGHT);
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

        for (BaseActor cinghialeActor : BaseActor.getList(mainStage, "Cinghiale")) {
            Cinghiale cinghiale = (Cinghiale) cinghialeActor;

            if (player.overlaps(cinghiale) || cinghiale.overlaps(player)) {
                player.preventOverlap(cinghiale);
                cinghiale.preventOverlap(player);

                if(player.getDirection() == Player.RIGHT || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.LEFT)) {
                    Action moveBy = Actions.moveBy(-200,0,0.5f);
                    player.hit(moveBy);
                }
                else if(player.getDirection() == Player.LEFT || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.RIGHT)) {
                    Action moveBy = Actions.moveBy(200,0,0.5f);
                    player.hit(moveBy);
                }
                else if(player.getDirection() == Player.TOP || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.BOTTOM)) {
                    Action moveBy = Actions.moveBy(0, -200, 0.5f);
                    player.hit(moveBy);
                }
                else if(player.getDirection() == Player.BOTTOM || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.TOP)) {
                    Action moveBy = Actions.moveBy(0,200,0.5f);
                    player.hit(moveBy);
                }

                if(hearts.size() > 0) {
                    Heart heart = hearts.get(hearts.size() - 1);
                    hearts.remove(heart);
                    heart.removeHeart();
                }
            }
        }

        if (BaseActor.count(mainStage, "Food") == 0 && !win) {
            win = true;
            GameManager.setActiveScreen(new YouWinScreen());
        }

        if (BaseActor.count(uiStage, "Heart") == 0 && !win) {
            win = true;
            GameManager.setActiveScreen(new GameOverScreen());
        }
    }

}
