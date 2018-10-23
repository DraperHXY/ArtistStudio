package com.draper.dao;

import com.draper.BaseTest;
import com.draper.service.util.TimeUtil;
import com.draper.entity.Title;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TitleMapperTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Autowired
    private TitleMapper titleMapper;

    @Test
    public void testInsertTitle() {
        Title title = new Title();
        title.setCreateAt(TimeUtil.getNowTimeAsLong());
        title.setLevel(1);
        title.setName("我是标题");
        title.setUrl("我是 Url");
        title.setEditorId(1);

        titleMapper.insertTitle(title);
    }

    @Test
    public void testUpdateTitleValue() {
        titleMapper.updateTitleValue("level", 2, "url", "还好");
    }

    @Test
    public void testSelectTitleList() {
        List<Title> titles = titleMapper.selectTitleList();

        for (int i = 0; i < titles.size(); i++) {
            logger.warn("title id = {}", titles.get(i).getId());
            logger.warn("title createAt = {}", titles.get(i).getCreateAt());
            logger.warn("title name = {}", titles.get(i).getName());
            logger.warn("title level = {}", titles.get(i).getLevel());
            logger.warn("title url = {}", titles.get(i).getUrl());
        }
    }


}
