package br.com.techlead.agendacontato.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Classe de configuração da autenticação via OAuth.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 21/01/2018
 */
/*@EnableResourceServer*/
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests();
        http.requestMatchers()
                .antMatchers("/",
                        "/registro/**",
                        "/register/**",
                        "/oauth/**",
                        "/oauth/token",
                        "/oauth/authorize",
                        "/v2/**",
                        "/api/swagger-ui.html",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/api/v2/**")
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll();
    }

}
