package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
@SpringBootConfiguration
public class MyConfig implements WebMvcConfigurer{

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterception()).addPathPatterns("/**").excludePathPatterns("/**/*.js","/**/*.css","/**/*.html");
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/html/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        //super.addViewControllers(registry);
    }

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
		registry.order(0);
		/*registry.jsp("/html/", ".html");
		registry.order(1);*/
		
		//FreeMarkerViewResolver html=new FreeMarkerViewResolver("/html/", ".html");
		//html.setViewClass(FreeMarkerViewResolver.class);
		//registry.viewResolver(html);
		registry.enableContentNegotiation(new MappingJackson2JsonView());
		
		//WebMvcConfigurer.super.configureViewResolvers(registry);
	}


	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true)  
        /* 不检查Accept请求头 */
       .ignoreAcceptHeader(true)
       .parameterName("mediaType")
        /* 设置默认的media yype */
       .defaultContentType(MediaType.TEXT_HTML)
        /* 请求以.html结尾的会被当成MediaType.TEXT_HTML*/
       .mediaType("html", MediaType.TEXT_HTML)
       /* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON*/
       .mediaType("json", MediaType.APPLICATION_JSON);
		WebMvcConfigurer.super.configureContentNegotiation(configurer);
	}
	
	/*@Autowired
    MultiViewResover resover;

    @Bean(name = "viewResover")
    public MultiViewResover getViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");

        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setViewClass(ThymeleafView.class);

        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setSuffix(".ftl");

        Map<String, ViewResolver> resolvers = new HashedMap();
        resolvers.put("jsp",internalResourceViewResolver);
        resolvers.put("th",thymeleafViewResolver);
        resolvers.put("ftl",freeMarkerViewResolver);

        resover.setResolvers(resolvers);
        return resover;
    }*/
	/*@Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("/WEB-INF/html/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("utf-8");
        templateResolver.setCacheable(false);
        templateResolver.setOrder(1);
        return templateResolver;
    }*/
	/*
	@Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // templateEngine
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolverThymeLeaf() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("utf-8");
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[]{"html/*", "vue/*"});
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
}
