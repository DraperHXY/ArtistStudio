package com.draper.service.impl;

import com.draper.dao.ProductionMapper;
import com.draper.entity.Production;
import com.draper.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionMapper productionMapper;

    @Override
    public void insertProduction(Production production) {
        productionMapper.insertProduction(production);
    }

    @Override
    public Production selectProductionById(long id) {
        return productionMapper.selectProductionById(id);
    }

    @Override
    public void updateProductionIntro(long id, String intro) {
        productionMapper.updateProductionValueByKey("intro", intro, id);
    }

    @Override
    public void deleteProductionById(long id) {
        productionMapper.deleteProductionById(id);
    }

    @Override
    public void setUpShow(long id) {
        productionMapper.updateProductionValueByKey("state", 1, id);
    }

    @Override
    public void setDownShow(long id) {
        productionMapper.updateProductionValueByKey("state", 0, id);
    }

    @Override
    public void setUpBanner(long id) {
        productionMapper.updateProductionValueByKey("banner", 1, id);
    }

    @Override
    public void setDownBanner(long id) {
        productionMapper.updateProductionValueByKey("banner", 0, id);
    }

    @Override
    public List<Production> selectAllProduction() {
        return productionMapper.selectAllProduction();
    }

    @Override
    public List<Production> selectBannerProduction() {
        return productionMapper.selectProductionListByKeyValue("banner", 1);
    }

    @Override
    public List<Production> selectArtistProduction(long artistId) {
        return productionMapper.selectProductionListByKeyValue("artist", artistId);
    }
}
