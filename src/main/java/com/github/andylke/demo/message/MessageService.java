package com.github.andylke.demo.message;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageService {

  @Autowired private MessageRepository messageRepository;

  @Transactional
  public void saveMessage(final String code, final String text) {
    final Optional<Message> findResult = messageRepository.findByCode(code);
    findResult.ifPresentOrElse(
        (message) -> {
          message.setText(text);
          messageRepository.saveAndFlush(message);
        },
        () -> {
          final Message message = new Message();
          message.setCode(code);
          message.setText(text);
          messageRepository.saveAndFlush(message);
        });
  }
}
