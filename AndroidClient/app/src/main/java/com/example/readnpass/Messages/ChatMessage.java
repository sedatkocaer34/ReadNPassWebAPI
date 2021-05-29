package com.example.readnpass.Messages;

import java.util.Date;

public class ChatMessage
{
    private String messageText;
    private String messageUser;
    private long messageTime;

    public boolean isBelongsToCurrentUser()
    {
        return belongsToCurrentUser;
    }

    public void setBelongsToCurrentUser(boolean belongsToCurrentUser) {
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    private boolean belongsToCurrentUser;

    public ChatMessage(String messageText, String messageUser, boolean belongsToCurrentUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.belongsToCurrentUser = belongsToCurrentUser;
        // Initialize to current time
        messageTime = new Date().getTime();
    }

    public ChatMessage(){

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
