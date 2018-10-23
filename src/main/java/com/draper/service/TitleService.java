package com.draper.service;

import com.draper.entity.Title;

import java.util.List;

public interface TitleService {

    void insertTitle(Title title);

    void updateTitleName(String oldName, String newName);

    void updateTitleUrl(String name, String url);

    void updateTitleLevel(String name, int level);

    List<Title> getTitleList();

}
