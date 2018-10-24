package com.draper.dao;

import com.draper.entity.Showreel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowreelMapper {

    void insertShowreel(Showreel showreel);

    void deleteShowreel(long id);

    void setUpShow(String name);

    void setUpShowProduction(long productionId);

    void setDownShow(String name);

    void setDownShowProduction(long productionId);

    List<Showreel> selectShowreelListByName(String name);

    void updateShowreelValue(@Param("id") long id, @Param("key") String key, @Param("value") Object value);

    long getShowreelId(@Param("name") String name, @Param("productionId") long productionId);

    /**
     * 模糊匹配查询
     *
     * @param key 搜索关键字
     * @return productionId
     */
    List<Long> searchByKey(String key);
}