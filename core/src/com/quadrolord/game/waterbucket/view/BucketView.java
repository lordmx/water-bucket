package com.quadrolord.game.waterbucket.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.quadrolord.game.waterbucket.logic.Bucket;
import com.quadrolord.game.waterbucket.screen.AbstractScreen;

/**
 * Created by Quadrowin on 08.01.2016.
 */
public class BucketView extends AbstractShape {

    protected Bucket mBucket;

    protected Label mLabel;

    public BucketView (Bucket bucket, int index, AbstractScreen screen) {
        mBucket = bucket;
        mTexture = screen.getSkin().get("bucket-view", Texture.class);
        screen.addStageBounds(this, 0 + 50 * index, 50, 40, 40);

        mLabel = new Label("", screen.getSkin().get("bucket-label-style", Label.LabelStyle.class));
        mLabel.setAlignment(Align.center, Align.center);
        mLabel.setBounds(0, 0, getWidth(), getHeight());

        mLabel.setUserObject(this);

        screen.getStage().addActor(mLabel);
    }

    public Bucket getBucket() {
        return mBucket;
    }

    public Label getLabel() {
        return mLabel;
    }

    @Override
    public void act (float delta) {
        mLabel.setText(
                String.format("%.1f/%d", mBucket.Current, + mBucket.MaxVolume)
        );
        mLabel.setBounds(
                getX(),
                getY(),
                getWidth(),
                getHeight()
        );
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {

        applyTransform(batch);

        float width = getWidth();
        float height = getHeight();

        /*

00              04----------1
                 \      /  /
                  \  /    /
40                 3-----2

         */

        float[] polygon1 = new float[]{
                +00,
                +height,
                mWhiteColor, 0, 0,

                +width,
                +height,
                mWhiteColor, 0, 0,

                +width * 0.9f,
                +0,
                mWhiteColor, 0, 0,

                +width * 0.1f,
                +0,
                mWhiteColor, 0, 0,
        };

        batch.draw(mTexture, polygon1, 0, polygon1.length);

        float waterColor = Color.BLUE.toFloatBits();
        float ratio = mBucket.Current / mBucket.MaxVolume;

        float[] polygon2 = new float[]{
                +width * 0.1f,
                +0.1f * height + 0.9f * height * ratio,
                waterColor, 0, 0,

                +width * 0.9f,
                +0.1f * height + 0.9f * height * ratio,
                waterColor, 1, 0,

                +width * 0.8f,
                +0.1f * height,
                waterColor, 1, 1,

                +width * 0.2f,
                +0.1f * height,
                waterColor, 0, 1,
        };


        batch.draw(mTexture, polygon2, 0, polygon2.length);

        if (mBucket.isSelected()) {
            Gdx.app.log("", " draw selected ");
            float markColor = Color.YELLOW.toFloatBits();

            float[] polygon3 = new float[]{
                    +width * 0.5f - 10f,
                    +height + 10f,
                    markColor, 0, 0,

                    +width * 0.5f + 10f,
                    +height + 10f,
                    markColor, 1, 0,

                    +width * 0.5f,
                    +height - 10f,
                    markColor, 1, 1,

                    +width * 0.5f,
                    +height - 10f,
                    markColor, 0, 1,
            };


            batch.draw(mTexture, polygon3, 0, polygon3.length);
        }

        resetTransform(batch);
    }


}
