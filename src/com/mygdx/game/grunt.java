package com.mygdx.game;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class grunt {
	Boolean melee = true;
	Boolean bedead = false;
	Boolean tapped = false;
	float bedeaddelay = 0.1f;
	//int gsoul.priority = 0;
	ArrayList<grunt> targlist = new ArrayList<grunt>();
	ArrayList<castle> targlist2 = new ArrayList<castle>();
	ArrayList<grunt> target;
	float Uw = Gdx.graphics.getWidth()/100f;
	float Uh = Gdx.graphics.getHeight()/100f;
	float wide;
	float high;
	float highPure;
	Boolean interfere = false;
	
	Boolean allyenemy = false;
	castle targetc = null;
	SpriteBatch batch;
//	float gsoul.PosX, gsoul.PosY;
//	float gsoul.PosXPure, gsoul.PosYPure;
	float range = 0;
	float rangePure;
	float Speed = 1f;
//	float hp = 100;
//	float gsoul.damage = 12;
//	float checkhp = 100;
//	float gsoul.maxhp = hp;
//	int gsoul.hitnumber = 0;
	double delay = 0;
	grunt targetholder;
	Rectangle targetbox;
	Rectangle stopbox;
	Rectangle self;
	TextureRegion gg;
	Animation animated;
	Animation attack;
//	ArrayList<String> gsoul.inflictedstatus = new ArrayList<String>();
//	String gsoul.statatk = "flame";
	double statdelay = 1;
//	float gsoul.rSpeedPure;

	Map<Float, Animation> mapstat = new HashMap<Float, Animation>();
	Animation doom;
	Texture blast;
	Assetloader loadin;
	Gscreen level;
	soul gsoul;
	
	public grunt(){
	}
	public grunt(Gscreen level,float high,soul gsoul){
		this.gsoul = gsoul;
		this.gsoul.id = level.gruntid;
		level.gruntid ++;
		this.level = level;
		this.loadin = level.loadin;
		this.allyenemy = gsoul.allyenemy;
	
		rangePure = gsoul.range;
		this.range = rangePure * Uw;
		highPure = high;
		this.high = highPure * Uh;
		animated = loadin.mapanim.get(this.gsoul.monster)[0];	
		attack = loadin.mapanim.get(this.gsoul.monster)[1];
		ratiow = (float)(animated.getKeyFrame(0.4f).getRegionHeight())/(float)(animated.getKeyFrame(0.4f).getRegionWidth());
		wide = (float)((high/ratiow)*0.8f);
		
		
		
		
		if(allyenemy == false){
			level.allyqueuecount ++;
			this.gsoul.priority = level.allyqueuecount;
			this.gsoul.rSpeedPure = this.gsoul.rSpeedPure;
			self = new Rectangle(gsoul.PosX, gsoul.PosY, wide, high);
			this.gsoul.PosXPure = (level.gcas.xpos + level.gcas.self.width/2f)/Uw;
			
		}else{
			level.minionqueuecount ++;
			this.gsoul.priority = level.minionqueuecount;
			this.gsoul.rSpeedPure = -this.gsoul.rSpeedPure;
			self = new Rectangle(level.backpos, gsoul.PosY, wide, high);
			//	gsoul.PosXPure = (level.ecas.xpos - (level.ecas.self.width/2f))/Uw;
			this.gsoul.PosXPure = (level.backpos - (level.ecas.self.width) - (self.width * 2f))/Uw;
			
		}
		this.gsoul.PosX = -999f;
	
		targlist = level.grunts;
		targlist2 = level.allcastles;
		batch = level.batch;
		
		targetbox = new Rectangle();
		stopbox = new Rectangle();
		target = new ArrayList<grunt>();
	
		mapstat.put(1f, loadin.flame);
		mapstat.put(2f, loadin.frozen);
		mapstat.put(3f, loadin.poison);
		mapstat.put(4f, loadin.light);
	}
	boolean stopping(){
		for(grunt a: targlist){
			if(a.allyenemy == this.allyenemy && a.gsoul.hp >0){
				if(Intersector.overlaps(stopbox, a.self) && a.gsoul.priority < this.gsoul.priority){
					return true;
				}else if(Intersector.overlaps(self, a.self) && a.gsoul.priority < this.gsoul.priority){
					return true;
				}
			}
		}
		return false;
	}

	public void checker(grunt en){
		if(Intersector.overlaps(targetbox,en.self) == false && target.contains(en) == true){
			target.remove(en);
		}
	}
	public void multitar(){
		for(grunt a: targlist){
			if(a.allyenemy != allyenemy && a.gsoul.hp >0){
				checker(a);
				if(Intersector.overlaps(targetbox, a.self)){
					if(target.contains(a) == false){
						target.add(a);
					}
					targetc = null;
				}
				else{
					target.remove(a);
				}
			}
		}
	}

	public void singletar(){
		for(grunt a: targlist){
			if(a.allyenemy != this.allyenemy && a.gsoul.hp > 0){
				checker(a);
			
			if(Intersector.overlaps(targetbox,a.self) && target.contains(a) == true){
				break;
			}
			if(Intersector.overlaps(targetbox,a.self) && target.contains(a) == false){
				target.add(a);
				targetc = null;
				break;
			}
		}
		}
		}
	public void randtar(){
		for(grunt a :targlist){
			if(a.allyenemy != this.allyenemy && a.gsoul.hp > 0){
			checker(a);
			if(Intersector.overlaps(targetbox,a.self) && target.contains(a) == false){
				target.add(a);
				targetc = null;
			}
			}
		}
		if(target.size() != 0){
			targetholder = target.get((int)( Math.random() * target.size()));
			target.clear();
			target.add(targetholder);
			}
		}
	public void farthtar(float max){
	target.clear();
	if(target.size() == 0){
		for(grunt a: targlist){
			if(a.allyenemy != this.allyenemy && a.gsoul.hp > 0){
				checker(a);
				if(Math.abs(gsoul.PosX - a.gsoul.PosX) > max && Intersector.overlaps(targetbox,a.self) && target.contains(a) == false){
					target.clear();
				//	Gdx.app.log("er", String.valueOf(Math.abs(gsoul.PosX - a.gsoul.PosX)));
					max = Math.abs(gsoul.PosX - a.gsoul.PosX);
					target.add(a);
				targetc = null;	
				}
			}
			}
		}
	}
	public void casltar(Boolean aore){
		if(target.size() == 0){
			for(castle a: targlist2){
				if(a.allyenemy != this.allyenemy){
					if(Intersector.overlaps(targetbox,a.self)){
						target.clear();
						targetc = a;
					}
					else if(Intersector.overlaps(targetbox,a.self) == false && targetc != null){
						targetc = null;
					}
				}
			}
		}
	}
	
	public void gettarget(int type, Boolean allymin){
		float max = 0;
	//	int deadn = -1;
		for (int i = 0; i< target.size(); i++){
			if(target.get(i).gsoul.hp <= 0){
				target.get(i).bedead = true;
				target.remove(i);
				
			}
			}
			if(targetc != null && targetc.hp <= 0){
				targetc = null;
			}
		//if(deadn != -1){target.remove(deadn);}
		//stopp();
		casltar(allymin);
		
		
		switch(type){
		case 1:
		multitar();
		break;
		//single
		case 2:
		singletar();
		break;
		//random
		case 3:
		randtar();
		break;
			//farthest
		case 4:
		farthtar(max);
		break;
		}

	
}
	
	TextureRegion framewalk;
	float ratio;
	float ratiow;
	float moveAnimPosX = 0;
	float moveAnimPosY = 0;
	float chkhpdelay = 0;
	
	public void hit(){
		chkhpdelay -= Gdx.graphics.getDeltaTime();
		if(gsoul.hp != gsoul.checkhp ){
			chkhpdelay = 2f;
			gsoul.checkhp = gsoul.hp;
		}
		if (gsoul.hitnumber != 0f && chkhpdelay > 0){// normal blood from hit
			
			batch.draw(loadin.normalhit.getKeyFrame(level.time,true), allyenemy ? gsoul.PosX + loadin.normalhit.getKeyFrame(level.time).getRegionWidth(): gsoul.PosX + self.width, gsoul.PosY,allyenemy ? self.width : -self.width ,self.height );
		}
		if (gsoul.hitnumber == 2f && chkhpdelay > 0){
			//batch.draw(loadin.shot.getKeyFrame(level.time,true),gsoul.PosX - self.width, gsoul.PosY - self.width/2,182,161);
			batch.draw(loadin.cyborgatkr.getKeyFrame(level.time,true), allyenemy ? gsoul.PosX+ loadin.normalhit.getKeyFrame(level.time).getRegionWidth(): gsoul.PosX + self.width, gsoul.PosY,allyenemy ? self.width : -self.width ,self.height );
		}
		if (gsoul.hitnumber == 3f && chkhpdelay > 0){// lightning touch
			batch.draw(loadin.lightning.getKeyFrame(level.time,true),gsoul.PosX, gsoul.PosY,self.width * 1.5f,Uh * 110);
		//	gsoul.hitnumber = 0;
	  	}
		if (gsoul.hitnumber == 4f && chkhpdelay > 0){// normal blood from hit
			
			batch.draw(loadin.skellyatkr.getKeyFrame(level.time,true), allyenemy ? gsoul.PosX+ loadin.normalhit.getKeyFrame(level.time).getRegionWidth(): gsoul.PosX + self.width, gsoul.PosY,allyenemy ? self.width : -self.width ,self.height );
		}
		if (gsoul.hitnumber == 5f && chkhpdelay > 0){// normal blood from hit
			
			batch.draw(loadin.treeminionatkr.getKeyFrame(level.time,true), allyenemy ? gsoul.PosX+ loadin.normalhit.getKeyFrame(level.time).getRegionWidth(): gsoul.PosX + self.width, gsoul.PosY,allyenemy ? self.width : -self.width ,self.height );
		}
	if (gsoul.hitnumber == 6f && chkhpdelay > 0){// normal blood from hit
			
			batch.draw(loadin.poisontouch.getKeyFrame(level.time,true), allyenemy ? gsoul.PosX+ loadin.normalhit.getKeyFrame(level.time).getRegionWidth(): gsoul.PosX + self.width, gsoul.PosY,allyenemy ? self.width : -self.width ,self.height );
		}
	if (gsoul.hitnumber == 8f && chkhpdelay > 0){// normal blood from hit
		
		batch.draw(loadin.fingertouch.getKeyFrame(level.time,true), allyenemy ? gsoul.PosX+ loadin.normalhit.getKeyFrame(level.time).getRegionWidth(): gsoul.PosX + self.width, gsoul.PosY,allyenemy ? self.width : -self.width ,self.height );
	}
	if (gsoul.hitnumber == 7f && chkhpdelay > 0){// normal blood from hit
		
		batch.draw(loadin.bombtouch.getKeyFrame(level.time,true), allyenemy ? gsoul.PosX+ loadin.normalhit.getKeyFrame(level.time).getRegionWidth(): gsoul.PosX + self.width, gsoul.PosY,allyenemy ? self.width : -self.width ,self.height );
	}
		if (gsoul.hp <= 0){ // death animation
			//batch.draw(loadin.shot.getKeyFrame(level.time,true),gsoul.PosX, gsoul.PosY+ self.height/3f,300,161);
			batch.draw(loadin.rip,gsoul.PosX, gsoul.PosY,self.width * 1.5f,self.height * 1.5f);
			this.bedead = true;
			
			
		}
		
	}
	float divider = Uw;

	boolean statdelay2tf = false;
	float statdelay3 = 2f;
	float statdelay4 = 10f;
	public void statuseffect(){
	
		
		while(gsoul.inflictedstatus.contains(0f)){
			gsoul.inflictedstatus.remove(0f);
		}
		if(gsoul.inflictedstatus.contains(1f)){
			if(statdelay <= 0){
			statdelay = 2f;
			gsoul.hp -= 2;
			} else {
				statdelay -= Gdx.graphics.getDeltaTime();
			}
		}
		if(gsoul.inflictedstatus.contains(2f)  && statdelay2tf == false){
			
			this.gsoul.rSpeedPure = gsoul.rSpeedPure * 0.5f;
			statdelay2tf =true;
			
		}
		if(gsoul.inflictedstatus.contains(3f)){
			if(statdelay3 <= 0){
			statdelay = 2f;
			gsoul.hp -= (int)(gsoul.maxhp * 0.04f);
			} else {
				statdelay3 -= Gdx.graphics.getDeltaTime();
			}
		}
		if(gsoul.inflictedstatus.contains(4f)){
			if(statdelay4 <= 0){
				gsoul.hp -= 30;
				statdelay4 = 5f;
			}else{
				statdelay4 -= Gdx.graphics.getDeltaTime();
			}
		}
		if(gsoul.inflictedstatus.size() != 0){
			for(int i = 0; i < gsoul.inflictedstatus.size();i ++){
				if(i %2 == 0 ){
				batch.draw(mapstat.get(gsoul.inflictedstatus.get(i)).getKeyFrame(level.time,true),gsoul.PosX - (i/2 * (5f *Uw)) , gsoul.PosY + self.height + (2f * Uh),self.width,self.height/1.5f);
				}else if (i % 2 == 1){
					batch.draw(mapstat.get(gsoul.inflictedstatus.get(i)).getKeyFrame(level.time,true),gsoul.PosX +((i + 1)/2 * (5f*Uw)), gsoul.PosY + self.height + (2f * Uh),self.width,self.height/1.5f);	
				}
				}
			}

	}
	float clearing = 0.4f;
	float timedtap = 0.8f;
	public void update(){
		//System.out.println(colorhp(this.hp));
		gsoul.PosYPure = 20f ;
		gsoul.PosY = gsoul.PosYPure * Uh;
		gsoul.PosXPure += Speed;
		gsoul.PosX = gsoul.PosXPure * Uw;
		//gsoul.PosX = 3200f;
		//System.out.println(gsoul.PosX);
		//System.out.println(level.ecas.gsoul.PosX);
		if(tapped == false && target.size() == 0 && clearing <= 0f){
			gsoul.hitnumber = 0;
			clearing = 0.4f;
		}else{
			clearing -= Gdx.graphics.getDeltaTime();
		}
		
		if(tapped == true){
			if(timedtap < 0f){
				gsoul.hitnumber = 0;
				tapped = false;
				timedtap = 0.8f;
			}else{
				timedtap -= Gdx.graphics.getDeltaTime();
			}
		}
		if(this.gsoul.hp < 0f || this.bedead == true){
			this.gsoul.damage = 0;
			this.gsoul.inflictedstatus.clear();
			for(grunt i: target){
				i.gsoul.hitnumber = 0;
			}
			target.clear();
			
			bedeaddelay -= Gdx.graphics.getDeltaTime();
			if(bedeaddelay < 0){
				bedead = true;
			}
			hit();
		}else{
		targetbox.set(allyenemy ?  (float)gsoul.PosX- range : gsoul.PosX+self.getWidth() , gsoul.PosY, range, 10f * Uh);
		stopbox.set(allyenemy ?  (float)(gsoul.PosX- self.getWidth()/2f  ) : gsoul.PosX+self.getWidth() + self.getWidth()/2f, gsoul.PosY, self.getWidth()/2f, 10f * Uh);


		//Gdx.app.log("s", String.valueOf(target.size()));
		//System.out.println(String.valueOf(targetc != null));
		
		ratiow = (float)(animated.getKeyFrame(level.time,true).getRegionHeight())/(float)(animated.getKeyFrame(level.time,true).getRegionWidth());
		wide = (float)((high/ratiow)*0.8f);
		gettarget((int)gsoul.targettype,allyenemy);
		
		
		self.set(gsoul.PosX, gsoul.PosY,wide,high);
		
	//	atkAnimPosX = gsoul.PosX-self.getWidth()/2f;
	//	System.out.println(attack.getKeyFrameIndex(level.time));
		statuseffect();
		attackenemy(target,targetc,gsoul.statatk);
		
		
		level.hpshape.setColor(colorhp(this.gsoul.hp));
		level.hpshape.circle(this.self.x + this.self.width/2f, this.self.y + this.self.height + (3f * Uh), self.width/8f);
		
		hit();
		}
	}
	
	public void attackenemy(ArrayList<grunt> targete, castle targetcc, float statatk){
//		AnimPosX = gsoul.PosX - self.getWidth()/2;
		if(this.gsoul.hp >= 0f){
		//time += Gdx.graphics.getDeltaTime();
		ratio = (float)(attack.getKeyFrame(level.time,true).getRegionHeight())/(float)(attack.getKeyFrame(level.time,true).getRegionWidth());

			if(targete.size() == 0 && targetcc == null){
				if(stopping()){
					batch.draw(animated.getKeyFrame(level.time,true),allyenemy ? gsoul.PosX + high/ratiow: gsoul.PosX , gsoul.PosY,allyenemy ? -high/ratiow : high/ratiow,high);
					Speed = 0;
				}else{
				batch.draw(animated.getKeyFrame(level.time,true),allyenemy ? gsoul.PosX + high/ratiow: gsoul.PosX , gsoul.PosY,allyenemy ? -high/ratiow : high/ratiow,high);
				
				Speed = gsoul.rSpeedPure;
				}
			} else if(targete.size() != 0){	
				//ratio = (float)(attack.getKeyFrame(time,true).getRegionHeight())/(float)(attack.getKeyFrame(time,true).getRegionWidth());
			
				batch.draw(attack.getKeyFrame(level.time,true),allyenemy ? gsoul.PosX + high/ratio: gsoul.PosX,gsoul.PosY,allyenemy ? -high/ratio : high/ratio,high);	
				Speed = 0;
				
				delayhit(target);
				
			}else if(targetcc != null){
				
				batch.draw(attack.getKeyFrame(level.time,true),allyenemy ? gsoul.PosX + high/ratio: gsoul.PosX,gsoul.PosY,allyenemy ? -high/ratio: high/ratio,high);
				
				
				Speed = 0;
				delayhit(targetcc);
			}
			}
	
	
	}

	public void delayhit(ArrayList <grunt> targeti){
		
		if(delay < 0){
			for(grunt i: targeti){
			//targethit(i);
				
				//i.hp -= 1;
				delay = 0.3f;
				
				i.gsoul.hp -= gsoul.damage;
				i.gsoul.hitnumber = gsoul.hitatk;
				loadin.hitsfx.play();
				if(gsoul.statatk != 0 && !(i.gsoul.inflictedstatus.contains(gsoul.statatk))){
					i.gsoul.inflictedstatus.add(gsoul.statatk);
					
				}
			
			Gdx.app.log("grunt", String.valueOf(i.gsoul.hp));
			}
		}else{
	
		delay -= Gdx.graphics.getDeltaTime();
			}
	}
	public void delayhit(castle targeti){
		
		if(delay < 0){
	
			targeti.hp -= gsoul.damage;			
			delay = 0.3f;
			loadin.castlehitsfx.play();
			Gdx.app.log("grunt", String.valueOf(targeti.hp));
		}else{
		delay -= Gdx.graphics.getDeltaTime();
			}
	}
	public void resize(){
		Uw = Gdx.graphics.getWidth()/100f;
		Uh = Gdx.graphics.getHeight()/100f;
		
	}
	
public Color colorhp(float currenthp ){
	float red = 0f;
	float green = 1f;
	float yellow = 1f;
	float percenthp = currenthp/gsoul.maxhp;
	if(percenthp > 0.75f){
		green = 1f;
		yellow = (percenthp - 0.75f) * 4f;
		return new Color(0f, green, yellow, 0f);
	}else if (percenthp > 0.5f && percenthp <= 0.75f){
		green = 1f;
		red = 1f - ((percenthp - 0.5f) * 4f);
		return new Color(red, green, 0f, 0f);
	}else if (percenthp > 0.25f && percenthp <= 0.5f){
		red = 1f;
		green = (percenthp - 0.25f) * 4f;
		return new Color(red,green, 0f, 0f);
	}else{
		green = 0f;
		red = (percenthp) * 4f;
		return new Color(red,green, 0f,0f);
	}
}
	}

