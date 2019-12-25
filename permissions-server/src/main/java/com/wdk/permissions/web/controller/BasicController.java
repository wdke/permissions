package com.wdk.permissions.web.controller;

import com.wdk.permissions.common.model.ResponseVo;
import com.wdk.permissions.service.BasicService;
import com.wdk.permissions.web.args.LoginArgs;
import com.wdk.permissions.web.args.RegisterArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by wdk on 2019/12/23
 */
@RestController
@RequestMapping("api/basic")
public class BasicController {

    @Autowired
    private BasicService basicService;


    /**
     * 登陆接口
     *
     * @param loginArgs
     * @return
     */
    @PostMapping(value = "login")
    public ResponseVo<String> login(@RequestBody LoginArgs loginArgs) {

        ResponseVo<String> result = basicService.login(loginArgs.getUsername(), loginArgs.getPassord());


        return result;
    }

    /**
     * 注册接口
     *
     * @param registerArgs
     * @return
     */
    @PostMapping(value = "register")
    public ResponseVo<Integer> register(@RequestBody RegisterArgs registerArgs) {

        ResponseVo<Integer> result = basicService.register(registerArgs);


        return result;
    }

    /**
     * 校验token是否存在
     *
     * @param tokenValue
     * @return
     */
    @GetMapping(value = "token/check")
    public ResponseVo<Boolean> tokenCheck(@RequestParam("tokenValue") String tokenValue) {

        ResponseVo<Boolean> result = basicService.tokenCheck(tokenValue);


        return result;
    }

}
