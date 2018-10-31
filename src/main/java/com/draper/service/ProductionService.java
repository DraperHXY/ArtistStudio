package com.draper.service;

import com.draper.entity.Production;

import java.util.List;

public interface ProductionService {

    void insertProduction(Production production);

    Production selectProductionById(long id);

    /**
     * 更新产品简介
     * @param id 数据库唯一标识
     * @param intro 产品简介
     */
    void updateProductionIntro(long id, String intro);

    void deleteProductionById(long id);

    void setUpShow(long id);

    void setDownShow(long id);

    void setUpBanner(long id);

    void setDownBanner(long id);

    List<Production> selectAllProduction();

    List<Production> selectBannerProduction();

    List<Production> selectArtistProduction(long artistId);


}
