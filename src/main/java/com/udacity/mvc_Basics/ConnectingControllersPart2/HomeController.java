package com.udacity.mvc_Basics.ConnectingControllersPart2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private MessageListservice messageListservice;

    public HomeController(MessageListservice messageListservice) {
        this.messageListservice = messageListservice;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute MessageForm newMessage, Model model)
{
    model.addAttribute("greetings", this.messageListservice.getMessages());
    return "home";
}
@PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm,Model model)
{
    messageListservice.addMessage(messageForm.getText());
    model.addAttribute("greetings", messageListservice.getMessages());
  messageForm.setText("");
    return "home";
}
}
