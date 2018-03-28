package com.sharism.blog_server.mapper;

import com.sharism.blog_server.model.BlogInfo;
import com.sharism.blog_server.model.BlogInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogInfoMapper {
    long countByExample(BlogInfoExample example);

    int deleteByExample(BlogInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BlogInfo record);

    int insertSelective(BlogInfo record);

    List<BlogInfo> selectByExampleWithBLOBs(BlogInfoExample example);

    List<BlogInfo> selectByExample(BlogInfoExample example);

    BlogInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BlogInfo record, @Param("example") BlogInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogInfo record, @Param("example") BlogInfoExample example);

    int updateByExample(@Param("record") BlogInfo record, @Param("example") BlogInfoExample example);

    int updateByPrimaryKeySelective(BlogInfo record);

    int updateByPrimaryKeyWithBLOBs(BlogInfo record);

    int updateByPrimaryKey(BlogInfo record);
}