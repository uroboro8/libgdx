//3.
//3.1.
package it.labgaming.gamelab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.audio.Music;

public class Player extends BaseActor
{

    private Music music;
    private int direction=0;
    private int prevDirection = 0;
    private int speed=8;

    String[] top = {"a1-up.png","a2-up.png","a3-up.png"};
    String[] left = {"a1-left.png","a2-left.png","a3-left.png"};
    String[] right = {"a1.png","a2.png","a3.png"};
    String[] bottom = {"a1-down.png","a2-down.png","a3-down.png"};

    Animation<TextureRegion> animTop;
    Animation<TextureRegion> animLeft;
    Animation<TextureRegion> animRight;
    Animation<TextureRegion> animBottom;

    public Player(float x, float y, Stage s)
    {
        super(x,y,s);


        //String[] filenames = {"a1-down.png","a2-down.png","a3-down.png"};
        //loadAnimationFromFiles(filenames, 0.1f, true);

        animTop =  loadAnimationFromFiles(top, 0.1f, true);
        animBottom =  loadAnimationFromFiles(bottom, 0.1f, true);
        animRight =  loadAnimationFromFiles(right, 0.1f, true);
        animLeft =  loadAnimationFromFiles(left, 0.1f, true);

        setAnimation(animBottom);
        setDirection(Player.IDLE);
        setBoundaryPolygon(8);
    }

    public int getDirection(){
        return this.direction;
    }

    public void setDirection(int d)
    {
        direction=d;
    }

    public int getPrevDirection() {
        return prevDirection;
    }

    public void setPrevDirection(int prevDirection) {
        this.prevDirection = prevDirection;
    }

    public void act(float dt)
    {
        super.act(dt);

            if (direction == Player.LEFT) {
                this.moveBy(-speed, 0);
                //animLeft = loadAnimationFromFiles(left,0.1f,true);
                setAnimation(animLeft);
            } else if (direction == Player.TOP) {
                this.moveBy(0, speed);
                //anim = loadAnimationFromFiles(top,0.1f,true);
                setAnimation(animTop);
            } else if (direction == Player.RIGHT) {
                this.moveBy(speed, 0);
                //anim = loadAnimationFromFiles(right,0.1f,true);
                setAnimation(animRight);
            } else if (direction == Player.BOTTOM) {
                this.moveBy(0, -speed);
                //anim = loadAnimationFromFiles(bottom,0.1f,true);
                setAnimation(animBottom);

        }
        boundToWorld();
        alignCamera();
    }

    public void hit(Action moveBy,Stage stage){
    
        music = Gdx.audio.newMusic(Gdx.files.internal("damage.ogg"));
        music.setVolume(0.2f);
        music.setLooping(false);
        music.play();
       // this.isHit = true;
        Gdx.input.setInputProcessor(null);
        this.setAnimationPaused(true);
        this.clearActions();
        this.setDirection(Player.IDLE);
        this.addAction(moveBy);
        Gdx.input.setInputProcessor(stage);
       // this.isHit = false;
        //this.setAnimationPaused(false);
    }



}
