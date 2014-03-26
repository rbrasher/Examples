package com.comfycouch.examples;

import org.andengine.entity.shape.IShape;

public interface IAreaShape extends IShape {

	public float getWidth();
	public float getHeight();
	
	public float getWidthScaled();
	public float getHeightScaled();
	
	public void setHeight(final float pHeight);
	public void setWidth(final float pWidth);
	public void setSize(final float pWidth, final float pHeight);
}
