package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class itemshop implements Screen,InputProcessor{
	//public PurchaseManagerConfig purchaseManagerConfig;
	
	static Texture back;
	Batch batch;
	boolean connected = false;
	OrthographicCamera c;
	Viewport vp;
	int required;
	int gained;
	float widt = Gdx.graphics.getWidth();
	float high = Gdx.graphics.getHeight();
	Stage mstage;

	ImageButton gplus;
	Animation title;
	TextButton fortify,rebuild,goback;
	
	Beta game;
	float Uw,Uh;
	float time;
	float fmultiplyer;
	int steps = 1;
	
	public itemshop(final Beta game){
	this.game = game;
	connected = game.gserv.returnIn();
	
    //purchaseManagerConfig = new PurchaseManagerConfig();
    //purchaseManagerConfig.addOffer(new Offer().setType(OfferType.ENTITLEMENT).setIdentifier(productID_d100));
	fmultiplyer = 1.2f; 
	gplus = new ImageButton(game.loadin.ginstyle);
			
	fortify = new TextButton("fortify",game.loadin.yesbuttonstyle);
	rebuild = new TextButton("rebuild",game.loadin.yesbuttonstyle);
	goback = new TextButton("back",game.loadin.nobuttonstyle);
	
	Uw = Gdx.graphics.getWidth()/100f;
	Uh = Gdx.graphics.getHeight()/100f;
	time = 0f;
	c = new OrthographicCamera();
	vp = new StretchViewport(widt,high,c);
	c.translate(widt/2,high/2);
	mstage = new Stage(vp){
		@Override
        public boolean keyDown(int keyCode) {
        if (keyCode == Keys.BACK) {
    		game.setScreen(game.meta);
			Gdx.input.setInputProcessor(game.meta.mstage);
        }
        return super.keyDown(keyCode);
    }
};
	float ratio3 = (float)game.loadin.NAbuttonstyle.imageUp.getMinHeight()/(float)game.loadin.NAbuttonstyle.imageUp.getMinWidth();
	float ratio4 = ratio3/2f;
	title = game.loadin.title;
	float scalin = (Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Uw : Uh );

	//play.().expand().fill();
	gplus.setBounds(Uw * 80f, Uh * 10f, ( scalin * 15f), ( scalin * 15f)*ratio3);
	gplus.getImageCell().expand().fill();
	
	rebuild.setBounds(Uw *40f, Uh * 10f, ( scalin * 10f), ( scalin * 10f));
	//rank.getImageCell().expand().fill();
	fortify.setBounds(Uw * 20f, Uh * 10f, ( scalin * 10f), ( scalin * 10f));
	//trophy.getImageCell().expand().fill();
	
	goback.setBounds(Uw * 80f, Uh * 1f, ( scalin * 10f), ( scalin * 10f) * ratio3);
	//qmark.getImageCell().expand().fill();
	mstage.addActor(goback);

	mstage.addActor(rebuild);
	mstage.addActor(gplus);
	mstage.addActor(fortify);
	
//	mstage.addActor(play);
	batch = mstage.getBatch();
	Gdx.input.setInputProcessor(mstage);
	Gdx.input.setCatchBackKey(true);
	goback.addListener(new ClickListener(){
		@Override
		public void clicked(InputEvent e, float x, float y){
			
			game.setScreen(game.meta);
			Gdx.input.setInputProcessor(game.meta.mstage);
		}
	});


	rebuild.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
		//	System.out.println("hel");
			game.save.diamond += gained;
			game.save.level = 1;
			game.saver.persist();
	//		Gdx.input.setInputProcessor(game.shoppin.stage);
		}
	});
	fortify.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
			if(game.save.diamond >= (required)){
				game.save.diamond -= (required);
			game.save.fortify += 1;
			fmultiplyer = 1.2f; 
			game.save.maxhp = game.save.maxhp * fmultiplyer;
			game.save.maxmp = game.save.maxmp * fmultiplyer;
			game.save.maxmpr = game.save.maxmpr * fmultiplyer;
			game.gserv.subscore(game.l2, game.save.fortify);
			game.saver.persist();
			}
		}
	});
	gplus.addListener(new ClickListener(){	
		@Override
		public void clicked(InputEvent e, float x, float y){
			if(connected == false){
			game.gserv.siin();
			}else if(connected == true){
			game.gserv.siout();
			gplus.setStyle(game.loadin.goutstyle);
			}
		}
	});
	
	
	
	
	
	
	}
	public void backend(){
		if(game.gserv.rtnsteps() == this.steps){
		
		game.save.iapbought = true;
		game.saver.persist();
		this.steps++;
		}
	}
	float savedelay = 0f;
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0.6f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		backend();
		if(savedelay < 0){
			game.saver.persist();
			savedelay = 0.5f;
		}else{
			savedelay -= Gdx.graphics.getDeltaTime();
		}
		if(connected == true){
			gplus.setStyle(game.loadin.goutstyle);
		}else{
			gplus.setStyle(game.loadin.ginstyle);
		}
//		c.viewportHeight = 400;
//		c.viewportWidth = 400;
		time += Gdx.graphics.getDeltaTime();
		connected = game.gserv.returnIn();
		mstage.act();
		fmultiplyer = 1.2f;
		required = (int) (10 * (game.save.fortify + 1)) ;
		
		if(game.save.level > 10){
			gained = (int) ((1/2f) * Math.pow((game.save.level-5f),2f));
		}else{
			gained = 0;
		}
		
		batch.begin();
	batch.draw(title.getKeyFrame(time, true),0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	game.loadin.lfont.draw(batch,"Fortification Count:" + String.valueOf(game.save.fortify), 55f * Uw, 65f * Uh);
	game.loadin.lfont.draw(batch,"Stat Boost:" + String.format("%.2f", Math.pow(fmultiplyer,game.save.fortify)) + "x", 65f * Uw, 75f * Uh);

	game.loadin.bbfont.draw(batch, "SHOP", 30f * Uw, 92.65f * Uh);
	game.loadin.lfont.drawMultiLine(batch, "If you FORTIFY \nyou require " + required + " Diamonds", 57f * Uw, 60f * Uh);
	game.loadin.lfont.drawMultiLine(batch, "If you REBUILD \nyou will gain " + gained + " Diamonds", 57f * Uw, 40f * Uh);
	game.loadin.llfont.drawMultiLine(batch, "NOTE: REBUILDING will send\n you back to stage 1\nAny Purchase will\n turn off Ads", 70f * Uw, 90f * Uh);
	
	//game.loadin.bbfont.draw(batch, "Castle War", Uw * 7f, Uh * 93f);
	//batch.draw(back,0,0,widt,high);
		batch.end();
		mstage.draw();
	

		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		vp.update(width, height);
		System.out.println(height + " " + Gdx.graphics.getHeight()+ "" + c.position);
		Uw = Gdx.graphics.getWidth()/100f;
		Uh = Gdx.graphics.getHeight()/100f;
		
		
		//c.setToOrtho(false,1f * aspectr,1f);
		
	}
//	public PurchaseObserver purchaseObserver = new PurchaseObserver() {
//
//	    @Override
//	    public void handleRestore (Transaction[] transactions) {
//	        for (int i = 0; i < transactions.length; i++) {
//	            if (checkTransaction(transactions[i].getIdentifier()) == true) break;
//	        }
//	    }
//
//	    @Override
//	    public void handleRestoreError (Throwable e) {
//	        // getPlatformResolver().showToast("PurchaseObserver: handleRestoreError!");
//	        Gdx.app.log("ERROR", "PurchaseObserver: handleRestoreError!: " + e.getMessage());
//	        throw new GdxRuntimeException(e);
//	    }
//
//	    @Override
//	    public void handleInstall () {
//	        // getPlatformResolver().showToast("PurchaseObserver: installed successfully...");
//	        Gdx.app.log("handleInstall: ", "successfully..");
//	    }
//
//	    @Override
//	    public void handleInstallError (Throwable e) {
//	        // getPlatformResolver().showToast("PurchaseObserver: handleInstallError!");
//	        Gdx.app.log("ERROR", "PurchaseObserver: handleInstallError!: " + e.getMessage());
//	        throw new GdxRuntimeException(e);
//	    }
//
//	    @Override
//	    public void handlePurchase (Transaction transaction) {
//	        checkTransaction(transaction.getIdentifier());
//	    }
//
//	    @Override
//	    public void handlePurchaseError (Throwable e) {
//	        if (e.getMessage().equals("There has been a Problem with your Internet connection. Please try again later")) {  
//
//	            // this check is needed because user-cancel is a handlePurchaseError too)
//	            // getPlatformResolver().showToast("handlePurchaseError: " + e.getMessage());
//	        }
//	        throw new GdxRuntimeException(e);
//	    }
//
//	    @Override
//	    public void handlePurchaseCanceled () {
//	    }
//	};
//	protected boolean checkTransaction (String ID) {
//	    boolean returnbool = false;
//	    if (productID_d100.equals(ID)) {
//	        PeDialogEvent purchasedmultiplayerEvent = new PeDialogEvent();
//	        purchasedmultiplayerEvent.setType(PeDialogEvent.Type.purchasedDualPlayer);
//	        notify(purchasedmultiplayerEvent);
//	        returnbool = true;
//	    }
//	    return returnbool;
//	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
