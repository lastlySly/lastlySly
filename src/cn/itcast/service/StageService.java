package cn.itcast.service;

import cn.itcast.po.ArticlesheetWithBLOBs;
import cn.itcast.po.CustomArticlesheetExtend;

import java.util.List;

public interface StageService {
    /**
     * 获取文章总数量
     * @return
     * @throws Exception
     */
    public int getArticlesCount() throws Exception;

    /**
     * 分页获取目录
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ArticlesheetWithBLOBs> getArticlesCatalog(int pageIndex, int pageSize) throws Exception;

    public CustomArticlesheetExtend getArticleDetail(String articleId) throws Exception;
}
