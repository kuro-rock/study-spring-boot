package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static com.example.sample.WebConst.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(LOGIN_URL).permitAll()//ログインフォームは許可
                .antMatchers("/user/**").permitAll()
                .antMatchers("/new").permitAll()//test用(ユーザ登録)※終わったら消す
                .antMatchers("/index").permitAll()//test用(ユーザ登録後の遷移画面）※終わったら消す
                .antMatchers("/user/create").permitAll()//test用機能※終わったら消す
                .anyRequest().authenticated();// それ以外は全て認証無しの場合アクセス不許可
        http.formLogin()
                .loginPage(LOGIN_URL).usernameParameter("loginId").passwordParameter("password")
                .loginProcessingUrl(LOGIN_PROCESSING_URL)//ログイン処理をするURL
                .failureUrl(LOGIN_FAILURE_URL)//認証失敗時のURL
                .successForwardUrl(LOGIN_SUCCESS_URL);
    }


}