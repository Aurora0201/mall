package top.pi1grim.mall.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.pi1grim.mall.interceptor.CheckTokenInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] path = {"/**"};
        String[] excludePath = {"/users/**", "/indexImg/**", "/category/**", "/swagger-ui/**"};
        registry.addInterceptor(new CheckTokenInterceptor()).addPathPatterns(path).excludePathPatterns(excludePath);
    }
}
