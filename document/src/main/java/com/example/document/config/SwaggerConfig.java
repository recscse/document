//package com.example.document.config;
//
//import com.beust.ah.A;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.document"))
//                .paths(PathSelectors.regex("/.*"))
//                .build().apiInfo(apiInfo());
//    }
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder().title("name of Service")
//                .description("Api endPoint Decoration")
//                .license("Apache 2.0")
//                .version("0.0.0.0")
//                .build();
//
//    }
//}
