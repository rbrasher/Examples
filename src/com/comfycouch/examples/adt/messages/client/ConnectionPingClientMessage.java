package com.comfycouch.examples.adt.messages.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.andengine.extension.multiplayer.adt.message.client.ClientMessage;

public class ConnectionPingClientMessage extends ClientMessage implements ClientMessageFlags {

	private long mTimestamp;
	
	// ==========================================
	// Constructors
	// ==========================================

	@Deprecated
	public ConnectionPingClientMessage() {

	}
	
	public long getTimestamp() {
		return this.mTimestamp;
	}

	public void setTimestamp(final long pTimestamp) {
		this.mTimestamp = pTimestamp;
	}
	
	@Override
	public short getFlag() {
		return FLAG_MESSAGE_CLIENT_CONNECTION_PING;
	}

	@Override
	protected void onReadTransmissionData(final DataInputStream pDataInputStream) throws IOException {
		this.mTimestamp = pDataInputStream.readLong();
	}

	@Override
	protected void onWriteTransmissionData(final DataOutputStream pDataOutputStream) throws IOException {
		pDataOutputStream.writeLong(this.mTimestamp);
	}
}
