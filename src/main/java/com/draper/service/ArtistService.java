package com.draper.service;

import com.draper.entity.Artist;

public interface ArtistService {

    void insertArtist(Artist artist);

    void selectArtistByEmail(String email);

    void updateArtistValue(String queryKey, Object queryValue, String key, String value);

    void deleteArtistByEmail(String email);

}
