package com.wdk.permissions.model;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;import java.io.Serializable;

/**
 * 系统菜单路径
 * @db permissions
 * @table sys_menus
 * @author wdke
 * @date 2019/12/25 12
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysMenus implements Serializable {

	//菜单ID
	private Integer id;

	//菜单名称
	private String name;

	//菜单地址
	private String url;

	//所属服务器
	private String host;

	//父节点
	private Integer parent;

	//所有父节点
	private String parents;

	//备注
	private String remark;

	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

	//更新时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date updateTime;



}

