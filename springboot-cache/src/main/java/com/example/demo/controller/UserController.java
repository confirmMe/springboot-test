package com.example.demo.controller;

import com.example.demo.ecption.UserNotExistExpection;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by ysw on 2019/4/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
//   @RequestMapping(value="/login")
    public String login(String username, String password, Model model, HttpSession httpSession) {

        if (username.equals("jjj")) {
            throw new UserNotExistExpection();
        }
//        System.out.println(1/0);
        if (password.equals("950925")) {
            httpSession.setAttribute("username", username);
            return "redirect:/main.html";//外部重定向


        } else {
//            map.put("msg","登录失败");
            model.addAttribute("msg", "error");
            return "login";
        }

    }

}

