package com.quadrolord.game.waterbucket.view;

import com.quadrolord.game.waterbucket.logic.Bucket;
import com.quadrolord.game.waterbucket.logic.Game;
import com.quadrolord.game.waterbucket.screen.AbstractScreen;

/**
 * Created by Quadrowin on 08.01.2016.
 */
public class TargetBucketView extends BucketView {

    public Game mGame;

    public TargetBucketView(Game game, Bucket bucket, int index, AbstractScreen screen) {
        super(bucket, index, screen);
        mGame = game;
    }

    @Override
    public void act (float delta) {
        mLabel.setText(
                String.format("%.1f/%d", mBucket.Current, + mGame.getTask())
        );
        mLabel.setBounds(
                getX(),
                getY(),
                getWidth(),
                getHeight()
        );
    }

}
