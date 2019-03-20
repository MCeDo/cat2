package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.model.Comment;
import com.cedo.cat2shop.service.CommentService;
import com.cedo.common.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chendong
 * @date 19-3-13 下午9:06
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public HttpResult list(@RequestParam(defaultValue = "0") Integer current, @RequestParam(defaultValue = "10") Integer size) {
        return commentService.list(current, size);
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @PostMapping
    public HttpResult add(@RequestBody Comment comment) {
        return commentService.add(comment);
    }

    @PutMapping
    public HttpResult update(@RequestBody Comment comment) {
        return commentService.update(comment);
    }
}
