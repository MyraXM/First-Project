package cn.wolfcode.lww.service;

import cn.wolfcode.lww.domain.Hotsell;

import java.util.List;

public interface HotSellService {
    int deleteByPrimaryKey(Integer id);

    int insert(Hotsell record);

    Hotsell selectByPrimaryKey(Integer id);

    List<Hotsell> selectAll();

    int updateByPrimaryKey(Hotsell record);


}
