package com.example.demo.controller;

import com.example.demo.event.AyUserQueryEvent;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/ayUser")
public class AyUserController {
    @Resource
    private AyUserService ayUserService;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping("/index")
    public String index(Model model) {
        List<AyUser> list = ayUserService.findAll();
        model.addAttribute("users", list);
        System.out.println("query user");

        applicationEventPublisher.publishEvent(new AyUserQueryEvent(this, list.size()));

        return "ayUser";
    }
}
