package com.udacity.mvc_Basics.ConnectingControllersPart2;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class MessageListservice {
    private List<String> messages;

    @PostConstruct
    public void postconstruct()
    {
        this.messages=new ArrayList<>();

    }
    public void addMessage(String message)
    {
messages.add(message);
    }
    public List<String> getMessages()
        {
return new ArrayList<>(this.messages);
    }
}
