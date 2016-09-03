package com.mygdx.game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class datas implements Serializable{
	Integer money;
	Integer level;
	Map<String, Boolean> mapbought = new HashMap<String, Boolean>();
	Float maxhp;
	Float maxmp;
	Float maxmpr;
	Boolean iapbought;
	Integer mlevel;
	Integer fortify;  
	Integer diamond;
	public datas(){
		level = new Integer(1);
		iapbought = false;
		money = new Integer(5000);
		maxhp = new Float(200);
		maxmp = new Float(100);
		maxmpr = new Float(2);
		mlevel = new Integer(0);
		fortify = new Integer(0);
		diamond = new Integer(0);
		mapbought.put("1", true);
		mapbought.put("2", false);
		mapbought.put("3", false);
		mapbought.put("4", false);
		mapbought.put("5", false);
		mapbought.put("6", false);
		mapbought.put("7", false);
		mapbought.put("8", false);
		mapbought.put("9", false);
		mapbought.put("10", false);
		mapbought.put("11", false);
		mapbought.put("12", false);
		mapbought.put("13", false);
		mapbought.put("14", false);
		mapbought.put("15", false);
		mapbought.put("16", false);
		mapbought.put("17", false);	
		mapbought.put("18", false);
		mapbought.put("19", false);
		mapbought.put("20", false);
		mapbought.put("21", false);
		mapbought.put("22", false);
		mapbought.put("23", false);
		mapbought.put("24", false);
		mapbought.put("25", false);
		mapbought.put("26", false);
		mapbought.put("27", false);
		mapbought.put("28", false);
		mapbought.put("29", false);
		mapbought.put("30", false);
		mapbought.put("31", false);
		mapbought.put("32", false);
		mapbought.put("33", false);
		mapbought.put("34", false);

}

	@Override
	public void write(Json json) {
		// TODO Auto-generated method stub
		json.writeValue("maxhp",maxhp);
		json.writeValue("maxmp",maxmp);
		json.writeValue("maxmpr",maxmpr);
		json.writeValue("mapbought", mapbought);
		json.writeValue("money", money);
		json.writeValue("level",level);
		json.writeValue("mlevel",mlevel);
		json.writeValue("fortify",fortify);
		json.writeValue("diamond",diamond);
		json.writeValue("iapbought",iapbought);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		// TODO Auto-generated method stub
		iapbought = json.readValue("iapbought", Boolean.class,jsonData);
		level = json.readValue("level", Integer.class,jsonData);
		mlevel = json.readValue("mlevel", Integer.class,jsonData);
		maxhp = json.readValue("maxhp", Float.class,jsonData);
		maxmpr = json.readValue("maxmpr", Float.class,jsonData);
		maxmp = json.readValue("maxmp", Float.class,jsonData);
		money = json.readValue("money", Integer.class,jsonData);
		diamond = json.readValue("diamond",Integer.class,jsonData);
		fortify = json.readValue("fortify",Integer.class,jsonData);
		Map<String, Boolean> mapbought = json.readValue("mapbought", HashMap.class, Boolean.class,jsonData);
		for(String uid: mapbought.keySet()){
			this.mapbought.put(uid, mapbought.get(uid));
		}
	}
}