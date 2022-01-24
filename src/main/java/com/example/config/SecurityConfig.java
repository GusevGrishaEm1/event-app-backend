package com.example.config;

import com.example.entity.Role;
import com.example.security.JwtConfigure;
import com.example.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtProvider jwtProvider;

    @Autowired
    public SecurityConfig(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public void configure(HttpSecurity http) throws Exception {
        http
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/users/register/*", "/users/login").permitAll()
                .antMatchers(HttpMethod.POST, "/events").hasAnyAuthority(Role.USER_BUSINESS.name())
                .antMatchers(HttpMethod.PUT, "/events").hasAnyAuthority(Role.USER_BUSINESS.name())
                .antMatchers(HttpMethod.DELETE, "/events").hasAnyAuthority(Role.USER_BUSINESS.name())
                .antMatchers(HttpMethod.GET,"/users/profile/default").hasAnyAuthority(Role.USER_DEFAULT.name())
                .antMatchers(HttpMethod.GET,"/users/profile/business").hasAnyAuthority(Role.USER_BUSINESS.name())
                .antMatchers(HttpMethod.GET,"/events", "/events/reviews").hasAnyAuthority(Role.USER_DEFAULT.name(),Role.USER_BUSINESS.name())
                .antMatchers(HttpMethod.POST,"/events/subscribe").hasAnyAuthority(Role.USER_DEFAULT.name())
                .antMatchers(HttpMethod.DELETE,"/events/unsubscribe").hasAnyAuthority(Role.USER_DEFAULT.name())
                .antMatchers(HttpMethod.PUT,"/events/add/review").hasAnyAuthority(Role.USER_DEFAULT.name())
                .anyRequest()
                .authenticated()
                .and()
                .apply(new JwtConfigure(jwtProvider));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
