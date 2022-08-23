package com.PolarStructureKit.kit.im.entity;

import lombok.*;

/**
 * 客户端向服务端传递的消息
 * @author Lovsog
 * @date 2022/8/23 10:26
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String name;
}
