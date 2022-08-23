package com.PolarStructureKit.kit.im.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/** 
 * 【WebSocket配置】启用 Websocket 的消息代理
 * @author Lovsog
 * @date 2022/8/23 10:54
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 注册 STOMP 协议的节点，并指定使用 SockJS 协议
     * @author Lovsog
     * @date 2022/8/23 10:57
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/im").addInterceptors(new HandshakeInterceptor()).withSockJS();
    }

    /**
     * 配置使用消息代理
     * @author Lovsog
     * @date 2022/8/23 11:00
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 统一配置消息代理，消息代理即订阅点，客户端通过订阅消息代理点接受消息
        registry.enableSimpleBroker("/b", "/g", "/user");
        // 配置点对点消息的前缀
        registry.setUserDestinationPrefix("/user");
    }
}
