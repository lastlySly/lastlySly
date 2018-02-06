package cn.itcast.service;

import cn.itcast.po.Adminsheet;
import cn.itcast.po.ArticlesheetWithBLOBs;
import cn.itcast.po.Categorysheet;

import java.util.List;

/**
 * 博客后台各操作接口
 */
public interface AdminService {

    /**
     * 管理员登录接口
     * @return 返回值为管理员信息
     */
    public Adminsheet findAdministrators(String username,String password) throws Exception;

    /**
     * 添加文章接口
     * @param article
     * @return
     * @throws Exception
     */
    public boolean addArticle(ArticlesheetWithBLOBs article) throws Exception;

    /**
     * 获取类别
     * @return
     * @throws Exception
     */
    public List<Categorysheet> getCategory() throws Exception;

}
