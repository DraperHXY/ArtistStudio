package com.draper.service;

import com.draper.entity.Showreel;

public interface ShowreelService {

    void insertShowreel(Showreel showreel);

    void deleteShowreel(long id);

    void delteShowreel(String name, long productionId);

    void setUpShow(String name);

    void setDownShow(String name);

    long getShowreelId(String name, long id);
}
