package com.centro.integral.medico.security;

import com.centro.integral.medico.security.filter.JwtAuthenticatonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class HttpSecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticatonFilter authenticatonFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionManConfig -> sessionManConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterAfter(authenticatonFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authConfig -> {

                    //authConfig.requestMatchers(HttpMethod.POST,"/auth/authenticate").permitAll();
                    //authConfig.requestMatchers(HttpMethod.GET,"/auth/public-access").permitAll();
                    //authConfig.requestMatchers("/error").permitAll();
                    //authConfig.requestMatchers(HttpMethod.POST,"/api/process-pdf").permitAll();
                    //authConfig.requestMatchers(HttpMethod.GET,"/empresas/**").permitAll();
                    //authConfig.requestMatchers(HttpMethod.POST,"/empresas").permitAll();
                    //authConfig.requestMatchers(HttpMethod.POST,"/insumos").permitAll();

                    // authConfig.requestMatchers(HttpMethod.GET,"/guias").hasAnyAuthority(Permission.READ_ALL_PRODUCTS.name());

                    //authConfig.requestMatchers(HttpMethod.POST,"/guias").hasAnyAuthority(Permission.SAVE_ONE_PRODUCT.name());

                    authConfig.anyRequest().permitAll();

                });
        return httpSecurity.build();
    }
}
