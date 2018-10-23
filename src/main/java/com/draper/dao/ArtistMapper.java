package com.draper.dao;

import com.draper.entity.Artist;
import org.apache.ibatis.annotations.Param;

public interface ArtistMapper {

    void insertArtist(Artist artist);

    Artist selectArtistById(long id);

    void updateArtistValueByKey(@Param("id") long id, @Param("key") String key, @Param("value") Object object);

    void deleteArtistById(long id);

}
