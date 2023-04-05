package cn.wolfcode.lww.service;

import cn.wolfcode.lww.domain.Travelnotes;
import cn.wolfcode.lww.util.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TravelnotesService {
    int deleteByPrimaryKey(String id);

    int insert(Travelnotes record);

    Travelnotes selectByPrimaryKey(String id);

    void updateWatchById(String id);

    int updateByPrimaryKey(Travelnotes record);


    PageInfo<Travelnotes> selectAll(QueryObject queryObject);
}
