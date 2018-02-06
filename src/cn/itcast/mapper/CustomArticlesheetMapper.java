package cn.itcast.mapper;

import cn.itcast.po.ArticlesheetWithBLOBs;
import cn.itcast.po.CustomArticlesheetExtend;

import java.util.List;
import java.util.Map;

public interface CustomArticlesheetMapper {
    /**
     * 分页获取目录
     * @param map
     * @return
     */
    public List<ArticlesheetWithBLOBs> getArticlesCatalog(Map<String, Integer> map);

    public List<CustomArticlesheetExtend> getArticleDetail(Map<String,String> map);

}


