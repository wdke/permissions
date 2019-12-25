package com.wdk.permissions.model;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;import java.io.Serializable;

/**
 * 
 * @db permissions
 * @table sys_role_menu
 * @author wdke
 * @date 2019/12/25 12
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRoleMenu implements Serializable {

	//权限ID
	private Integer id;

	//角色ID
	private Integer roleId;

	//菜单路径ID
	private Integer menuId;

	//备注
	private String remark;

	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

	//更新时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date updateTime;



}

