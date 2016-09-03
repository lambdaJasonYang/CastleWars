package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class shopbutton extends ImageButton {
	String uid;
	int type; //1 summon, 2 turret
	int cost;
	String description;
	String activename;
	boolean bought;
	boolean checked;
	String eqslot;
	float delay = 0;
	float rdelay;
	int level;
	public shopbutton(Drawable imageUp) {
		super(imageUp);
		// TODO Auto-generated constructor stub
	}

	public shopbutton(ImageButtonStyle style) {
		super(style);
		// TODO Auto-generated constructor stub
	}

}
