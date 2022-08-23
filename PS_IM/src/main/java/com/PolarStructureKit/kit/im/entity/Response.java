package com.PolarStructureKit.kit.im.entity;

import lombok.*;

/**
 * 服务端向客户端发放的消息
 * @author Lovsog
 * @date 2022/8/23 10:29
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String response;
}
