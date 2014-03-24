package com.comfycouch.examples.game.snake.entity;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.comfycouch.examples.game.snake.util.constants.SnakeConstants;

public abstract class CellEntity extends Sprite implements SnakeConstants, ICellEntity {

	protected int mCellX;
	protected int mCellY;
	
	public CellEntity(final int pCellX, final int pCellY, final int pWidth, final int pHeight, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pCellX * CELL_WIDTH, pCellY * CELL_HEIGHT, pWidth, pHeight, pTextureRegion, pVertexBufferObjectManager);
		
		this.mCellX = pCellX;
		this.mCellY = pCellY;
	}
	
	public int getCellX() {
		return this.mCellX;
	}
	
	public int getCellY() {
		return this.mCellY;
	}
	
	public void setCell(final ICellEntity pCellEntity) {
		this.setCell(pCellEntity.getCellX(), pCellEntity.getCellY());
	}
	
	public void setCell(final int pCellX, final int pCellY) {
		this.mCellX = pCellX;
		this.mCellY = pCellY;
		this.setPosition(this.mCellX * CELL_WIDTH, this.mCellY * CELL_HEIGHT);
	}
	
	@Override
	public boolean isInSameCell(final ICellEntity pCellEntity) {
		return this.mCellX == pCellEntity.getCellX() && this.mCellY == pCellEntity.getCellY();
	}
	
}
