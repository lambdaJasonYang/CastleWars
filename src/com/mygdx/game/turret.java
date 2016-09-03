package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class turret {
	boolean allyenemy = true;
	ArrayList<grunt> targetlist;
	ArrayList<bullet> bullets;
	grunt target;
	final Vector2 position;
	Gscreen level;
	int type;
	float maind;
	Texture bulletpic;
	Texture turretpic;
	float delay;
	int damage;
	float statatk;
	float counter = 0;
	public turret(Gscreen level, Texture turretpic, Vector2 position, boolean allyenemy, Texture bulletpic,int damage, float delay, int type, float statatk){
		this.level = level;
		this.allyenemy = allyenemy;
		this.type = type;
		this.turretpic = turretpic;
		this.position = position;
		this.bulletpic = bulletpic;
		this.delay = delay;
		if(Gdx.graphics.getWidth() > Gdx.graphics.getHeight()){
			maind = level.Uw;
		}else{
			maind = level.Uh;
		}
		bullets = level.bullets;
		targetlist = new ArrayList<grunt>();
		this.damage = damage;
		this.statatk = statatk;
	}
	public void randtar(){
		
		for(grunt a: level.grunts){
			if(a.allyenemy != this.allyenemy && a.gsoul.hp > 0){
				if(allyenemy ? (a.gsoul.PosX > level.backpos/2): (a.gsoul.PosX < level.backpos/2 )&& a.gsoul.PosX > 0){
				targetlist.add(a);
		}
	}
		}
		if(targetlist.size() != 0){
		target = targetlist.get((int)( Math.random() * targetlist.size()));
		targetlist.clear();
		}
	}
	public void singtar(){
	
		for(grunt a: level.grunts){
			if(a.allyenemy != this.allyenemy && a.gsoul.hp > 0){
				if(allyenemy ? (a.gsoul.PosX > level.backpos/2 ) : (a.gsoul.PosX < level.backpos/2 ) && a.gsoul.PosX > 0){
				target = a;
		}
	}
		}
	}
	public void update(){
		
		level.batch.draw(turretpic, position.x, position.y, 10f * maind, 10f * maind);
		switch(type){
		case 1:
			singtar();
			break;
		case 2:
			randtar();
			break;
		}
	
		if(counter >= delay){
			if(target != null){
			if(target.gsoul.hp <= 0){
				target.bedead = true;
			}
			bullets.add(new bullet(position, target,allyenemy,bulletpic,damage,statatk));
			level.loadin.turretfiresfx.play();
			target = null;
			
			}
			
			
			
		counter = 0;
		}else{
			counter += Gdx.graphics.getDeltaTime();
		}
	}
}
