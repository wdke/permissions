package com.wdk.permissions.model;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;import java.io.Serializable;

/**
 * 角色管理
 * @db permissions
 * @table sys_role
 * @author wdke
 * @date 2019/12/25 12
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRole implements Serializable {

	//ID 唯一值
	private Integer id;

	//角色名称
	private String rolename;

	//创建日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

	//更新日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date updateTime;



}

