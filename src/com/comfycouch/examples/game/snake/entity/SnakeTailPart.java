package com.comfycouch.examples.game.snake.entity;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class SnakeTailPart extends CellEntity {

	// ==========================================
	// CONSTRUCTORS
	// ==========================================
	
	public SnakeTailPart(final SnakeHead pSnakeHead, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		this(pSnakeHead.mCellX, pSnakeHead.mCellY, pTextureRegion, pVertexBufferObjectManager);
	}
	
	public SnakeTailPart(final int pCellX, final int pCellY, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pCellX, pCellY, CELL_WIDTH, CELL_HEIGHT, pTextureRegion, pVertexBufferObjectManager);
	}
}
