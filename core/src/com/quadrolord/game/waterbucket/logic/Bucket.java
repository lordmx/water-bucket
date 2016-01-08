package com.quadrolord.game.waterbucket.logic;

/**
 * Created by Quadrowin on 08.01.2016.
 */
public class Bucket {

    public float Current = 0;

    public int MaxVolume = 10;

    private boolean mSelected;

    public Bucket(int max) {
        MaxVolume = max;
    }

    public boolean isSelected() {
        return mSelected;
    }

    public void setSelected(boolean value) {
        mSelected = value;
    }

}
