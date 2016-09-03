package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

class castle {
	Rectangle self;
	int hp ;
	float xpos;
	float ypos;
	int checkhp = hp;
	Animation pic;
	Animation hurt;
	boolean allyenemy;
	SpriteBatch drawer;
	Gscreen level;
	turret turreta;
	String turretaid;
	turret turretb;
	String turretbid;
	float chkhpdelay = 0;
	float Uw = Gdx.graphics.getWidth()/100;
	float Uh = Gdx.graphics.getHeight()/100;

	public castle(int hp, boolean allyenemy, float xpos, Animation pict, SpriteBatch draw, Gscreen level, String turretaid, String turretbid){
		pic = pict;
		this.hp = hp;
		this.turretaid = turretaid;
		this.turretbid = turretbid;
		this.xpos = xpos;
		ypos = Uh * 20f;
		self = new Rectangle().setSize(Uw * 60f, Uh * 80f);
		this.level = level;
		drawer = draw;
		this.allyenemy = allyenemy;
//
//		useturreta();
//		useturretb();
		if(allyenemy == true){
	//		self.setPosition(xpos - self.getWidth(), ypos);
			self.setPosition(xpos - (self.getWidth()),ypos);
			hurt = level.loadin.enemycastlehurtAnim;
			if(turretaid != "none"){
			turreta = new turret(level,level.loadin.maptur.get(turretaid)[0],new Vector2(xpos - self.getWidth()/3f,ypos + self.getHeight()/4.2f), allyenemy,level.loadin.maptur.get(turretaid)[1],Math.round(level.loadin.mapdata.get(turretaid)[0]),level.loadin.mapdata.get(turretaid)[1],Math.round(level.loadin.mapdata.get(turretaid)[2]),level.loadin.mapdata.get(turretaid)[3]);
			}
			if(turretbid != "none"){
			turretb = new turret(level,level.loadin.maptur.get(turretbid)[0],new Vector2(xpos - self.getWidth()/1.2f,ypos + self.getHeight()/4.2f), allyenemy, level.loadin.maptur.get(turretbid)[1],Math.round(level.loadin.mapdata.get(turretbid)[0]),level.loadin.mapdata.get(turretbid)[1],Math.round(level.loadin.mapdata.get(turretbid)[2]),level.loadin.mapdata.get(turretbid)[3]);
			}
		}else{
			self.setPosition(xpos, ypos);
			hurt = level.loadin.mycastlehurtAnim;
			if(!turretaid.equals("none")){
			turreta = new turret(level,level.loadin.maptur.get(turretaid)[0],new Vector2(xpos + self.getWidth()/6f,ypos + self.getHeight()/4.2f), allyenemy, level.loadin.maptur.get(turretaid)[1],Math.round(level.loadin.mapdata.get(turretaid)[0]),level.loadin.mapdata.get(turretaid)[1],Math.round(level.loadin.mapdata.get(turretaid)[2]),level.loadin.mapdata.get(turretaid)[3]);
			}
			if(!turretbid.equals( "none")){
			turretb = new turret(level,level.loadin.maptur.get(turretbid)[0],new Vector2(xpos + self.getWidth()/1.5f,ypos + self.getHeight()/4.2f), allyenemy, level.loadin.maptur.get(turretbid)[1],Math.round(level.loadin.mapdata.get(turretbid)[0]),level.loadin.mapdata.get(turretbid)[1],Math.round(level.loadin.mapdata.get(turretbid)[2]),level.loadin.mapdata.get(turretbid)[3]);
			}
		}
	//	turreta = new turret(level,turretapic,(allyenemy ? new Vector2(xpos - self.getWidth()/3f,ypos + self.getHeight()/4.2f):new Vector2(xpos + self.getWidth()/6f,ypos + self.getHeight()/4.2f)), allyenemy,turretabulletpic,turretadelay,turretaatktype);
	//	turreta = new turret(level,turretapic,(allyenemy ? new Vector2(xpos - self.getWidth()/1.2f,ypos + self.getHeight()/4.2f):new Vector2(xpos + self.getWidth()/1.5f,ypos + self.getHeight()/4.2f)), allyenemy,turretbbulletpic,turretbdelay,turretbatktype);
	}
	

	public void update(){
		
		if(damaged() == true){
			drawer.draw(hurt.getKeyFrame(level.time,true), self.x, self.y, self.getWidth(),self.getHeight());
			} else {
			drawer.draw(pic.getKeyFrame(level.time,true), self.x, self.y, self.getWidth(),self.getHeight());
			}
		if(turreta != null){
		turreta.update();
		}
		if(turretb != null){
		turretb.update();
		}
		
	}
	public void resize(){
		Uw = Gdx.graphics.getWidth()/100f;
		Uh = Gdx.graphics.getHeight()/100f;
	}
	public boolean damaged(){
		chkhpdelay -= Gdx.graphics.getDeltaTime();
		for(grunt i: level.grunts){
			if(i.targetc == this){
				return true;	
		
			}
		}
	return false;
	}
}
