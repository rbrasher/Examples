package com.comfycouch.examples.game.pong.adt;

public class PaddleUserData {

	private final int mOwnerID;
	private final int mOpponentID;
	
	// ==========================================
	// CONSTRUCTOR
	// ==========================================
	public PaddleUserData(final int pOwnerID, final int pOpponentID) {
		this.mOwnerID = pOwnerID;
		this.mOpponentID = pOpponentID;
	}
	
	// ==========================================
	// GETTER & SETTER
	// ==========================================
	public int getOwnerID() {
		return this.mOwnerID;
	}
	
	public int getOpponentID() {
		return this.mOpponentID;
	}
}
