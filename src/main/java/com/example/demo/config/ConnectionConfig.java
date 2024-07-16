package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConnectionConfig{

	@Bean
	public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:oracle:thin:@192.168.0.139:1521:snukifkslib");
        dataSourceBuilder.username("futuredb");
        dataSourceBuilder.password("futuredb");
        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        return dataSourceBuilder.build();
    }
	
}
