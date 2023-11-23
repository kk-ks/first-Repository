package  kk_framework.mapper;
 

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import kk_framework.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
 
/**
 * @Author makejava  
 * @Desc ????(Link)表数据库访问层
 * @Date 2023-07-30 22:31:06
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}
