package com.home.wupupupu.service;

import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.pojo.PageBean;

public interface ArticleService {
    void addArticle(Article article);

    PageBean list(Integer pageNum, Integer pageSize, String categoryId, String state);

    void updateArticle(Article article);

    void deleteArticle(Integer id);
}
