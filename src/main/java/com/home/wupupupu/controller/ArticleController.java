package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.pojo.PageBean;
import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.service.ArticleService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
//@CrossOrigin

public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("addArticle")
    public Result addArticle(@RequestBody @Validated(Article.add.class) Article article){
        articleService.addArticle(article);
        return Result.success();
    }
    @GetMapping("list")
    public Result<PageBean<Article>> list(Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) String categoryId,
                                          @RequestParam(required = false) String state){

        PageBean pageBean=articleService.list(pageNum,pageSize,categoryId,state);

        return Result.success(pageBean);
    }
    @PutMapping("updateArticle")
    public Result updateArticle(@RequestBody@Validated(Article.update.class) Article article){
        articleService.updateArticle(article);
        return Result.success();
    }
    @DeleteMapping("deleteArticle")
    public Result deleteArticle(Integer id){
        articleService.deleteArticle(id);
        return Result.success();
    }

}
