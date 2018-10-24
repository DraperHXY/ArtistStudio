package com.draper.service;

import com.draper.entity.Artist;

public interface ArtistService {

    void insertArtist(Artist artist);

    Artist selectArtist(String email);

    void updateAddress(String email, String address);

    void updateEmail(String oldEmail, String newEmail);

    void updatePhoneNumber(String email, String phoneNumber);

    void updateCareer(String email, String career);

    void updateImgUrl(String email, String imgUrl);

    void deleteArtistByEmail(String email);

}
