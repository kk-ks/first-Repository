package kk_framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import kk_framework.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ?û??(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-06 19:54:07
 */
@Mapper
//@Repository(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {

}


