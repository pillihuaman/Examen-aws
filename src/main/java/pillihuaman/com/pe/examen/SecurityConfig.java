package pillihuaman.com.pe.examen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 🔴 Desactiva CSRF para pruebas
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 🔴 Permite todos los endpoints
                );
        return http.build();
    }
}
