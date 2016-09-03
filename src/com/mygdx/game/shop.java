package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class shop implements Screen,InputProcessor{
	SpriteBatch drawer = new SpriteBatch();
	Beta game;
	Gscreen nextlevel;

	ArrayList<shopbutton> listbut = new ArrayList<shopbutton>();
	 //butt = skinn.getDrawable("hit0001");
	InputMultiplexer multi;
	ImageButton selectedbutton;
	ImageButton tbutton;
	ImageButton gbutton;
	ImageButton fbutton;
	ImageButton febutton;
	TextButton cont;
	TextButton backtom;
	shopbutton button1, button2,  button3,  button4,  button5, button6, button7,  button8,  button9,  button10, button11, button12,  button13,  button14,  button15;
	shopbutton buttoni1,buttoni2, buttoni3, buttoni4, buttoni5;
	
	shopbutton hpplus,mpplus, mprplus;
	
	shopbutton magicbutton;
	shopbutton lmagic;
	shopbutton bombmagic;
	shopbutton poisonmagic;
	shopbutton fingermagic;
	
	shopbutton turretabutton,turretbbutton;
	shopbutton flametbutton,frozentbutton,poisontbutton,lightningtbutton;
	BitmapFont font;

	float[] tempx = new float[5];
	float[] tempy = new float[5];
	
	TextButton Yes;
	TextButton No;
	int maxhp;
	int maxmp;
	int maxmpr;
	int selected = 0;
	Stage stage;
	ButtonGroup<shopbutton> sgroup;
	ButtonGroup<shopbutton> bgroup;
	OrthographicCamera cam;
	Viewport viewp;
	float Uw = Gdx.graphics.getWidth()/100f;
	float Uh = Gdx.graphics.getHeight()/100f;
	Assetloader loadin;
	datas save;
	float dimens;
	Drawable aaa = null;

	//float fmultiplyer;
	public shop(final Beta game){
		
		this.game = game;
		
		loadin = game.loadin;
		save = game.save;
		
//		fmultiplyer = (float) (Math.pow(1.2f,game.save.fortify)); 
		
		maxhp = Math.round(game.save.maxhp);
		maxmp = Math.round(game.save.maxmp) ;
		maxmpr = Math.round(game.save.maxmpr);
		
		//cam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		//cam = new OrthographicCamera(100,100);
	
		//cam.position.set(game.camwid,game.camhei,0);
    	//viewp =  new FitViewport(game.camwid,game.camhei,cam);
		font = new BitmapFont();
		multi = new InputMultiplexer();
//		stage = new Stage(viewp,drawer);
		//viewp = new 
		stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight())){
			@Override
	        public boolean keyDown(int keyCode) {
	        if (keyCode == Keys.BACK) {
	    		game.setScreen(game.meta);
				Gdx.input.setInputProcessor(game.meta.mstage);
	        }
	        return super.keyDown(keyCode);
	    }
	};
		
		
		

		Gdx.input.setInputProcessor(stage);
		
		//ButtonGroup<ImageButton> bgrp = new ButtonGroup<ImageButton>(buttonaa, buttonbb);
		fbutton = new ImageButton(loadin.NAbuttonstyle);
		tbutton = new ImageButton(loadin.NAbuttonstyle);
		gbutton = new ImageButton(loadin.NAbuttonstyle);
		
		cont = new TextButton("Start",loadin.yesbuttonstyle);
		backtom = new TextButton("Back",loadin.nobuttonstyle);
		
		hpplus = new shopbutton(loadin.hpstyle);
		mpplus = new shopbutton(loadin.mpstyle);
		mprplus = new shopbutton(loadin.mpstyle);
		
		button1 = new shopbutton(loadin.knightbuttonstyle);
		button2 = new shopbutton(loadin.slimebuttonstyle);
		button3 = new shopbutton(loadin.skellybuttonstyle);
		button4 = new shopbutton(loadin.cyborgbuttonstyle);
		button5 = new shopbutton(loadin.grandmasterbuttonstyle);
		button6 = new shopbutton(loadin.rustybuttonstyle);
		button7 = new shopbutton(loadin.ghostbuttonstyle);
		button8 = new shopbutton(loadin.plantbuttonstyle);
		button9 = new shopbutton(loadin.ballerbuttonstyle);
		button10 = new shopbutton(loadin.eyebuttonstyle);
		button11 = new shopbutton(loadin.squirtbuttonstyle);
		button12 = new shopbutton(loadin.mumbuttonstyle);
		button13 = new shopbutton(loadin.pharbuttonstyle);
		button14 = new shopbutton(loadin.tankbuttonstyle);
		button15 = new shopbutton(loadin.indrabuttonstyle);
		flametbutton = new shopbutton(loadin.flametbuttonstyle);
		frozentbutton = new shopbutton(loadin.freezetbuttonstyle);
		poisontbutton= new shopbutton(loadin.poisontbuttonstyle);
		lightningtbutton= new shopbutton(loadin.lightningtbuttonstyle);

		
		Yes = new TextButton("Yes",loadin.yesbuttonstyle);
		No = new TextButton("No",loadin.nobuttonstyle);
	
//		turretabutton = new ImageButton(loadin.NAbuttonstyle);
//		turretbbutton = new ImageButton(loadin.NAbuttonstyle);
		turretabutton = new shopbutton(loadin.NAbuttonstyle);
		turretbbutton = new shopbutton(loadin.NAbuttonstyle);
		
		
		buttoni5 = new shopbutton(loadin.NAbuttonstyle);
		buttoni3 = new shopbutton(loadin.NAbuttonstyle);
		buttoni4 = new shopbutton(loadin.NAbuttonstyle);
		buttoni2 = new shopbutton(loadin.NAbuttonstyle);
		buttoni1 = new shopbutton(loadin.NAbuttonstyle);
		
		magicbutton = new shopbutton(loadin.NAbuttonstyle);
		lmagic = new shopbutton(loadin.lightningtouchstyle);
		fingermagic = new shopbutton(loadin.fingertouchstyle);
		poisonmagic = new shopbutton(loadin.poisontouchstyle);
		bombmagic = new shopbutton(loadin.bombtouchstyle);
		
		button1.uid= "1";
		button2.uid= "2";
		button3.uid= "3";
		button4.uid= "4";
		button5.uid= "5";
		
		flametbutton.uid= "6";
		frozentbutton.uid= "7";
		poisontbutton.uid= "8";
		lightningtbutton.uid= "9";
		
		turretabutton.uid= "10";
		turretbbutton.uid= "11";
		
		buttoni1.uid = "12";
		buttoni2.uid= "13";
		buttoni3.uid= "14";
		buttoni4.uid= "15";
		buttoni5.uid= "16";
		magicbutton.uid = "17";
		lmagic.uid = "18";
		mpplus.uid ="19";
		mprplus.uid ="20";
		hpplus.uid = "21";
		
		button6.uid = "22";
		button7.uid = "23";
		button8.uid = "24";
		button9.uid = "25";
		button10.uid = "26";
		button11.uid = "27";
		button12.uid = "28";
		button13.uid = "29";
		button14.uid = "30";
		button15.uid = "31";
		fingermagic.uid = "32";
		poisonmagic.uid = "33";
		bombmagic.uid = "34";
		
		
		buttoni1.type= 1;
		buttoni2.type= 1;
		buttoni3.type= 1;
		buttoni4.type= 1;
		buttoni5.type= 1;
		button1.type= 1;
		button2.type= 1;
		button3.type= 1;
		button4.type= 1;
		button5.type= 1;
		button6.type= 1;
		button7.type= 1;
		button8.type= 1;
		button9.type= 1;
		button10.type= 1;
		button11.type= 1;
		button12.type= 1;
		button13.type= 1;
		button14.type= 1;
		button15.type= 1;
		turretabutton.type= 2;
		turretbbutton.type= 2;
		flametbutton.type= 2;
		frozentbutton.type= 2;
		poisontbutton.type= 2;
		lightningtbutton.type= 2;
		magicbutton.type = 3;
		lmagic.type = 3;
		fingermagic.type = 3;
		poisonmagic.type = 3;
		bombmagic.type = 3;
		mpplus.type = 4;
		mprplus.type = 4;
		hpplus.type = 4;
		
		
		buttoni1.bought= game.save.mapbought.get(buttoni1.uid);
		buttoni2.bought= game.save.mapbought.get(buttoni2.uid);
		buttoni3.bought= game.save.mapbought.get(buttoni3.uid);
		buttoni4.bought= game.save.mapbought.get(buttoni4.uid);
		buttoni5.bought= game.save.mapbought.get(buttoni5.uid);
		button1.bought= game.save.mapbought.get(button1.uid);
		button2.bought= game.save.mapbought.get(button2.uid);
		button3.bought= game.save.mapbought.get(button3.uid);
		button4.bought= game.save.mapbought.get(button4.uid);
		button5.bought= game.save.mapbought.get(button5.uid);
		button6.bought= game.save.mapbought.get(button6.uid);
		button7.bought= game.save.mapbought.get(button7.uid);
		button8.bought= game.save.mapbought.get(button8.uid);
		button9.bought= game.save.mapbought.get(button9.uid);
		button10.bought= game.save.mapbought.get(button10.uid);
		button11.bought= game.save.mapbought.get(button11.uid);
		button12.bought= game.save.mapbought.get(button12.uid);
		button13.bought= game.save.mapbought.get(button13.uid);
		button14.bought= game.save.mapbought.get(button14.uid);
		button15.bought= game.save.mapbought.get(button15.uid);
		turretabutton.bought= game.save.mapbought.get(turretabutton.uid);
		turretbbutton.bought= game.save.mapbought.get(turretbbutton.uid);
		flametbutton.bought= game.save.mapbought.get(flametbutton.uid);
		frozentbutton.bought= game.save.mapbought.get(frozentbutton.uid);
		poisontbutton.bought= game.save.mapbought.get(poisontbutton.uid);
		lightningtbutton.bought= game.save.mapbought.get(lightningtbutton.uid);
		lmagic.bought = game.save.mapbought.get(lmagic.uid);
		fingermagic.bought = game.save.mapbought.get(fingermagic.uid);
		poisonmagic.bought = game.save.mapbought.get(poisonmagic.uid);
		bombmagic.bought = game.save.mapbought.get(bombmagic.uid);
	
		mpplus.bought = false;
		mprplus.bought = false;
		hpplus.bought = false;
		
		button1.level = 0;
		button2.level = 0;
		button3.level = 0;
		button4.level = 30;
		button5.level = 60;
		button6.level = 0;
		button7.level = 0;
		button8.level = 10;
		button9.level = 40;
		button10.level = 70;
		button11.level = 0;
		button12.level = 0;
		button13.level = 20;
		button14.level = 50;
		button15.level = 80;
		
		button1.cost =   5000;
		button2.cost =  8000;
		button3.cost =   20000;
		button4.cost =   200000;
		button5.cost =  150000;
		button6.cost =   7000;
		button7.cost =  30000;
		button8.cost =   50000;
		button9.cost =   300000;
		button10.cost =  600000;
		button11.cost =   15000;
		button12.cost =  20000;
		button13.cost =   100000;
		button14.cost =   800000;
		button15.cost =  1000000;
		flametbutton.cost =  300000;
		frozentbutton.cost =  500000;
		poisontbutton.cost =  200000;
		lightningtbutton.cost = 200000;
		lmagic.cost = 10000;
		fingermagic.cost = 20000;
		poisonmagic.cost = 10000;
		bombmagic.cost = 20000;
		mpplus.cost = 2000;
		hpplus.cost = 4000;
		mprplus.cost = 3000;
		
		
		button1.description = "    Knight\n melee \n medium hp \n low attack \n medium speed \n single target \n Uses: 15 mp\n Cooldown: 3";
		button2.description = "    Slime\n melee \n low hp \n medium attack \n high speed \n single target \n Uses: 10 mp\n Cooldown: 1";
		button3.description = "    Undead archer\n ranged \n low hp \n low attack \n low speed \n random target \n Uses: 10 mp\n Cooldown: 3";
		button4.description = "    Cyborg\n ranged \n medium hp \n high attack \n medium speed \n multiple targets \n Burns \n Uses: 50 mp\n Cooldown: 10";
		button5.description = "    Grandmaster\n melee \n medium hp \n high+ attack \n high speed \n single target \n Shocks \n Uses: 45 mp\n Cooldown: 8";
		button6.description = "    Prototype\n melee \n low hp \n low attack \n high speed \n single target \n Uses: 10 mp\n Cooldown: 2";
		button7.description = "    Ghost\n melee \n low hp \n medium attack \n high speed \n single target \n Freezes \n Uses: 20 mp\n Cooldown: 1";
		button8.description = "    Mutant flytrap\n melee \n high hp \n high attack \n low speed \n single target \n Poisons \n Uses: 40 mp\n Cooldown: 10";
		button9.description = "    Football Player\n melee \n high hp+ \n medium attack \n high speed \n single target \n Uses: 45 mp\n Cooldown: 8";
		button10.description = "    Optical Oddity\n ranged \n medium hp \n high attack+ \n medium speed \n random target \n Freezes \n Uses: 40 mp\n Cooldown: 10";
		button11.description = "    Squirt\n ranged \n low hp \n low attack \n high speed \n multiple target \n Uses: 20 mp\n Cooldown: 1";
		button12.description = "    Mummy\n melee \n medium hp \n medium attack \n low speed \n random target \n Uses: 15 mp\n Cooldown: 3";
		button13.description = "    Pharoah\n ranged \n high hp+ \n high attack \n low speed \n single targets \n Poisons \n Uses: 50 mp\n Cooldown: 10";
		button14.description = "    Tank\n ranged \n high hp+ \n high attack+ \n medium speed \n multiple targets \n Burns \n Uses: 65 mp\n Cooldown: 15";
		button15.description = "    Indra\n ranged \n high hp++ \n high attack++ \n high speed \n multiple targets \n Shocks \n Uses: 100 mp\n Cooldown: 12";
		flametbutton.description = "    infernal turret\n Burns \n Medium delay \n high damage ";
		frozentbutton.description = "    frost turret\n Freezes \n Medium delay \n medium damage ";
		poisontbutton.description = "    toxic turret\n Poisons \n Long delay \n low damage ";
		lightningtbutton.description = "    static turret\n Shocks \n Short delay \n medium damage ";
		lmagic.description = "    Lightning\n Shocks \n medium damage\n Costs: 45 mp\n Cooldown: 3";
		fingermagic.description = "    Tap n Crush\n \n high damage++ \n Costs: 35 mp\n Cooldown: 4";
		poisonmagic.description = "    Curse\n Poisons \n high damage\n Costs: 55 mp\n Cooldown: 6";
		bombmagic.description = "    Explode\n Burns \n high damage+\n Costs: 60 mp\n Cooldown: 5";
		mpplus.description = "    +10 to Max mana";
		mprplus.description = "    +1 to Max mana\n regeneration";
		hpplus.description = "    +50 to Max health";
		
		
		button1.activename = "knight";
		button2.activename = "slime";
		button3.activename = "skelly";
		button4.activename = "cyborg";
		button5.activename = "gmaster";
		button6.activename = "rusty";
		button7.activename = "ghost";
		button8.activename = "plant";
		button9.activename = "baller";
		button10.activename = "eye";
		button11.activename = "squirt";
		button12.activename = "mum";
		button13.activename = "phar";
		button14.activename = "tank";
		button15.activename = "indra";
		flametbutton.activename = "flamet";
		frozentbutton.activename = "frozent";
		poisontbutton.activename = "poisont";
		lightningtbutton.activename = "lightningt";
		lmagic.activename = "lmagic";
		fingermagic.activename = "fingermagic";
		poisonmagic.activename = "poisonmagic";
		bombmagic.activename = "bombmagic";


		buttoni1.eqslot = "none";
		buttoni2.eqslot = "none";
		buttoni3.eqslot = "none";
		buttoni4.eqslot = "none";
		buttoni5.eqslot = "none";
				
		turretabutton.eqslot =  "none";
		turretbbutton.eqslot =  "none";
		
		magicbutton.eqslot = "none";
		
		float dimens = 8f;
		float ratio3 = (float)loadin.NAbuttonstyle.imageUp.getMinHeight()/(float)loadin.NAbuttonstyle.imageUp.getMinWidth();

		float scalin = (Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Uw : Uh );
		
		
		cont.setBounds(Uw * 90f, Uh * 10f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		backtom.setBounds(Uw * 90f, Uh * 4f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		
		//cont.get
		//cont.sizeBy(-(Uh * 15), -(Uh * 15)*ratio3);
		
		hpplus.setBounds(Uw* 10f, Uh * 88f, ( scalin * 3f), ( scalin * 3f));
		hpplus.getImageCell().expand().fill();
		mpplus.setBounds(Uw* 30f, Uh * 88f, ( scalin * 3f), ( scalin * 3f));
		mpplus.getImageCell().expand().fill();
		mprplus.setBounds(Uw* 50f, Uh * 88f, ( scalin * 3f), ( scalin * 3f));
		mprplus.getImageCell().expand().fill();
		
		magicbutton.setBounds(Uw* 70f, Uh * 70f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		magicbutton.getImageCell().expand().fill();
		fingermagic.setBounds(Uw* 70f, Uh * 55f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		fingermagic.getImageCell().expand().fill();
		lmagic.setBounds(Uw* 70f, Uh * 40f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		lmagic.getImageCell().expand().fill();
		poisonmagic.setBounds(Uw* 70f, Uh * 25f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		poisonmagic.getImageCell().expand().fill();
		bombmagic.setBounds(Uw* 70f, Uh * 10f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		bombmagic.getImageCell().expand().fill();
		
		turretabutton.setBounds(Uw* 50f, Uh * 70f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		turretabutton.getImageCell().expand().fill();
		turretbbutton.setBounds(Uw* 60f, Uh * 70f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		turretbbutton.getImageCell().expand().fill();
		flametbutton.setBounds(Uw* 50f, Uh * 55f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		flametbutton.getImageCell().expand().fill();
		frozentbutton.setBounds(Uw* 50f, Uh * 40f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		frozentbutton.getImageCell().expand().fill();
		poisontbutton.setBounds(Uw* 60f, Uh * 55f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		poisontbutton.getImageCell().expand().fill();
		lightningtbutton.setBounds(Uw* 60f, Uh * 40f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		lightningtbutton.getImageCell().expand().fill();
	
		
		buttoni1.setBounds(Uw, Uh * 70f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		buttoni1.getImageCell().expand().fill();
		buttoni2.setBounds(Uw, Uh * 55f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		buttoni2.getImageCell().expand().fill();
		buttoni3.setBounds(Uw, Uh * 40f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		buttoni3.getImageCell().expand().fill();
		buttoni4.setBounds(Uw, Uh * 25f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		buttoni4.getImageCell().expand().fill();
		buttoni5.setBounds(Uw, Uh * 10f, ( scalin * dimens), ( scalin * dimens)*ratio3);
		buttoni5.getImageCell().expand().fill();
		
		Yes.setBounds(Uw * 4f, Uh * 2f, (scalin * 5f), (scalin * 5f) * ratio3);
	//	Yes.getImageCell().expand().fill();
		No.setBounds(Yes.getX() + Yes.getWidth() + Uw * 2f, Yes.getY(), Yes.getWidth(), Yes.getHeight());
	//	No.getImageCell().expand().fill();
	
		button1.setBounds(buttoni1.getX() + buttoni1.getWidth() + (Uw * 5f), buttoni1.getY(),  ( scalin * dimens), ( scalin * dimens)*ratio3);
		button1.getImageCell().expand().fill();
		button2.setBounds(buttoni2.getX() + buttoni2.getWidth() + (Uw * 5f), buttoni2.getY(),  ( scalin * dimens), ( scalin * dimens)*ratio3);
		button2.getImageCell().expand().fill();
		button3.setBounds(buttoni3.getX() + buttoni3.getWidth() + (Uw * 5f), buttoni3.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button3.getImageCell().expand().fill();
		button4.setBounds(buttoni4.getX() + buttoni4.getWidth() + (Uw * 5f), buttoni4.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button4.getImageCell().expand().fill();
		button5.setBounds(buttoni5.getX() + buttoni5.getWidth() + (Uw * 5f), buttoni5.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button5.getImageCell().expand().fill();
		button6.setBounds(button1.getX() + buttoni1.getWidth() + (Uw * 5f), buttoni1.getY(),  ( scalin * dimens), ( scalin * dimens)*ratio3);
		button6.getImageCell().expand().fill();
		button7.setBounds(button2.getX() + buttoni2.getWidth() + (Uw * 5f), buttoni2.getY(),  ( scalin * dimens), ( scalin * dimens)*ratio3);
		button7.getImageCell().expand().fill();
		button8.setBounds(button3.getX() + buttoni3.getWidth() + (Uw * 5f), buttoni3.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button8.getImageCell().expand().fill();
		button9.setBounds(button4.getX() + buttoni4.getWidth() + (Uw * 5f), buttoni4.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button9.getImageCell().expand().fill();
		button10.setBounds(button5.getX() + buttoni5.getWidth() + (Uw * 5f), buttoni5.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button10.getImageCell().expand().fill();
		button11.setBounds(button6.getX() + buttoni1.getWidth() + (Uw * 5f), buttoni1.getY(),  ( scalin * dimens), ( scalin * dimens)*ratio3);
		button11.getImageCell().expand().fill();
		button12.setBounds(button7.getX() + buttoni2.getWidth() + (Uw * 5f), buttoni2.getY(),  ( scalin * dimens), ( scalin * dimens)*ratio3);
		button12.getImageCell().expand().fill();
		button13.setBounds(button8.getX() + buttoni3.getWidth() + (Uw * 5f), buttoni3.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button13.getImageCell().expand().fill();
		button14.setBounds(button9.getX() + buttoni4.getWidth() + (Uw * 5f), buttoni4.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button14.getImageCell().expand().fill();
		button15.setBounds(button10.getX() + buttoni5.getWidth() + (Uw * 5f), buttoni5.getY(), ( scalin * dimens), ( scalin * dimens)*ratio3);
		button15.getImageCell().expand().fill();
		

//		stage.addActor(febutton);

	
		bgroup = new ButtonGroup<shopbutton>(buttoni1,buttoni2,buttoni3,buttoni4,buttoni5,turretabutton,turretbbutton,magicbutton);
		sgroup = new ButtonGroup<shopbutton>(button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,flametbutton,frozentbutton,poisontbutton,lightningtbutton,lmagic,fingermagic,poisonmagic,bombmagic,hpplus,mpplus,mprplus);
		
		
		listbut.add(buttoni1);  
	    listbut.add(buttoni2);
	    listbut.add(buttoni3);
	    listbut.add(buttoni4);
	    listbut.add(buttoni5);
	    listbut.add(turretabutton);
	    listbut.add(turretbbutton);
	    listbut.add(magicbutton);
	    
//	    listbut.add(hpplus);
	    
	    
	    buttoni1.setChecked(true);
	    
	    stage.addActor(backtom);
	    
	    stage.addActor(magicbutton);
	    stage.addActor(lmagic);
	    stage.addActor(fingermagic);
	    stage.addActor(bombmagic);
	    stage.addActor(poisonmagic);
	    stage.addActor(mpplus);
	    stage.addActor(mprplus);
	    stage.addActor(hpplus);
	    //stage.addActor(fbutton);
	    //stage.addActor(gbutton);
	    //stage.addActor(tbutton);
	    
	    stage.addActor(flametbutton);
	    stage.addActor(frozentbutton);
	    stage.addActor(poisontbutton);
	    stage.addActor(lightningtbutton);
	    
	    stage.addActor(turretabutton);
	    stage.addActor(turretbbutton);
	 	stage.addActor(Yes);
	 	stage.addActor(No);
	    stage.addActor(button1);
	 	stage.addActor(button2);
	    stage.addActor(button3);
	    stage.addActor(button4);
	    stage.addActor(button5);
	    stage.addActor(button6);
	 	stage.addActor(button7);
	    stage.addActor(button8);
	    stage.addActor(button9);
	    stage.addActor(button10);
	    stage.addActor(button11);
	 	stage.addActor(button12);
	    stage.addActor(button13);
	    stage.addActor(button14);
	    stage.addActor(button15);
	 	stage.addActor(cont);
	    
	    
	   
	    stage.addActor(buttoni1);
	    stage.addActor(buttoni2);
	    stage.addActor(buttoni3);
	    stage.addActor(buttoni4);
	    stage.addActor(buttoni5);
	    
	    


	    Yes.setVisible(false);
	    	Yes.addListener(new ClickListener(){	
				@Override
				public void clicked(InputEvent e, float x, float y){
					if(game.save.money >= sgroup.getChecked().cost ){
						game.save.money -= sgroup.getChecked().cost;
					if(sgroup.getChecked().type !=4){
					save.mapbought.put(sgroup.getChecked().uid,true);
					equipping(sgroup.getChecked());
					}else{
						hpmp();
						sgroup.uncheckAll();
					}
					Yes.setVisible(false);
					No.setVisible(false);
					}
				}
			});
	    No.setVisible(false);
		No.addListener(new ClickListener(){	
			@Override
			public void clicked(InputEvent e, float x, float y){
				Yes.setVisible(false);
				No.setVisible(false);
				sgroup.uncheckAll();
			}
		});
		for(final shopbutton i: sgroup.getButtons()){
			i.addListener(new ClickListener(){
	    		@Override
	    		public void clicked(InputEvent e, float x, float y){
	    			if(i.type == 1 && empty()){
	    				buttoni1.setChecked(true);
	    			}else if(i.type == 2 && turretabutton.eqslot.equals("none") && turretbbutton.eqslot.equals("none")){
	    				turretabutton.setChecked(true);
	    			}else if(i.type == 3){
	    				magicbutton.setChecked(true);
	    			}
	    			buttonfunc(i);
	    			game.saver.persist();
	    		}
	    	});
		}


    	backtom.addListener(new ClickListener(){
    		@Override
    		public void clicked(InputEvent e, float x, float y){
    			
    			game.setScreen(game.meta);
    			Gdx.input.setInputProcessor(game.meta.mstage);
    		}
    	});
	    	cont.addListener(new ClickListener(){
	    		@Override
	    		public void clicked(InputEvent e, float x, float y){
	    			
	    			game.saver.persist();
	    			nextlevel = new Gscreen(game, false);
	    			game.setScreen(nextlevel);
	    			multi.clear();
	    			multi.addProcessor(nextlevel.gdetect);
	    			multi.addProcessor(nextlevel.stage);
	    			Gdx.input.setInputProcessor(multi);
	    			
	    		}
	    	});
	    	
	}

	 public void buttonfunc(shopbutton abutton){
		 if(save.mapbought.get(abutton.uid) == true ){
				equipping(abutton);
				}else if(game.save.money >= abutton.cost){
					
					yesnofunct(abutton);
	
	 }
	 }
	ShapeRenderer c = new ShapeRenderer();
	public void hpmp(){
		if(sgroup.getChecked().uid.equals("19")){
			game.save.maxmp += 10;
		}else if(sgroup.getChecked().uid.equals("20")){
			game.save.maxmpr += 1;
		}else if(sgroup.getChecked().uid.equals("21")){
			game.save.maxhp += 50;
		}
		game.saver.persist();
		No.setVisible(false);
	}
	public void yesnofunct(shopbutton item){
		if(item.type == bgroup.getChecked().type || item.type ==4){
			Yes.setVisible(true);
			No.setVisible(true);
			
			}
		 Gdx.input.setCatchBackKey(true);
	}
	

	public boolean empty(){
		return buttoni1.eqslot.equals("none") && buttoni2.eqslot.equals("none") && buttoni3.eqslot.equals("none") && buttoni4.eqslot.equals("none") && buttoni5.eqslot.equals("none") ;
	}
	@Override
	public void render(float delta) {
//		fmultiplyer = (float) (Math.pow(1.2f,game.save.fortify)); 
//		maxhp = (int) (game.save.maxhp * fmultiplyer);
//		maxmp = (int) (game.save.maxmp * fmultiplyer);
//		maxmpr = (int) (game.save.maxmpr * fmultiplyer);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0.41f, 0.8f, 0, 0);
	//	System.out.println(turretbbutton.getName());
		maxhp = Math.round( game.save.maxhp);
		maxmp = Math.round( game.save.maxmp) ;
		maxmpr = Math.round( game.save.maxmpr);
		stage.getViewport().apply();
		if(empty()){
			cont.setVisible(false);
		}else{
			cont.setVisible(true);
		}
	
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
//		switchingroles();
		stage.act();
		stage.getBatch().begin();
		stage.getBatch().draw(loadin.back,-4f * Uw,0,300f * Uw , Uh * 100f);
		//stage.getBatch().draw(loadin.selected, bgroup.getChecked().getX()-( 0.45f * Uw), bgroup.getChecked().getY()-(0.45f * Uh), bgroup.getChecked().getWidth()+ (0.9f * Uw),bgroup.getChecked().getHeight() + (0.9f * Uh));
		//stage.getBatch().draw(loadin.shop, Uw * 35, Uh * 80, Uw * 15, Uh * 20);
	//	font.draw(stage.getBatch(), game.gserv.getname(), 74 * Uw, 80 * Uh);
		if(sgroup.getChecked() != null){
			
			loadin.llfont.drawMultiLine(stage.getBatch(),sgroup.getChecked().description,78f * Uw, 80f * Uh);
//			if(save.mapbought.get(sgroup.getChecked().uid) == true || sgroup.getChecked().type != bgroup.getChecked().type && sgroup.getChecked().type != 4 ){
//				Yes.setVisible(false);
//				No.setVisible(false);
//			}else 
			//&& sgroup.getChecked().type == bgroup.getChecked().type
			if (save.mapbought.get(sgroup.getChecked().uid) == false   || sgroup.getChecked().type == 4){
				if(sgroup.getChecked().cost <= game.save.money && sgroup.getChecked().level <= game.save.mlevel){
					Yes.setVisible(true);
					No.setVisible(true);
				loadin.lfont.draw(stage.getBatch(),"Costs $" + sgroup.getChecked().cost + " Buy Now?",No.getX() + No.getWidth() + (2 * Uw), No.getHeight());
				}else{
					if(sgroup.getChecked().level > game.save.mlevel){
						//not
						Yes.setVisible(false);
						No.setVisible(false);
						loadin.lfont.draw(stage.getBatch(), "Pass stage " + sgroup.getChecked().level +" to unlock",Uw, No.getHeight());
					}
					if(sgroup.getChecked().cost > game.save.money){
						Yes.setVisible(false);
						No.setVisible(false);
						loadin.lfont.draw(stage.getBatch(), "Not Enough, Costs $" + sgroup.getChecked().cost,No.getX() + No.getWidth() + (30f * Uw), No.getHeight());
					}
				}
				}else{
					Yes.setVisible(false);
					No.setVisible(false);	
				}
		} 
		//stage.getBatch().draw(loadin.coin, randomcoin.get(6)[0], randomcoin.get(6)[1], Uw * 10, Uh * 10);
//		for(int i = 0; i< 5; i++){
//			for(int b = 0; b < 5  ; b++){
//			stage.getBatch().draw(loadin.coin, tempx[i], tempy[b], Uw * 10f, (Uw * 10f) *(loadin.coin.getHeight())/(loadin.coin.getWidth()));
//			}
//		}
		//stage.getBatch().draw(loadin.coin, Uw *87f, Uh * 90f, Uh * 5f, (Uh * 5f) *(loadin.coin.getHeight())/(loadin.coin.getWidth()));
		if(empty()){
			loadin.llfont.drawMultiLine(stage.getBatch(),"Must have at least \n 1 minion to start", 77f * Uw, 90f * Uh );
		}
		
		loadin.lfont.draw(stage.getBatch(),"Minions",buttoni1.getX(), buttoni1.getY() + ( buttoni1.getHeight() + (Uh * 4.55f)));
		loadin.lfont.draw(stage.getBatch(),"Turret",turretabutton.getX(), turretabutton.getY() + ( turretabutton.getHeight()+ (Uh * 4.55f) ));
		loadin.lfont.draw(stage.getBatch(),"Magic",magicbutton.getX(), magicbutton.getY() + ( magicbutton.getHeight()+ (Uh * 4.55f) ));
		loadin.lfont.draw(stage.getBatch(),"$" +game.save.money + "",Uw * 75f, Uh * 97f);
		loadin.lfont.draw(stage.getBatch(),"Health: " +maxhp,hpplus.getX(), hpplus.getY() + hpplus.getHeight() * 2f);
		loadin.lfont.draw(stage.getBatch(),"Mana: " +maxmp,mpplus.getX(), mpplus.getY()+ mpplus.getHeight() * 2f);
		loadin.lfont.draw(stage.getBatch(),"Mana/Sec: " +maxmpr,mprplus.getX(), mprplus.getY()+ mprplus.getHeight() *2f);
		
		//stage.getBatch().draw(loadin.coin, Uw *80f, Uh * 80f, Uh * 10f, (Uh * 10f) *(loadin.coin.getHeight())/(loadin.coin.getWidth()));
		
		
		


	

		
		
		stage.getBatch().end();
		dividers();
		stage.draw();
		
		 
		
		stage.getBatch().begin();
		locked();
		stage.getBatch().end();
		achievements();
	}
	public void achievements(){
		if(game.gserv.returnIn() == true){
			if(game.save.mlevel >0){
				game.gserv.unlachieve(game.a1);
			}
			if(game.save.money >= 1000000){
				game.gserv.unlachieve(game.a2);
			}
			if(fingermagic.bought && lmagic.bought && poisonmagic.bought && bombmagic.bought){
				game.gserv.unlachieve(game.a3);
			}
			if(button1.bought &&button1.bought &&button2.bought &&button3.bought &&button4.bought &&button5.bought &&button6.bought &&button7.bought &&button8.bought &&button9.bought &&button10.bought &&button11.bought &&button12.bought &&button13.bought &&button14.bought &&button15.bought ){
				game.gserv.unlachieve(game.a4);
			}
			if(lightningtbutton.bought && poisontbutton.bought && flametbutton.bought && frozentbutton.bought && button1.bought &&button1.bought &&button2.bought &&button3.bought &&button4.bought &&button5.bought &&button6.bought &&button7.bought &&button8.bought &&button9.bought &&button10.bought &&button11.bought &&button12.bought &&button13.bought &&button14.bought &&button15.bought && fingermagic.bought && lmagic.bought && poisonmagic.bought && bombmagic.bought){
				game.gserv.unlachieve(game.a5);
			}
			if(lightningtbutton.bought && poisontbutton.bought && flametbutton.bought && frozentbutton.bought){
				game.gserv.unlachieve(game.a6);
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
	public void dividers(){
		Gdx.gl.glEnable(GL20.GL_BLEND);
	      Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		c.setProjectionMatrix(stage.getCamera().combined);
		c.begin(ShapeType.Filled);
		//c.setColor(Color.RED);
		//c.rect(buttoni1.getX(), buttoni1.getY(),buttoni1.getWidth(),buttoni1.getHeight());
		c.setColor(Color.RED);
		c.rect(bgroup.getChecked().getX()-(0.5f * Uw), bgroup.getChecked().getY() - (0.5f * Uh),bgroup.getChecked().getWidth() + (1f * Uw),bgroup.getChecked().getHeight() + (1f * Uh));
		c.setColor(Color.BLUE);
		for(shopbutton i: bgroup.getButtons()){
			 c.rect(i.getX()-(0.25f * Uw), i.getY() - (0.25f * Uh),i.getWidth() + (0.5f * Uw),i.getHeight() + (0.5f * Uh));  
		  }
		c.setColor(new Color(0f,0f,0f,0.2f));
		c.rect(buttoni5.getX() - (0.5f * Uw), buttoni5.getY() - (0.5f * Uh),buttoni1.getX() + (buttoni1.getWidth() * 5.9f),buttoni1.getY()+buttoni1.getHeight() - buttoni5.getY() + Uh);//+ (buttoni1.getHeight() * 0.8f));
		c.setColor(new Color(1f,1f,0f,0.2f));
		c.rect(turretabutton.getX() - (1f * Uw), buttoni5.getY() - (0.5f * Uh), (turretabutton.getWidth() * 2.5f),buttoni1.getY()+buttoni1.getHeight() - buttoni5.getY() + Uh  );//+ (buttoni1.getHeight() * 0.8f));
		c.setColor(new Color(0.6f,0f,0.8f,0.2f));
		c.rect(magicbutton.getX() - (0.5f * Uw), buttoni5.getY() - (0.5f * Uh), (magicbutton.getWidth() * 1.1f),buttoni1.getY()+buttoni1.getHeight() - buttoni5.getY() + Uh );// + (buttoni1.getHeight() * 0.8f));
		c.end();
		
	}
	public void equipping(shopbutton item){
		
		if(item.type == bgroup.getChecked().type){
		bgroup.getChecked().setStyle(item.getStyle());
		bgroup.getChecked().eqslot = item.activename;
		item.bought = true;
	//	bgroup.getChecked().bought = item.bought;
		norep(bgroup.getChecked(),bgroup.getChecked());
		
		}else{
			item.bought = true;
		}
	}
	public void norep(shopbutton equipped, shopbutton other){
		for(shopbutton i: listbut){
			if(i != equipped && i.eqslot.equals(other.eqslot) ){
				//System.out.println(mapsetslots.get(i) + " " + mapsetslots.get(other));
				i.setStyle(loadin.NAbuttonstyle);
				i.eqslot = "none";
				//mapsetslots.put(i, "none");
			}
		}
	}
	public void locked(){
		for(shopbutton i: sgroup.getButtons()){
			if(i.bought != true && i.type != 4){
				stage.getBatch().draw(loadin.lock, i.getX()+i.getWidth()/8f,i.getY() + i.getHeight()/1.9f,i.getWidth()/6f,i.getHeight()/3f);
			}
		}
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	
//		stage.getViewport().update(width, height);
//		stage.getViewport().apply();
		Uw = Gdx.graphics.getWidth()/100f;
		Uh = Gdx.graphics.getHeight()/100f;
		//ac1 = stage.getActors().get(0);
		//ac1.setBounds(, y, width, height);
		stage.getViewport().update(width, height,false);
		stage.getViewport().apply();
		backtom.setPosition(90f * Uw, backtom.getHeight());
		cont.setPosition(90f * Uw, backtom.getY() + cont.getHeight() + Uh);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		game.saver.persist();
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
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
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	
}
