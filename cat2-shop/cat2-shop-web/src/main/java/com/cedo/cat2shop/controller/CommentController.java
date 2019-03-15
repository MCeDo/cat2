package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.model.Comment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chendong
 * @date 19-3-13 下午9:06
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController<Comment> {
}
