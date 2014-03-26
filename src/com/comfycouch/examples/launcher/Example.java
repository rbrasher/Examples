package com.comfycouch.examples.launcher;

import org.andengine.ui.activity.BaseGameActivity;

import com.comfycouch.examples.AnalogOnScreenControlExample;
import com.comfycouch.examples.AnalogOnScreenControlsExample;
import com.comfycouch.examples.AnimatedSpritesExample;
import com.comfycouch.examples.AutoParallaxBackgroundExample;
import com.comfycouch.examples.BitmapFontExample;
import com.comfycouch.examples.BoundCameraExample;
import com.comfycouch.examples.CanvasTextureCompositingExample;
import com.comfycouch.examples.CardinalSplineMoveModifierExample;
import com.comfycouch.examples.CollisionDetectionExample;
import com.comfycouch.examples.ColorKeyTextureSourceDecoratorExample;
import com.comfycouch.examples.CoordinateConversionExample;
import com.comfycouch.examples.CustomFontExample;
import com.comfycouch.examples.DigitalOnScreenControlExample;
import com.comfycouch.examples.ETC1TextureExample;
import com.comfycouch.examples.EaseFunctionExample;
import com.comfycouch.examples.EntityModifierExample;
import com.comfycouch.examples.EntityModifierIrregularExample;
import com.comfycouch.examples.HullAlgorithmExample;
import com.comfycouch.examples.ImageFormatsExample;
//import com.comfycouch.examples.LevelLoaderExample;
import com.comfycouch.examples.LineExample;
import com.comfycouch.examples.LoadTextureExample;
import com.comfycouch.examples.MenuExample;
import com.comfycouch.examples.ModPlayerExample;
import com.comfycouch.examples.MotionStreakExample;
import com.comfycouch.examples.MovingBallExample;
import com.comfycouch.examples.MultiTouchExample;
import com.comfycouch.examples.MultiplayerBluetoothExample;
import com.comfycouch.examples.MultiplayerExample;
import com.comfycouch.examples.MultiplayerServerDiscoveryExample;
import com.comfycouch.examples.MusicExample;
import com.comfycouch.examples.PVRCCZTextureExample;
import com.comfycouch.examples.PVRGZTextureExample;
import com.comfycouch.examples.PVRTextureExample;
import com.comfycouch.examples.ParticleSystemCoolExample;
import com.comfycouch.examples.ParticleSystemNexusExample;
import com.comfycouch.examples.ParticleSystemSimpleExample;
import com.comfycouch.examples.PathModifierExample;
import com.comfycouch.examples.PauseExample;
import com.comfycouch.examples.PhysicsCollisionFilteringExample;
import com.comfycouch.examples.PhysicsExample;
import com.comfycouch.examples.PhysicsFixedStepExample;
import com.comfycouch.examples.PhysicsJumpExample;
import com.comfycouch.examples.PhysicsMouseJointExample;
import com.comfycouch.examples.PhysicsRemoveExample;
import com.comfycouch.examples.PhysicsRevoluteJointExample;
import com.comfycouch.examples.PinchZoomExample;
import com.comfycouch.examples.R;
import com.comfycouch.examples.RadialBlurExample;
import com.comfycouch.examples.RectangleExample;
import com.comfycouch.examples.RepeatingSpriteBackgroundExample;
import com.comfycouch.examples.Rotation3DExample;
import com.comfycouch.examples.RunnablePoolUpdateHandlerExample;
//import com.comfycouch.examples.SVGTextureRegionExample;
import com.comfycouch.examples.ScreenCaptureExample;
import com.comfycouch.examples.SoundExample;
import com.comfycouch.examples.SplitScreenExample;
import com.comfycouch.examples.SpriteBatchExample;
import com.comfycouch.examples.SpriteExample;
import com.comfycouch.examples.SpriteRemoveExample;
import com.comfycouch.examples.StrokeFontExample;
import com.comfycouch.examples.SubMenuExample;
import com.comfycouch.examples.TMXTiledMapExample;
import com.comfycouch.examples.TextBreakExample;
import com.comfycouch.examples.TextExample;
import com.comfycouch.examples.TextMenuExample;
import com.comfycouch.examples.TextureOptionsExample;
import com.comfycouch.examples.TexturePackerExample;
import com.comfycouch.examples.TickerTextExample;
import com.comfycouch.examples.TouchDragExample;
import com.comfycouch.examples.UnloadResourcesExample;
import com.comfycouch.examples.UpdateTextureExample;
import com.comfycouch.examples.XMLLayoutExample;
import com.comfycouch.examples.ZoomExample;
import com.comfycouch.examples.app.cityradar.CityRadarActivity;
import com.comfycouch.examples.benchmark.AnimationBenchmark;
import com.comfycouch.examples.benchmark.AttachDetachBenchmark;
import com.comfycouch.examples.benchmark.EntityModifierBenchmark;
import com.comfycouch.examples.benchmark.PhysicsBenchmark;
import com.comfycouch.examples.benchmark.SpriteBenchmark;
import com.comfycouch.examples.benchmark.TickerTextBenchmark;
import com.comfycouch.examples.game.pong.PongGameActivity;
import com.comfycouch.examples.game.racer.RacerGameActivity;
import com.comfycouch.examples.game.snake.SnakeGameActivity;

public enum Example {
	// ===========================================================
	// Elements
	// ===========================================================

	ANALOGONSCREENCONTROL(AnalogOnScreenControlExample.class, R.string.example_analogonscreencontrol),
	ANALOGONSCREENCONTROLS(AnalogOnScreenControlsExample.class, R.string.example_analogonscreencontrols),
	ANIMATEDSPRITES(AnimatedSpritesExample.class, R.string.example_animatedsprites),
//	AUGMENTEDREALITY(AugmentedRealityExample.class, R.string.example_augmentedreality),
//	AUGMENTEDREALITYHORIZON(AugmentedRealityHorizonExample.class, R.string.example_augmentedrealityhorizon),
	AUTOPARALLAXBACKGROUND(AutoParallaxBackgroundExample.class, R.string.example_autoparallaxbackground),
	BITMAPFONT(BitmapFontExample.class, R.string.example_bitmapfont),
	BOUNDCAMERA(BoundCameraExample.class, R.string.example_boundcamera),
	CARDINALSPLINEMOVEMODIFIER(CardinalSplineMoveModifierExample.class, R.string.example_cardinalsplinemovemodifier),
	CANVASTEXTURECOMPOSITING(CanvasTextureCompositingExample.class, R.string.example_canvastexturecompositing),
	CHANGEABLETEXT(TextExample.class, R.string.example_changeabletext),
	COLLISIONDETECTION(CollisionDetectionExample.class, R.string.example_collisiondetection),
	COLORKEYTEXTURESOURCEDECORATOR(ColorKeyTextureSourceDecoratorExample.class, R.string.example_colorkeytexturesourcedecorator),
	COORDINATECONVERSION(CoordinateConversionExample.class, R.string.example_coordinateconversion),
	CUSTOMFONT(CustomFontExample.class, R.string.example_customfont),
	DIGITALONSCREENCONTROL(DigitalOnScreenControlExample.class, R.string.example_digitalonscreencontrol),
	EASEFUNCTION(EaseFunctionExample.class, R.string.example_easefunction),
	ENTITYMODIFIER(EntityModifierExample.class, R.string.example_entitymodifier),
	ENTITYMODIFIERIRREGULAR(EntityModifierIrregularExample.class, R.string.example_entitymodifierirregular),
	ETC1TEXTURE(ETC1TextureExample.class, R.string.example_etc1texture),
	HULLALGORITHM(HullAlgorithmExample.class, R.string.example_hullalgorithm),
	IMAGEFORMATS(ImageFormatsExample.class, R.string.example_imageformats),
	//LEVELLOADER(LevelLoaderExample.class, R.string.example_levelloader),
	LINE(LineExample.class, R.string.example_line),
	LOADTEXTURE(LoadTextureExample.class, R.string.example_loadtexture),
	MENU(MenuExample.class, R.string.example_menu),
	MODPLAYER(ModPlayerExample.class, R.string.example_modplayer),
	MOTIONSTREAK(MotionStreakExample.class, R.string.example_motionstreak),
	MOVINGBALL(MovingBallExample.class, R.string.example_movingball),
	MULTIPLAYER(MultiplayerExample.class, R.string.example_multiplayer),
	MULTIPLAYERSERVERDISCOVERY(MultiplayerServerDiscoveryExample.class, R.string.example_multiplayerserverdiscovery),
	MULTIPLAYERBLUETOOTH(MultiplayerBluetoothExample.class, R.string.example_multiplayerbluetooth),
	MULTITOUCH(MultiTouchExample.class, R.string.example_multitouch),
	MUSIC(MusicExample.class, R.string.example_music),
	PAUSE(PauseExample.class, R.string.example_pause),
	PATHMODIFIER(PathModifierExample.class, R.string.example_pathmodifier),
	PARTICLESYSTEMNEXUS(ParticleSystemNexusExample.class, R.string.example_particlesystemnexus),
	PARTICLESYSTEMCOOL(ParticleSystemCoolExample.class, R.string.example_particlesystemcool),
	PARTICLESYSTEMSIMPLE(ParticleSystemSimpleExample.class, R.string.example_particlesystemsimple),
	PHYSICSCOLLISIONFILTERING(PhysicsCollisionFilteringExample.class, R.string.example_physicscollisionfiltering),
	PHYSICS(PhysicsExample.class, R.string.example_physics),
	PHYSICSFIXEDSTEP(PhysicsFixedStepExample.class, R.string.example_physicsfixedstep),
	PHYSICSMOUSEJOINT(PhysicsMouseJointExample.class, R.string.example_physicsmousejoint),
	PHYSICSJUMP(PhysicsJumpExample.class, R.string.example_physicsjump),
	PHYSICSREVOLUTEJOINT(PhysicsRevoluteJointExample.class, R.string.example_physicsrevolutejoint),
	PHYSICSREMOVE(PhysicsRemoveExample.class, R.string.example_physicsremove),
	PINCHZOOM(PinchZoomExample.class, R.string.example_pinchzoom),
	PVRCCZTEXTURE(PVRCCZTextureExample.class, R.string.example_pvrccztexture),
	PVRGZTEXTURE(PVRGZTextureExample.class, R.string.example_pvrgztexture),
	PVRTEXTURE(PVRTextureExample.class, R.string.example_pvrtexture),
	RADIALBLUR(RadialBlurExample.class, R.string.example_radialblur),
	RECTANGLE(RectangleExample.class, R.string.example_rectangle),
	REPEATINGSPRITEBACKGROUND(RepeatingSpriteBackgroundExample.class, R.string.example_repeatingspritebackground),
	ROTATION3D(Rotation3DExample.class, R.string.example_rotation3d),
	RUNNABLEPOOLUPDATEHANDLER(RunnablePoolUpdateHandlerExample.class, R.string.example_runnablepoolupdatehandler),
	SCREENCAPTURE(ScreenCaptureExample.class, R.string.example_screencapture),
	SOUND(SoundExample.class, R.string.example_sound),
	SPLITSCREEN(SplitScreenExample.class, R.string.example_splitscreen),
	SPRITEBATCH(SpriteBatchExample.class, R.string.example_spritebatch),
	SPRITE(SpriteExample.class, R.string.example_sprite),
	SPRITEREMOVE(SpriteRemoveExample.class, R.string.example_spriteremove),
	STROKEFONT(StrokeFontExample.class, R.string.example_strokefont),
	SUBMENU(SubMenuExample.class, R.string.example_submenu),
	//SVGTEXTUREREGION(SVGTextureRegionExample.class, R.string.example_svgtextureregion),
	TEXT(TextExample.class, R.string.example_text),
	TEXTBREAK(TextBreakExample.class, R.string.example_textbreak),
	TEXTMENU(TextMenuExample.class, R.string.example_textmenu),
	TEXTUREOPTIONS(TextureOptionsExample.class, R.string.example_textureoptions),
	TEXTUREPACKER(TexturePackerExample.class, R.string.example_texturepacker),
	TMXTILEDMAP(TMXTiledMapExample.class, R.string.example_tmxtiledmap),
	TICKERTEXT(TickerTextExample.class, R.string.example_tickertext),
	TOUCHDRAG(TouchDragExample.class, R.string.example_touchdrag),
	UNLOADRESOURCES(UnloadResourcesExample.class, R.string.example_unloadresources),
	UPDATETEXTURE(UpdateTextureExample.class, R.string.example_updatetexture),
	XMLLAYOUT(XMLLayoutExample.class, R.string.example_xmllayout),
	ZOOM(ZoomExample.class, R.string.example_zoom),

	BENCHMARK_ANIMATION(AnimationBenchmark.class, R.string.example_benchmark_animation),
	BENCHMARK_ATTACHDETACH(AttachDetachBenchmark.class, R.string.example_benchmark_attachdetach),
//	BENCHMARK_PARTICLESYSTEM(ParticleSystemBenchmark.class, R.string.example_benchmark_particlesystem),
	BENCHMARK_PHYSICS(PhysicsBenchmark.class, R.string.example_benchmark_physics),
	BENCHMARK_ENTITYMODIFIER(EntityModifierBenchmark.class, R.string.example_benchmark_entitymodifier),
	BENCHMARK_SPRITE(SpriteBenchmark.class, R.string.example_benchmark_sprite),
	BENCHMARK_TICKERTEXT(TickerTextBenchmark.class, R.string.example_benchmark_tickertext),

	APP_CITYRADAR(CityRadarActivity.class, R.string.example_app_cityradar),

	GAME_PONG(PongGameActivity.class, R.string.example_game_pong),
	GAME_SNAKE(SnakeGameActivity.class, R.string.example_game_snake),
	GAME_RACER(RacerGameActivity.class, R.string.example_game_racer);
	
	// ==========================================
	// Constants
	// ==========================================

	// ==========================================
	// Fields
	// ==========================================

	public final Class<? extends BaseGameActivity> CLASS;
	public final int NAMERESID;

	// ==========================================
	// Constructors
	// ==========================================

	private Example(final Class<? extends BaseGameActivity> pExampleClass, final int pNameResID) {
		this.CLASS = pExampleClass;
		this.NAMERESID = pNameResID;
	}

	// ==========================================
	// Getter & Setter
	// ==========================================

	// ==========================================
	// Methods for/from SuperClass/Interfaces
	// ==========================================

	// ==========================================
	// Methods
	// ==========================================

	// ==========================================
	// Inner and Anonymous Classes
	// ==========================================
}
