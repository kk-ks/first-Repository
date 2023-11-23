package com.kk.controller;


import kk_framework.entity.Comment;
import kk_framework.response.ResponseResult;
import kk_framework.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("comment")
public class CommentController {

    //TODO: 11.21号写,22号完成
    @Autowired
    private CommentService commentService;

    @GetMapping("commentList")
    public ResponseResult commentList(Long articleId,int pageNum,int pageSize){

        return commentService.commentList(articleId,pageNum,pageSize);
    }

    //TODO: 发送评论，11.23号上午
    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return ResponseResult.okResult();
    }
}
