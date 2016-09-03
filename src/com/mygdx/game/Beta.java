package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Beta extends Game implements ApplicationListener{
	String a1 = "CggIzI7o5gUQAhAB"; //noob
	String a2 = "CggIzI7o5gUQAhAC"; //mill
	String a3 = "CggIzI7o5gUQAhAD";//wiz
	String a4 = "CggIzI7o5gUQAhAE";//sum
	String a5 = "CggIzI7o5gUQAhAF";//mriwant
	String a6 ="CggIzI7o5gUQAhAG";//td
	String a7 ="CggIzI7o5gUQAhAH";//resili
	String a8= "CggIzI7o5gUQAhAI";//allmy
	String a9="CggIzI7o5gUQAhAJ";//alilless
	String a10="CggIzI7o5gUQAhAK";//novice
	String a11="CggIzI7o5gUQAhAL";//true dis
	String a12="CggIzI7o5gUQAhAM";//gobroke
	String l1 ="CggIzI7o5gUQAhAN";
	String l2 ="CggIzI7o5gUQAhAO";
	datas save;
	shop shoppin;
	mainmenu meta;	
	Assetloader loadin;
	IGoogleServices gserv;
	winloss wlscreen;
	learn mlearn;
	itemshop mitemshop;
	DatasManager saver;
	public Beta(){
		
	}
	public Beta(IGoogleServices gserv ){
	this.gserv =  gserv;	
	}

	public void create() {

			saver =  new DatasManager();

		//gserv.signOut();
		save = saver.retrieve();
		if(save.iapbought == true){
			gserv.showAds(false);
		}
		loadin = new Assetloader();
		mlearn = new learn(this);
		mitemshop = new itemshop(this);
		wlscreen = new winloss(this);
		shoppin = new shop(this);
		meta = new mainmenu(this);
		setScreen((Screen) meta);
		//setScreen((Screen) shoppin);
		
	}
}










