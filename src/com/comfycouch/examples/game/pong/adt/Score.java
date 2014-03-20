package com.comfycouch.examples.game.pong.adt;

public class Score {

	private int mScore = 0;
	
	
	public int getScore() {
		return this.mScore;
	}
	
	public void increase() {
		this.mScore++;
	}
}
