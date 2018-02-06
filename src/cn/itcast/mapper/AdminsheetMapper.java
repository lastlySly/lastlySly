package cn.itcast.mapper;

import cn.itcast.po.Adminsheet;
import cn.itcast.po.AdminsheetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminsheetMapper {
    int countByExample(AdminsheetExample example);

    int deleteByExample(AdminsheetExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Adminsheet record);

    int insertSelective(Adminsheet record);

    List<Adminsheet> selectByExample(AdminsheetExample example);

    Adminsheet selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Adminsheet record, @Param("example") AdminsheetExample example);

    int updateByExample(@Param("record") Adminsheet record, @Param("example") AdminsheetExample example);

    int updateByPrimaryKeySelective(Adminsheet record);

    int updateByPrimaryKey(Adminsheet record);
}