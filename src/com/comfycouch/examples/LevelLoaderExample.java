package com.comfycouch.examples;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.IEntity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.SAXUtils;
import org.andengine.util.debug.Debug;
import org.andengine.util.level.IEntityLoader;
import org.andengine.util.level.LevelLoader;
import org.andengine.util.level.constants.LevelConstants;
import org.xml.sax.Attributes;

import android.widget.Toast;

/*
public class LevelLoaderExample extends SimpleBaseGameActivity {

	private static final int CAMERA_WIDTH = 480;
	private static final int CAMERA_HEIGHT = 320;
	
	private static final String TAG_ENTITY = "entity";
	private static final String TAG_ENTITY_ATTRIBUTE_X = "x";
	private static final String TAG_ENTITY_ATTRIBUTE_Y = "y";
	private static final String TAG_ENTITY_ATTRIBUTE_WIDTH = "width";
	private static final String TAG_ENTITY_ATTRIBUTE_HEIGHT = "height";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE = "type";
	
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_BOX = "box";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_CIRCLE = "circle";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_TRIANGLE = "triangle";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_HEXAGON = "hexagon";
	
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TiledTextureRegion mBoxFaceTextureRegion;
	private TiledTextureRegion mCircleFaceTextureRegion;
	private TiledTextureRegion mTriangleFaceTextureRegion;
	private TiledTextureRegion mHexagonFaceTextureRegion;
	
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		Toast.makeText(this, "Loading Level...", Toast.LENGTH_SHORT).show();
		
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 64, 128, TextureOptions.BILINEAR);
		this.mBoxFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "face_box_tiled.png", 0, 0, 2, 1); //64 x 32
		this.mCircleFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "face_circle_tiled.png", 0, 32, 2, 1); //64 x 32
		this.mTriangleFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "face_triangle_tiled.png", 0, 64, 2, 1); //64 x 32
		this.mHexagonFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "face_hexagon_tiled.png", 0, 96, 2, 1); //64 x 32
		this.mBitmapTextureAtlas.load();
		
	}

	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		
		final Scene scene = new Scene();
		scene.setBackground(new Background(0, 0, 0));
		
		final LevelLoader levelLoader = new LevelLoader();
		levelLoader.setAssetBasePath("level/");
		
		levelLoader.registerEntityLoader(LevelConstants.TAG_LEVEL, new IEntityLoader() {
			@Override
			public IEntity onLoadEntity(final String pEntityName, final Attributes pAttributes) {
				final int width = SAXUtils.getIntAttributeOrThrow(pAttributes, LevelConstants.TAG_LEVEL_ATTRIBUTE_WIDTH);
				final int height = SAXUtils.getIntAttributeOrThrow(pAttributes, LevelConstants.TAG_LEVEL_ATTRIBUTE_HEIGHT);
				LevelLoaderExample.this.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(LevelLoaderExample.this, "Loaded level with width=" + width + " and height=" + height + ".", Toast.LENGTH_LONG).show();
					}
				});

				return scene;
			}
		});
		
		levelLoader.registerEntityLoader(TAG_ENTITY, new IEntityLoader() {
			@Override
			public IEntity onLoadEntity(final String pEntityName, final Attributes pAttributes) {
				final int x = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_X);
				final int y = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_Y);
				final int width = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_WIDTH);
				final int height = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_HEIGHT);
				final String type = SAXUtils.getAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_TYPE);

				final VertexBufferObjectManager vertexBufferObjectManager = LevelLoaderExample.this.getVertexBufferObjectManager();

				final AnimatedSprite face;
				if(type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_BOX)) {
					face = new AnimatedSprite(x, y, width, height, LevelLoaderExample.this.mBoxFaceTextureRegion, vertexBufferObjectManager);
				} else if(type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_CIRCLE)) {
					face = new AnimatedSprite(x, y, width, height, LevelLoaderExample.this.mCircleFaceTextureRegion, vertexBufferObjectManager);
				} else if(type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_TRIANGLE)) {
					face = new AnimatedSprite(x, y, width, height, LevelLoaderExample.this.mTriangleFaceTextureRegion, vertexBufferObjectManager);
				} else if(type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_HEXAGON)) {
					face = new AnimatedSprite(x, y, width, height, LevelLoaderExample.this.mHexagonFaceTextureRegion, vertexBufferObjectManager);
				} else {
					throw new IllegalArgumentException();
				}

				face.animate(200);

				return face;
			}
		});
		
		try {
			levelLoader.loadLevelFromAsset(this.getAssets(), "example.lvl");
		} catch (final IOException e) {
			Debug.e(e);
		}
		
		return scene;
	}

}
*/
