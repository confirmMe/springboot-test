package com.ysw.demojpa.Controller;

import com.ysw.demojpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ysw.demojpa.repository.userRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    userRepository userRepository;

    @ResponseBody
    @GetMapping("/get/{id}")
    public User get(@PathVariable Integer id) {
        return userRepository.findAll().get(0);
    }

    @GetMapping("/save")
    @ResponseBody
    public void save(User user) {
        userRepository.save(user);
    }
}
