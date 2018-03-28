package com.sharism.blog_server.service.impl;

import com.sharism.blog_server.mapper.BlogInfoMapper;
import com.sharism.blog_server.model.BlogInfo;
import com.sharism.blog_server.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
