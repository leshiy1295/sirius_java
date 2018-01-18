package com.javacodegeeks.snippets.enterprise.jettywebsocket.jsr356.client;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class ToUpper356ClientSocket {

	CountDownLatch latch = new CountDownLatch(1);
	private Session session;

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Connected to server");
		this.session = session;
		latch.countDown();
	}

	@OnMessage
	public void onText(String message, Session session) {
		System.out.println("Message received from server:" + message);
	}

	@OnClose
	public void onClose(CloseReason reason, Session session) {
		System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public void sendMessage(String str) {
		try {
			session.getBasicRemote().sendText(str);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
