package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller

@RequestMapping("/funny")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";

    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDudeprocessForm(HttpServletRequest request, Model model){

        String theName = request.getParameter("studentName");
        String result = "Yo! "+theName.toUpperCase();
        model.addAttribute("message",result);
        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String letShoutDudeprocessFormVersionThree(@RequestParam("studentName") String theName, Model model){


        String result = "Heyh my friend from v3! "+theName.toUpperCase();
        model.addAttribute("message",result);
        return "helloworld";
    }
}
