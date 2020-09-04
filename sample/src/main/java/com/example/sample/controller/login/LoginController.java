package com.example.sample.controller.login;

import com.example.sample.controller.abstruct.AbstractHtmlController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.example.sample.WebConst.*;

@Controller
@Slf4j
public class LoginController extends AbstractHtmlController {


    @Override
    public String getFunctionName() {
        return "A_LOGIN";
    }

    @ModelAttribute
    LoginForm loginForm(){return new LoginForm();}

    /**
     * ログイン画面表示
     * @return getメソッドの時はログイン画面を表示する
     */
    @GetMapping(LOGIN_URL)
    public String loginFrom(){
        return "login/login";
    }

    /**
     * 入力チェック
     *
     * @param form
     * @param br
     * @return
     */
    @PostMapping(LOGIN_URL)
    public String index(@Validated @ModelAttribute LoginForm form, BindingResult br) {
        // 入力チェックエラーがある場合は、元の画面にもどる
        if (br.hasErrors()) {
            return "login/login";
        }
        return "forward:" + LOGIN_PROCESSING_URL;
    }


    /**
     * ログイン成功
     *
     * @param form
     * @param attributes
     * @return
     */
    @RequestMapping(LOGIN_SUCCESS_URL)
    public String loginSuccess(@ModelAttribute LoginForm form, RedirectAttributes attributes) {
//        attributes.addFlashAttribute("msg", getMessage("login.success"));
        return "redirect:/";
    }

    /**
     * ログイン失敗
     *
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(LOGIN_FAILURE_URL)
    public String loginFailure(@ModelAttribute LoginForm form, Model model) {
        model.addAttribute("msg", getMessage("login.failed"));
        return "login/login";
    }
}
