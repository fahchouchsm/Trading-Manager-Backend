package fahchouch.trading_manager.config;

import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Dotenv dotenv() {
        return Dotenv.load();
    }

    @Bean
    public DataSource dataSource(Dotenv dotenv) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(dotenv.get("DB_URL"));
        ds.setUsername(dotenv.get("DB_USER"));
        ds.setPassword(dotenv.get("DB_PASSWORD"));
        return ds;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build(); // <<< build the chain
    }
}
