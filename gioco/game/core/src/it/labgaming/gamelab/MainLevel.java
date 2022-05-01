package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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

   private Music music;
    @Override
    public void initialize()
    {
        Gdx.input.setInputProcessor(uiStage);

        music = Gdx.audio.newMusic(Gdx.files.internal("background-music.wav"));
        music.setVolume(0.2f);
        music.setLooping(true);
        music.play();

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
        for (int i = 0; i <= 2400;i +=250) {
            new Tree(i,0,mainStage);
        }
        for (int i = 0; i <= 2400;i +=250) {
            new Tree(i,2150,mainStage);
        }
        for (int i = 0; i <= 2400-250;i +=250) {
            new Tree(0,i,mainStage);
        }
        for (int i = 250; i <= 2400-250;i +=250) {
            new Tree(2150,i,mainStage);
        }

        //zona in alto a sinistra
        new Cespuglio(250,1880,mainStage);
        new Cespuglio(334,1880,mainStage);
        new Cespuglio(334,1970,mainStage);
        new Cespuglio(418,1970,mainStage);
        new Cespuglio(502,1970,mainStage);
        new Cespuglio(502,1790,mainStage);
        new Cespuglio(502,1700,mainStage);
        new Cespuglio(502,1610,mainStage);
        new Cespuglio(586,1610,mainStage);
        new Cespuglio(418,1700,mainStage);
        new Cespuglio(334,1700,mainStage);
        new Cespuglio(334,1610,mainStage);
        new Cespuglio(334,1520,mainStage);
        new Cespuglio(334,1430,mainStage);
        new Cespuglio(334,1340,mainStage);
        new Cespuglio(502,1340,mainStage);
        new Cespuglio(502,1430,mainStage);

        //zona in alto a destra
        new Cespuglio(920,1970,mainStage);
        new Cespuglio(1004,1970,mainStage);
        new Cespuglio(1088,1970,mainStage);
        new Cespuglio(1088,1880,mainStage);
        new Cespuglio(1088,1790,mainStage);
        new Cespuglio(1004,1790,mainStage);
        new Cespuglio(1172,1790,mainStage);
        new Cespuglio(1340,1790,mainStage);
        new Cespuglio(1424,1790,mainStage);
        new Cespuglio(1508,1790,mainStage);
        new Cespuglio(1592,1790,mainStage);
        new Cespuglio(1592,1700,mainStage);
        new Cespuglio(2012,1700,mainStage);
        new Cespuglio(2096,1700,mainStage);
        new Cespuglio(2012,1880,mainStage);
        new Cespuglio(2012,1970,mainStage);
        new Cespuglio(2012,1790,mainStage);
        new Cespuglio(2012,2060,mainStage);
        new Cespuglio(2096,1790,mainStage);
        new Cespuglio(2096,1880,mainStage);
        new Cespuglio(2096,1970,mainStage);
        new Cespuglio(2096,2060,mainStage);
        new Cespuglio(1256,1970,mainStage);
        new Cespuglio(1340,1970,mainStage);
        new Cespuglio(1424,1970,mainStage);
        new Cespuglio(1508,1970,mainStage);
        new Cespuglio(1592,1970,mainStage);
        new Cespuglio(1676,1970,mainStage);
        new Cespuglio(1760,1970,mainStage);
        new Cespuglio(1844,1970,mainStage);
        new Cespuglio(1760,1700,mainStage);
        new Cespuglio(1760,1790,mainStage);

        //alberi
        new Tree(670,1940,mainStage);
        new Tree(670,1690,mainStage);
        new Tree(670,1440,mainStage);
        new Tree(920,1440,mainStage);
        new Tree(1170,1440,mainStage);
        new Tree(1420,1440,mainStage);
        new Tree(1670,1440,mainStage);
        new Tree(1420,920,mainStage);
        new Tree(1670,920,mainStage);
        new Tree(249,1000,mainStage);
        new Tree(1420,670,mainStage);
        new Tree(1420,420,mainStage);
        new Tree(670,1190,mainStage);
        new Tree(920,1190,mainStage);

        //NPC Buoni
        new Dog(700,500,mainStage);
        new Horse(250,900,mainStage);
        new Cat(1200,1400,mainStage);

        //NPC Nemici
        new Cinghiale(1800,700,mainStage,0);
        new Cinghiale(1150,1900,mainStage,1);
        new Cinghiale(390,1550,mainStage,3);
        new Cinghiale (1050,2050,mainStage,4);

        new Bear(1100,1700,mainStage,0);
        new Bear(570,2050,mainStage,1);

        //Cibo
        new Food(250,1970,mainStage,Food.CAKE);
       // new Food(595,1700,mainStage);
        new Food(427,1630,mainStage,Food.HAMBURGER);
        new Food(920,2060,mainStage,Food.ORANGE);
        new Food(1030,1880,mainStage,Food.MEAT);
        new Food(1900,630,mainStage,Food.CAKE);
        new Food(1685,1700,mainStage,Food.HAMBURGER);

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

        for (BaseActor cespuglio : BaseActor.getList(mainStage, "Cespuglio"))
            player.preventOverlap(cespuglio);

        for (BaseActor catActor : BaseActor.getList(mainStage, "Cat")) {
            Cat cat = (Cat) catActor;
            player.preventOverlap(cat);
            cat.setXPath(500);
        }

        for (BaseActor dogActor : BaseActor.getList(mainStage, "Dog")) {
            Dog dog = (Dog) dogActor;
            player.preventOverlap(dog);
            dog.setSquarePath(100,100,100);
        }

        for (BaseActor horseActor : BaseActor.getList(mainStage, "Horse")) {
            Horse horse = (Horse) horseActor;
            player.preventOverlap(horse);
            horse.setSquarePath(100,100,300);
        }

        for (BaseActor foodActor : BaseActor.getList(mainStage, "Food")) {
            Food food = (Food) foodActor;

            if (player.overlaps(food) && !food.isCollected()) {
                food.collect();
                PickUp pickup = new PickUp(0, 0, mainStage);
                pickup.centerAtActor(food);
                //pickup.remove();
            }
        }

        for (BaseActor cinghialeActor : BaseActor.getList(mainStage, "Cinghiale")) {
            Cinghiale cinghiale = (Cinghiale) cinghialeActor;
            if(cinghiale.getCount() == 0)
                cinghiale.setSquarePath(150,200,200);
            else if(cinghiale.getCount() == 1)
                cinghiale.setXPath(750);
            else if(cinghiale.getCount() == 3)
                cinghiale.setSquarePath(200,200,300);
            else if(cinghiale.getCount() == 4)
                cinghiale.setXPath(500);

            if (player.overlaps(cinghiale) || cinghiale.overlaps(player)) {
                player.preventOverlap(cinghiale);
                //cinghiale.preventOverlap(player);

                if(player.getDirection() == Player.RIGHT || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.LEFT)) {
                    Action moveBy = Actions.moveBy(-400,0,0.5f);
                    player.hit(moveBy,uiStage);
                }
                else if(player.getDirection() == Player.LEFT || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.RIGHT)) {
                    Action moveBy = Actions.moveBy(400,0,0.5f);
                    player.hit(moveBy,uiStage);
                }
                else if(player.getDirection() == Player.TOP || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.BOTTOM)) {
                    Action moveBy = Actions.moveBy(0, -400, 0.5f);
                    player.hit(moveBy,uiStage);
                }
                else if(player.getDirection() == Player.BOTTOM || (player.getDirection() == Player.IDLE && cinghiale.getDirection() == Cinghiale.TOP)) {
                    Action moveBy = Actions.moveBy(0,400,0.5f);
                    player.hit(moveBy,uiStage);
                }

                if(hearts.size() > 0) {
                    Heart heart = hearts.get(hearts.size() - 1);
                    hearts.remove(heart);
                    heart.removeHeart();
                }

            }
        }

        for (BaseActor bearActor : BaseActor.getList(mainStage, "Bear")) {
           Bear bear = (Bear) bearActor;
            if(bear.getCount() == 0)
                bear.setXPath(350);
            else if(bear.getCount() == 1){
                bear.setYPath(350);
            }


            if (player.overlaps(bear) || bear.overlaps(player)) {
                player.preventOverlap(bear);
                //bear.preventOverlap(player);

                if(player.getDirection() == Player.RIGHT || (player.getDirection() == Player.IDLE && bear.getDirection() == Bear.LEFT)) {
                    Action moveBy = Actions.moveBy(-400,0,0.5f);
                    player.hit(moveBy,uiStage);
                }
                else if(player.getDirection() == Player.LEFT || (player.getDirection() == Player.IDLE && bear.getDirection() == Bear.RIGHT)) {
                    Action moveBy = Actions.moveBy(400,0,0.5f);
                    player.hit(moveBy,uiStage);
                }
                else if(player.getDirection() == Player.TOP || (player.getDirection() == Player.IDLE && bear.getDirection() == Bear.BOTTOM)) {
                    Action moveBy = Actions.moveBy(0, -400, 0.5f);
                    player.hit(moveBy,uiStage);
                }
                else if(player.getDirection() == Player.BOTTOM || (player.getDirection() == Player.IDLE && bear.getDirection() == Bear.TOP)) {
                    Action moveBy = Actions.moveBy(0,400,0.5f);
                    player.hit(moveBy,uiStage);
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
            music.stop();
            music.dispose();
            GameManager.setActiveScreen(new YouWinScreen());
        }

        if (BaseActor.count(uiStage, "Heart") == 0 && !win) {
            win = true;
            music.stop();
            music.dispose();
            GameManager.setActiveScreen(new GameOverScreen());
        }
    }

}
