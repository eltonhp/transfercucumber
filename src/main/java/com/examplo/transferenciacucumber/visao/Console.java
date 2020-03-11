package com.examplo.transferenciacucumber.visao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Console implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
          System.out.println("teste");
    }
}
