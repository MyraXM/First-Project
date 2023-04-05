package cn.wolfcode.lww.service.impl;

import cn.wolfcode.lww.domain.Travelnotes;
import cn.wolfcode.lww.mapper.TravelnotesMapper;
import cn.wolfcode.lww.service.TravelnotesService;
import cn.wolfcode.lww.util.QueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class TravelnotesServiceImpl implements TravelnotesService {
    @Autowired
    TravelnotesMapper travelnotesMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return travelnotesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Travelnotes record) {
        //生成写游记的时间
        Date date = new Date();
        //统一格式化时间
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        String dateTime = simpleDateFormat.format(date).toString();
        record.setWriteTime(dateTime);
        return travelnotesMapper.insert(record);
    }

    @Override
    public Travelnotes selectByPrimaryKey(String id) {
        return travelnotesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateWatchById(String id) {
        travelnotesMapper.updateWatchById(id);
    }

    @Override
    public PageInfo<Travelnotes> selectAll(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(),queryObject.getPageSize());
        List<Travelnotes> travelnotes = travelnotesMapper.selectAll();
        return new PageInfo<Travelnotes>(travelnotes);
    }




    @Override
    public int updateByPrimaryKey(Travelnotes record) {
        //生成修改攻略的时间
        Date date = new Date();
        //统一格式化时间
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        String dateTime = simpleDateFormat.format(date).toString();
        record.setWriteTime(dateTime);

        //调用mapper
        return travelnotesMapper.updateByPrimaryKey(record);
    }




}
