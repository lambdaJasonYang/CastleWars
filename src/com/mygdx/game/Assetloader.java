package com.mygdx.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Assetloader {

	Animation aaa;
	Animation hiteff;
	static Texture back;
	Animation ggg;
	Texture button;
	
	
	
	Map<String, Animation[]> mapanim = new HashMap<String, Animation[]>();
	Map<String, Float[]> mapdata = new HashMap<String, Float[]>();
	Map<String, Texture[]> maptur = new HashMap<String, Texture[]>();	
	
	TextureAtlas enemycastle;
	TextureAtlas enemycastlehurt;
	TextureAtlas mycastle;
	TextureAtlas mycastlehurt;
	Animation enemycastleAnim;
	Animation mycastleAnim;
	Animation enemycastlehurtAnim;
	Animation mycastlehurtAnim;
	
	
	Animation minionmove;
	Animation minionatk;
	Animation gmastermove;
	Animation gmasteratk;
	Animation cyborgmove;
	Animation cyborgatk;
	Animation cyborgatkr;
	Animation knightmove;
	Animation knightatk;
	Animation skellymove;
	Animation skellyatk;
	Animation skellyatkr;
	Animation slimemove;
	Animation slimeatk;
	Animation treeminionmove;
	Animation treeminionatk;
	Animation treeminionatkr;
	Animation rustymove;
	Animation rustyatk;
	Animation ghostmove;
	Animation ghostatk;
	Animation plantmove;
	Animation plantatk;
	Animation ballermove;
	Animation balleratk;
	Animation eyemove;
	Animation eyeatk;
	Animation squirtmove;
	Animation squirtatk;
	Animation mummove;
	Animation mumatk;
	Animation pharmove;
	Animation pharatk;
	Animation tankmove;
	Animation tankatk;
	Animation indramove;
	Animation indraatk;
	
	Animation normalhit;
	
	Texture flameturret;
	Texture frozenturret;
	Texture poisonturret;
	Texture lightningturret;
	
	Texture fball;
	Texture frball;
	Texture lball;
	Texture pball;
	
	TextureAtlas flamefx;
	Animation flame;
	TextureAtlas icefx;
	Animation frozen;
	TextureAtlas poisonfx;
	Animation poison;
	TextureAtlas lightfx;
	Animation light;
	
	TextureAtlas shothit;
	Animation shot;
	
	Animation title;
	
	
	Skin nobutton;
	Skin yesbutton;
	Skin NAbutton;
	Skin knightbutton;
	Skin slimebutton;
	Skin skellybutton;
	Skin cyborgbutton;
	Skin grandmasterbutton;
	Skin treeminionbutton;
	Skin rustybutton;
	Skin ghostbutton;
	Skin plantbutton;
	Skin ballerbutton;
	Skin eyebutton;
	Skin squirtbutton;
	Skin mumbutton;
	Skin pharbutton;
	Skin tankbutton;
	Skin indrabutton;	
	Skin flametbutton;
	Skin freezetbutton;
	Skin poisontbutton;
	Skin lightningtbutton;
	
	Skin cashbutton;
	TextButtonStyle cashbuttonstyle = new TextButtonStyle();
	
	Skin lightningtouchbutton;
	ImageButtonStyle lightningtouchstyle = new ImageButtonStyle();
	Skin poisontouchbutton;
	ImageButtonStyle poisontouchstyle = new ImageButtonStyle();
	Skin fingertouchbutton;
	ImageButtonStyle fingertouchstyle = new ImageButtonStyle();
	Skin bombtouchbutton;
	ImageButtonStyle bombtouchstyle = new ImageButtonStyle();
	
	
	Skin playbutton;
	Skin pausebutton;
	Skin ginbutton;
	Skin goutbutton;
	
	Skin hpbutton;
	Skin mpbutton;
	Skin qmarkbutton;
	Skin rankbutton;
	Skin trophybutton;

	ImageButtonStyle rankbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle trophybuttonstyle = new ImageButtonStyle();
	TextButtonStyle nobuttonstyle = new TextButtonStyle();
	TextButtonStyle yesbuttonstyle = new TextButtonStyle();
	ImageButtonStyle NAbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle knightbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle slimebuttonstyle = new ImageButtonStyle();
	ImageButtonStyle skellybuttonstyle = new ImageButtonStyle();
	ImageButtonStyle cyborgbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle grandmasterbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle treeminionbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle rustybuttonstyle = new ImageButtonStyle();
	ImageButtonStyle ghostbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle plantbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle ballerbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle eyebuttonstyle = new ImageButtonStyle();
	ImageButtonStyle squirtbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle mumbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle pharbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle tankbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle indrabuttonstyle = new ImageButtonStyle();	
	
	ImageButtonStyle flametbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle freezetbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle poisontbuttonstyle = new ImageButtonStyle();
	ImageButtonStyle lightningtbuttonstyle = new ImageButtonStyle();	
	
	ImageButtonStyle hpstyle = new ImageButtonStyle();
	ImageButtonStyle mpstyle = new ImageButtonStyle();
	ImageButtonStyle qmarkstyle = new ImageButtonStyle();
	
	ImageButtonStyle ginstyle = new ImageButtonStyle();
	ImageButtonStyle goutstyle = new ImageButtonStyle();
	ImageButtonStyle pausestyle = new ImageButtonStyle();
	TextButtonStyle tbuttonstyle = new TextButtonStyle();
	
	
	Texture selected;
	Texture shop;
	Texture coin;
	
	TextureAtlas bloodhit;
	Texture castleimage;
	
	Animation lightning;
	Animation poisontouch;
	Animation fingertouch;
	Animation bombtouch;
	
	Skin skinn = new Skin(new TextureAtlas("blood.pack"));
	
	
	Texture lock;
	TextureAtlas burnb;
	Animation burnin;
	TextureAtlas doomatlas;
	Animation doom;
	float defaultwidth =1280f;
	float defaultheight = 800f;
	float wratio = Gdx.graphics.getWidth()/defaultwidth;
	float hratio = Gdx.graphics.getHeight()/defaultheight;
	Texture casl;
	Texture rip;
	Animation atk2;
	ArrayList<String> equipped = new ArrayList<String>();
	BitmapFont font;
	BitmapFont font2;
	BitmapFont lfont;
	BitmapFont llfont;
	BitmapFont bfont;
	BitmapFont bbfont;
	BitmapFont ifont;
	Sound lightnsfx;
	Sound hitsfx;
	Sound castlehitsfx;
	Sound turretfiresfx;
	public Assetloader(){
		
		hitsfx = Gdx.audio.newSound(Gdx.files.internal("hitsfx.wav"));
		lightnsfx = Gdx.audio.newSound(Gdx.files.internal("lightnsfx.wav"));
		turretfiresfx= Gdx.audio.newSound(Gdx.files.internal("turretfiresfx.wav"));
		normalhit = new Animation(1/5f, (new TextureAtlas("normalhit.pack")).getRegions());
		
		castlehitsfx = Gdx.audio.newSound(Gdx.files.internal("castlehitsfx.wav"));
		
		lightning = new Animation(1/20f, (new TextureAtlas("lightning.pack")).getRegions());

		poisontouch = new Animation(1/10f, (new TextureAtlas("poisontouch.pack")).getRegions());

		fingertouch = new Animation(1/10f, (new TextureAtlas("fingertouch.pack")).getRegions());

		bombtouch = new Animation(1/20f, (new TextureAtlas("bombtouch.pack")).getRegions());
		font = new BitmapFont();
		font2 = new BitmapFont(Gdx.files.internal("text.fnt"));
		lfont = new BitmapFont(Gdx.files.internal("text.fnt"));	
		lfont.setScale(0.5f * wratio,0.5f * hratio);
		
		llfont = new BitmapFont(Gdx.files.internal("text.fnt"));	
		llfont.setScale(0.35f * wratio,0.35f * hratio);
		ifont = new BitmapFont(Gdx.files.internal("text.fnt"));	
		ifont.setScale(0.35f * wratio,0.35f * hratio);
		ifont.setColor(new Color(1f,0.2f,0,1f));
		bfont = new BitmapFont(Gdx.files.internal("text.fnt"));	
		bfont.setScale(1.6f * wratio,1.6f * hratio);
		bbfont = new BitmapFont(Gdx.files.internal("text.fnt"));	
		bbfont.setScale(2.7f * wratio,2.7f *hratio);
		//lightn.setFrameDuration(1f);
		selected = new Texture("selected.png");
		shop = new Texture("shop.png");
		coin = new Texture("coin.png");
		lock = new Texture("lock.png");
		rip = new Texture("rip.png");
		
		fball = new Texture("fball.png");
		frball = new Texture("frball.png");
		pball = new Texture("pball.png");
		lball = new Texture("lball.png");
		
		flameturret = new Texture("flameturret.png");
		frozenturret = new Texture("frozenturret.png");
		poisonturret = new Texture("poisonturret.png");
		lightningturret = new Texture("lightningturret.png");
		
		burnb = new TextureAtlas("burn.pack");
		burnin = new Animation(1/15f,burnb.getRegions());
		doomatlas = new TextureAtlas("doom.pack");
		doom = new Animation(1/30f, doomatlas.getRegions());
		castleimage = new Texture("castle.png");
		bloodhit = new TextureAtlas("blood.pack");
		//blast = new Texture("blast.png");
		icefx = new TextureAtlas("icefx.pack");
		frozen = new Animation(1/5f,icefx.getRegions());
		
		flamefx = new TextureAtlas("flamefx.pack");
		flame = new Animation(1/3f, flamefx.getRegions());
		
		poisonfx = new TextureAtlas("poisonfx.pack");
		poison = new Animation(1/3f, poisonfx.getRegions());
	
		lightfx = new TextureAtlas("lightfx.pack");
		light = new Animation(1/3f, lightfx.getRegions());
		
		shothit = new TextureAtlas("shothit.pack");
		shot = new Animation(1/5f, shothit.getRegions());
		
		enemycastle = new TextureAtlas("enemycastle.pack");
		enemycastleAnim = new Animation (1/2f, enemycastle.getRegions());
		enemycastlehurt = new TextureAtlas("enemycastlehurt.pack");
		enemycastlehurtAnim = new Animation(1/2f, enemycastlehurt.getRegions());
		mycastle = new TextureAtlas("mycastle.pack");
		mycastleAnim = new Animation(1/2f, mycastle.getRegions());
		mycastlehurt = new TextureAtlas("mycastlehurt.pack");
		mycastlehurtAnim = new Animation(1/2f, mycastlehurt.getRegions());
		
		title = new Animation(1/6f, ( new TextureAtlas("title.pack")).getRegions());
		minionmove = new Animation(1/6f, ( new TextureAtlas("minionmove.pack")).getRegions());
		minionatk = new Animation(1/6f, ( new TextureAtlas("minionatk.pack")).getRegions());
		gmastermove = new Animation(1/6f, ( new TextureAtlas("gmastermove.pack")).getRegions());
		gmasteratk = new Animation(1/6f, ( new TextureAtlas("gmasteratk.pack")).getRegions());
		cyborgmove = new Animation(1/6f, ( new TextureAtlas("cyborgmove.pack")).getRegions());
		cyborgatk = new Animation(1/20f, ( new TextureAtlas("cyborgatk.pack")).getRegions());
		cyborgatkr = new Animation(1/6f, ( new TextureAtlas("cyborgatkr.pack")).getRegions());
		knightmove = new Animation(1/6f, ( new TextureAtlas("knightmove.pack")).getRegions());
		knightatk = new Animation(1/6f, ( new TextureAtlas("knightatk.pack")).getRegions());
		skellymove = new Animation(1/6f, ( new TextureAtlas("skellymove.pack")).getRegions());
		skellyatk = new Animation(1/6f, ( new TextureAtlas("skellyatk.pack")).getRegions());
		skellyatkr = new Animation(1/8f, ( new TextureAtlas("skellyatkr.pack")).getRegions());
		slimemove = new Animation(1/6f, ( new TextureAtlas("slimemove.pack")).getRegions());
		slimeatk = new Animation(1/6f, ( new TextureAtlas("slimeatk.pack")).getRegions());
		treeminionmove = new Animation(1/20f, ( new TextureAtlas("treeminionmove.pack")).getRegions());
		treeminionatk = new Animation(1/20f, ( new TextureAtlas("treeminionatk.pack")).getRegions());
		treeminionatkr = new Animation(1/6f, ( new TextureAtlas("treeminionatkr.pack")).getRegions());
		 rustymove= new Animation(1/20f, (new TextureAtlas("rustymove.pack")).getRegions());
		 rustyatk= new Animation(1/20f, (new TextureAtlas("rustyatk.pack")).getRegions());
		 ghostmove= new Animation(1/6f, (new TextureAtlas("ghostmove.pack")).getRegions());
		 ghostatk= new Animation(1/6f, (new TextureAtlas("ghostatk.pack")).getRegions());
		 plantmove= new Animation(1/6f, (new TextureAtlas("plantmove.pack")).getRegions());
		 plantatk= new Animation(1/6f, (new TextureAtlas("plantatk.pack")).getRegions());
		 ballermove= new Animation(1/6f, (new TextureAtlas("ballermove.pack")).getRegions());
		 balleratk= new Animation(1/6f, (new TextureAtlas("balleratk.pack")).getRegions());
		 eyemove= new Animation(1/6f, (new TextureAtlas("eyemove.pack")).getRegions());
		 eyeatk= new Animation(1/6f, (new TextureAtlas("eyeatk.pack")).getRegions());
		 squirtmove= new Animation(1/6f, (new TextureAtlas("squirtmove.pack")).getRegions());
		 squirtatk= new Animation(1/6f, (new TextureAtlas("squirtatk.pack")).getRegions());
		 mummove= new Animation(1/6f, (new TextureAtlas("mummove.pack")).getRegions());
		 mumatk= new Animation(1/6f, (new TextureAtlas("mumatk.pack")).getRegions());
		 pharmove= new Animation(1/6f, (new TextureAtlas("pharmove.pack")).getRegions());
		 pharatk= new Animation(1/20f, (new TextureAtlas("pharatk.pack")).getRegions());
		 tankmove= new Animation(1/6f, (new TextureAtlas("tankmove.pack")).getRegions());
		 tankatk= new Animation(1/6f, (new TextureAtlas("tankatk.pack")).getRegions());
		indramove= new Animation(1/6f, (new TextureAtlas("indramove.pack")).getRegions());
		 indraatk= new Animation(1/6f, (new TextureAtlas("indraatk.pack")).getRegions());

		hiteff = new Animation(1/10f, bloodhit.getRegions());
		button = new Texture("badlogic.jpg");
		back = new Texture("backg.png");
		casl = new Texture("castle.png");
		
		nobutton = new Skin(new TextureAtlas("no.pack"));
		yesbutton = new Skin(new TextureAtlas("yes.pack"));
		NAbutton = new Skin(new TextureAtlas("NAbutton.pack"));
		knightbutton = new Skin(new TextureAtlas("knightbutton.pack"));
		slimebutton = new Skin(new TextureAtlas("slimebutton.pack"));
		skellybutton = new Skin(new TextureAtlas("skellybutton.pack"));
		cyborgbutton = new Skin(new TextureAtlas("cyborgbutton.pack"));
		grandmasterbutton = new Skin(new TextureAtlas("grandmasterbutton.pack"));
		treeminionbutton = new Skin(new TextureAtlas("treeminionbutton.pack"));
		 rustybutton= new Skin(new TextureAtlas("rustybutton.pack"));
		 ghostbutton= new Skin(new TextureAtlas("ghostbutton.pack"));
		 plantbutton= new Skin(new TextureAtlas("plantbutton.pack"));
		 ballerbutton= new Skin(new TextureAtlas("ballerbutton.pack"));
		 eyebutton= new Skin(new TextureAtlas("eyebutton.pack"));
		 squirtbutton= new Skin(new TextureAtlas("squirtbutton.pack"));
		 mumbutton= new Skin(new TextureAtlas("mumbutton.pack"));
		 pharbutton= new Skin(new TextureAtlas("pharbutton.pack"));
		 tankbutton= new Skin(new TextureAtlas("tankbutton.pack"));
		 indrabutton= new Skin(new TextureAtlas("indrabutton.pack"));	
		 
		 flametbutton= new Skin(new TextureAtlas("flametbutton.pack"));
		 freezetbutton= new Skin(new TextureAtlas("freezetbutton.pack"));
		 poisontbutton= new Skin(new TextureAtlas("poisontbutton.pack"));
		 lightningtbutton= new Skin(new TextureAtlas("lightningtbutton.pack"));	
		
		playbutton = new Skin(new TextureAtlas("playbutton.pack"));
		pausebutton = new Skin(new TextureAtlas("pause.pack"));
		hpbutton = new Skin(new TextureAtlas("hp.pack"));
		mpbutton = new Skin(new TextureAtlas("mp.pack"));
		qmarkbutton = new Skin(new TextureAtlas("qmark.pack"));
		ginbutton = new Skin(new TextureAtlas("gin.pack"));
		goutbutton = new Skin(new TextureAtlas("gout.pack"));

		trophybutton = new Skin(new TextureAtlas("trophy.pack"));
		rankbutton = new Skin(new TextureAtlas("rank.pack"));
	
		lightningtouchbutton = new Skin(new TextureAtlas("lightningtouchbutton.pack"));
		poisontouchbutton = new Skin(new TextureAtlas("poisontouchbutton.pack"));
		bombtouchbutton = new Skin(new TextureAtlas("bombtouchbutton.pack"));
		fingertouchbutton = new Skin(new TextureAtlas("fingertouchbutton.pack"));
		
		cashbutton = new Skin(new TextureAtlas("cashbutton.pack"));
		
		cashbuttonstyle.up = cashbutton.getDrawable("sprite1");
		cashbuttonstyle.down = cashbutton.getDrawable("sprite2");
		cashbuttonstyle.font = llfont;
		
		lightningtouchstyle.imageUp = lightningtouchbutton.getDrawable("sprite1");  
		lightningtouchstyle.imageDown = lightningtouchbutton.getDrawable("sprite2");  

		poisontouchstyle.imageUp = poisontouchbutton.getDrawable("sprite1");  
		poisontouchstyle.imageDown = poisontouchbutton.getDrawable("sprite2");  
		
		bombtouchstyle.imageUp = bombtouchbutton.getDrawable("sprite1");  
		bombtouchstyle.imageDown = bombtouchbutton.getDrawable("sprite2");  
		
		fingertouchstyle.imageUp = fingertouchbutton.getDrawable("sprite1");  
		fingertouchstyle.imageDown = fingertouchbutton.getDrawable("sprite2");  
		
		flametbuttonstyle.imageUp = flametbutton.getDrawable("sprite1");
		flametbuttonstyle.imageDown = flametbutton.getDrawable("sprite2");
		
		freezetbuttonstyle.imageUp = freezetbutton.getDrawable("sprite1");
		freezetbuttonstyle.imageDown = freezetbutton.getDrawable("sprite2");

		poisontbuttonstyle.imageUp = poisontbutton.getDrawable("sprite1");
		poisontbuttonstyle.imageDown = poisontbutton.getDrawable("sprite2");
		
		lightningtbuttonstyle.imageUp = lightningtbutton.getDrawable("sprite1");
		lightningtbuttonstyle.imageDown = lightningtbutton.getDrawable("sprite2");

		
		trophybuttonstyle.imageUp = trophybutton.getDrawable("sprite");
		trophybuttonstyle.imageUp = trophybutton.getDrawable("sprite");

		rankbuttonstyle.imageUp = rankbutton.getDrawable("sprite");
		rankbuttonstyle.imageUp = rankbutton.getDrawable("sprite");
		
		ginstyle.imageUp = ginbutton.getDrawable("sprite");
		ginstyle.imageDown = ginbutton.getDrawable("sprite");
		
		goutstyle.imageUp = goutbutton.getDrawable("sprite");
		goutstyle.imageDown = goutbutton.getDrawable("sprite");
		
		hpstyle.imageUp = hpbutton.getDrawable("sprite1");
		hpstyle.imageDown = hpbutton.getDrawable("sprite2");
		
		mpstyle.imageUp = mpbutton.getDrawable("sprite1");
		mpstyle.imageDown = mpbutton.getDrawable("sprite2");
		
		qmarkstyle.imageUp = qmarkbutton.getDrawable("question");
		qmarkstyle.imageDown = qmarkbutton.getDrawable("question");
		
		pausestyle.imageUp = pausebutton.getDrawable("sprite");
		pausestyle.imageUp = pausebutton.getDrawable("sprite");
		
		tbuttonstyle.font = bfont;
		tbuttonstyle.up = playbutton.getDrawable("sprite");
		tbuttonstyle.down = playbutton.getDrawable("sprite");
		
		nobuttonstyle.font = lfont;
		nobuttonstyle.up = nobutton.getDrawable("sprite1");
		nobuttonstyle.down = nobutton.getDrawable("sprite2");
		
		yesbuttonstyle.font = lfont;
		yesbuttonstyle.up = yesbutton.getDrawable("sprite1");
		yesbuttonstyle.down = yesbutton.getDrawable("sprite2");
		
		NAbuttonstyle.imageUp = NAbutton.getDrawable("sprite1");
		NAbuttonstyle.imageDown = NAbutton.getDrawable("sprite1");
		NAbuttonstyle.imageChecked = NAbutton.getDrawable("sprite1");

		knightbuttonstyle.imageUp = knightbutton.getDrawable("sprite1");
		knightbuttonstyle.imageDown = knightbutton.getDrawable("sprite2");
		
		slimebuttonstyle.imageUp = slimebutton.getDrawable("sprite1");
		slimebuttonstyle.imageDown = slimebutton.getDrawable("sprite2");

		skellybuttonstyle.imageUp = skellybutton.getDrawable("sprite1");
		skellybuttonstyle.imageDown = skellybutton.getDrawable("sprite2");

		cyborgbuttonstyle.imageUp = cyborgbutton.getDrawable("sprite1");
		cyborgbuttonstyle.imageDown = cyborgbutton.getDrawable("sprite2");

		grandmasterbuttonstyle.imageUp = grandmasterbutton.getDrawable("sprite1");
		grandmasterbuttonstyle.imageDown = grandmasterbutton.getDrawable("sprite2");

		treeminionbuttonstyle.imageUp = treeminionbutton.getDrawable("sprite1");
		treeminionbuttonstyle.imageDown = treeminionbutton.getDrawable("sprite2");
		
		 rustybuttonstyle.imageUp =  rustybutton.getDrawable("sprite1");
		 rustybuttonstyle.imageDown =  rustybutton.getDrawable("sprite2");
		 
		 ghostbuttonstyle.imageUp =  ghostbutton.getDrawable("sprite1");
		 ghostbuttonstyle.imageDown =  ghostbutton.getDrawable("sprite2");
		 
		 plantbuttonstyle.imageUp =  plantbutton.getDrawable("sprite1");
		 plantbuttonstyle.imageDown =  plantbutton.getDrawable("sprite2");
		 
		 ballerbuttonstyle.imageUp =  ballerbutton.getDrawable("sprite1");
		 ballerbuttonstyle.imageDown =  ballerbutton.getDrawable("sprite2");
		 
		 eyebuttonstyle.imageUp =  eyebutton.getDrawable("sprite1");
		 eyebuttonstyle.imageDown =  eyebutton.getDrawable("sprite2");
		 
		 squirtbuttonstyle.imageUp =  squirtbutton.getDrawable("sprite1");
		 squirtbuttonstyle.imageDown =  squirtbutton.getDrawable("sprite2");
		 
		 mumbuttonstyle.imageUp =   mumbutton.getDrawable("sprite1");
		 mumbuttonstyle.imageDown =   mumbutton.getDrawable("sprite2");
		 
		 pharbuttonstyle.imageUp =  pharbutton.getDrawable("sprite1");
		 pharbuttonstyle.imageDown =  pharbutton.getDrawable("sprite2");
		 
		 tankbuttonstyle.imageUp =  tankbutton.getDrawable("sprite1");
		 tankbuttonstyle.imageDown =  tankbutton.getDrawable("sprite2");
		 
		 indrabuttonstyle.imageUp = indrabutton.getDrawable("sprite1");
		 indrabuttonstyle.imageDown = indrabutton.getDrawable("sprite2");
		
		mapanim.put("cyborg", new Animation[]{cyborgmove,cyborgatk});
		mapanim.put("skelly", new Animation[]{skellymove,skellyatk} );
		mapanim.put("knight",  new Animation[]{knightmove,knightatk} );
		mapanim.put("slime", new Animation[]{slimemove,slimeatk} );
		mapanim.put("gmaster", new Animation[]{gmastermove,gmasteratk} );
		mapanim.put("rusty", new Animation[]{rustymove,rustyatk});
		mapanim.put("ghost", new Animation[]{ghostmove,ghostatk} );
		mapanim.put("plant",  new Animation[]{plantmove,plantatk} );
		mapanim.put("baller", new Animation[]{ballermove,balleratk} );
		mapanim.put("eye", new Animation[]{eyemove,eyeatk} );
		mapanim.put("squirt", new Animation[]{squirtmove,squirtatk});
		mapanim.put("mum", new Animation[]{mummove,mumatk} );
		mapanim.put("phar",  new Animation[]{pharmove,pharatk} );
		mapanim.put("tank", new Animation[]{tankmove,tankatk} );
		mapanim.put("indra", new Animation[]{indramove,indraatk} );
		
		maptur.put("flamet", new Texture[]{flameturret,fball});
		maptur.put("poisont", new Texture[]{poisonturret,pball});
		maptur.put("frozent", new Texture[]{frozenturret,frball});
		maptur.put("lightningt", new Texture[]{lightningturret,lball});
		//damage, delay, atktype, statatk
		mapdata.put("flamet", new Float[]{17f,1.2f,2f,1f});
		mapdata.put("poisont", new Float[]{8f,2.8f,2f,3f});
		mapdata.put("frozent", new Float[]{12f,1.4f,2f,2f});
		mapdata.put("lightningt", new Float[]{12f,0.6f,2f,4f});
		
	//float hp0,float damage1,float rSpeedPure2,float range3, float statatk4, float hitnumber5,float atktype6,mana7 ,delay8, szie9
	//stat atk 0-none 1-fire 2-ice 3-poison
	//hitnumber
		//////////////////////////////////hp////dmg///spd///rnge st//ht#/ atk//man//de//size/       
		mapdata.put("cyborg", new Float[]{145f, 16f, 0.45f, 60f, 1f, 2f, 1f, 60f, 10f, 30f});
		mapdata.put("skelly", new Float[]{70f,  4f,  0.3f,  44f, 0f, 99f, 3f, 20f, 3f,  20f});
		mapdata.put("knight", new Float[]{120f, 6f,  0.37f, 0.5f,  0f, 2f, 2f, 25f, 3f,  20f});
		mapdata.put("slime",  new Float[]{60f,  8f,  0.5f,  0.5f,  0f, 99f, 2f, 20f, 1f,  15f});
		mapdata.put("gmaster",new Float[]{150f, 22f, 0.6f,  1f,  4f, 99f, 2f, 55f, 8f,  20f});
		mapdata.put("rusty",  new Float[]{70f,  5f,  0.55f, 0.5f,  0f, 99f, 2f, 20f, 2f,  25f});
		mapdata.put("ghost",  new Float[]{80f,  9f,  0.6f,  0.5f,  2f, 99f, 2f, 20f, 1f,  25f});
		mapdata.put("plant",  new Float[]{225f, 17f, 0.32f,  0.5f,  3f, 2f, 2f, 50f, 10f, 40f});
		mapdata.put("baller", new Float[]{300f, 12f, 0.6f,  1f,  0f, 99f, 2f, 55f, 8f,  35f});
		mapdata.put("eye",    new Float[]{150f, 19f, 0.45f, 70f, 2f, 5f, 4f, 50f, 10f, 40f});
		mapdata.put("squirt", new Float[]{80f,  5f,  0.55f, 35f, 1f, 99f, 4f, 30f, 1f,  20f});
		mapdata.put("mum",    new Float[]{100f, 10f,  0.3f,  0.5f,  1f, 99f, 2f, 25f, 3f,  20f});
		mapdata.put("phar",   new Float[]{300f, 14f, 0.25f, 60f, 3f, 5f, 3f, 50f, 10f, 30f});
		mapdata.put("tank",   new Float[]{500f, 20f, 0.45f, 70f, 1f, 99f, 4f, 65f, 15f, 50f});
		mapdata.put("indra",  new Float[]{600f, 26f, 0.6f,  75f, 4f, 3f,  1f, 100f,12f, 30f});
		//dmg,stat,hitnum,mana,delay
		mapdata.put("lmagic", 	   new Float[]{30f,4f, 3f,25f,3f});
		mapdata.put("poisonmagic", new Float[]{55f,3f,6f,35f,6f});
		mapdata.put("bombmagic",   new Float[]{60f,1f,7f,40f,5f});
		mapdata.put("fingermagic", new Float[]{85f,0f,8f,15f,4f});
		}
//	BitmapFont createFont(FreeTypeFontGenerator ftfg, float dp)
//	{
//	    return ftfg.generateFont((int)(dp * Gdx.graphics.getDensity()));
//	}
	
	//row , col
	public Animation animated(Texture Spriteframe, int numberframes,int row, int col, float speed){
		TextureRegion[] taa;
		TextureRegion[][] ta;
		int splitwidth = Spriteframe.getWidth()/col;
		int splitheight = Spriteframe.getHeight()/row;
		ta = TextureRegion.split(Spriteframe, splitwidth,splitheight);
		taa = new TextureRegion[numberframes];
		int ind = 0;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++ ){
				if(ind == numberframes){
					break;
				}
				taa[ind++] = ta[i][j];
			}
		}
		
	return new Animation(speed,taa);
	}
}

