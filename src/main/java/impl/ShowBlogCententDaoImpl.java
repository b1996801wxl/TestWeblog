package impl;

import dao.ShowBlogCententDao;
import entity.BlogContentQuery;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class ShowBlogCententDaoImpl extends BaseDao<BlogContentQuery> implements ShowBlogCententDao {
    @Override
    public List<BlogContentQuery> ShowContent(BigDecimal pagenum, BigDecimal num) {
        return executeQuery("SELECT USER_INFO.USER_NAME, USER_INFO.HEAD_IMG,BLOG_CONTENT.* FROM USER_INFO,BLOG_CONTENT WHERE BLOG_CONTENT.USER_ID = USER_INFO.USER_ID ORDER BY BLOG_CONTENT.BLOG_ID DESC LIMIT ?,?",new Object[]{pagenum.multiply(num),(pagenum.subtract(new BigDecimal(1))).multiply(num)});
    }

}
