package com.wdk.permissions.web.pages;

import com.wdk.permissions.service.SysRoleService;
import com.alibaba.druid.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import com.wdk.permissions.common.enums.ResponseStatusEnum;
import com.wdk.permissions.common.model.ResponseVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wdk.permissions.common.model.PageParam;
import com.wdk.permissions.model.SysRole;
import com.wdk.permissions.web.args.SysRoleArgs;
import com.wdk.permissions.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;



//角色管理页面控制类
@Controller
@RequestMapping("pages/sys/role")
public class SysRolePages {

	//定义生成logger对象
	private static Logger logger=LoggerFactory.getLogger(SysRolePages.class);

	//角色管理逻辑处理对象
	@Autowired
	private SysRoleService sysRoleService;

	/**
	* 首页接口
	*
	* @param sysRole
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@RequestMapping(value = "",name = "首页接口")
	public String index(SysRoleArgs sysRole, PageParam pageParam, Model model){

		//打印方法开始参数
		logger.info("index start。param:【sysRole->{},pageParam->{}】", JSON.toJSONString(sysRole), JSON.toJSONString(pageParam));

		//纪录开始时间
		long startTimes = System.currentTimeMillis();

		//调用业务逻辑
		PageInfo<SysRole> result = sysRoleService.pageInfo(sysRole, pageParam);

		//数据返回jsp
		model.addAttribute("datas", result);

		//打印方法开始参数
		logger.info("index end。result:【data->{},times->{}】", JSON.toJSONString(result), TimeUtils.format(System.currentTimeMillis() - startTimes));
		return "/sysRole/index";
	}

	/**
	 * 新增页面路由
	 *
	 * @return
	 */
	@GetMapping(value = "insert/pages", name = "新增页面路由")
	public String insertPage() {

		//生成日志
		logger.info("insertPage start ");

		return "/sysRole/insert";
	}

	/**
	* 新增接口
	*
	* @param sysRole
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@PostMapping(value = "insert",name = "新增接口")
	public String insert(SysRoleArgs sysRole){

		//打印方法开始参数
		logger.info("insert start。param:【sysRole->{}】", JSON.toJSONString(sysRole));

		//纪录开始时间
		long startTimes = System.currentTimeMillis();

		//调用业务逻辑
		Integer result = sysRoleService.insertSelective(sysRole);

		//打印方法开始参数
		logger.info("insert end。result:【data->{},times->{}】", JSON.toJSONString(result), TimeUtils.format(System.currentTimeMillis() - startTimes));
		return "redirect:/sys/role";
	}

	/**
	* 进入更新页面
	*
	* @param id
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@GetMapping(value = "update/pages",name = "进入更新页面")
	public String updatePage(Integer id, Model model){

		//打印方法开始参数
		logger.info("selectByPrimaryKey start。param【id->{}】", id);

		//纪录开始时间
		long startTimes=System.currentTimeMillis();

		//根据主键查询数据
		SysRole result = sysRoleService.selectByPrimaryKey(id);

		//数据返回html
		model.addAttribute("data", result);

		//打印方法开始参数
		logger.info("selectByPrimaryKey end。result【data->{},times->{}】", result, TimeUtils.format(System.currentTimeMillis() - startTimes));

		//返回页面路径
		return "/sysRole/update";
	}

	/**
	* 更新接口
	*
	* @param sysRole
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@PostMapping(value = "update",name = "更新接口")
	public String update(SysRoleArgs sysRole){

		//打印方法开始参数
		logger.info("update start。param:【sysRole->{}】", JSON.toJSONString(sysRole));

		//纪录开始时间
		long startTimes = System.currentTimeMillis();

		//调用业务逻辑
		Integer result = sysRoleService.updateSelectiveByPrimaryKey(sysRole);

		//打印方法开始参数
		logger.info("update end。result:【data->{},times->{}】", JSON.toJSONString(result), TimeUtils.format(System.currentTimeMillis() - startTimes));
		return "redirect:/sys/role";
	}

	/**
	 * 移除方法
	 *
	 * @param id
	 * @return
	 */
	@PostMapping(value = "remove", name = "移除方法")
	@ResponseBody
	public ResponseVo<Integer> remove(HttpServletRequest request, Integer id) {
		//打印方法开始参数
		logger.info("remove start。param:【id->{}】", id);

		//校验方法
		if (id == null) {
			if(StringUtils.isEmpty(request.getParameter("id"))){
				return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR.getCode(),"id不能为空！");
			}else {
				id=Integer.parseInt(request.getParameter("id"));
			}
		}
		//纪录开始时间
		long startTimes=System.currentTimeMillis();

		//调用业务逻辑
		Integer result = sysRoleService.deleteByPrimaryKey(id);

		//打印方法开始参数
		logger.info("remove end。result【data->{},times-{}】", result, TimeUtils.format(System.currentTimeMillis() - startTimes));


		return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);

	}
}
