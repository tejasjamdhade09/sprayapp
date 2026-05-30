package com.farm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class DatabaseConfig {
	 @Value("${DATABASE_URL:}")
	    private String databaseUrl;

	    @Bean
	    
	    public DataSource dataSource() {
	        String jdbcUrl = databaseUrl;

	        // Convert Render's postgres:// URL to jdbc:postgresql://
	        if (jdbcUrl.startsWith("postgres://")) {
	            jdbcUrl = jdbcUrl.replace("postgres://", "jdbc:postgresql://");
	        } else if (jdbcUrl.startsWith("postgresql://")) {
	            jdbcUrl = jdbcUrl.replace("postgresql://", "jdbc:postgresql://");
	        }

	        // Extract username and password from URL
	        // Format: jdbc:postgresql://user:pass@host:port/dbname
	        String withoutPrefix = jdbcUrl.replace("jdbc:postgresql://", "");
	        String userInfo = withoutPrefix.split("@")[0];
	        String username = userInfo.split(":")[0];
	        String password = userInfo.split(":")[1];
	        String hostAndDb = withoutPrefix.split("@")[1];
	        String cleanUrl = "jdbc:postgresql://" + hostAndDb;

	        return DataSourceBuilder.create()
	                .url(cleanUrl)
	                .username(username)
	                .password(password)
	                .driverClassName("org.postgresql.Driver")
	                .build();
	    }
	}

