package org.samapitan.model;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class ChatMessage {
  abstract String getText();
  abstract MessageType getMessageType();
  abstract String getOwner();
}
