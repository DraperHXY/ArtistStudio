package com.draper.dao;

import com.draper.entity.Production;
import org.apache.ibatis.annotations.Param;

public interface ProductionMapper {

    void insertProduction(Production production);

    Production selectProductionById(long id);

    void updateProductionValueByKey(@Param("key") String key,@Param("value") Object value, @Param("id") long id);

    void deleteProductionById(long id);

}
