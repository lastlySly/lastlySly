package cn.itcast.controller;

import cn.itcast.myutils.MyResponseJson;
import cn.itcast.myutils.VerCode;
import cn.itcast.myutils.VerificationCode;
import cn.itcast.po.Adminsheet;
import cn.itcast.po.ArticlesheetWithBLOBs;
import cn.itcast.po.Categorysheet;
import cn.itcast.service.AdminService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "/adminController")
public class AdminController {
    @Autowired
    private AdminService adminService;

    private ObjectMapper om = new ObjectMapper();

    /**
     * 登录模块
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Adminsheet adminsheet;
        try {
            adminsheet = adminService.findAdministrators(username,password);
//            System.out.println(adminsheet.getUsername());

            if (adminsheet != null){
                MyResponseJson successmrj = new MyResponseJson(1,"登陆成功",adminsheet);
                String success = om.writeValueAsString(successmrj);
                request.getSession().setAttribute("admin",adminsheet);
                Cookie cookie = new Cookie("admin",adminsheet.getUsername());
                cookie.setMaxAge(60*20);
                cookie.setPath("/lastlySly/MyBolg/handler/");
                response.addCookie(cookie);
                response.getWriter().write(success);
            }else{
                MyResponseJson definedmrj = new MyResponseJson(0,"账号或密码出错",null);
                String defined = om.writeValueAsString(definedmrj);
                response.getWriter().write(defined);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MyResponseJson errmrj = new MyResponseJson(0,"服务器正在维护，登录失败，请稍后重试",null);
            String err = om.writeValueAsString(errmrj);
            response.getWriter().write(err);
        }


    }

    /**
     * 验证码刷新
     * @param request
     * @param response
     */
    @RequestMapping(value = "/refreshVerCode")
    public void refreshVerCode(HttpServletRequest request,HttpServletResponse response){
        try {
            VerificationCode vercode = VerCode.Vercode();
            request.getSession().setAttribute("vercode",vercode.getStr());
            ImageIO.write(vercode.getImg(),"jpg",response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证验证码
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/checkVerCode",method = RequestMethod.POST)
    public void checkVerCode(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String vercode = (String) request.getSession().getAttribute("vercode");
        System.out.println(vercode);
        String code = request.getParameter("inputvercode");

        if (code !=null && vercode.equalsIgnoreCase(code)) {
            MyResponseJson successmrj = new MyResponseJson(1,"验证码验证成功",null);
            String success = om.writeValueAsString(successmrj);
            response.getWriter().write(success);
        }else{
            MyResponseJson definemrj = new MyResponseJson(1,"验证码验证成功",null);
            String define = om.writeValueAsString(definemrj);
            response.getWriter().write(define);
            request.getRequestDispatcher("/MyBolg/handler/AdminLogin.html").forward(request, response);
//			response.sendRedirect("/SessionValidate/mylogin/login.html");
        }
    }

    /**
     * 图片上传
     * @param req
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadImgEditor")
    @ResponseBody
    public Map<String, String> uploadImgEditor(MultipartHttpServletRequest req,HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        MultipartFile pictureFile = req.getFile("file");
        Map<String, String> map = new HashMap<String,String>();
        if(pictureFile!=null && pictureFile.getOriginalFilename()!=null && pictureFile.getOriginalFilename().length()>0){

            String filePath = "G:\\tomcat临时图片服务器\\";
            //上传文件原始名称
            String originalFilename = pictureFile.getOriginalFilename();
            //新的图片名称
            String newFileName = UUID.randomUUID() +originalFilename.substring(originalFilename.lastIndexOf("."));
            //新文件
//            System.out.println(filePath+newFileName);
            File file = new File(filePath+newFileName);
            //将内存中的文件写入磁盘
            pictureFile.transferTo(file);
            map.put("link", "http://localhost:8080/picupload/"+newFileName);
        }
        System.out.println(map.get("link"));
        return map;
    }

    /**
     * 删除图片
     * @param req
     */
    @RequestMapping(value = "/deleteImg")
    public void deleteImg(MultipartHttpServletRequest req){
        MultipartFile picFile = req.getFile("file");
        String originalFilename = picFile.getOriginalFilename();
        System.out.println(originalFilename+"======5555555");
        File file = new File("G:\\tomcat临时图片服务器\\"+originalFilename);
        System.out.println(originalFilename);
        file.delete();
    }

    /**
     * 添加文章
     * @param request
     * @param response
     * @param multipartrequest
     * @throws IOException
     */
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    @ResponseBody
    public MyResponseJson addArticle(HttpServletRequest request,HttpServletResponse response,MultipartHttpServletRequest multipartrequest) throws IOException {
//        System.out.println("这是一次测试");
        String article_title = request.getParameter("article_title");
        String article_describe = request.getParameter("article_describe");
        String article_content = request.getParameter("article_content");
        String keyword = request.getParameter("keyword");
        int category = Integer.parseInt(request.getParameter("category"));
        String tags = request.getParameter("tags");
        String pubdate = request.getParameter("pubdate");
        String imgurl = "";
//
//        System.out.println("1:"+article_title+"; 2:"+article_describe+"; 3:"+article_content+"; 4:"+keyword+"; 5:"
//                +category+"; 6:"+tags+"; 7:"+pubdate);
        //标题图片处理
        MultipartFile titleImg = multipartrequest.getFile("img_inp");
        if(titleImg != null && titleImg.getOriginalFilename() != null && titleImg.getOriginalFilename().length()>0){
           //图片上传路径
            String filePath = "G:\\tomcat临时图片服务器\\";
            //图片原有名称
            String originalFilename = titleImg.getOriginalFilename();
            //图片新名称
            String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新文件
            File file = new File(filePath + newFilename);
            titleImg.transferTo(file);
            System.out.println("图片上传成功");
            imgurl = "http://localhost:8080/picupload/"+newFilename;
        }

        ArticlesheetWithBLOBs articlesheetWithBLOBs = new ArticlesheetWithBLOBs();
        articlesheetWithBLOBs.setArticleid(String.valueOf(UUID.randomUUID()));
        articlesheetWithBLOBs.setArticleContent(article_content);
        articlesheetWithBLOBs.setArticleTitle(article_title);
        articlesheetWithBLOBs.setArticleDescribe(article_describe);
        articlesheetWithBLOBs.setCategory(category);
        articlesheetWithBLOBs.setKeyword(keyword);
        articlesheetWithBLOBs.setPubdate(pubdate);
        articlesheetWithBLOBs.setTitleImgurl(imgurl);
        articlesheetWithBLOBs.setTags(tags);

        try {
            boolean flag = adminService.addArticle(articlesheetWithBLOBs);
            if (flag){
                return new MyResponseJson(1,"发布文章成功",null);
            }else{
                return new MyResponseJson(0,"发布文章失败",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResponseJson(0,"服务器出错，请等待维护",null);
        }


    }

    @RequestMapping(value = "/getCategory",method = RequestMethod.POST)
    @ResponseBody
    public MyResponseJson getCategory(){

        try {
            List<Categorysheet> list = adminService.getCategory();
            if(list != null){
                return new MyResponseJson(1,"类别获取成功",list);
            }else{
                return new MyResponseJson(2,"暂无分类",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResponseJson(0,"服务器出错",null);

        }

    }

}
