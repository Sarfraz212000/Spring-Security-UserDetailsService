package in.sbms.rest;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private MyUserDetails details;
	
	@Autowired
	public void config(AuthenticationManagerBuilder builder)throws Exception {
	
		builder.userDetailsService(details).passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((req) -> req
                        .antMatchers("/greet").permitAll()
                        .anyRequest()
                        .authenticated()
        ).formLogin(withDefaults());
		return http.build();
		
		
	}

}
