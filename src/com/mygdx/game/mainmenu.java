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
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class mainmenu implements Screen,InputProcessor{
	static Texture back;
	Batch batch;
	boolean connected = false;
	OrthographicCamera c;
	Viewport vp;
	float widt = Gdx.graphics.getWidth();
	float high = Gdx.graphics.getHeight();
	Stage mstage;
	TextButton play;
	TextButton mitemshop;
	ImageButton gplus;
	Animation title;
	ImageButton qmark;
	ImageButton rank;
	ImageButton trophy;
	String[][] things;
	Beta game;
	float Uw,Uh;
	float time;
	
	public mainmenu(final Beta game){
	this.game = game;
	connected = game.gserv.returnIn();
	//things = game.gserv.getdetail();
	gplus = new ImageButton(game.loadin.ginstyle);
	play = new TextButton("Play",game.loadin.tbuttonstyle);
	mitemshop = new TextButton("Shop",game.loadin.tbuttonstyle);
	qmark = new ImageButton(game.loadin.qmarkstyle);
	rank = new ImageButton(game.loadin.rankbuttonstyle);
	trophy = new ImageButton(game.loadin.trophybuttonstyle);
	
	Uw = Gdx.graphics.getWidth()/100f;
	Uh = Gdx.graphics.getHeight()/100f;
	time = 0f;
	c = new OrthographicCamera();
	vp = new StretchViewport(widt,high,c);
	c.translate(widt/2,high/2);
	mstage = new Stage(vp);
	float ratio3 = (float)game.loadin.NAbuttonstyle.imageUp.getMinHeight()/(float)game.loadin.NAbuttonstyle.imageUp.getMinWidth();
	title = game.loadin.title;
	float scalin = (Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Uw : Uh );
	play.setBounds(Uw * 36.5f, Uh * 32f, ( scalin * 27f), ( scalin * 27f)*ratio3);
	
	mitemshop.setBounds(Uw * 38f, Uh * 2f, ( scalin * 24f), ( scalin * 22f)*ratio3);
	//play.().expand().fill();
	gplus.setBounds(Uw * 80f, Uh * 1f, ( scalin * 15f), ( scalin * 15f)*ratio3);
	gplus.getImageCell().expand().fill();
	
	rank.setBounds(Uw *2f, Uh * 1f, ( scalin * 8f), ( scalin * 16f));
	rank.getImageCell().expand().fill();
	trophy.setBounds(Uw * 13f, Uh * 3f, ( scalin * 5f), ( scalin * 10f));
	trophy.getImageCell().expand().fill();
	
	qmark.setBounds(Uw * 1f, Uh * 50f, ( scalin * 10f), ( scalin * 10f));
	qmark.getImageCell().expand().fill();
	mstage.addActor(mitemshop);
	mstage.addActor(rank);
	mstage.addActor(trophy);
	mstage.addActor(gplus);
	mstage.addActor(qmark);
	
	mstage.addActor(play);
	batch = mstage.getBatch();
	Gdx.input.setInputProcessor(mstage);
	Gdx.input.setCatchBackKey(true);
	qmark.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
		//	System.out.println("hel");
			//game.gserv.showachieve();
			game.setScreen(game.mlearn);
			Gdx.input.setInputProcessor(game.mlearn.mstage);
			//game.gserv.buythis("diamond100");
	//		Gdx.input.setInputProcessor(game.shoppin.stage);
		}
	});
	mitemshop.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
			game.setScreen(game.mitemshop);
			Gdx.input.setInputProcessor(game.mitemshop.mstage);
		}
	});
	rank.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
		//	System.out.println("hel");
			if(connected == true){
				game.gserv.showleader();
			}else{
				game.gserv.siin();
			}
	//		Gdx.input.setInputProcessor(game.shoppin.stage);
		}
	});
	trophy.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
		//	System.out.println("hel");
			if(connected == true){
				game.gserv.showachieve();
			}else{
				game.gserv.siin();
			}
	//		Gdx.input.setInputProcessor(game.shoppin.stage);
		}
	});
	play.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
		//	System.out.println("hel");
			game.setScreen(game.shoppin);
			Gdx.input.setInputProcessor(game.shoppin.stage);
		}
	});
	gplus.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
			if(connected == false){
			game.gserv.siin();
			}else if(connected == true){
			game.gserv.siout();
			}
		}
	});
	}
	public void achievements(){
		if(connected == true){
			if(game.save.mlevel >0){
				game.gserv.unlachieve(game.a1);
			}
			if(game.save.money >= 1000000){
				game.gserv.unlachieve(game.a2);
			}
			if(game.save.fortify >= 5){
				game.gserv.unlachieve(game.a7);
			}
			if(game.save.diamond >0){
				game.gserv.unlachieve(game.a8);
			}
			if(game.save.mlevel > 10){
				game.gserv.unlachieve(game.a9);
			}
			if(game.save.mlevel > 40){
				game.gserv.unlachieve(game.a10);
			}
			if(game.save.mlevel > 80){
				game.gserv.unlachieve(game.a11);
			}
			if(game.save.money ==0){
				game.gserv.unlachieve(game.a12);
			}
			
		}
	}
	float subscoredelay = 0f;
	float addelay = 20f;
	float addelay1 = 40f;
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.6f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(game.save.iapbought == false){
		if(addelay < 0 && game.gserv.rtnloadedint() == false){
			game.gserv.showads();
			addelay = 20f;
		}else{
			addelay -= Gdx.graphics.getDeltaTime();
		}
		if(addelay1 < 0 && game.gserv.rtnloadedint() == true){
			game.gserv.showads();
			addelay1 = 40f;
		}else{
			addelay1 -= Gdx.graphics.getDeltaTime();
		}
		}
		connected = game.gserv.returnIn();
		if(connected == true){
			gplus.setStyle(game.loadin.goutstyle);
		}else{
			gplus.setStyle(game.loadin.ginstyle);
		}
		if(subscoredelay <= 0 && connected == true){
			game.gserv.subscore(game.l1,game.save.level);
			game.gserv.subscore(game.l2, game.save.fortify);
			subscoredelay = 20f;
		}else{
			subscoredelay -= Gdx.graphics.getDeltaTime();
		}
		achievements();
//		c.viewportHeight = 400;
//		c.viewportWidth = 400;
		time += Gdx.graphics.getDeltaTime();
		
		mstage.act();

		
		batch.begin();

	batch.draw(title.getKeyFrame(time, true),0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	game.loadin.bbfont.draw(batch, "Castle War", Uw * 7f, Uh * 91f);
	game.loadin.llfont.draw(batch, "best record stage: " + game.save.mlevel,Uw * 70f ,Uh * 30f );
	game.loadin.llfont.draw(batch, "next stage: " + game.save.level, Uw * 75f, Uh * 25f);
	//batch.draw(back,0,0,widt,high)
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
	     if(keycode == Keys.BACK){
	    	 game.setScreen(game.meta);
				Gdx.input.setInputProcessor(game.meta.mstage);
	        }
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
