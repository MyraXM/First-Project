package cn.wolfcode.lww.controller;

import cn.wolfcode.lww.domain.Comment;
import cn.wolfcode.lww.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/insertComment")
    public String insertComment(Comment comment){
        commentService.insert(comment);
        if (comment.getType() == 0){
            return "redirect:/selectByPrimaryKey?id="+comment.getArtId();
        }else {
            return "redirect:/selectTravelByPrimaryKey?id="+comment.getArtId();
        }
    }

}
