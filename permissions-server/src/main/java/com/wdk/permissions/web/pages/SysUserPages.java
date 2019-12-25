package com.wdk.permissions.web.pages;

import com.wdk.permissions.service.SysUserService;
import com.alibaba.druid.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import com.wdk.permissions.common.enums.ResponseStatusEnum;
import com.wdk.permissions.common.model.ResponseVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wdk.permissions.common.model.PageParam;
import com.wdk.permissions.model.SysUser;
import com.wdk.permissions.web.args.SysUserArgs;
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



//用户管理页面控制类
@Controller
@RequestMapping("pages/sys/user")
public class SysUserPages {

	//定义生成logger对象
	private static Logger logger=LoggerFactory.getLogger(SysUserPages.class);

	//用户管理逻辑处理对象
	@Autowired
	private SysUserService sysUserService;

	/**
	* 首页接口
	*
	* @param sysUser
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@RequestMapping(value = "",name = "首页接口")
	public String index(SysUserArgs sysUser, PageParam pageParam, Model model){

		//打印方法开始参数
		logger.info("index start。param:【sysUser->{},pageParam->{}】", JSON.toJSONString(sysUser), JSON.toJSONString(pageParam));

		//纪录开始时间
		long startTimes = System.currentTimeMillis();

		//调用业务逻辑
		PageInfo<SysUser> result = sysUserService.pageInfo(sysUser, pageParam);

		//数据返回jsp
		model.addAttribute("datas", result);

		//打印方法开始参数
		logger.info("index end。result:【data->{},times->{}】", JSON.toJSONString(result), TimeUtils.format(System.currentTimeMillis() - startTimes));
		return "/sysUser/index";
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

		return "/sysUser/insert";
	}

	/**
	* 新增接口
	*
	* @param sysUser
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@PostMapping(value = "insert",name = "新增接口")
	public String insert(SysUserArgs sysUser){

		//打印方法开始参数
		logger.info("insert start。param:【sysUser->{}】", JSON.toJSONString(sysUser));

		//纪录开始时间
		long startTimes = System.currentTimeMillis();

		//调用业务逻辑
		Integer result = sysUserService.insertSelective(sysUser);

		//打印方法开始参数
		logger.info("insert end。result:【data->{},times->{}】", JSON.toJSONString(result), TimeUtils.format(System.currentTimeMillis() - startTimes));
		return "redirect:/sys/user";
	}

	/**
	* 进入更新页面
	*
	* @param username
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@GetMapping(value = "update/pages",name = "进入更新页面")
	public String updatePage(String username, Model model){

		//打印方法开始参数
		logger.info("selectByPrimaryKey start。param【username->{}】", username);

		//纪录开始时间
		long startTimes=System.currentTimeMillis();

		//根据主键查询数据
		SysUser result = sysUserService.selectByPrimaryKey(username);

		//数据返回html
		model.addAttribute("data", result);

		//打印方法开始参数
		logger.info("selectByPrimaryKey end。result【data->{},times->{}】", result, TimeUtils.format(System.currentTimeMillis() - startTimes));

		//返回页面路径
		return "/sysUser/update";
	}

	/**
	* 更新接口
	*
	* @param sysUser
	* @author jack
	* @date 2019/12/25 12:45
	*/
	@PostMapping(value = "update",name = "更新接口")
	public String update(SysUserArgs sysUser){

		//打印方法开始参数
		logger.info("update start。param:【sysUser->{}】", JSON.toJSONString(sysUser));

		//纪录开始时间
		long startTimes = System.currentTimeMillis();

		//调用业务逻辑
		Integer result = sysUserService.updateSelectiveByPrimaryKey(sysUser);

		//打印方法开始参数
		logger.info("update end。result:【data->{},times->{}】", JSON.toJSONString(result), TimeUtils.format(System.currentTimeMillis() - startTimes));
		return "redirect:/sys/user";
	}

	/**
	 * 移除方法
	 *
	 * @param username
	 * @return
	 */
	@PostMapping(value = "remove", name = "移除方法")
	@ResponseBody
	public ResponseVo<Integer> remove(HttpServletRequest request, String username) {
		//打印方法开始参数
		logger.info("remove start。param:【username->{}】", username);

		//校验方法
		if (StringUtils.isEmpty(username)) {
			if(StringUtils.isEmpty(request.getParameter("username"))){
				return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR.getCode(),"username不能为空！");
			}else {
				username=request.getParameter("username");
			}
		}
		//纪录开始时间
		long startTimes=System.currentTimeMillis();

		//调用业务逻辑
		Integer result = sysUserService.deleteByPrimaryKey(username);

		//打印方法开始参数
		logger.info("remove end。result【data->{},times-{}】", result, TimeUtils.format(System.currentTimeMillis() - startTimes));


		return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);

	}
}
