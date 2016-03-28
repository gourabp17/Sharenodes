package com.cportal.webinit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration 
@ComponentScan("com.cportal.web") 
@EnableWebMvc   
public class AppConfig extends WebMvcConfigurerAdapter  {  
	@Bean  
        public UrlBasedViewResolver setupViewResolver() {  
            UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
            resolver.setPrefix("/WEB-INF/views/jsp/");  
            resolver.setSuffix(".jsp");  
            resolver.setViewClass(JstlView.class);  
            return resolver;  
        }
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**")
	    .excludePathPatterns("/").excludePathPatterns("/resources/**").excludePathPatterns("/loginform")
	    .excludePathPatterns("/loginform/generate_captcha").excludePathPatterns("/registercomp")
	    .excludePathPatterns("/loginform/forgetpassword").excludePathPatterns("/verify_account");
	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
} 