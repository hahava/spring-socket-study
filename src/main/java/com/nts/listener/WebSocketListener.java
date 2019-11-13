package com.nts.listener;

import lombok.extern.java.Log;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * not working..
 */
@Log
@Component
public class WebSocketListener {
	@EventListener
	public void handleWebSocketConnectionListener(SessionConnectedEvent sessionConnectedEvent) {
		log.info("Received Connection");
	}
}
