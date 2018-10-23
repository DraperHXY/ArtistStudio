package com.draper.dao;

import com.draper.entity.Showreel;

import java.util.List;

public interface ShowreelMapper {

    void insertShowreel(Showreel showreel);

    void deleteShowreel(long id);

    void setUpShow(String name);

    void setDownShow(String name);

    List<Showreel> selectShowreelListByName(String name);

}
