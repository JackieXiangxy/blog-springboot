package com.jackie.blogasd.controller;

import com.alibaba.fastjson.JSON;
import com.jackie.blogasd.service.UserService;
import com.jackie.blogutils.respose.ResponseUtil;
import com.jackie.blogutils.respose.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("asd")
public class LoginController {
    private final static Logger log= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param object 传进的参数
     * @return
     */
    @ResponseBody
    @PostMapping("register")
    public Result<Object> userRegister(String object){
       int res = userService.insertUser(object);
        if (res > 0){
            log.info("注册成功！");
            return ResponseUtil.ok(res);
        }else {
            log.info("注册失败！");
            return ResponseUtil.fall(res);
        }
    }


    /**
     * 登录
     * @param object
     * @return
     */
    @ResponseBody
    @PostMapping("login")
    public Result<Object> userLogin(String object){
        Map<String,String> userMap= (Map<String, String>) JSON.parse(object);
        String username=userMap.get("username").trim();
        String password=userMap.get("password").trim();
        Subject subject= SecurityUtils.getSubject();//获取当前登陆用户
        if (!subject.isAuthenticated()){
            try {
                UsernamePasswordToken token=new UsernamePasswordToken(username,password);
            }catch (UnknownAccountException e) {
                e.printStackTrace();
//                System.out.println(e.getMessage());
                System.out.println("用户名错误！");
            }catch (IncorrectCredentialsException e) {
                e.printStackTrace();
//                System.out.println("密码错误！");
                System.out.println(e.getMessage());
            } catch (AuthenticationException e) {
                e.printStackTrace();
//                System.out.println("其他错误！");
                System.out.println(e.getMessage());
            }
        }

        return null;
    }


}
