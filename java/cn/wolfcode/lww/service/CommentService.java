package cn.wolfcode.lww.service;

import cn.wolfcode.lww.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    List<Comment> queryComment(String artId,Integer type);

    int deleteByArtId(String id);
}
