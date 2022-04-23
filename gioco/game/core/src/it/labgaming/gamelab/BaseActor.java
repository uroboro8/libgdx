package it.labgaming.gamelab;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class BaseActor extends Actor {

    //Begin 1.1.
    private Animation<TextureRegion> animation;
    private float elapsedTime;
    private boolean animationPaused;
    private Vector2 velocityVec;
    private Vector2 accelerationVec;

    private float acceleration;
    private float maxSpeed;
    private float deceleration;

    public BaseActor(float x, float y, Stage s)
    {

        super();

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        setPosition(x,y);
        s.addActor(this);

        //Begin 1.1.
        animation = null;
        elapsedTime = 0;
        animationPaused = false;
        //End 1.1.

        velocityVec = new Vector2(0,0);
        //End 2.6.



        //Begin 2.8.
        accelerationVec = new Vector2(0,0);
        acceleration = 0;
        //End 2.8.



        //Begin 3.1.
        maxSpeed = 1000;
        deceleration = 0;

    }

    public void setAnimation(Animation<TextureRegion> anim)
    {
        animation = anim;
        TextureRegion tr = animation.getKeyFrame(0);
        float w = tr.getRegionWidth();
        float h = tr.getRegionHeight();
        setSize( w, h );
        setOrigin( w/2, h/2 );
    }

    public void setAnimationPaused(boolean pause)
    {
        animationPaused = pause;
    }

    public void act(float dt)
    {
        super.act( dt );

        if (!animationPaused)
            elapsedTime += dt;
    }

    public void draw(Batch batch, float parentAlpha)
    {
        super.draw( batch, parentAlpha );

        //Apply color tint effect.
        Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a);

        if (animation != null && isVisible() )
            batch.draw( animation.getKeyFrame(elapsedTime),
                    getX(), getY(), getOriginX(), getOriginY(),
                    getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation() );
    }

    public Animation<TextureRegion> loadAnimationFromFiles(String[] fileNames,
                                                           float frameDuration,
                                                           boolean loop)
    {
        int fileCount = fileNames.length;
        Array<TextureRegion> textureArray = new Array<TextureRegion>();

        for (int n = 0; n < fileCount; n++)
        {
            String fileName = fileNames[n];
            Texture texture = new Texture( Gdx.files.internal(fileName) );
            texture.setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear );
            textureArray.add( new TextureRegion( texture ) );
        }

        Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);

        if (loop)
            anim.setPlayMode(Animation.PlayMode.LOOP);
        else
            anim.setPlayMode(Animation.PlayMode.NORMAL);

        if (animation == null)
            setAnimation(anim);

        return anim;
    }

    public Animation<TextureRegion> loadAnimationFromSheet(String fileName,
                                                           int rows, int cols,
                                                           float frameDuration, boolean loop)
    {
        Texture texture = new Texture(Gdx.files.internal(fileName), true);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        int frameWidth = texture.getWidth() / cols;
        int frameHeight = texture.getHeight() / rows;

        TextureRegion[][] temp = TextureRegion.split(texture,
                frameWidth,
                frameHeight);

        Array<TextureRegion> textureArray = new Array<TextureRegion>();

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                textureArray.add( temp[r][c] );

        Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);

        if (loop)
            anim.setPlayMode(Animation.PlayMode.LOOP);
        else
            anim.setPlayMode(Animation.PlayMode.NORMAL);

        if (animation == null)
            setAnimation(anim);

        return anim;
    }
    //End 1.7.

    public Animation<TextureRegion> loadTexture(String fileName)
    {
        String[] fileNames = new String[1];
        fileNames[0] = fileName;
        return loadAnimationFromFiles(fileNames, 1, true);
    }

    public boolean isAnimationFinished()
    {
        return animation.isAnimationFinished(elapsedTime);
    }

    public void setSpeed(float speed)
    {
        //If length is zero, then assume motion angle is zero degrees.
        if (velocityVec.len() == 0)
            velocityVec.set(speed, 0);
        else
            velocityVec.setLength(speed);
    }

    public float getSpeed()
    {
        return velocityVec.len();
    }

    public void setMotionAngle(float angle)
    {
        velocityVec.setAngleDeg(angle);
    }

    public float getMotionAngle()
    {
        return velocityVec.angleDeg();
    }

    public boolean isMoving()
    {
        return (getSpeed() > 0);
    }

    //Begin 2.9.
    public void setAcceleration(float acc)
    {
        acceleration = acc;
    }

    public void accelerateAtAngle(float angle)
    {
        accelerationVec.add( new Vector2(acceleration, 0).setAngleDeg(angle) );
    }

    public void setMaxSpeed(float ms)
    {
        maxSpeed = ms;
    }

    public void setDeceleration(float dec)
    {
        deceleration = dec;
    }

    public void applyPhysics(float dt)
    {
        //Apply acceleration.
        velocityVec.add( accelerationVec.x * dt, accelerationVec.y * dt );

        float speed = getSpeed();

        //Decrease speed (decelerate) when not accelerating.
        if (accelerationVec.len() == 0)
            speed -= deceleration * dt;

        //Keep speed within set bounds.
        speed = MathUtils.clamp(speed, 0, maxSpeed);

        //Update velocity.
        setSpeed(speed);

        //Apply velocity.
        moveBy( velocityVec.x * dt, velocityVec.y * dt );

        //Reset acceleration.
        accelerationVec.set(0,0);
    }

}
