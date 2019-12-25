package com.wdk.permissions.web.args;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户管理
 *
 * @author wdke
 * @db permissions
 * @table sys_user
 * @date 2019/12/25 09
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterArgs implements Serializable {


    //用户名
    @NotBlank(message = "cannot be empty")
    private String username;

    //用户密码
    @NotBlank(message = "cannot be empty")
    private String password;

    //电话
    @NotNull(message = "cannot be null")
    private Long phone;

    //邮箱
    @Email(message = "格式不符合邮箱格式。")
    private String email;


}

