package com.wdk.permissions.service;

import com.wdk.permissions.common.model.ResponseVo;
import com.wdk.permissions.model.SysUser;
import com.wdk.permissions.web.args.RegisterArgs;

/**
 * created by wdk on 2019/12/23
 */
public interface BasicService {
    /**
     * 登陆接口
     *
     * @param username
     * @param password
     * @return
     */
    ResponseVo<String> login(String username, String password);


    /**
     * 校验token
     *
     * @param tokenValue
     * @return
     */
    ResponseVo<Boolean> tokenCheck(String tokenValue);


    /**
     * 根据手机号查询
     *
     * @param phone
     * @return
     */
    SysUser getUserByPhone(Long phone);


    /**
     * 注册用户
     *
     * @param registerArgs
     * @return
     */
    ResponseVo<Integer> register(RegisterArgs registerArgs);
}
