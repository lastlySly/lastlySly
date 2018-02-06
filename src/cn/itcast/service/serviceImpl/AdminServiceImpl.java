package cn.itcast.service.serviceImpl;

import cn.itcast.mapper.AdminsheetMapper;
import cn.itcast.mapper.ArticlesheetMapper;
import cn.itcast.mapper.CategorysheetMapper;
import cn.itcast.po.Adminsheet;
import cn.itcast.po.AdminsheetExample;
import cn.itcast.po.ArticlesheetWithBLOBs;
import cn.itcast.po.Categorysheet;
import cn.itcast.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminsheetMapper adminsheetMapper;

    @Autowired
    private ArticlesheetMapper articlesheetMapper;

    @Autowired
    private CategorysheetMapper categorysheetMapper;
    /**
     *
     * @param username 用户账号
     * @param password 用户密码
     * @return
     */
    @Override
    public Adminsheet findAdministrators(String username,String password) throws Exception {
        AdminsheetExample adminsheetExample = new AdminsheetExample();
        AdminsheetExample.Criteria criteria = adminsheetExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<Adminsheet> list = adminsheetMapper.selectByExample(adminsheetExample);
        Adminsheet adminsheet = null;
        if(list.size() >0){
            adminsheet = list.get(0);
        }
        return adminsheet;
    }

    @Override
    public boolean addArticle(ArticlesheetWithBLOBs article) throws Exception {
        int row = articlesheetMapper.insertSelective(article);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Categorysheet> getCategory() throws Exception {

        List<Categorysheet> list = categorysheetMapper.selectByExample(null);
        if(list != null){
            return list;
        }
        return null;
    }
}
