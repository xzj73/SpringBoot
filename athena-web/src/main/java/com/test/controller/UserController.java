package com.test.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.annotation.Reference;
import com.test.domain.User;
import com.test.services.UserService;

import com.test.utils.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
public class UserController {

    @Reference
    private UserService userService;


    @RequestMapping(value = "/getUser",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public Object getUser(HttpServletResponse response,
                          @RequestParam(value = "id", required = false) String id
    ) {
        return userService.get(id);





    }

    @RequestMapping(value = "/createUser",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object createUser(HttpServletResponse response,
                             @RequestParam(value = "username", required = false) String username,
                             @RequestParam(value = "loginid") String loginid,
                             @RequestParam(value = "password", required = false) String password,
                             @RequestParam(value = "mobile", required = false) String mobile

    ) {

        User user = new User();

        String id = Tools.getUUID();

        user.setId(id);

        if (username != null) {
            user.setUsername(username);
        }
        if (loginid != null) {
            user.setLoginid(loginid);
        }
        if (password != null) {
            user.setPassword(password);
        }
        if (mobile != null) {
            user.setMobile(mobile);
        }

        userService.create(user);

        return userService.get(id);
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object login(HttpServletResponse response,
                             @RequestParam(value = "username", required = false) String username,

                             @RequestParam(value = "password", required = false) String password

    ) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        return  userService.login(user);

    }


}
