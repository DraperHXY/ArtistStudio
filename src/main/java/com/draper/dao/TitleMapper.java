package com.draper.dao;

import com.draper.entity.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleMapper {

    void insertTitle(Title title);

    void updateTitleValue(@Param("id") long id, @Param("key")String key,@Param("value") Object value);

    List<Title> selectTitleList();


}
