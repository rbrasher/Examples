package com.comfycouch.examples.game.pong.adt.messages.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.comfycouch.examples.game.pong.util.constants.PongConstants;
import com.comfycouch.extension.multiplayer.protocol.adt.message.client.ClientMessage;


public class MovePaddleClientMessage extends ClientMessage implements PongConstants {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public int mPaddleID;
	public float mY;

	// ===========================================================
	// Constructors
	// ===========================================================

	public MovePaddleClientMessage() {

	}

	public MovePaddleClientMessage(final int pID, final float pY) {
		this.mPaddleID = pID;
		this.mY = pY;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public void setPaddleID(final int pPaddleID, final float pY) {
		this.mPaddleID = pPaddleID;
		this.mY = pY;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public short getFlag() {
		return FLAG_MESSAGE_CLIENT_MOVE_PADDLE;
	}

	@Override
	protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
		this.mPaddleID = pDataInputStream.readInt();
		this.mY = pDataInputStream.readFloat();
	}

	@Override
	protected void onWriteTransmissionData(final DataOutputStream pDataOutputStream) throws IOException {
		pDataOutputStream.writeInt(this.mPaddleID);
		pDataOutputStream.writeFloat(this.mY);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}