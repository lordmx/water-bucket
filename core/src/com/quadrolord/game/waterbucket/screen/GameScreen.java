package com.quadrolord.game.waterbucket.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.quadrolord.game.waterbucket.WaterBucket;
import com.quadrolord.game.waterbucket.logic.Bucket;
import com.quadrolord.game.waterbucket.logic.Game;
import com.quadrolord.game.waterbucket.view.BucketView;
import com.quadrolord.game.waterbucket.view.SourceBucketView;
import com.quadrolord.game.waterbucket.view.TargetBucketView;

import java.util.Iterator;

/**
 * Created by Quadrowin on 27.11.2015.
 */
public class GameScreen extends AbstractScreen {



    public GameScreen(WaterBucket front, Game game) {
        super(front, game);

        // Разрешение
        mStage.setViewport(new FitViewport(400 * mPx, 300 * mPx));
        mStage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

        BitmapFont font = mSkin.getFont("default");

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.WHITE);
        mSkin.add("bucket-label-style", labelStyle);

        mGame.randomizeTask();

        ClickListener bucketClickListener = new ClickListener() {

            @Override
            public void clicked (InputEvent event, float x, float y) {

                Label lbl = (Label)event.getListenerActor();
                BucketView bv = (BucketView)lbl.getUserObject();
                Gdx.app.log("clicked", "bucket clicked ");
                mGame.useBucket(bv.getBucket());

            }

        };

        int index = 0;
        for (Iterator<Bucket> iter = mGame.getBuckets().iterator(); iter.hasNext(); index++) {
            Bucket b = iter.next();
            BucketView bv = new BucketView(b, index, this);

            bv.getLabel().addListener(bucketClickListener);
        }


        BucketView sourceBucket = new SourceBucketView(mGame.getSourceBucket(), 0, this);
        initBounds(sourceBucket, 0, 0, 400, 40);
        sourceBucket.getLabel().addListener(bucketClickListener);

        BucketView targetBucket = new TargetBucketView(mGame, mGame.getTargetBucket(), 0, this);
        initBounds(targetBucket, 0, 260, 400, 40);
        targetBucket.getLabel().addListener(bucketClickListener);

        mGame.setOnVictory(new Runnable() {

            @Override
            public void run() {

                mAdapter.switchToScreen(new VictoryScreen(mAdapter, mGame), true);

            }

        });

        Gdx.app.log("inited", " +++ ");

//        mStage.setDebugAll(true);
    }

    @Override
    public void draw(float delta) {
        mStage.act(delta);
        mStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        mStage.getViewport().update(width, height, true);
    }

    @Override
    public void update(float delta) {

    }

}
