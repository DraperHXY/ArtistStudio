package com.draper.service.impl;

import com.draper.dao.TitleMapper;
import com.draper.entity.Title;
import com.draper.service.TitleService;
import com.draper.service.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    public TitleMapper titleMapper;

    @Override
    public void insertTitle(Title title) {
        title.setCreateAt(TimeUtil.getNowTimeAsLong());
        titleMapper.insertTitle(title);
    }

    @Override
    public void updateTitleName(String oldName, String newName) {
        titleMapper.updateTitleValue("name", oldName, "name", newName);
    }

    @Override
    public void updateTitleUrl(String name, String url) {
        titleMapper.updateTitleValue("name", name, "url", url);
    }

    @Override
    public void updateTitleLevel(String name, int level) {
        titleMapper.updateTitleValue("name", name, "level", level);
    }

    @Override
    public List<Title> getTitleList() {
        return titleMapper.selectTitleList();
    }
}
