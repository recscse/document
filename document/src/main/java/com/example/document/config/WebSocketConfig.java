//package com.example.document.config;
//
//import com.sun.nio.sctp.NotificationHandler;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    public void registerWebSocketHnadler(WebSocketHandlerRegistry registry){
//         registry.addHandler(new NotificationHandler<>(), "/notification")
//                 .setAllowedOrigins("*");
//    }
//}
