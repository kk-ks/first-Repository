package kk_framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kk_framework.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ?????(Category)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-30 14:18:05
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {


}


