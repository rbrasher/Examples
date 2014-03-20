package com.comfycouch.examples.game.pong.adt.messages.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.comfycouch.examples.game.pong.util.constants.PongConstants;
import com.comfycouch.extension.multiplayer.protocol.adt.message.server.ServerMessage;


public class UpdateBallServerMessage extends ServerMessage implements PongConstants {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public float mX;
	public float mY;

	// ===========================================================
	// Constructors
	// ===========================================================

	public UpdateBallServerMessage() {

	}

	public UpdateBallServerMessage(final float pX, final float pY) {
		this.mX = pX;
		this.mY = pY;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public void set(final float pX,final float pY) {
		this.mX = pX;
		this.mY = pY;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public short getFlag() {
		return FLAG_MESSAGE_SERVER_UPDATE_BALL;
	}

	@Override
	protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
		this.mX = pDataInputStream.readFloat();
		this.mY = pDataInputStream.readFloat();
	}

	@Override
	protected void onWriteTransmissionData(final DataOutputStream pDataOutputStream) throws IOException {
		pDataOutputStream.writeFloat(this.mX);
		pDataOutputStream.writeFloat(this.mY);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}