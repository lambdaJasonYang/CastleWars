package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class learn implements Screen,InputProcessor{
	static Texture back;
	Batch batch;
	
	OrthographicCamera c;
	Viewport vp;
	float widt = Gdx.graphics.getWidth();
	float high = Gdx.graphics.getHeight();
	Stage mstage;
	
	Animation title;
	TextButton backtom;
	
	Beta game;
	float Uw,Uh;
	float time;
	//-----------
	public learn(final Beta game){
	this.game = game;
	
	backtom = new TextButton("back",game.loadin.nobuttonstyle);
	Uw = Gdx.graphics.getWidth()/100f;
	Uh = Gdx.graphics.getHeight()/100f;
	time = 0f;
	c = new OrthographicCamera();
	vp = new StretchViewport(widt,high,c);
	c.translate(widt/2,high/2);
	mstage = new Stage(vp){
		@Override
        public boolean keyDown(int keyCode) {
        if (keyCode == Keys.BACK) {
    		game.setScreen(game.meta);
			Gdx.input.setInputProcessor(game.meta.mstage);
        }
        return super.keyDown(keyCode);
    }
};
	float ratio3 = (float)game.loadin.NAbuttonstyle.imageUp.getMinHeight()/(float)game.loadin.NAbuttonstyle.imageUp.getMinWidth();
//	title = game.loadin.title;
	float scalin = (Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Uw : Uh );
	backtom.setBounds(Uw * 80f, Uh * 1f, ( scalin * 10f), ( scalin * 10f) * ratio3);
	
	mstage.addActor(backtom);
	batch = mstage.getBatch();
	Gdx.input.setInputProcessor(mstage);
	Gdx.input.setCatchBackKey(true);
	backtom.addListener(new ClickListener(){
		@Override
		public void clicked(InputEvent e, float x, float y){
			
			game.setScreen(game.meta);
			Gdx.input.setInputProcessor(game.meta.mstage);
		}
	});
	}
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0.6f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		c.viewportHeight = 400;
//		c.viewportWidth = 400;
		time += Gdx.graphics.getDeltaTime();
	
		mstage.act();

		
		batch.begin();
	
	batch.draw(game.loadin.back,-4f * Uw,0,300f * Uw , Uh * 100f);
	game.loadin.ifont.drawMultiLine(batch, 
			"	                              Instructions	\n"
			+ "Select Minions to summon to destroy the enemy castle\n\n"
			+ "Summoning Minions require mana which is regenerated every second\n\n"
			+ "Unlock new Minions,Turrets, and Magic by obtaining CASH after passing each stage\n\n"
			+ "Magic is used by first toggling the Magic button then tapping on the enemy\n\n"
			+ "Diamonds are obtained by REBUILDING your castle - Option is avaliable in Shop\n\n"
			+ "Diamonds can be used to FORTIFY your castle - Option is avaliable in Shop\n\n"
			+ "FORTIFY - magic and minion's health and damage are multiplied by 1.2x\n\n"
			+ "and your castle's health, mana, mana regeneration are also multiplied by 1.2x\n\n"
			+ "WARNING: If you REBUILD your castle, you return to the first stage \n"
			+ "but all minions,magic,turrets,upgrades,diamonds and cash are kept \n"
			+ "You must pass stage 10 to get ANY diamonds when you REBUILD\n"
			+ "or else you will not gain any diamonds and jump back to the first stage!\n"
			+ "								Status Effects\n "
			+ "Burn - Causes flat health damage over time\n"
			+ "Poison - Causes percent damage over time\n"
			+ "Freeze - Slows speed by 50%\n"
			+ "Shock - Burst damage over long intervals\n"
			

			+ "", Uw * 7f, Uh * 89f);
	//batch.draw(back,0,0,widt,high);
		batch.end();
		mstage.draw();
	

		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		vp.update(width, height);
		System.out.println(height + " " + Gdx.graphics.getHeight()+ "" + c.position);
		Uw = Gdx.graphics.getWidth()/100f;
		Uh = Gdx.graphics.getHeight()/100f;
		
		
		//c.setToOrtho(false,1f * aspectr,1f);
		
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
