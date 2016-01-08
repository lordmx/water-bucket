package com.quadrolord.game.waterbucket.view;

import com.quadrolord.game.waterbucket.logic.Bucket;
import com.quadrolord.game.waterbucket.screen.AbstractScreen;

/**
 * Created by Quadrowin on 08.01.2016.
 */
public class SourceBucketView extends BucketView {

    public SourceBucketView(Bucket bucket, int index, AbstractScreen screen) {
        super(bucket, index, screen);
    }

    @Override
    public void act (float delta) {
        mLabel.setText(" Lake ");
        mLabel.setBounds(
                getX(),
                getY(),
                getWidth(),
                getHeight()
        );
    }

}
