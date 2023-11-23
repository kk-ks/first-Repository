package kk_framework.service;
import com.baomidou.mybatisplus.extension.service.IService;
import kk_framework.entity.Comment;
import kk_framework.response.ResponseResult;

/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-11-22 16:20:13
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(Long articleId, int pageNum, int pageSize);

    void addComment(Comment comment);
}
