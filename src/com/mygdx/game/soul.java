package com.mygdx.game;

import java.io.Serializable;
import java.util.ArrayList;


public class soul implements Serializable{
	int priority = 0;
	Boolean allyenemy;
	Boolean melee = true;
	int id = 0;
	String monster;
//	Boolean interfere = false;
	int type = 1;//randomatk multi
//Boolean allyenemy = false;
	float PosX, PosY;
	float PosXPure, PosYPure;
//	float range = 0;
//	float rangePure;
//	float Speed = 1f;
	float hp;// = 100;
	float damage;// = 12;
	float checkhp;// = 100;
	float maxhp;
	float hitatk;
	float hitnumber;// = 0;
	float range;
	float targettype;
	ArrayList<Float> inflictedstatus = new ArrayList<Float>();
	float statatk;// = "flame";
	double statdelay = 1;
	float rSpeedPure;
	//public soul(int priority, Boolean melee, float wide, float high, float highPure, Boolean interfere, Boolean type, Boolean allyenemy, float PosX, float PosY, float PosXPure, float PosYPure, )
	public soul(){
	}
	public soul(String monster, Boolean allyenemy,float hp,float damage,float rSpeedPure,float range, float statatk, float hitatk, float targettype){
		this.monster = monster;
		this.allyenemy = allyenemy;
		this.hp = hp;
		checkhp = this.hp;
		maxhp = this.hp;
		
		this.damage = damage;
		this.rSpeedPure = rSpeedPure;
		this.range = range;
		this.statatk = statatk;
		this.hitatk = hitatk;
		this.targettype = targettype;
	}
}
