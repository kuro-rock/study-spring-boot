package com.example.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping(path = "lp", produces = "text/html")
    public String lp() {
        return "LPです";
    }

    @GetMapping(path = "logged_in", produces = "text/html")
    public String logged_in() {
        return "ログインしました";
    }

    @GetMapping(path = "secret", produces = "text/html")
    public String secret() {
        return "秘密のページです";
    }

}
