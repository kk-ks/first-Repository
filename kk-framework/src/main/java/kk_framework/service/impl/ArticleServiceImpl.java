package kk_framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kk_framework.constants.SystemConstants;
import kk_framework.entity.Article;
import kk_framework.entity.Category;
import kk_framework.mapper.ArticleMapper;
import kk_framework.response.ResponseResult;
import kk_framework.service.ArticleService;

import kk_framework.service.CategoryService;
import kk_framework.response.utils.BeanCopyUtils;
import kk_framework.vo.ArticleDetailVO;
import kk_framework.vo.ArticleListVO;
import kk_framework.vo.HotArticleVo;
import kk_framework.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    CategoryService categoryService;
    public ResponseResult hotArticleList(){
        //热门文章
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        queryWrapper.orderByAsc(Article::getViewCount);
        Page<Article> page=new Page(1,10);
        page(page,queryWrapper);
        List<Article> records = page.getRecords();
        List<HotArticleVo> articleVos = BeanCopyUtils.copyBeanList(records, HotArticleVo.class);
        return ResponseResult.okResult(articleVos);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        Page<Article>page=new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Article> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        lambdaQueryWrapper.orderByAsc(Article::getIsTop);
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);
        page(page,lambdaQueryWrapper);
        List<Article> records = page.getRecords();
        records.stream()
                .map(new Function<Article, Article>() {

                    @Override
                    public Article apply(Article article){
                        Category category= categoryService.getById(article.getCategoryId());
                        String name=category.getName();
                        article.setCategoryName(name);
                        return article;
                    }
                }
                );
        List<ArticleListVO> articleListVOS= BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVO.class);

        PageVO pageVO=new PageVO(articleListVOS,page.getTotal());
        return ResponseResult.okResult(pageVO);


    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        Article article = getById(id);

        ArticleDetailVO articleDetailVO = BeanCopyUtils.copyBean(article, ArticleDetailVO.class);

        Long Gid = articleDetailVO.getCategoryId();
        Category category = categoryService.getById(Gid);
        if(category!=null){
            articleDetailVO.setCategoryName(category.getName());
        }

        return ResponseResult.okResult(articleDetailVO);
    }
}
