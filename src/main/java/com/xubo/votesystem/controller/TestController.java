package com.xubo.votesystem.controller;

import com.xubo.votesystem.common.BasicResultVO;
import com.xubo.votesystem.entitys.domain.User;
import com.xubo.votesystem.service.UserService;
import com.xubo.votesystem.utils.AuthorizationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author xubo
 * @Date 2022/5/10 13:43
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public BasicResultVO getAllUser() {
        Map<String, Object> userInfo = AuthorizationUtils.getRequestUser();
        System.out.println("userInfo = " + userInfo);
        List<User> list = userService.list();
        return BasicResultVO.success(list);
    }

}
