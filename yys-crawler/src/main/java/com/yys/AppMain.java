package com.yys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@ServletComponentScan
@ComponentScan
@SpringBootApplication
public class AppMain {


    public static void main(String[] args){
        SpringApplication.run(AppMain.class,args);
    }
}
