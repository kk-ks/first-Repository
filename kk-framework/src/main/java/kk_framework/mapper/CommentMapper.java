package kk_framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kk_framework.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论表(Comment)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-22 16:12:17
 */
public interface CommentMapper extends BaseMapper<Comment> {

}

