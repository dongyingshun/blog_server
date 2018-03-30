package com.sharism.blog_server.controller;

import com.github.pagehelper.PageInfo;
import com.sharism.blog_server.model.BlogInfo;
import com.sharism.blog_server.service.BlogService;
import com.sharism.blog_server.utils.DateTime;
import com.sharism.blog_server.utils.Result;
import com.sharism.blog_server.utils.Uuid;
import com.sharism.blog_server.utils.mapToBean;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author DYS
 * @Package com.sharism.blog_server.controller
 * @Description:
 * @date 2018/3/24-23:50
 * @Version: 1.0
 */
@CrossOrigin //支持跨域请求
@Controller
@RequestMapping(value = "blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
     /**
        * @ProjectName:    BlogController
        * @Description:    插入一篇博客
        * @Author:         DYS
        * @CreateDate:     2018/3/25-0:32
        * @UpdateUser:     DYS
        * @UpdateDate:
        * @UpdateRemark:   The modified content
        * @Version:        1.0
        */


    @RequestMapping(value = "/insertBlog", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result insertBlog(HttpServletRequest request, HttpServletResponse response){

        //TODO :获取session值

        String userId="690770002d9f4b78a10903efc3320391";



        String blog= request.getParameter("blogMap");
        if(blog==null)
            return  Result.newInstance().setCode(-1).setMessage("数据为空").setValue(null);
        JSONObject jb = JSONObject.fromObject(blog);
        Map blogMap = (Map)jb;
        BlogInfo blogInfo=new BlogInfo();
        try {
            blogInfo  = (BlogInfo) mapToBean.mapToBean(blogMap, BlogInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(-2).setMessage("数据转换有误").setValue(null);
        }
        //id
        String id=Uuid.getUUID();
        blogInfo.setId(id);
        //作者id
        blogInfo.setUserId(userId);
        //发表时间
        blogInfo.setPublishDate(DateTime.getStringDate());
        //发表删除
        blogInfo.setRemove(0);
        //点赞个数
        blogInfo.setPraiseAmount(0);
        //阅读次数
        blogInfo.setReadCount(0);
        //转发量
        blogInfo.setTranspondAmount(0);

        try {
            blogService.insertBlog(blogInfo);
            return  Result.newInstance().setCode(1).setMessage("博客上传成功").setValue(id);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(0).setMessage("博客上传失败").setValue(null);
        }
    }



    @RequestMapping(value = "/blogList", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result blogList(HttpServletRequest request, HttpServletResponse response){
        //TODO 获取session
        String userId="690770002d9f4b78a10903efc3320391";


        String blogPageMap= request.getParameter("blogPageMap");
        if(blogPageMap==null)
            return  Result.newInstance().setCode(-1).setMessage("数据为空").setValue(null);
        JSONObject Page = JSONObject.fromObject(blogPageMap);
        int pageNum  = Page.getInt("pageNum");
        int pageSize = Page.getInt("pageSize");

        if(pageSize<0)
            return  Result.newInstance().setCode(-2).setMessage("数据条数不合法");
        if(pageNum<0)
            return  Result.newInstance().setCode(-3).setMessage("页数不合法");

        Map map=(Map)Page;
        map.put("id",userId);
        //Page.clear();
        List<BlogInfo> blogInfos = null;
        try {
            blogInfos = blogService.selectBlogPageWithBolg(map, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(-4).setMessage("服务器错误");
        }

        PageInfo<BlogInfo> pageInfo = new PageInfo<>(blogInfos);

        return  Result.newInstance().setCode(1).setMessage("成功").setValue(pageInfo);

    }

    @RequestMapping(value = "/deleteBlog", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result deleteBlog(HttpServletRequest request, HttpServletResponse response){
        //TODO 获取session
        String userId="690770002d9f4b78a10903efc3320391";


        String blogArrayList= request.getParameter("blogArrayList");
        if(blogArrayList==null)
            return  Result.newInstance().setCode(-1).setMessage("数据为空").setValue(null);

        String[] split = blogArrayList.split(",");

        if(split.length==0)
            return  Result.newInstance().setCode(-2).setMessage("数据为空");



        List<String> list =new ArrayList<>();
        for(String tmp:split) {
            list.add(tmp);
        }
        int i = 0;
        try {
            i = blogService.batchSetBlogDeleteStatus(userId,list);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(-3).setMessage("删除失败");
        }
            return  Result.newInstance().setCode(1).setMessage("成功").setValue(i);

    }

    @RequestMapping(value ="/updateBlogInfo",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result updateBlogInfo(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) {
        //TODO :获取session值
        String userId = "690770002d9f4b78a10903efc3320391";

        String blogInfoMap= request.getParameter("updateBlogInfoMap");
        if(blogInfoMap==null)
            return  Result.newInstance().setCode(-1).setMessage("数据为空");
        JSONObject jb = JSONObject.fromObject(blogInfoMap);
        Map map = (Map)jb;
        BlogInfo blobgInfo=null;
        try {
            blobgInfo =(BlogInfo)mapToBean.mapToBean(map,BlogInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(-2).setMessage("数据转换有误");
        }
        if(blobgInfo.getId()==null)
            return  Result.newInstance().setCode(-3).setMessage("博客id不能为空");

        int i=0;
        try {
            i= blogService.updateByPrimaryKeySelective(blobgInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(-4).setMessage("更新失败");
        }
        if(i>0)
            return  Result.newInstance().setCode(1).setMessage("更新成功");
        else
            return  Result.newInstance().setCode(0).setMessage("没有要更新的");

    }

    @RequestMapping(value = "/test",method ={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result test(){
        return  Result.newInstance().setCode(1).setMessage("测试成功").setValue("file_server 测试");

    }
}
