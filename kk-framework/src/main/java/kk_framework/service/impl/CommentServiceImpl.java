package kk_framework.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kk_framework.entity.Comment;
import kk_framework.entity.User;
import kk_framework.enums.AppHttpCodeEnum;
import kk_framework.exception.SystemException;
import kk_framework.mapper.CommentMapper;
import kk_framework.response.ResponseResult;
import kk_framework.response.utils.BeanCopyUtils;
import kk_framework.service.CommentService;
import kk_framework.service.UserService;
import kk_framework.vo.CommentVo;
import kk_framework.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2023-11-22 16:20:13
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper,Comment> implements CommentService  {

    @Autowired
    private UserService userService;
    @Override
    public ResponseResult commentList(Long articleId, int pageNum, int pageSize) {
        LambdaQueryWrapper<Comment>queryWrapper=new LambdaQueryWrapper<>();

        //判断articleId
        queryWrapper.eq(Comment::getArticleId,articleId);

        //判断是否为根评论
        queryWrapper.eq(Comment::getRootId,-1);

        //分页查询
        Page<Comment> page=new Page(pageNum,pageSize);

        page(page,queryWrapper);

        List<CommentVo> commentVoList=toCommentVoList(page.getRecords());

        getChildrenById(commentVoList);
        return ResponseResult.okResult(commentVoList);
    }

    @Override
    public void addComment(Comment comment) {
        if(!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        save(comment);
        return ;
    }

    private List<CommentVo> toCommentVoList(List<Comment> list){

        List<CommentVo>voList= BeanCopyUtils.copyBeanList(list,CommentVo.class);

        for (CommentVo comment : voList) {

            Long id=comment.getId();

            //通过createbyid，找到评论者
            Long createId = comment.getCreateBy();
            User user = userService.getById(createId);
            if(user!=null)
                comment.setUsername(user.getNickName());
            User touser=userService.getById(comment.getToCommentId());
            if(comment.getToCommentId()!=-1&&touser!=null){
                comment.setToCommentUserName(touser.getUserName());
            }
        }
        return voList;
    }

    private List<CommentVo> getChildrenById(List<CommentVo> list) {
        LambdaQueryWrapper<Comment>queryWrapper=new LambdaQueryWrapper<>();
        for (CommentVo commentVo : list) {
            Long id=commentVo.getId();
            queryWrapper.eq(Comment::getToCommentId,id);
            List<Comment>children=list(queryWrapper);
            List<CommentVo>childrenVo=null;
            if(!children.isEmpty()){
                childrenVo = toCommentVoList(children);
                getChildrenById(childrenVo);
            }
            commentVo.setChildren(childrenVo);
        }
        return list;
    }
}
