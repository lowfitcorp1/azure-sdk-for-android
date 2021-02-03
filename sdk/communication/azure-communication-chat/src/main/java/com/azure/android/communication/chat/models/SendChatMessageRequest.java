// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.android.communication.chat.models;

import com.azure.android.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The SendChatMessageRequest model.
 */
@Fluent
public final class SendChatMessageRequest {
    /*
     * Chat message content.
     */
    @JsonProperty(value = "content", required = true)
    private String content;

    /*
     * The display name of the chat message sender. This property is used to
     * populate sender name for push notifications.
     */
    @JsonProperty(value = "senderDisplayName")
    private String senderDisplayName;

    /*
     * The chat message type.
     */
    @JsonProperty(value = "type")
    private ChatMessageType type;

    /**
     * Get the content property: Chat message content.
     * 
     * @return the content value.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Set the content property: Chat message content.
     * 
     * @param content the content value to set.
     * @return the SendChatMessageRequest object itself.
     */
    public SendChatMessageRequest setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get the senderDisplayName property: The display name of the chat message
     * sender. This property is used to populate sender name for push
     * notifications.
     * 
     * @return the senderDisplayName value.
     */
    public String getSenderDisplayName() {
        return this.senderDisplayName;
    }

    /**
     * Set the senderDisplayName property: The display name of the chat message
     * sender. This property is used to populate sender name for push
     * notifications.
     * 
     * @param senderDisplayName the senderDisplayName value to set.
     * @return the SendChatMessageRequest object itself.
     */
    public SendChatMessageRequest setSenderDisplayName(String senderDisplayName) {
        this.senderDisplayName = senderDisplayName;
        return this;
    }

    /**
     * Get the type property: The chat message type.
     * 
     * @return the type value.
     */
    public ChatMessageType getType() {
        return this.type;
    }

    /**
     * Set the type property: The chat message type.
     * 
     * @param type the type value to set.
     * @return the SendChatMessageRequest object itself.
     */
    public SendChatMessageRequest setType(ChatMessageType type) {
        this.type = type;
        return this;
    }
}
