package com.example.sample.controller.home;

import com.example.sample.controller.abstruct.AbstractHtmlController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends AbstractHtmlController {
    @Override
    public String getFunctionName() {
        return "HOME";
    }

    @GetMapping("/")
    public String index(Model model) {
        return "home/index";
    }
}
