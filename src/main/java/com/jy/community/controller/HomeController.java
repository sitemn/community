package com.jy.community.controller;

import com.jy.community.entity.DiscussPost;
import com.jy.community.entity.Page;
import com.jy.community.entity.User;
import com.jy.community.service.DiscussPostService;
import com.jy.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path="/index",method= RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        // method call money, SpringMVC will automatically instantiate Model and Page, and Page into the Model.
        // So, you can directly access the data in the Page object in thymeleaf.
        // System.out.println(page.hashCode()).
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        // Gain on list information, imagine a vertical expansion of the data, one dimension -> two dimensions
        List<Map<String,Object>> discussPosts=new ArrayList<>();

        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user=userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
