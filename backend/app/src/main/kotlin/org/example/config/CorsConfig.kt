package org.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CorsFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {
    @Bean
    fun corsFilter(): CorsFilter {
        val config = CorsConfiguration()
        config.allowedOrigins = listOf("http://localhost:3000") // フロントエンドの URL を指定
        config.allowedMethods = listOf("GET", "POST", "PUT", "DELETE")
        config.allowedHeaders = listOf("*")
        config.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)

        return CorsFilter(source)
    }
}