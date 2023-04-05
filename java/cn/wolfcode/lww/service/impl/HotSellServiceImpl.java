package cn.wolfcode.lww.service.impl;

import cn.wolfcode.lww.domain.Hotsell;
import cn.wolfcode.lww.mapper.HotsellMapper;
import cn.wolfcode.lww.service.HotSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotSellServiceImpl implements HotSellService {
    @Autowired
    HotsellMapper hotsellMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Hotsell record) {
        return 0;
    }

    @Override
    public Hotsell selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Hotsell> selectAll() {
        return hotsellMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Hotsell record) {
        return 0;
    }
}
