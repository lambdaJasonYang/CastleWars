package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Beta extends Game implements ApplicationListener{

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










