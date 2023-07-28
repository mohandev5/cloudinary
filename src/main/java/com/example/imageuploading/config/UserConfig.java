package com.example.imageuploading.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration

public class UserConfig {

    private final String CLOUD_NAME="dxexmssdr";
    private final String API_KEY="122877238947871";
    private final String API_SECRET="loBifIQQWeIJr8G1y5A387BOSaU";

//
//    @Value("${cloudinary.cloudName}")
//    private String cloudName;
//
//    @Value("${cloudinary.apiKey}")
//    private String apiKey;
//
//    @Value("${cloudinary.apiSecret}")
//    private String apiSecret;

    @Bean
    public Cloudinary cloudinary(){
        Map<String,String> config=new HashMap<>();
        config.put("cloud_name",CLOUD_NAME);
        config.put("api_key",API_KEY);
        config.put("api_secret",API_SECRET);
        return new Cloudinary(config);
    }

}
