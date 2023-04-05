package cn.wolfcode.lww.service.impl;

import cn.wolfcode.lww.domain.Comment;
import cn.wolfcode.lww.mapper.CommentMapper;
import cn.wolfcode.lww.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Comment record) {
        //生成时间
        Date date = new Date();
        //统一格式化时间
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        String dateTime = simpleDateFormat.format(date).toString();
        // 时间设置在评论里面
        record.setTime(dateTime);
        //调用mapper层
        return commentMapper.insert(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return 0;
    }

    @Override
    public List<Comment> queryComment(String artId, Integer type) {
        return commentMapper.queryComment(artId,type);
    }

    @Override
    public int deleteByArtId(String id) {
        return commentMapper.deleteByArtId(id);
    }


}
