package cn.itcast.service.serviceImpl;
import cn.itcast.mapper.ArticlesheetMapper;
import cn.itcast.mapper.CustomArticlesheetMapper;
import cn.itcast.po.ArticlesheetWithBLOBs;
import cn.itcast.po.CustomArticlesheetExtend;
import cn.itcast.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StageServiceImpl implements StageService {

    @Autowired
    private CustomArticlesheetMapper customArticlesheetMapper;

    @Autowired
    private ArticlesheetMapper articlesheetMapper;

    /**
     * 获取文章总数量
     * @return
     * @throws Exception
     */
    @Override
    public int getArticlesCount() throws Exception {
        int count = articlesheetMapper.countByExample(null);
        return count;
    }

    /**
     * 获取目录
     * @param start 起始
     * @param pageSize 每页显示量
     * @return
     * @throws Exception
     */
    @Override
    public List<ArticlesheetWithBLOBs> getArticlesCatalog(int start, int pageSize) throws Exception {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("start",start);
        map.put("pageSize",pageSize);
        List<ArticlesheetWithBLOBs> list = customArticlesheetMapper.getArticlesCatalog(map);
        return list;
    }

    /**
     * 文章详情
     * @param articleId
     * @return
     * @throws Exception
     */
    @Override
    public CustomArticlesheetExtend getArticleDetail(String articleId) throws Exception {
        Map<String,String> map = new HashMap<String,String>();
        map.put("articleId",articleId);
        List<CustomArticlesheetExtend> list = customArticlesheetMapper.getArticleDetail(map);

        return list.get(0);
    }
}
