package com.nts.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = {"com.nts"})
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 중계기를 등록
		registry.enableSimpleBroker("/topic");
		// 헨들러 메서드로 전달한다. @MessageMapping 과 연동
		registry.setApplicationDestinationPrefixes("/app");
	}

	/**
	 * 최초 handshake 시에 맵핑되는 요청 주소
	 * 해당 주소로 요청 시도 후 ws protocol 로 업그레이드 한다.
	 * @param registry
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/echo-endpoint").setAllowedOrigins("*");
	}
}
