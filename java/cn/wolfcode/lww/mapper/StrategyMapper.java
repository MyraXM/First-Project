package cn.wolfcode.lww.mapper;

import cn.wolfcode.lww.domain.Strategy;
import cn.wolfcode.lww.domain.Strategy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StrategyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Strategy record);

    Strategy selectByPrimaryKey(String id);

    List<Strategy> selectAll(@Param("classify") String classify);   // mapper 里面的classify

    int updateByPrimaryKey(Strategy record);

    void updateWatchById(String id);
}