package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.AccountService;
import com.atguigu.admin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author liuyang
 * @create 2022-06-29-12:46
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id) {
        return cityService.getCityById(id);
    }


    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id)  {
        return accountService.getAcctById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user ", Long.class);
        return  aLong.toString();
    }

    /**
     * 登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        if(StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            //把登陆成功的用户信息保存起来
            session.setAttribute("loginUser",user);
            //登陆成功则重定向到index.html中;防止表单重复提交
            return "redirect:index.html";
        }else {
            //用户信息为空则重新返回到登录页面
            model.addAttribute("msg","账号错误，请重新输入!");
            return "login";
        }


    }

    /**
     * 去index页面
     */
    @GetMapping("/index.html")
    public String mainPage(HttpSession session, Model model) {
        log.info("当前方式是： {}","mainPage");
        //是否登录 拦截器、过滤器
//        Object attribute = session.getAttribute("loginUser");
//        if (attribute != null){
//            return "index";
//        }else {
//            model.addAttribute("msg","请先登录!");
//            return "login";
//        }
        return "index";
    }
}
