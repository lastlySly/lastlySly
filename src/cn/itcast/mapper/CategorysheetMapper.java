package cn.itcast.mapper;

import cn.itcast.po.Categorysheet;
import cn.itcast.po.CategorysheetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategorysheetMapper {
    int countByExample(CategorysheetExample example);

    int deleteByExample(CategorysheetExample example);

    int deleteByPrimaryKey(Integer categoryid);

    int insert(Categorysheet record);

    int insertSelective(Categorysheet record);

    List<Categorysheet> selectByExample(CategorysheetExample example);

    Categorysheet selectByPrimaryKey(Integer categoryid);

    int updateByExampleSelective(@Param("record") Categorysheet record, @Param("example") CategorysheetExample example);

    int updateByExample(@Param("record") Categorysheet record, @Param("example") CategorysheetExample example);

    int updateByPrimaryKeySelective(Categorysheet record);

    int updateByPrimaryKey(Categorysheet record);
}