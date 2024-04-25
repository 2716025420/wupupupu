package com.home.wupupupu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.home.wupupupu.mapper.ArticleMapper;
import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.pojo.PageBean;
import com.home.wupupupu.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public void addArticle(Article article) {
        article.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        article.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        Map<String,Object> map = ThreadLocalUtil.get();
        int userId=(int) map.get("id");
        article.setCreateUser(userId);
        articleMapper.addArticle(article);
    }

    @Override
    public PageBean list(Integer pageNum, Integer pageSize, String categoryId, String state) {
        PageBean<Article> pageBean=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        Map<String,Object>map = ThreadLocalUtil.get();
        int userId=(int) map.get("id");
        List<Article> articleList= articleMapper.list(categoryId,state,userId);
        Page<Article> articlePage=(Page<Article>) articleList;
        pageBean.setTotal(articlePage.getTotal());
        pageBean.setItems(articlePage.getResult());
        return pageBean;
    }

    @Override
    public void updateArticle(Article article) {
        article.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        articleMapper.updateArticle(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);
    }
}
