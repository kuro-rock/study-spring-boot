package com.example.sample.controller.user;

import com.example.sample.controller.abstruct.BaseController;
import com.example.sample.dao.UserDao;
import com.example.sample.dto.user.User;
import com.example.sample.service.UserServiceImpl;
import com.example.sample.validation.UserFormValidator;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class UserController extends BaseController {

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder("userForm")
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(userFormValidator);
    }

    @Autowired
    UserDao userDao;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @ModelAttribute("userForm")
    UserForm userForm(){return new UserForm();}

    @RequestMapping("/index")
    public String index(Model model){
        List<User> user = userDao.selectAll();
        model.addAttribute("user",user);
        return "user/index";
    }

    @RequestMapping("/new")
    public String newUser(){
        return "user/new";
    }


    @RequestMapping("/user/create")
    public String createUser(@Validated @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        // 入力チェックエラーがある場合は、元の画面にもどる
        if (bindingResult.hasErrors()) {
            return "redirect:/user/new";
        }
        // 入力値からDTOを作成する
        val inputUser = modelMapper.map(userForm, User.class);
        val password = userForm.getPassword();

        // パスワードをハッシュ化する
        inputUser.setPassword(passwordEncoder.encode(password));

        // 登録する
        val createdUser = userService.create(inputUser);

        return "redirect:/index";

    }



}
