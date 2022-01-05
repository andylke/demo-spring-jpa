package com.github.andylke.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.github.andylke.demo.message.MessageService;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Autowired private MessageService messageService;

  @EventListener({ApplicationReadyEvent.class})
  void ready() {
    messageService.saveMessage("foo", "foo " + LocalDateTime.now().toString());
  }
}
