package kk_framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kk_framework.entity.Article;
import kk_framework.response.ResponseResult;
import org.springframework.stereotype.Service;


public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
