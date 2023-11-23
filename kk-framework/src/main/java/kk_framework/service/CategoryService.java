package kk_framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kk_framework.entity.Category;
import kk_framework.response.ResponseResult;


/**
 * ?????(Category)表服务接口
 *
 * @author makejava
 * @since 2023-07-30 14:18:04
 */
public interface CategoryService extends IService<Category> {
    ResponseResult getCategory();

    ResponseResult getCategoryList();
}


