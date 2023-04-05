package cn.wolfcode.lww.service.impl;

import cn.wolfcode.lww.domain.Strategy;
import cn.wolfcode.lww.mapper.StrategyMapper;
import cn.wolfcode.lww.service.StrategyService;
import cn.wolfcode.lww.util.QueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    StrategyMapper strategyMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return strategyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Strategy record) {
        //生成写攻略的时间
        Date date = new Date();
        //统一格式化时间
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        String dateTime = simpleDateFormat.format(date).toString();
        record.setWriteTime(dateTime);

        return strategyMapper.insert(record);
    }

    @Override
    public Strategy selectByPrimaryKey(String id) {
        return strategyMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Strategy> selectAll(QueryObject queryObject,String classify) {  //引入类
        //告诉插件  第几页 每页显示多少条数据
        PageHelper.startPage(queryObject.getCurrentPage(),queryObject.getPageSize());
        List<Strategy> strategies = strategyMapper.selectAll(classify);
        return new PageInfo<Strategy>(strategies);
    }




    @Override
    public int updateByPrimaryKey(Strategy record) {
        //生成修改攻略的时间
        Date date = new Date();
        //统一格式化时间
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        String dateTime = simpleDateFormat.format(date).toString();
        record.setWriteTime(dateTime);

        //调用mapper
        return strategyMapper.updateByPrimaryKey(record);
    }

    @Override
    public void updateWatchById(String id) {
        strategyMapper.updateWatchById(id);
    }


}
