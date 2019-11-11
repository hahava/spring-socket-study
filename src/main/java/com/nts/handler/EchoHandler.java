package com.nts.handler;

import lombok.extern.java.Log;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Log
@Controller
public class EchoHandler {

	@MessageMapping("/echo")
	@SendTo("/topic/echo")
	public String echo(String msg) {
		return "RECEIVE : " + msg;
	}

}
