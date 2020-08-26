package com.ex.Controllers;

import com.ex.Frames.Users;
import com.ex.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/users")
public class LoginCtrl {
    //private HibernateTemplate hibernateTemplate;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public ModelAndView validateUsr(@RequestParam("username")String username, @RequestParam("password")String password) {
        String msg = "";
        Users user = userService.login(username, password);
        return new ModelAndView("result", "output", msg);
    }
}
