package com.draper.dao;

import com.draper.entity.Production;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionMapper {

    void insertProduction(Production production);

    Production selectProductionById(long id);

    void updateProductionValueByKey(@Param("key") String key,@Param("value") Object value, @Param("id") long id);

    void deleteProductionById(long id);

    //上架
    void setUpShow(long id);

    void setDownShow(long id);

    List<Production> selectAllProduction();

    List<Production> selectBannerProduction();

    void setUpBanner(long id);

    void setDownBanner(long id);
}
