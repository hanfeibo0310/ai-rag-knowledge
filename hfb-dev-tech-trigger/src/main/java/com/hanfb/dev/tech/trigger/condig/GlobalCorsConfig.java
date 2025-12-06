package com.hanfb.dev.tech.trigger.condig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 开发环境允许所有域名，生产环境替换为前端实际域名（如http://localhost:5500）
        config.addAllowedOriginPattern("*"); 
        config.setAllowCredentials(true); // 核心：允许凭证（解决跨域报错关键）
        config.addAllowedMethod("*");     // 允许所有HTTP方法（POST/GET等）
        config.addAllowedHeader("*");     // 允许所有请求头
        config.addExposedHeader("*");     // 暴露所有响应头，让前端能读取
        config.setMaxAge(3600L);          // 预检请求缓存时间

        // 对所有接口生效（包含/api/v1/rag/*）
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}