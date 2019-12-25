package com.wdk.permissions.service;

import com.wdk.permissions.model.SysRoleMenu;
import com.wdk.permissions.web.args.SysRoleMenuArgs;

import com.github.pagehelper.PageInfo;
import com.wdk.permissions.common.model.PageParam;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wdke
 * @date 2019/12/25
 */
public interface SysRoleMenuService{

	/**
	* 查询返回key为数据库字段的map
	* @param param ：查询条件Map,key为数据库字段，value为值
	* @return ：List<Map<String,Object>>
	* @author jack
	* @date 2019/12/25 12:45
	*/
	List<Map<String,Object>> selectListByMapReturnMap(Map<String,Object> param);

	/**
	* 根据map获取查询列表
	* @param param ：查询条件Map,key为java对应字段，value为值
	* @return ：List<SysRoleMenu
	* @author jack
	* @date 2019/12/25 12:45
	*/
	List<SysRoleMenu> selectListByMap(Map<String,Object> param);

	/**
	* 获取查询列表
	* @param param
	* @return ：List<SysRoleMenu
	* @author jack
	* @date 2019/12/25 12:45
	*/
	List<SysRoleMenu> list(SysRoleMenu param);

	/**
	* 根据主键查询数据
	*
	* @param id
	* @author jack
	* @date 2019/12/25 12:45
	*/
	SysRoleMenu selectByPrimaryKey(Integer id);

	/**
	* 分页查询
	* @param param：查询参数
	* @param pageParam ::分页参数
	* @return ：PageInfo<SysRoleMenu:分页结果集
	* @author jack
	* @date 2019/12/25 12:45
	*/
	PageInfo<SysRoleMenu> pageInfo(SysRoleMenuArgs param,PageParam pageParam);

	/**
	* 获取查询列表
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int insert(SysRoleMenu param);

	/**
	* 不为空新增
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int insertSelective(SysRoleMenuArgs param);

	/**
	* 批量新增
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int batchInsert(List<SysRoleMenu> param);

	/**
	* 根据主键更新全量
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int updateByPrimaryKey(SysRoleMenu param);

	/**
	* 根据主键更新全量
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int updateSelectiveByPrimaryKey(SysRoleMenuArgs param);

	/**
	* 存在即更新，不存在就插入
	* @param param
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int batchInsertUpdate(List<SysRoleMenu> param);

	/**
	* 批量更新
	* @param param
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int batchUpdate(List<SysRoleMenu> param);

	/**
	* 根据主键删除数据
	* @param id
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int deleteByPrimaryKey(Integer id);

	/**
	* 根据查询条件删除数据
	* @param param
	* @author jack
	* @date 2019/12/25 12:45
	*/
	int deleteBySelect(SysRoleMenu param);



}