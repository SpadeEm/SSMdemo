package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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
	
	
	
	/*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("springUpload")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException{
    	long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
//                  String path="D:/springUpload"+file.getOriginalFilename();
                	//指定路径
                	String path="D:/springUpload/"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
                 
            }
           
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success"; 
    }
    
    
    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("fileUpload2")
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
         long  startTime=System.currentTimeMillis();
        if (file.getSize()<=0) {
			return "fail";
		}
        System.out.println("fileName："+file.getOriginalFilename());
        String path="D:/springUpload/"+file.getOriginalFilename();
         
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success"; 
    }
    
    @RequestMapping("fileUploads")
    public String  fileUploads(@RequestParam("file") CommonsMultipartFile[] file) throws IOException {
    	long  startTime=System.currentTimeMillis();
        for (CommonsMultipartFile itemfile: file) {
			
        	if (itemfile.getSize()<=0) {
    			return "fail";
    		}
            System.out.println("fileName："+itemfile.getOriginalFilename());
            String path="D:/springUpload/fileUpload/"+itemfile.getOriginalFilename();
             
            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            itemfile.transferTo(newFile);
        	
		}  
        long  endTime=System.currentTimeMillis();
        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success"; 
    }

}
