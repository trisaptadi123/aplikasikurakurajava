package com.kurakura.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

public class KuraKura extends Game {
	private SpriteBatch batch;
	private Texture mouseyTexture;
	private float mouseyX;
	private float mouseyY;
	private Texture starfishTexture;
	private float starfishX;
	private float starfishY;
	private Texture floorTexture;
	private Texture winMessage;
	private boolean win;
	public void create()
	{
		batch = new SpriteBatch();
		mouseyTexture = new Texture(
				Gdx.files.internal("kur.png") );
		mouseyX = 20;
		mouseyY = 20;
		starfishTexture = new Texture(
				Gdx.files.internal("bin.png") );
		starfishX = 400;
		starfishY = 300;
		floorTexture = new Texture(
				Gdx.files.internal("baw.jpg") );

		winMessage = new Texture(
				Gdx.files.internal("tert.png") );
		win = false;
	}
	public void render()
	{
// check user input
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			mouseyX--;
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			mouseyX++;
		if (Gdx.input.isKeyPressed(Keys.UP))
			mouseyY++;
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			mouseyY--;
// check win condition: mousey must be overlapping

		if ( (mouseyX > starfishX)
				&& (mouseyX + mouseyTexture.getWidth() < starfishX
				+ starfishTexture.getWidth())
				&& (mouseyY > starfishY)
				&& (mouseyY + mouseyTexture.getHeight() < starfishY
				+ starfishTexture.getHeight()) )
			win = true;
// clear screen and draw graphics
		Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw( floorTexture, 0, 0 );
		batch.draw( starfishTexture, starfishX, starfishY );
		batch.draw( mouseyTexture, mouseyX, mouseyY );
		if (win)
			batch.draw( winMessage, 150, 60 );
		batch.end();
	}
}