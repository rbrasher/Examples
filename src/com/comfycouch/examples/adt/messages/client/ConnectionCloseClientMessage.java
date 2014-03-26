package com.comfycouch.examples.adt.messages.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.andengine.extension.multiplayer.adt.message.client.ClientMessage;

public class ConnectionCloseClientMessage extends ClientMessage implements ClientMessageFlags {

	public ConnectionCloseClientMessage() {

	}
	
	@Override
	public short getFlag() {
		return FLAG_MESSAGE_CLIENT_CONNECTION_CLOSE;
	}
	
	@Override
	protected void onReadTransmissionData(final DataInputStream pDataInputStream) throws IOException {
		/* Nothing to read. */
	}
	
	@Override
	protected void onWriteTransmissionData(final DataOutputStream pDataOutputStream) throws IOException {
		/* Nothing to write. */
	}
}
