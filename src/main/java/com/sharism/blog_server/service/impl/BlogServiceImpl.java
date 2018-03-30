package com.sharism.blog_server.service.impl;

import com.github.pagehelper.PageHelper;
import com.sharism.blog_server.mapper.BlogInfoMapper;
import com.sharism.blog_server.model.BlogInfo;
import com.sharism.blog_server.service.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author DYS
 * @Package com.sharism.blog_server.service.impl
 * @Description:
 * @date 2018/3/24-23:42
 * @Version: 1.0
 */
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public int insertBlog(BlogInfo blogInfo) {
        return blogInfoMapper.insert(blogInfo);
    }


    /**
     * 获取博客列表（带博客内容）
     * @return
     * @throws Exception
     */
    @Override
    public List<BlogInfo> selectBlogPageWithBolg(Map map, int pageNum, int pageSize) throws Exception {
        //不进行count查询。第三个參数设为false (pageNum, pageSize,false)
        PageHelper.startPage(pageNum, pageSize);
        return blogInfoMapper.selectBlogPageWithBolg(map);
    }

    /**
     * 批量删除
     * @param
     * @return
     */
    @Override
    public int batchSetBlogDeleteStatus(String userId, List<String> ids) throws Exception{
        return blogInfoMapper.batchSetBlogDeleteStatus(userId,ids);
    }
}
