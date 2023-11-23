package kk_framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

//import com.sun.org.apache.bcel.internal.generic.NEW;
import kk_framework.constants.SystemConstants;
import kk_framework.entity.Article;
import kk_framework.mapper.CategoryMapper;
import kk_framework.response.ResponseResult;
import kk_framework.service.ArticleService;
import kk_framework.service.CategoryService;
import kk_framework.response.utils.BeanCopyUtils;
import kk_framework.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kk_framework.entity.Category;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ?????(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-07-30 14:18:05
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ResponseResult getCategory() {
        LambdaQueryWrapper<Category> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getStatus, SystemConstants.Category_STATUS_NORMAL);
        List<Category> categories = categoryMapper.selectList(queryWrapper);
        List<CategoryVO> categoryVOS = BeanCopyUtils.copyBeanList(categories, CategoryVO.class);
        return ResponseResult.okResult(categoryVOS);
    }
    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Article>articleWrapper=new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        Set<Long> collect = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());

        List<Category> categories = listByIds(collect);
        List<Category> categories1 = categories.stream()
                .filter(category -> SystemConstants.Category_STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
        List<CategoryVO> categoryVOS = BeanCopyUtils.copyBeanList(categories1, CategoryVO.class);
        return ResponseResult.okResult(categoryVOS);
    }
}


