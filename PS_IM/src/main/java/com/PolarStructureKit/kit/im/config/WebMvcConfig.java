package com.PolarStructureKit.kit.im.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 
 * 【MVC配置】
 * @author Lovsog
 * @date 2022/8/23 10:53
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/broadcast").setViewName("/broadcast");
        registry.addViewController("/group").setViewName("/group");
        registry.addViewController("/chat").setViewName("/chat");
    }
}
