package cn.itcast.controller;

import cn.itcast.myutils.MyResponseJson;
import cn.itcast.po.ArticlesheetWithBLOBs;
import cn.itcast.po.CustomArticlesheetExtend;
import cn.itcast.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/stageController")
public class StageController {

    @Autowired
    private StageService stageService;

    /**
     * 获取文章数量
     * @param response
     * @return
     */
    @RequestMapping(value = "/getArticlesCount",method = RequestMethod.POST)
    @ResponseBody
    public MyResponseJson getArticlesCount(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try {
            int count = stageService.getArticlesCount();
            MyResponseJson mrj = new MyResponseJson(1,"获取文章数量成功，共有"+count+"篇文章",count);
            return mrj;
        } catch (Exception e) {
            e.printStackTrace();
            MyResponseJson err = new MyResponseJson(0,"服务器出错",null);
            return err;
        }
    }

    /**
     * 分页获取目录
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/getArticlesCatalog",method = RequestMethod.POST)
    @ResponseBody
    public MyResponseJson getArticleCatalog(HttpServletResponse response, HttpServletRequest request){
        response.setContentType("text/html;charset=utf-8");

        int pageIndex = Integer.parseInt(request.getParameter("dqy"));
        int pageSize = Integer.parseInt(request.getParameter("pagesize"));
        int start = (pageIndex-1)*pageSize;
        System.out.println(start+"  ===  "+pageSize);
        try {
            List<ArticlesheetWithBLOBs> list = stageService.getArticlesCatalog(start,pageSize);
//            System.out.println(list.get(0).getArticleTitle());
            return new MyResponseJson(1,"查询成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResponseJson(0,"服务器出错",null);
        }
    }

    @RequestMapping(value = "/getArticleDetail",method = RequestMethod.POST)
    @ResponseBody
    public MyResponseJson getArticleDetail(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        String articleId = request.getParameter("nid");
        try {
            CustomArticlesheetExtend customArticlesheetExtend = stageService.getArticleDetail(articleId);
            return new MyResponseJson(1,"获取数据成功",customArticlesheetExtend);
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResponseJson(0,"服务器出错，请求失败",null);
        }
    }
}
