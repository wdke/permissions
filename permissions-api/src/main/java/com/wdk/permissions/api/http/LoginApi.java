package com.wdk.permissions.api.http;

import com.wdk.permissions.api.args.RegisterArgs;
import com.wdk.permissions.api.args.UserArgs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * created by wdk on 2019/12/24
 */
@FeignClient(name = "permissions-server")
@RequestMapping("/permissions-server/api")
public interface LoginApi {


    /**
     * 登陆接口
     *
     * @param userArgs
     * @return
     */
    @PostMapping(value = "login")
    String login(@RequestBody UserArgs userArgs);


    /**
     * token校验
     *
     * @param tokenValue
     * @return
     */
    @GetMapping(value = "token/check")
    String login(@RequestParam("tokenValue") String tokenValue);

    /**
     * 注册接口
     *
     * @param registerArgs
     * @return
     */
    @PostMapping(value = "register")
    String login(@RequestBody RegisterArgs registerArgs);
}
