package com.comfycouch.examples;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.font.BitmapFont;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.align.HorizontalAlign;


public class BitmapFontExample extends SimpleBaseGameActivity {

	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 480;
	
	private BitmapFont mBitmapFont;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		this.mBitmapFont = new BitmapFont(this.getTextureManager(), this.getAssets(), "font/BitmapFont.fnt");
		this.mBitmapFont.load();
	}

	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		
		final Scene scene = new Scene();
		scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
		
		final Text bitmapText = new Text(160, 230, this.mBitmapFont, "Hello Bitmap Font!", new TextOptions(HorizontalAlign.CENTER), this.getVertexBufferObjectManager());
		
		scene.attachChild(bitmapText);
		
		return scene;
	}
	
	public void onGameCreated() {
		
	}

}
