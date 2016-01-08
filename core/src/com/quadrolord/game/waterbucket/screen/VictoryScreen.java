package com.quadrolord.game.waterbucket.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.quadrolord.game.waterbucket.WaterBucket;
import com.quadrolord.game.waterbucket.logic.Game;

/**
 * Created by Quadrowin on 08.01.2016.
 */
public class VictoryScreen extends AbstractScreen {

    public VictoryScreen(WaterBucket front, Game game) {
        super(front, game);

        // Разрешение
        mStage.setViewport(new FitViewport(400 * mPx, 300 * mPx));
        mStage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

        BitmapFont font = mSkin.getFont("default");

        com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle labelStyle = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(font, Color.WHITE);
        mSkin.add("bucket-label-style", labelStyle);

        Label title = new Label("Congratulations!", labelStyle);
        title.setAlignment(Align.center, Align.center);
        addStageBounds(title, 0, 200, 400, 300);
    }

    @Override
    public void draw(float delta) {
        mStage.act(delta);
        mStage.draw();
    }

    @Override
    public void update(float delta) {

    }
}
