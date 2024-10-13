package com.santiago.backend.icons.icons_backend.security;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests((authz) -> authz
        .requestMatchers(HttpMethod.GET, "/icons/*").permitAll()// Permit acces to only GET requests in this route
        .requestMatchers(HttpMethod.POST, "/icons/signUp").permitAll()// Permit acces to only POST requests in this route
        // .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")// Permit acces to only POST requests in this route
        // .requestMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN")// Permit acces to only POST requests in this route
        // .requestMatchers(HttpMethod.GET, "/api/products/{id}").hasAnyRole("ADMIN", "USER")// Permit acces to only POST requests in this route
        // .requestMatchers(HttpMethod.PUT, "/api/products/{id}").hasRole("ADMIN")// Permit acces to only POST requests in this route
        // .requestMatchers(HttpMethod.DELETE, "/api/products/{id}").hasRole("ADMIN")// Permit acces to only POST requests in this route
        )// Restring access to requests if not authenticated
        .csrf(config -> config.disable())
        .cors(cors -> cors.configurationSource(configurationSource()))
        .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }
    
    @Bean
    CorsConfigurationSource configurationSource(){
        CorsConfiguration config = new CorsConfiguration(); // Instanciamos la clase
        config.setAllowedOriginPatterns(Arrays.asList("*")); // Especificamos que urls externas tiene acceso a nuestra aplicacion
        // En este caso permitimos el acceso a todas.
        // configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","https://localhost","*")); // Otra alternativa al metodo de arriba
        config.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT")); // Especificamos a que metodos tienen acceso esas urls
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Especificamos a que headers tienen acceso esas urls
        config.setAllowCredentials(true); 

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Especificamos a que rutas se 
        //le aplica la configuración de CORS, en este caso a todas las rutas de la app

        return source; // retornamos la clase de configuración.
    }

    
     @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
		    // Instanciamos la clase FilterRegistrationBean pasandole la configuracion que hicimos en el metodo anterior.
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<>(new CorsFilter(configurationSource()));
        // Establecemos la mas alta prioridad para este filtro
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;
    }


}
