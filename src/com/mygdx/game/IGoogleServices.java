package com.mygdx.game;

public interface IGoogleServices {
	public String getname();
	public void siin();
	public void siout();
	void toastingb(String buffer);


	void showAds(boolean show);
	boolean returnIn();
	void showOrLoadInterstital();
	void showachieve();
	void showleader();
	void subscore(String id, int num);
	void achieve(String aid);
	void buythis(String sku);
	void unlachieve(String aid);
	void showads();
	String[][] getdetail(String pid);
	
	String transfering();
	int rtnsteps();
	boolean rtnloadedint();

}
