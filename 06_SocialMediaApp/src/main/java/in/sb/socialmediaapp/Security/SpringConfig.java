package in.sb.socialmediaapp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SpringConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //All the requests should be authenticated
        http.authorizeHttpRequests(auth ->auth.anyRequest().authenticated());
        //If a request is not authenticated, a web page is shown
        http.httpBasic(Customizer.withDefaults());
        // CSRF -> Post, Put
        http.csrf(csrf -> csrf.disable());


        return http.build();
    }
}
