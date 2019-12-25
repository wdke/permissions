package com.wdk.permissions.web.controller;

import com.wdk.permissions.common.enums.ResponseStatusEnum;
import com.wdk.permissions.common.model.ResponseVo;
import com.wdk.permissions.service.LoginService;
import com.wdk.permissions.web.args.LoginArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by wdk on 2019/12/23
 */
@RestController
@RequestMapping("api")
public class LoginController {

	@Autowired
	private LoginService loginService;


	@PostMapping(value = "login")
	public ResponseVo<String> login(@RequestBody LoginArgs loginArgs){

		ResponseVo<String> result=loginService.login(loginArgs.getUsername(),loginArgs.getPassord());


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

		ResponseVo<Boolean> result = loginService.tokenCheck(tokenValue);


		return result;
	}

}
