package cn.wolfcode.lww.service;

import cn.wolfcode.lww.domain.Strategy;
import cn.wolfcode.lww.util.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StrategyService {
    int deleteByPrimaryKey(String id);

    int insert(Strategy record);

    Strategy selectByPrimaryKey(String id);
        // List<Strategy> selectAll();
    PageInfo<Strategy> selectAll(QueryObject queryObject,String classify);


    int updateByPrimaryKey(Strategy record);

    void updateWatchById(String id);


}
