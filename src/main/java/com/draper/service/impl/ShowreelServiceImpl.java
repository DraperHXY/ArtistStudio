package com.draper.service.impl;

import com.draper.dao.ProductionMapper;
import com.draper.dao.ShowreelMapper;
import com.draper.entity.Production;
import com.draper.entity.Showreel;
import com.draper.service.ShowreelService;
import com.draper.service.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShowreelServiceImpl implements ShowreelService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShowreelMapper showreelMapper;

    @Autowired
    private ProductionMapper productionMapper;

    @Override
    public void insertShowreel(Showreel showreel) {
        showreel.setCreateAt(TimeUtil.getNowTimeAsLong());
        showreelMapper.insertShowreel(showreel);
    }

    @Override
    public void deleteShowreel(long id) {
        showreelMapper.deleteShowreel(id);
    }

    @Override
    public void deleteShowreel(String name, long productionId) {
        long id = showreelMapper.getShowreelId(name, productionId);
        showreelMapper.deleteShowreel(id);
    }

    @Override
    public void setUpShow(String name) {
        // 将作品集 name 的全部作品上架
        showreelMapper.setUpShow(name);

        // 找出作品集 name 有哪些作品
        List<Showreel> showreelList = showreelMapper.selectShowreelListByName(name);

        // 将作品的 id 专门拿出来去分别上架
        for (Showreel showreel : showreelList) {
            productionMapper.setUpShow(showreel.getProductionId());
        }


    }

    @Override
    public void setDownShow(String name) {
        // 将作品集 name 的全部作品下架
        showreelMapper.setDownShow(name);

        // 找出作品集 name 有哪些作品
        List<Showreel> showreelList = showreelMapper.selectShowreelListByName(name);

        // 将作品的 id 专门拿出来去分别上架
        for (Showreel showreel : showreelList) {
            productionMapper.setDownShow(showreel.getProductionId());
        }
    }

    @Override
    public long getShowreelId(String name, long productionId) {
        return showreelMapper.getShowreelId(name, productionId);
    }

    @Override
    public List<Production> searchByKey(String key) {
        // 给 longs 去重
        List<Long> longs = showreelMapper.searchByKey("%" + key + "%");
        Set longsSet = new HashSet(longs);
        longs.clear();
        longs.addAll(longsSet);

        List<Production> productionList = new ArrayList<>();
        for (Long aLong : longs) {
            productionList.add(productionMapper.selectProductionById(aLong));
        }
        return productionList;
    }
}
