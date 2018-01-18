package com.javacodegeeks.snippets.enterprise.jettywebsocket.jsr356.client;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;

public class WebSocket356ClientMain {

	public static void main(String[] args) {
	
		try {

			String dest = "ws://localhost:8080/jsr356toUpper";
			ToUpper356ClientSocket socket = new ToUpper356ClientSocket();
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(socket, new URI(dest));

			socket.getLatch().await();
			socket.sendMessage("echo356");
			socket.sendMessage("test356");
			Thread.sleep(10000l);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
