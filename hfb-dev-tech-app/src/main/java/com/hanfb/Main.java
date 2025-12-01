package com.hanfb;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@Configurable
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}