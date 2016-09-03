package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class winloss implements Screen,InputProcessor{
	static Texture back;
	Batch batch;
	int won;
	OrthographicCamera c;
	Viewport vp;
	float widt = Gdx.graphics.getWidth();
	float high = Gdx.graphics.getHeight();
	Stage mstage;
	TextButton cont;
	TextButton backto;
	TextButton backtog;
	Beta game;
	float Uw,Uh;
	BitmapFont font;
	float  red,blue,green;
	int loot = 0;
	InputMultiplexer multi;
	
	//-------------------------------------
	public winloss(final Beta game){
	this.game = game;
	won = 0;
	backto = new TextButton("Exit",game.loadin.nobuttonstyle);
	backtog = new TextButton("Back",game.loadin.tbuttonstyle);
	cont = new TextButton("Continue",game.loadin.tbuttonstyle);
	multi = new InputMultiplexer();
	Uw = Gdx.graphics.getWidth()/100f;
	Uh = Gdx.graphics.getHeight()/100f;
	font = new BitmapFont();
	red = 0.4f;
	blue = 0.4f;
	green = 0.4f;
	c = new OrthographicCamera();
	vp = new StretchViewport(widt,high,c);
	c.translate(widt/2,high/2);
	mstage = new Stage(vp){
		@Override
        public boolean keyDown(int keyCode) {
        if (keyCode == Keys.BACK) {
    
        }
        return super.keyDown(keyCode);
    }
};
	float ratio3 = (float)game.loadin.NAbuttonstyle.imageUp.getMinHeight()/(float)game.loadin.NAbuttonstyle.imageUp.getMinWidth();

	float scalin = (Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Uw : Uh );
	cont.setBounds(Uw * 35f, Uh * 10f, ( scalin * 40f), ( scalin * 40f)*ratio3);
	//cont.getImageCell().expand().fill();
	backto.setBounds(Uw * 80f, Uh * 80f, ( scalin * 10f), ( scalin * 10f)*ratio3);
//	backto.getImageCell().expand().fill();
	backtog.setBounds(Uw * 35f, Uh * 10f, ( scalin * 30f), ( scalin * 30f)*ratio3);
//	backtog.getImageCell().expand().fill();
	
	
	mstage.addActor(backto);
	mstage.addActor(backtog);
	
	mstage.addActor(cont);
	batch = mstage.getBatch();
	//Gdx.input.setInputProcessor(mstage);
	cont.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
			System.out.println("hel");
			game.setScreen(game.shoppin);
			Gdx.input.setInputProcessor(game.shoppin.stage);
		}
	});
	backto.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
			game.setScreen(game.meta);
			Gdx.input.setInputProcessor(game.meta.mstage);
		}
	});
	backtog.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
			game.setScreen(game.shoppin.nextlevel);
			Gdx.input.setInputProcessor(game.meta.mstage);
			multi.clear();
			multi.addProcessor(game.shoppin.nextlevel.gdetect);
			multi.addProcessor(game.shoppin.nextlevel.stage);
			Gdx.input.setInputProcessor(multi);
		}
	});
	
	 Gdx.input.setCatchBackKey(true);
	}
	
	@Override
	public void render(float delta) {

		if(game.gserv.rtnloadedint() == true && game.save.iapbought == false && Math.random() >= 0.6){
			game.gserv.showads();
		}
		Gdx.gl.glClearColor(red, blue, green, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		

		
		mstage.act();
	
		
		batch.begin();
		if(won == 0){
			red = 1f;
			blue = 0f;
			green = 0f;
			game.loadin.bbfont.draw(batch,"DEFEAT", 5f * Uw, 80f * Uh);
			cont.setVisible(false);
			backtog.setVisible(false);
			game.shoppin.nextlevel.dispose();
		}else if (won == 1){
			red = 0.4f;
			blue = 1f;
			green = 1f;
			game.loadin.bbfont.draw(batch,"VICTORY", 5f * Uw, 80f * Uh);
			game.loadin.lfont.draw(batch,"Loot acquired:" + loot, 5f * Uw, 84f * Uh);
			backtog.setVisible(false);
			cont.setVisible(true);
		}else if (won == 2){
			red = 0.5f;
			blue = 0.5f;
			green = 0.5f;
			game.loadin.bbfont.draw(batch,"PAUSED", 10f * Uw, 80f * Uh);
			cont.setVisible(false);
			backtog.setVisible(true);
		}
		game.loadin.lfont.draw(batch, "Current Stage: " + game.save.level.toString(), 5f * Uw, 90f * Uh);
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
