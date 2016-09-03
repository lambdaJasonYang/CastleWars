package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class bullet {
	boolean allyenemy = true;
	Vector2 position;
	boolean lockx = false;
	boolean locky = false;
	float movey;
	float movex;
	int damage;
	float statatk;
	grunt target = null;
	Boolean dead = false;
	float Uw;
	float Uh;
	Texture bulletpic;
	public bullet(Vector2 position, grunt target, boolean allyenemy,Texture bulletpic2, int damage, float statatk){
		this.bulletpic = bulletpic2;
		 Uw = Gdx.graphics.getWidth()/100;
		 Uh = Gdx.graphics.getHeight()/100;
		 this.position = new Vector2();
		 this.position.x = position.x;
		 this.position.y = position.y;
		 this.allyenemy = allyenemy;
		 this.target = target;
		 this.damage = damage;
		 this.statatk = statatk;
	
	}
//	public bullet(grunt owner,grunt target,Animation bulletpic){
//		this.bulletpic = bulletpic;
//		 Uw = Gdx.graphics.getWidth()/100;
//		 Uh = Gdx.graphics.getHeight()/100;
//		position  = new Vector2();
//		this.owner= owner;
//		this.target = target;
//		position.x = owner.PosX;
//		position.y = owner.PosY + (owner.self.height/2f);
//		difx = Math.abs(target.PosX - position.x);
//		dify = Math.abs(target.PosY - position.y);
//		velox = difx/22;
//		veloy = dify/22;
//	}
	

	public void update(){
		if(target != null){
		if(target.gsoul.hp <= 0 ){
			dead = true;
			target = null;
		}
		if(dead == false){
				if(locky == false){
					movey = ((target.self.y + target.self.height/3) - position.y)/40f;
					locky = true;
				}
				if(lockx == false){
					movex = (target.self.x - position.x)/40f;
					lockx = true; 
				}
				position.y += movey;
				position.x += movex;
				
				//if(position.x > (target.PosX - target.self.width/3) && position.x < (target.PosX + target.self.width/3) && position.y > (target.PosY - target.self.height/3) && position.y < (target.PosY + target.self.height/3)  ){
				if(position.x > (target.self.x - Uw * 3) && position.x < (target.self.x + Uw * 3) && position.y > (target.self.y + target.self.height/3 - Uh * 3) && position.y < (target.self.y + target.self.height/3 + Uh * 3)  ){
				 
		//		if(target.self.contains(position.x,position.y)){	
				if(!target.gsoul.inflictedstatus.contains(statatk)){
					target.gsoul.inflictedstatus.add(statatk);
				}
					target.gsoul.hp -= damage;
				dead = true;
				}								
			}
		
		}else{
			dead = true;
	}
	}
}