package com.draper.dao;

import com.draper.BaseTest;
import com.draper.service.util.TimeUtil;
import com.draper.entity.Production;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductionMapperTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Autowired
    private ProductionMapper productionMapper;

    @Test
    public void testInsertProduction() {
        Production p = new Production();
        p.setCreateAt(TimeUtil.getNowTimeAsLong());
        p.setArtistId(2);
        p.setIntro("我是简介22");
        p.setState(1);
        p.setEditorId(1);
        p.setThumbnailUrl("我是缩略图2 URL");
        p.setVideoUrl("我是录像 URL");
        p.setArticle("我是正文文章");
        productionMapper.insertProduction(p);
    }

    @Test
    public void testSelectProductionById() {
        Production p = productionMapper.selectProductionById(1);
        logger.warn("production id = {}", p.getId());
        logger.warn("production createAt = {}", p.getCreateAt());
        logger.warn("production artistId = {}", p.getArtistId());
        logger.warn("production state = {}", p.getState());
        logger.warn("production intro = {}", p.getIntro());
        logger.warn("production editorId = {}", p.getEditorId());
        logger.warn("production thumbnailUrl = {}", p.getThumbnailUrl());
        logger.warn("production videoUrl = {}", p.getVideoUrl());
        logger.warn("production article = {}", p.getArticle());
    }

    @Test
    public void testUpdateProductionValueByKey() {
        productionMapper.updateProductionValueByKey("intro", "我是改变后的简介", 1);
        Production p = productionMapper.selectProductionById(1);
        logger.warn("production id = {}", p.getId());
        logger.warn("production createAt = {}", p.getCreateAt());
        logger.warn("production artistId = {}", p.getArtistId());
        logger.warn("production state = {}", p.getState());
        logger.warn("production intro = {}", p.getIntro());
        logger.warn("production editorId = {}", p.getEditorId());
        logger.warn("production thumbnailUrl = {}", p.getThumbnailUrl());
        logger.warn("production videoUrl = {}", p.getVideoUrl());
        logger.warn("production article = {}", p.getArticle());
    }

    @Test
    public void testDeleteProductionById() {
        productionMapper.deleteProductionById(1);
    }

    @Test
    public void testSetUpShow() {
        productionMapper.setUpShow(1);
    }

    @Test
    public void testSetDownShow() {
        productionMapper.setDownShow(1);
    }

    @Test
    public void testSelectAllProduction() throws Exception {
        List<Production> productionList = productionMapper.selectAllProduction();
        for (int i = 0; i < productionList.size(); i++) {
            logger.warn("intro = {}", productionList.get(i).getIntro());
        }
    }

    @Test
    public void testSelectBannerProduction() {
        List<Production> productionList = productionMapper.selectBannerProduction();
        for (int i = 0; i < productionList.size(); i++) {
            logger.warn("intro = {}", productionList.get(i).getIntro());
        }
    }

    @Test
    public void testSetUpBanner() throws Exception {
        productionMapper.setUpBanner(1);
    }

    @Test
    public void testSetDownBanner() throws Exception {
        productionMapper.setDownBanner(1);
    }

    @Test
    public void testSelectProductionListByKeyValue() throws Exception {
        List<Production> productionList = productionMapper.selectProductionListByKeyValue("state", 0);
        for (int i = 0; i < productionList.size(); i++) {
            logger.warn("production article = {}", productionList.get(i).getArticle());
        }
    }
}
