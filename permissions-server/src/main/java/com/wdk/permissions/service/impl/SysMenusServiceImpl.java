package com.wdk.permissions.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdk.permissions.common.model.PageParam;
import com.wdk.permissions.model.SysMenus;
import com.wdk.permissions.web.args.SysMenusArgs;
import com.wdk.permissions.service.SysMenusService;
import com.wdk.permissions.dao.SysMenusMapper;
import com.wdk.permissions.utils.TimeUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

/**
 *系统菜单路径
 * @author wdke
 * @date 2019/12/25
 */
@Service
public class SysMenusServiceImpl implements SysMenusService{

	private static Logger logger=LoggerFactory.getLogger(SysMenusServiceImpl.class);

	@Autowired
	private SysMenusMapper sysMenusMapper;



	/**
	* 查询返回key为数据库字段的map
	* @param param ：查询条件Map,key为数据库字段，value为值
	* @return ：List<Map<String,Object>>
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public List<Map<String,Object>> selectListByMapReturnMap(Map<String,Object> param){
		//打印方法开始参数
		logger.info("method->selectListByMapReturnMap start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		List<Map<String,Object>> result=sysMenusMapper.selectListByMapReturnMap(param);
		//打印方法开始参数
		logger.info("method->selectListByMapReturnMap end。result size->{},selectListByMapReturnMap use times->{}",result.size(),TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 根据map获取查询列表
	* @param param ：查询条件Map,key为java对应字段，value为值
	* @return ：List<SysMenus
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public List<SysMenus> selectListByMap(Map<String,Object> param){

		//打印方法开始参数
		logger.info("method->selectListByMap start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		List<SysMenus> result=sysMenusMapper.selectListByMap(param);
		//打印方法开始参数
		logger.info("method->selectListByMap end。result size->{},selectListByMap use times->{}",result.size(),TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 获取查询列表
	* @param param
	* @return ：List<SysMenus
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public List<SysMenus> list(SysMenus param){

		//打印方法开始参数
		logger.info("method->list start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		List<SysMenus> result=sysMenusMapper.list(param);
		//打印方法开始参数
		logger.info("method->list end。result size->{},list use times->{}",result.size(),TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 根据主键查询数据
	*
	* @param id
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public SysMenus selectByPrimaryKey(Integer id){

		//打印方法开始参数
		logger.info(">selectByPrimaryKey start。id->{}",id);
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		SysMenus result=sysMenusMapper.selectByPrimaryKey(id);
		//打印方法开始参数
		logger.info("method->selectByPrimaryKey end。result->{}, use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 分页查询
	* @param param：查询参数
	* @param pageParam ::分页参数
	* @return ：PageInfo<SysMenus:分页结果集
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public PageInfo<SysMenus> pageInfo(SysMenusArgs param,PageParam pageParam){

		//打印方法开始参数
		logger.info("method->list start。param->{},pageParam->{}",JSON.toJSONString(param),JSON.toJSONString(pageParam));

		//纪录开始时间
		long startTimes=System.currentTimeMillis();

		//参数类型转化
		SysMenus sysMenus = new SysMenus();
		BeanUtils.copyProperties(param,sysMenus);

		PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());

		List<SysMenus> result=sysMenusMapper.list(sysMenus);
		//打印方法开始参数
		logger.info("method->list end。result size->{},list use times->{}",result.size(),TimeUtils.format(System.currentTimeMillis()-startTimes));
		return new PageInfo(result);
	}

	/**
	* 获取查询列表
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int insert(SysMenus param){

		//打印方法开始参数
		logger.info("method->insert start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		int result=sysMenusMapper.insert(param);
		//打印方法开始参数
		logger.info("method->insert end。insert num->{},insert use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 不为空新增
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int insertSelective(SysMenusArgs param){

		//打印方法开始参数
		logger.info("method->insertSelective start。param->{}",JSON.toJSONString(param));

		//纪录开始时间
		long startTimes=System.currentTimeMillis();

		//参数类型转化
		SysMenus sysMenus = new SysMenus();
		BeanUtils.copyProperties(param,sysMenus);

		int result=sysMenusMapper.insertSelective(sysMenus);

		//打印方法开始参数
		logger.info("method->insertSelective end。insert num->{},insertSelective use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 批量新增
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int batchInsert(List<SysMenus> param){

		//打印方法开始参数
		logger.info("method->batchInsert start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		int result=sysMenusMapper.batchInsert(param);
		//打印方法开始参数
		logger.info("method->batchInsert end。insert num->{},batchInsert use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 根据主键更新全量
	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int updateByPrimaryKey(SysMenus param){

		//打印方法开始参数
		logger.info("method->updateByPrimaryKey start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		int result=sysMenusMapper.updateByPrimaryKey(param);
		//打印方法开始参数
		logger.info("method->updateByPrimaryKey end。insert num->{},updateByPrimaryKey use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 根据主键更新全量

	* @param param
	* @return ：int 数量
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int updateSelectiveByPrimaryKey(SysMenusArgs param){

		//打印方法开始参数
		logger.info("method->updateSelectiveByPrimaryKey start。param->{}",JSON.toJSONString(param));

		//纪录开始时间
		long startTimes=System.currentTimeMillis();

		//参数类型转化
		SysMenus sysMenus = new SysMenus();
		BeanUtils.copyProperties(param,sysMenus);

		int result=sysMenusMapper.updateSelectiveByPrimaryKey( sysMenus);

		//打印方法开始参数
		logger.info("method->updateSelectiveByPrimaryKey end。insert num->{},updateByPrimaryKey use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 存在即更新，不存在就插入
	* @param param
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int batchInsertUpdate(List<SysMenus> param){

		//打印方法开始参数
		logger.info("method->batchInsertUpdate start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		int result=sysMenusMapper.batchInsertUpdate(param);
		//打印方法开始参数
		logger.info("method->batchInsertUpdate end。insert num->{},updateByPrimaryKey use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 批量更新入
	* @param param
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int batchUpdate(List<SysMenus> param){

		//打印方法开始参数
		logger.info("method->batchUpdate start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		int result=sysMenusMapper.batchUpdate(param);
		//打印方法开始参数
		logger.info("method->batchUpdate end。insert num->{},updateByPrimaryKey use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 根据主键删除数据
	* @param id
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int deleteByPrimaryKey(Integer id){

		//打印方法开始参数
		logger.info("method->deleteByPrimaryKey start。id->{}",id);
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		int result=sysMenusMapper.deleteByPrimaryKey(id);
		//打印方法开始参数
		logger.info("method->deleteByPrimaryKey end。insert num->{},updateByPrimaryKey use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}

	/**
	* 根据查询删除数据
	* @param param
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@Override
	public int deleteBySelect(SysMenus param){

		//打印方法开始参数
		logger.info("method->deleteBySelect start。param->{}",JSON.toJSONString(param));
		//纪录开始时间
		long startTimes=System.currentTimeMillis();
		int result=sysMenusMapper.deleteBySelect(param);
		//打印方法开始参数
		logger.info("method->deleteBySelect end。insert num->{},updateByPrimaryKey use times->{}",result,TimeUtils.format(System.currentTimeMillis()-startTimes));
		return result;
	}



}