package com.sharism.blog_server.service;

import com.sharism.blog_server.model.BlogInfo;
import com.sharism.blog_server.model.BlogInfo;

/**
 * @author DYS
 * @Package com.sharism.blog_server.service
 * @Description:
 * @date 2018/3/24-23:41
 * @Version: 1.0
 */
public interface BlogService {
    /**
     * 插入一条博客
     * @param blogInfo
     * @return
     */
    int insertBlog(BlogInfo blogInfo)throws Exception;



}
