package com.quadrolord.game.waterbucket.logic;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Quadrowin on 08.01.2016.
 */
public class Game {

    private int mTask = 10;
    
    private Array<Bucket> mBuckets = new Array<Bucket>();

    private Bucket mSourceBucket;

    private Bucket mTargetBucket;

    private Bucket mCurrentBucket = null;

    private int mMovesCount = 0;

    private Runnable mOnVictory;

    public Game() {
        mSourceBucket = new Bucket(99999);
        mSourceBucket.Current = 99999;
        mTargetBucket = new Bucket(10000);
    }

    public Array<Bucket> getBuckets() {
        return mBuckets;
    }

    public Bucket getSourceBucket() {
        return mSourceBucket;
    }

    public Bucket getTargetBucket() {
        return mTargetBucket;
    }

    public int getTask() {
        return mTask;
    }

    public int getMovesCount() {
        return mMovesCount;
    }

    public void randomizeTask()
    {
        mTask = (int)(Math.random() * 10 + 10);
        mBuckets.clear();
        mBuckets.add(new Bucket(10));
        mBuckets.add(new Bucket(5));
        mBuckets.add(new Bucket(3));
    }

    public void setOnVictory(Runnable callback) {
        mOnVictory = callback;
    }

    public void useBucket(Bucket bucket) {
        if (mCurrentBucket != null) {
            float delta = Math.min(bucket.MaxVolume - bucket.Current, mCurrentBucket.Current);
            mCurrentBucket.Current -= delta;
            bucket.Current += delta;
            mCurrentBucket.setSelected(false);
            mCurrentBucket = null;
            mMovesCount++;

            if (bucket == mTargetBucket && mTargetBucket.Current == mTask) {
                mOnVictory.run();
            }
        } else {
            mCurrentBucket = bucket;
            if (mCurrentBucket != null) {
                mCurrentBucket.setSelected(true);
            }
        }
    }

}
