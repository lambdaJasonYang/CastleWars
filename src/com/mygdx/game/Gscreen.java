package com.mygdx.game;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Gscreen implements Screen,GestureListener {
	int allyqueuecount = 0;
	int minionqueuecount = 0;
	int gruntid = 0;
	float time = 0;
	Beta game;
	Boolean allyenemy = false;
	SpriteBatch batch;
	public static int counterd = 0;
	OrthographicCamera cam;
	float keycooldown = 2;
	//Rectangle a;
	//Rectangle b;
	int iX = 0;
	ShapeRenderer c;

	ArrayList<grunt> grunts = new ArrayList<grunt>();
	ArrayList<castle> allcastles = new ArrayList<castle>();
	ArrayList<Object> dead = new ArrayList<Object>();

	
	
	static Texture back;
	Animation ggg;
	Texture button;
	castle gcas, ecas;

	shopbutton buttin;
	shopbutton buttin2;
	shopbutton buttin3;
	shopbutton buttin4;
	shopbutton buttin5;
	
	shopbutton mbuttin;
	
	Stage stage;
	ImageButtonStyle bstyle1 = new ImageButtonStyle();
	ImageButtonStyle bstyle2 = new ImageButtonStyle();
	ImageButtonStyle bstyle3 = new ImageButtonStyle();
	ImageButtonStyle bstyle4 = new ImageButtonStyle();
	ImageButtonStyle bstyle5 = new ImageButtonStyle();
	
	ImageButtonStyle mstyle = new ImageButtonStyle();
	
	ImageButton pause;
	
	ArrayList<shopbutton> allbuttons = new ArrayList<shopbutton>();
	InputMultiplexer multip;
	Boolean touchatk = false;
	float touchatkdelay = 0;
	Vector3 worldcoor = new Vector3(0,0,0);
	float aspectratio;
	ExtendViewport viewp;
	Sprite backg;
	float Uw = Gdx.graphics.getWidth()/100;
	float Uh = Gdx.graphics.getHeight()/100;
	float backpos = 0;
	Texture blast;
	
	Map<String, Method> myppl = new HashMap<String, Method>();
	Map<String, grunt> notmyppl = new HashMap<String, grunt>();
	ArrayList<bullet> bullets = new ArrayList<bullet>();
	ArrayList<bullet> deadbullets = new ArrayList<bullet>();
	GestureDetector gdetect = new GestureDetector(this);
	Assetloader loadin;
	StretchViewport vp;
	Gscreen myself;
	int maxmp;
	int curmp;
	int maxmpr;
	int maxhp;
	float b1delay;
  	float b2delay;
	float b3delay;
	float b4delay;
	float b5delay;
	float mdelay;
	
	float fmultiplyer;
	ShapeRenderer hpshape;


	int clevel;
	public Gscreen (final Beta game, final boolean multiplayer) {
		
		backpos = 300f * Uw;
		myself = this;

		loadin = game.loadin;
		back = loadin.back;
	
		fmultiplyer = (float) (Math.pow(1.2f,game.save.fortify)); 
		maxmp = Math.round(game.save.maxmp);
		curmp = maxmp;
		maxhp = Math.round(game.save.maxhp);
		maxmpr = Math.round(game.save.maxmpr);
		
	
		cam = new OrthographicCamera();
//		clevel = this.game.save.level;
		stage = new Stage(){
			@Override
	        public boolean keyDown(int keyCode) {
	        if (keyCode == Keys.BACK) {
	        	game.wlscreen.won = 2;
				game.setScreen(game.wlscreen);
				Gdx.input.setInputProcessor(game.wlscreen.mstage);
	        }
	        return super.keyDown(keyCode);
	    }
	};
		//cam = (OrthographicCamera) stage.getCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		vp = new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),cam);
		cam.translate(allyenemy ? backpos - (110f * Uw):(10f * Uw), 0);

		pause = new ImageButton(loadin.pausestyle);	
		
		bstyle1.imageUp = game.shoppin.buttoni1.getStyle().imageUp;
		bstyle1.imageDown = game.shoppin.buttoni1.getStyle().imageDown;
		bstyle2.imageUp = game.shoppin.buttoni2.getStyle().imageUp;
		bstyle2.imageDown = game.shoppin.buttoni2.getStyle().imageDown;
		bstyle3.imageUp = game.shoppin.buttoni3.getStyle().imageUp;
		bstyle3.imageDown = game.shoppin.buttoni3.getStyle().imageDown;
		bstyle4.imageUp = game.shoppin.buttoni4.getStyle().imageUp;
		bstyle4.imageDown = game.shoppin.buttoni4.getStyle().imageDown;
		bstyle5.imageUp = game.shoppin.buttoni5.getStyle().imageUp;
		bstyle5.imageDown = game.shoppin.buttoni5.getStyle().imageDown;
		
		mstyle.imageUp = game.shoppin.magicbutton.getStyle().imageUp;
		mstyle.imageDown = game.shoppin.magicbutton.getStyle().imageDown;
		
//		buttin = new ImageButton(game.shoppin.button1.getStyle());
		buttin = new shopbutton(bstyle1);
		buttin2 = new shopbutton(bstyle2);
		buttin3 = new shopbutton(bstyle3);
		buttin4 = new shopbutton(bstyle4);
		buttin5 = new shopbutton(bstyle5);
		
		mbuttin = new shopbutton(mstyle);
		
		buttin.eqslot = game.shoppin.buttoni1.eqslot;
		buttin2.eqslot = game.shoppin.buttoni2.eqslot;
		buttin3.eqslot = game.shoppin.buttoni3.eqslot;
		buttin4.eqslot = game.shoppin.buttoni4.eqslot;
		buttin5.eqslot = game.shoppin.buttoni5.eqslot;
		
		mbuttin.eqslot = game.shoppin.magicbutton.eqslot;
		float scalin = (Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Uw : Uh );
		float butpos = Gdx.graphics.getWidth()/8f;
		float bratio = (float)bstyle1.imageDown.getMinHeight()/(float)bstyle1.imageDown.getMinWidth();
		
		buttin.setBounds(Uw * 10f, Uh * 6f, scalin * 10f, (scalin * 10f) * bratio);
		buttin.getImageCell().expand().fill();
		buttin2.setBounds(butpos + (Uw * 10f), Uh * 6f, scalin * 10f, (scalin * 10f) * bratio);
		buttin2.getImageCell().expand().fill();
		buttin3.setBounds(butpos * 2f + (Uw *10f), Uh * 6f,  scalin * 10f, (scalin * 10f) * bratio);
		buttin3.getImageCell().expand().fill();
		buttin4.setBounds(butpos * 3f+ (Uw * 10f), Uh * 6f, scalin * 10f, (scalin * 10f) * bratio);
		buttin4.getImageCell().expand().fill();
		buttin5.setBounds(butpos * 4f+ (Uw * 10f)  , Uh * 6f, scalin * 10f, (scalin * 10f) * bratio);
		buttin5.getImageCell().expand().fill();
		
		mbuttin.setBounds(Gdx.graphics.getWidth() - mbuttin.getWidth() - (Uw * 3f) , Uh * 6f, scalin * 10f, (scalin * 10f) * bratio);
		mbuttin.setPosition(Gdx.graphics.getWidth() - mbuttin.getWidth() - (Uw * 3f) , Uh * 6f);
		mbuttin.getImageCell().expand().fill();
		
		
		pause.setBounds((Uw * 100f - pause.getWidth()), Uh * 90f, scalin * 5f, scalin * 5f);
		pause.setPosition(((Uw * 100f)  ), Uh * 90f);
		pause.getImageCell().expand().fill();
		
		//allbuttons.add(mbuttin);
		
		allbuttons.add(buttin);
		allbuttons.add(buttin2);
		allbuttons.add(buttin3);
		allbuttons.add(buttin4);
		allbuttons.add(buttin5);
		stage.addActor(buttin);
		stage.addActor(buttin2);
		stage.addActor(buttin3);
		stage.addActor(buttin4);
		stage.addActor(buttin5);

		stage.addActor(mbuttin);

		stage.addActor(pause);
		
		this.game = game;
		c = new ShapeRenderer();
		hpshape = new ShapeRenderer();
		batch = new SpriteBatch();
		enemycastlesummon();
		gcas = new castle(maxhp,false,0,loadin.mycastleAnim,batch, this, game.shoppin.turretabutton.eqslot,game.shoppin.turretbbutton.eqslot);
		allcastles.add(ecas);
		allcastles.add(gcas);
//		if(allyenemy == false){
//			turret1 = new turret(this,new Vector2(5,5), false, loadin.blast,0.3f,1);
//		}	
		
		
		
		multip = new InputMultiplexer();
		multip.addProcessor(game.shoppin.stage);
		multip.addProcessor(game.shoppin); 
		multip.addProcessor(gdetect);
		
		Gdx.input.setInputProcessor(multip);
		game.setScreen(game.shoppin);
//String monster, Boolean allyenemy,float hp,float damage,float rSpeedPure,float range, String statatk, int hitnumber		
			
//	
//		buttin.rdelay = loadin.mapdata.get(buttin.eqslot)[8];
//		buttin2.rdelay = loadin.mapdata.get(buttin.eqslot)[8];
//		buttin3.rdelay = loadin.mapdata.get(buttin.eqslot)[8];
//		buttin4.rdelay = loadin.mapdata.get(buttin.eqslot)[8];
//		buttin5.rdelay = loadin.mapdata.get(buttin.eqslot)[8];
		//mbuttin.rdelay = loadin.mapdata.get(buttin.eqslot)[8];
		
		if(mbuttin.eqslot != "none"){
			mbuttin.rdelay = loadin.mapdata.get(mbuttin.eqslot)[4];
		}
	for(final shopbutton i: allbuttons){
		if(i.eqslot != "none"){
			i.rdelay = loadin.mapdata.get(i.eqslot)[8];
		}
		i.addListener(new ClickListener(){	
			@Override
			public void clicked(InputEvent e, float x, float y){
				//height, range
//				
//				grunts.add(myppl.get(i.eqslot));
				
				if(i.eqslot != "none" && curmp >= loadin.mapdata.get(i.eqslot)[7] ){
				//if(host == false && multiplayer == true){
			//		writebyte(1,i.eqslot);
					
					Float[] gdata = loadin.mapdata.get(i.eqslot);
					if(i.delay <= 0){
						//float hp,float damage,float rSpeedPure,float range, float statatk, float hitnumber
				grunts.add(new grunt(myself,gdata[9],new soul(i.eqslot,allyenemy,gdata[0] * fmultiplyer,gdata[1] * fmultiplyer,gdata[2],gdata[3],gdata[4],gdata[5],gdata[6])));
			
				curmp -= gdata[7];
				i.delay = i.rdelay;
			
					
				
				
				}
				}
				 
	
			}
		});
		
		mbuttin.addListener(new ClickListener(){	
			@Override
			public void clicked(InputEvent e, float x, float y){

			
				if(mbuttin.eqslot != "none"){
					if(mbuttin.checked == true){
						mbuttin.checked = false;
					}else{
						mbuttin.checked = true;
					}
				}	
			}
		});
		
		pause.addListener(new ClickListener(){	
			@Override
			public void clicked(InputEvent e, float x, float y){

			
				//game.save.level += 1;
				game.wlscreen.won = 2;
				game.setScreen(game.wlscreen);
				Gdx.input.setInputProcessor(game.wlscreen.mstage);
			}
		});
	}	
	 Gdx.input.setCatchBackKey(true);
	keycooldown = 51;
	}
	
	
	float touchx = 0;
	float touchy= 0;
	
	

	float spdelay = 0.2f;
	@Override	
	public void render (float delta) {

		//viewp.update(game.camwid,game.camhei,true);
		winlose();
		backpos = Uw * 300f;
		time += Gdx.graphics.getDeltaTime();
	
		keycooldown += Gdx.graphics.getDeltaTime();
		cam.translate(iX,0);
		cam.update();
		
//		if(keycooldown > 50){
//			keycooldown = 0;
//			grunts.add(new grunt(myself,new soul("skelly", !allyenemy), 20, 7));
//		}
		
		vp.apply();
		batch.setProjectionMatrix(vp.getCamera().combined);
		stage.act();
		
		c.setProjectionMatrix(cam.combined);
		hpshape.setProjectionMatrix(cam.combined);
		hpshape.begin(ShapeType.Filled);
		batch.begin();
	
			batch.draw(back,0,0,backpos , Uh * 100f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		  c.begin(ShapeType.Filled);
		  c.setColor(Color.PURPLE);
		  if(mbuttin.checked == true){
			  c.rect(cam.unproject(new Vector3(mbuttin.getX(),0,0)).x - (0.6f * Uw), mbuttin.getY() - (0.6f * Uh), mbuttin.getWidth() + (1.2f * Uw),mbuttin.getHeight() + (1.2f * Uh));
		  }
		 
		  updater();
		  loadin.lfont.draw(batch,"Summon Minion",cam.unproject(new Vector3(buttin.getX(),0,0)).x, buttin.getY() + buttin.getHeight() * 1.55f); 
		  loadin.lfont.draw(batch,"Magic",cam.unproject(new Vector3(mbuttin.getX(),0,0)).x, buttin.getY() + buttin.getHeight() * 1.55f); 
		  loadin.ifont.draw(batch,"HP:"+ gcas.hp,cam.unproject(new Vector3(Uw,0,0)).x, 98f * Uh); 
		  loadin.ifont.draw(batch,"MP:"+ curmp,cam.unproject(new Vector3(Uw,0,0)).x, 93f * Uh); 
		  loadin.ifont.draw(batch,"Enemy HP:"+ ecas.hp,cam.unproject(new Vector3(Uw * 66f,0,0)).x, 98f * Uh); 
		//  c.rect(buttin.getX(),buttin.getY(),buttin.getWidth(),buttin.getHeight());
		summoning();
		
		
		batch.end();
		c.end();
		hpshape.end();
		stage.draw();
		mregen();
		batch.begin();
		buttontimer();
		batch.end();
		
	}

	float regendelay = 1f;
	public void mregen(){
		if(regendelay <= 0){
			curmp += maxmpr;
			if(curmp >= maxmp){
				curmp = maxmp;
			}
			regendelay = 1f;
			}else{
				regendelay -= Gdx.graphics.getDeltaTime();
			}
	}

	public void buttontimer(){
		if(!mbuttin.eqslot.equals("none")){
			mbuttin.delay -= Gdx.graphics.getDeltaTime();
			if(mbuttin.delay >= 0){
				loadin.lfont.draw(batch, String.valueOf((int)Math.ceil(mbuttin.delay)), cam.unproject(new Vector3(mbuttin.getX() + mbuttin.getWidth()/2f,0f,0f)).x, mbuttin.getY() + mbuttin.getHeight()/2f);
				}	
		}
		
		for(shopbutton i: allbuttons){
			if(!i.eqslot.equals("none")){
		i.delay -=Gdx.graphics.getDeltaTime();
		if(i.delay >= 0){
		loadin.lfont.draw(batch, String.valueOf((int)Math.ceil(i.delay)), cam.unproject(new Vector3(i.getX() + i.getWidth()/2f,0f,0f)).x, i.getY() + i.getHeight()/2f);
		
			}	
		}
	}
	}
	int loot;
	public void winlose(){
		if(ecas.hp <= 0){
			ecas.hp = 0;
			loot = (int)((game.save.level * 1000f) *(Math.random()));
			game.save.money += loot;
			if(game.save.level > game.save.mlevel){
				game.save.mlevel = game.save.level;
			}
			game.save.level += 1;
			game.saver.persist();
			
			if(game.gserv.returnIn() == true){
			game.gserv.subscore(game.l1,game.save.level);
			}
			game.wlscreen.won = 1;
			game.wlscreen.loot = loot;
			game.setScreen(game.wlscreen);
			Gdx.input.setInputProcessor(game.wlscreen.mstage);
		}else if (gcas.hp <= 0){
			gcas.hp = 0;
			if(game.save.level > game.save.mlevel){
			game.save.mlevel = game.save.level;
			}
			//game.save.level = 1;
			game.saver.persist();
			game.wlscreen.won = 0;
			game.setScreen(game.wlscreen);
			Gdx.input.setInputProcessor(game.wlscreen.mstage);
		}
		
		
	}
	
	float sdelay = 0;
	float summondelay = 2f;
	public void summoning(){
		switch(game.save.level){
		case 1:
			sdelay = (float) (Math.random() * 10f) + 20f;
			String[] bagom = {"slime"};
			summonfun(sdelay,bagom);
			break;
		}
		if(game.save.level > 1 && game.save.level < 10){
			sdelay = (float) (Math.random() * 15f) + 8f/(game.save.level * 2f) + 5f;
			String[] bagom = {"skelly","slime"};
			summonfun(sdelay,bagom);
		}else if(game.save.level >= 10 && game.save.level < 20){
			sdelay = (float) (Math.random() * 13f) + 7f/(game.save.level * 2f) + 5f;
			String[] bagom = {"knight","skelly","slime","rusty"};
			summonfun(sdelay,bagom);
		}else if(game.save.level >= 20 && game.save.level < 30){
			sdelay = (float) (Math.random() * 15f) + 6f/(game.save.level * 2f) + 3f;
			String[] bagom = {"knight","skelly","slime","plant","phar","cyborg","rusty","mum"};
			summonfun(sdelay,bagom);
		}else if(game.save.level >= 40 && game.save.level < 50){
			sdelay = (float) (Math.random() * 14f) + 6f/(game.save.level * 2f) + 2f;
			String[] bagom = {"knight","skelly","slime","plant","phar","cyborg","baller","rusty","mum","ghost"};
			summonfun(sdelay,bagom);
		}else if(game.save.level >= 50 && game.save.level < 60){
			sdelay = (float) (Math.random() * 14f) + 6f/(game.save.level * 2f) + 1f;
			String[] bagom = {"knight","skelly","slime","plant","phar","cyborg","baller","gmaster","rusty","mum","ghost","squirt"};
			summonfun(sdelay,bagom);
		}else if(game.save.level >= 60 && game.save.level < 70){
			sdelay = (float) (Math.random() * 14f) + 5f/(game.save.level * 2f);
			String[] bagom = {"knight","skelly","slime","plant","phar","cyborg","baller","gmaster","eye","rusty","mum","ghost","squirt"};
			summonfun(sdelay,bagom);
		}else if(game.save.level >= 70 && game.save.level < 80){
			sdelay = (float) (Math.random() * 14f) + 5f/(game.save.level * 2f);
			String[] bagom = {"knight","skelly","slime","plant","phar","cyborg","baller","gmaster","eye","tank","rusty","mum","ghost","squirt"};
			summonfun(sdelay,bagom);
		}else if(game.save.level >= 80){
			sdelay = (float) (Math.random() * 10f) + 5f/(game.save.level * 2f);
			String[] bagom = {"knight","skelly","slime","plant","phar","cyborg","baller","gmaster","eye","tank","indra","rusty","mum","ghost","squirt"};
			summonfun(sdelay,bagom);
		}
	}
		public void enemycastlesummon(){
			String rturrets[] = {"flamet","frozent","poisont","lightningt"};
			int t1 = new Random().nextInt(rturrets.length);
			int t2 = new Random().nextInt(rturrets.length);
			if(game.save.level < 10){
			ecas = new castle(150 + (game.save.level * 30),true,backpos,loadin.enemycastleAnim,batch, this, "none","none");
			}else if(game.save.level >= 10 && game.save.level < 20){
				ecas = new castle(150 + (game.save.level * 50),true,backpos,loadin.enemycastleAnim,batch, this, rturrets[t1],"none");	
			}else if(game.save.level >= 20 && game.save.level < 30){
				ecas = new castle(150 + (game.save.level * 80),true,backpos,loadin.enemycastleAnim,batch, this, rturrets[t1],"none");	
			}else if(game.save.level >= 30 && game.save.level < 40){
				ecas = new castle(150 + (game.save.level * 120),true,backpos,loadin.enemycastleAnim,batch, this, rturrets[t1],rturrets[t1]);	
			}else if(game.save.level >= 40 && game.save.level < 50){
				ecas = new castle(150 + (game.save.level * 170),true,backpos,loadin.enemycastleAnim,batch, this, rturrets[t1],rturrets[t2]);	
			}else if(game.save.level >= 50){
				ecas = new castle(150 + (game.save.level * 250),true,backpos,loadin.enemycastleAnim,batch, this, rturrets[t1],rturrets[t2]);	
			
			}
			}

	public void summonfun(float delayin, String[] groupofm){
		if(summondelay <=0){
			String monst = groupofm[new Random().nextInt(groupofm.length)];
			//String monst = "cyborg";
			Float[] gdata = game.loadin.mapdata.get(monst);
			grunts.add(new grunt(myself,gdata[9],new soul(monst,!allyenemy,gdata[0],gdata[1],gdata[2],gdata[3],gdata[4],gdata[5],gdata[6])));
	summondelay = delayin;
		}else{summondelay -= Gdx.graphics.getDeltaTime();
	}
	}
	float deadcleardelay = 0.01f;
	public void updater(){
		//time += Gdx.graphics.getDeltaTime();
		if(touchatkdelay > 0){
			touchatkdelay -= Gdx.graphics.getDeltaTime();
		}
		
		//c.rect(touchx - 20f+cam.position.x - cam.viewportWidth/2,Gdx.graphics.getHeight() -touchy - (Gdx.graphics.getHeight() * 1.5f),40f,Gdx.graphics.getHeight()*3);  
		for(castle b: allcastles){
				//c.setColor(Color.RED);
 			  	//c.rect(b.self.x,b.self.y,b.self.getWidth(),b.self.getHeight());
				b.update();
				if(b.hp <= 0){
					dead.add(b);
					b = null;
				}		
		  }

		
		
		for (grunt b: grunts){
			b.update();
					
//					c.setColor(Color.BLUE);
//					c.rect(b.targetbox.x,b.targetbox.y,b.targetbox.getWidth(),b.targetbox.getHeight());
//					c.setColor(Color.RED);
//					c.rect(b.self	 .x,b.self.y,b.self.getWidth(),b.self.getHeight());
//					c.rect(b.stopbox.x,b.stopbox.y,b.stopbox.getWidth(),b.stopbox.getHeight());
					if(b.gsoul.hp <= 0 && b.bedead == true){
				
						dead.add(b);
						
						b = null;
					}	
					//batch.draw(loadin.lightning.getKeyFrame(time,true), 100f,20f,20f,1000f);
		}
		
		for(bullet i:bullets){
			if(i.target != null){
			batch.draw(i.bulletpic, i.position.x,i.position.y,Uh * 20,Uh * 20);
			i.update();
			
			if(i.dead == true || i.target == null){
				dead.add(i);
				i = null;
			}
			}
			//c.rect(i.position.x,i.position.y,10,10);
		}
		if(deadcleardelay <= 0){
		for (Object d: dead){
			grunts.remove(d);
			allcastles.remove(d);
			bullets.remove(d);
			//ecastles.remove(d);
		}
		dead.clear();
		deadcleardelay = 0.2f;
		
		}else{
			deadcleardelay -= Gdx.graphics.getDeltaTime();
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resize(int width, int height) {
		vp.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Uw = Gdx.graphics.getWidth()/100f;
		Uh = Gdx.graphics.getHeight()/100f;
		pause.setPosition(((Uw * 98f) - pause.getWidth()  ), Uh * 90f);
		for(grunt i: grunts){
			i.resize();
		}
		for(castle i: allcastles){
			i.resize();
		}
		
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
		this.dispose();
	}
	@Override
	public void dispose() {
		//this.dispose();
		//this.stage.dispose();
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		
		return false;
	}


	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
	
		worldcoor.set(x,y,0);
		cam.unproject(worldcoor);
//		if(grunts.size() > 0){
//			bullets.add(new bullet(new Vector2(worldcoor.x,worldcoor.y), grunts.get(0) ,true,loadin.blast));
//			}
		//touchx = (screenX +cam.position.x - cam.viewportWidth/2);
		touchx = worldcoor.x;
		touchy = worldcoor.y;
		if(mbuttin.eqslot != "none" && mbuttin.checked == true && curmp >= loadin.mapdata.get(mbuttin.eqslot)[3]){
			
				for(grunt i: grunts){
					if(i.allyenemy != allyenemy){
					if(touchx >= i.gsoul.PosX && touchx <= i.gsoul.PosX + i.self.width && touchy >= i.gsoul.PosY && touchy <= i.gsoul.PosY + i.self.height){
						if(mbuttin.delay <= 0){
							mbuttin.delay = mbuttin.rdelay;
							curmp -= loadin.mapdata.get(mbuttin.eqslot)[3];	
							loadin.lightnsfx.play();
							i.tapped = true;
				System.out.println("hit" +i.gsoul.PosX+ " o" + touchy/Uh); 
				i.gsoul.hp -= (fmultiplyer * loadin.mapdata.get(mbuttin.eqslot )[0] );
				addel(i.gsoul, loadin.mapdata.get(mbuttin.eqslot )[1]);
				i.gsoul.hitnumber = loadin.mapdata.get(mbuttin.eqslot )[2];
			
			
				//attkg.inflictedstatus.add("poison");
						}
			}
		}
		}
		}
		
		return false;
	}
	public void addel(soul asoul, Float num){
		if(!asoul.inflictedstatus.contains(num)){
			asoul.inflictedstatus.add(num);
		}
	}
	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub

		return false;
	}


	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		
		if(cam.position.x >= (Uw * 51f) && cam.position.x <= (backpos - (Uw * 31f))){
		cam.translate(deltaX, 0);
		}
		if (cam.position.x < (Uw * 51f) ){
			cam.translate((Uw * 51f)- cam.position.x, 0);
		}
		if (cam.position.x > (backpos - (Uw * 51f))){
			cam.translate((backpos - (Uw * 51f)) - cam.position.x ,0);
		}
		cam.update();
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}


}

