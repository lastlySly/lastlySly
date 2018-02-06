package cn.itcast.mapper;

import cn.itcast.po.Articlesheet;
import cn.itcast.po.ArticlesheetExample;
import cn.itcast.po.ArticlesheetWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlesheetMapper {
    int countByExample(ArticlesheetExample example);

    int deleteByExample(ArticlesheetExample example);

    int deleteByPrimaryKey(String articleid);

    int insert(ArticlesheetWithBLOBs record);

    int insertSelective(ArticlesheetWithBLOBs record);

    List<ArticlesheetWithBLOBs> selectByExampleWithBLOBs(ArticlesheetExample example);

    List<Articlesheet> selectByExample(ArticlesheetExample example);

    ArticlesheetWithBLOBs selectByPrimaryKey(String articleid);

    int updateByExampleSelective(@Param("record") ArticlesheetWithBLOBs record, @Param("example") ArticlesheetExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticlesheetWithBLOBs record, @Param("example") ArticlesheetExample example);

    int updateByExample(@Param("record") Articlesheet record, @Param("example") ArticlesheetExample example);

    int updateByPrimaryKeySelective(ArticlesheetWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticlesheetWithBLOBs record);

    int updateByPrimaryKey(Articlesheet record);
}