package com.cdsxt.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdsxt.base.BaseController;
import com.cdsxt.ro.UserRo;

@Controller
@RequestMapping("/back/user")
public class BackUserController extends BaseController{
	
	/**
	 * 登录
	 */
	@RequestMapping("/login.do")
	public String login(String username,String password)throws Exception{
		//去查询数据
		UserRo user=backUserService.selectUserByName(username);
		if (user!=null&&user.getPwd().equals(password)) {
			//登录成功
			//设置用户类型
			ses.setAttribute("curUser", user);
			//去主页
			return "redirect:/index/query.do";
		}
		//登录失败：用户名或密码错误
		return "/page/back/login.jsp";
	}
}
