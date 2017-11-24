package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dao.UserDao;
import com.java.entity.User;



@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private UserDao userdao;
	
	@RequestMapping(value="/userLogin")
	public String userLogin(HttpServletRequest request,
			HttpServletResponse response){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		User user = userdao.login(request.getParameter("userName"), request.getParameter("password"));
		if (user!=null) {
			return "success";
		}
		return "redirect:"+basePath+"login.jsp";
	}

}
