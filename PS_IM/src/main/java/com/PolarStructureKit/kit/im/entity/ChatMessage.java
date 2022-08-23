package com.PolarStructureKit.kit.im.entity;

import lombok.*;

/**
 * 聊天消息
 * @author Lovsog
 * @date 2022/8/23 10:31
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private int userID;
    private int fromUserID;
    private String message;
}
