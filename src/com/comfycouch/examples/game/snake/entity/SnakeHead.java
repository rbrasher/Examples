package com.comfycouch.examples.game.snake.entity;

import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.comfycouch.examples.game.snake.adt.Direction;

public class SnakeHead extends AnimatedCellEntity {

	// ==========================================
	// CONSTRUCTORS
	// ==========================================
	
	public SnakeHead(final int pCellX, final int pCellY, final TiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pCellX, pCellY, CELL_WIDTH, 2 * CELL_HEIGHT, pTiledTextureRegion, pVertexBufferObjectManager);
		
		this.setRotationCenterX(CELL_HEIGHT / 2);
	}

	@Override
	public void setCell(ICellEntity pCellEntity) {
		// TODO Auto-generated method stub
		
	}
	
	// ==========================================
	// METHODS
	// ==========================================
	
	public void setRotation(final Direction pDirection) {
		switch(pDirection) {
			case UP:
				this.setRotation(180);
				break;
			case DOWN:
				this.setRotation(0);
				break;
			case LEFT:
				this.setRotation(90);
				break;
			case RIGHT:
				this.setRotation(270);
				break;
			
		}
	}
}
