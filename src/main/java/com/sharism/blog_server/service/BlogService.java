package com.sharism.blog_server.service;

import com.sharism.blog_server.model.BlogInfo;
import com.sharism.blog_server.model.BlogInfo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取博客列表（带博客内容）
     * @return
     * @throws Exception
     */
    List<BlogInfo> selectBlogPageWithBolg(Map map, int pageNum, int pageSize) throws Exception;

    /**
     * 批量删除博客
     * @param
     * @return
     */
    int batchSetBlogDeleteStatus(String userId, List<String> ids)throws Exception;
}
