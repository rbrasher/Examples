package com.comfycouch.examples.game.snake.entity;

import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Frog extends AnimatedCellEntity {

	public Frog(final int pCellX, final int pCellY, final TiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pCellX, pCellY, CELL_WIDTH, CELL_HEIGHT, pTiledTextureRegion, pVertexBufferObjectManager);
	}

	@Override
	public void setCell(final ICellEntity pCellEntity) {
		
	}
}
