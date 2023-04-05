package cn.wolfcode.lww.mapper;

import cn.wolfcode.lww.domain.Travelnotes;
import cn.wolfcode.lww.domain.Travelnotes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelnotesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Travelnotes record);

    Travelnotes selectByPrimaryKey(String id);



    int updateByPrimaryKey(Travelnotes record);


    List<Travelnotes> selectAll();
    void updateWatchById(String id);
}