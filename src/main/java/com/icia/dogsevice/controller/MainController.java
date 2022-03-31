package com.icia.dogsevice.controller;

import com.icia.dogsevice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberService ms;


    @GetMapping("/")
    public String Main(Model model){
        model.addAttribute("sessionid",ms.getSessionId());
        System.out.println(ms.getSessionId());

        return "index";
    }
}
