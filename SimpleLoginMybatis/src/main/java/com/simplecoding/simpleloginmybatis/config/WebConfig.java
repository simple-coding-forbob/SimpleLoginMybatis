package com.simplecoding.simpleloginmybatis.config;


import com.simplecoding.simpleloginmybatis.interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    // 1) 인터셉터 설정 추가
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")             // 📌 모든 URL 경로에 대해 로그인 검증 실시
                .excludePathPatterns(               // 📌 로그인 없이 접근할 수 있는 예외 경로 등록
                        "/login",          // 로그인 API
                        "/loginProcess",
                        "/register",        // 회원가입 API
                        "/register/addition",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/favicon.ico"
                );
    }
}
