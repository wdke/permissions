package com.wdk.permissions.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.wdk.permissions.common.constant.RedisConstant;
import com.wdk.permissions.common.enums.ResponseStatusEnum;
import com.wdk.permissions.common.model.ResponseVo;
import com.wdk.permissions.dao.SysUserMapper;
import com.wdk.permissions.model.SysUser;
import com.wdk.permissions.redis.RedisStringDao;
import com.wdk.permissions.service.BasicService;
import com.wdk.permissions.utils.JwtUtils;
import com.wdk.permissions.utils.PasswordUtil;
import com.wdk.permissions.web.args.RegisterArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by wdk on 2019/12/23
 */
@Service
public class BasicServiceImpl implements BasicService {


    private static Logger logger = LoggerFactory.getLogger(BasicService.class);


    @Autowired
    RedisStringDao redisStringDao;


    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 登陆接口
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResponseVo<String> login(String username, String password) {

        //查询用户信息
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(username);


        if (null == sysUser) {
            logger.info("login  用户不存在 .username={}", username);
            return new ResponseVo(ResponseStatusEnum.PARRAM_ERROR.getCode(), "用户不存在");
        } else if (PasswordUtil.encrypt(password, "1qaz1qaz").equals(sysUser.getPassword())) {
            //生成 token
            Map<String, Object> map = new HashMap<>();
            map.put("username", username);
            String token = JwtUtils.createJWT(map);

            //保存到 redis
            redisStringDao.set("token_" + username, token, RedisConstant.TOKEN_TIME);
            logger.info("login 登录失败。username={}", username);
            return new ResponseVo(ResponseStatusEnum.SUCCESS, token);
        }

        return new ResponseVo(ResponseStatusEnum.USER_ERROR);

    }


    /**
     * 校验token
     *
     * @param tokenValue
     * @return
     */
    @Override
    public ResponseVo<Boolean> tokenCheck(String tokenValue) {
        String check = redisStringDao.get(tokenValue);
        if (StringUtils.isEmpty(check)) {
            return new ResponseVo(ResponseStatusEnum.SUCCESS, false);
        }
        return new ResponseVo(ResponseStatusEnum.SUCCESS, true);
    }

    /**
     * 根据用户名查询数据
     *
     * @param phone
     * @return
     */
    @Override
    public SysUser getUserByPhone(Long phone) {
        //查询用户信息
        SysUser sysUser = new SysUser();
        sysUser.setPhone(phone);
        List<SysUser> list = sysUserMapper.list(sysUser);

        if (list.size() == 0) {
            return null;
        }

        return list.get(0);
    }

    /**
     * 注册用户
     *
     * @param registerArgs
     * @return
     */
    @Override
    public ResponseVo<Integer> register(RegisterArgs registerArgs) {
        logger.info("register 校验用户名是否存在");
        SysUser userByUsername = sysUserMapper.selectByPrimaryKey(registerArgs.getUsername());
        if (null != userByUsername) {
            logger.info("register 用户名已经存在。，");
            return new ResponseVo<>(ResponseStatusEnum.ERROR.getCode(), "用户名已经存在。");
        }
        logger.info("register 校验手机号是否存在。");
        SysUser userByPhone = getUserByPhone(registerArgs.getPhone());
        if (null != userByPhone) {
            logger.info("register 手机号已经存在。");
            return new ResponseVo<>(ResponseStatusEnum.ERROR.getCode(), "用户名已经存在。");

        }

        SysUser sysUser = new SysUser();
        sysUser.setUsername(registerArgs.getUsername());
        sysUser.setPasswordKey(registerArgs.getUsername());
        sysUser.setPassword(PasswordUtil.encrypt(registerArgs.getPassword(), registerArgs.getUsername()));
        sysUser.setPhone(registerArgs.getPhone());
        sysUser.setEmail(registerArgs.getEmail());
        int result = sysUserMapper.insertSelective(sysUser);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS,result);
    }

}
