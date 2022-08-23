package com.PolarStructureKit.kit.im.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/** 
 * 【握手拦截器】
 * @author Lovsog
 * @date 2022/8/23 10:52
 */
@Slf4j
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    /**
     * 【WebSocket握手前】 向attributes中设置数据，之后在WebSocketHandler的session中获取
     * @author Lovsog
     * @date 2022/8/23 10:38
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return boolean
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("HandshakeInterceptor: beforeHandshake");
        log.info("Attributes: " + attributes.toString());
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
    /**
     * 【WebSocket握手后】
     * @author Lovsog
     * @date 2022/8/23 10:42
     * @param request
     * @param response
     * @param wsHandler
     * @param ex
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        log.info("HandshakeInterceptor: afterHandshake");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
