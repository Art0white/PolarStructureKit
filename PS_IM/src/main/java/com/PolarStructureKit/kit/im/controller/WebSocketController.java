package com.PolarStructureKit.kit.im.controller;

import com.PolarStructureKit.kit.im.entity.ChatMessage;
import com.PolarStructureKit.kit.im.entity.Message;
import com.PolarStructureKit.kit.im.entity.Response;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/** 
 * 【WebSocket控制器】
 * @author Lovsog
 * @date 2022/8/23 11:14
 */
@Controller
@Slf4j
public class WebSocketController {
    // 您不能将 WebSocket 与 JWT 集成以进行令牌验证。
    private static final String token = "这是你代码生成的令牌";
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    /**
     * 【广播】
     * @author Lovsog
     * @date 2022/8/23 11:17
     * @param message
     * @param authorizationToken
     * @return Response
     */
    @MessageMapping("/broadcast")
    @SendTo("/b")
    public Response broadcast(Message message, @Header(value = "authorization") String authorizationToken) {
        val response = new Response("Token check failed!");
        if (authorizationToken.equals(token)) {
            log.info("Token check success!!!");
            response.setResponse("Welcome, " + message.getName() + "!");
        } else {
            log.info(response.getResponse());
        }
        return response;
    }

    /**
     * 【群聊】
     * @author Lovsog
     * @date 2022/8/23 11:21
     * @param groupID
     * @param message
     */
    @MessageMapping("/group/{groupID}")
    public void group(@DestinationVariable int groupID, Message message) {
        log.info("Receive group message: [" + groupID + " -> " + message.getName() + "]");
        Response response = new Response("Welcome to group " + groupID + ", " + message.getName() + "!");
        simpMessagingTemplate.convertAndSend("/g/" + groupID, response);
    }

    /** 
     * 【点对点聊天】
     * @author Lovsog
     * @date 2022/8/23 11:28
     */
    @MessageMapping("/chat")
    public void chat(ChatMessage chatMessage) {
        log.info("Receive point-to-point chat message: [" + chatMessage.getFromUserID() + " -> " + chatMessage.getUserID() + ", " + chatMessage.getMessage() + "]");
        Response response = new Response("Receive message from user " + chatMessage.getFromUserID() + ": " + chatMessage.getMessage());
        simpMessagingTemplate.convertAndSendToUser(String.valueOf(chatMessage.getUserID()), "/msg", response);
    }
}

