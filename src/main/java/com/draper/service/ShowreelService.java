package com.draper.service;

import com.draper.entity.Production;
import com.draper.entity.Showreel;

import java.util.List;

public interface ShowreelService {

    void insertShowreel(Showreel showreel);

    /**
     * Spring MVC 不支持重载，故放弃
     *
     * @param id
     * @deprecated
     */
    void deleteShowreel(long id);

    void deleteShowreel(String name, long productionId);

    void setUpShow(String name);

    void setDownShow(String name);

    long getShowreelId(String name, long productionId);

    List<Production> searchByKey(String key);
}
