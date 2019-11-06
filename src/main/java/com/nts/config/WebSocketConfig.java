package com.nts.config;

import com.nts.handler.EchoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSocket
@ComponentScan(basePackages = {"com.nts"})
public class WebSocketConfig implements WebSocketConfigurer {

	private final static int MESSAGE_BUFFER_SIZE = 16384;

	@Bean
	public ServletServerContainerFactoryBean configureWebSocket() {
		ServletServerContainerFactoryBean factory = new ServletServerContainerFactoryBean();
		factory.setMaxBinaryMessageBufferSize(MESSAGE_BUFFER_SIZE);
		factory.setMaxTextMessageBufferSize(MESSAGE_BUFFER_SIZE);
		factory.setMaxSessionIdleTimeout(TimeUnit.MINUTES.convert(30, TimeUnit.MILLISECONDS));
		factory.setAsyncSendTimeout(TimeUnit.SECONDS.convert(5, TimeUnit.MILLISECONDS));
		return factory;
	}

	@Bean
	public EchoHandler echoHandler() {
		return new EchoHandler();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(echoHandler(), "/echo").setAllowedOrigins("*");
	}
}
