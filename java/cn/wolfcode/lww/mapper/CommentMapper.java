package cn.wolfcode.lww.mapper;

import cn.wolfcode.lww.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    List<Comment> queryComment(@Param("artId") String artId, @Param("type") Integer type);

    int deleteByArtId(String id);
}