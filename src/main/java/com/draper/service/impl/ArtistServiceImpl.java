package com.draper.service.impl;

import com.draper.dao.ArtistMapper;
import com.draper.entity.Artist;
import com.draper.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    @Override
    public void insertArtist(Artist artist) {
        artistMapper.insertArtist(artist);
    }

    @Override
    public Artist selectArtist(String email) {
        long id = artistMapper.getIdByEmail(email);
        return artistMapper.selectArtistById(id);
    }

    @Override
    public void updateAddress(String email, String address) {
        artistMapper.updateArtistValue("email", email, "address", address);
    }

    @Override
    public void updateEmail(String oldEmail, String newEmail) {
        artistMapper.updateArtistValue("email", oldEmail, "email", newEmail);
    }

    @Override
    public void updatePhoneNumber(String email, String phoneNumber) {
        artistMapper.updateArtistValue("email", email, "phone_number", phoneNumber);
    }

    @Override
    public void updateCareer(String email, String career) {
        artistMapper.updateArtistValue("email", email, "career", career);
    }

    @Override
    public void updateImgUrl(String email, String imgUrl) {
        artistMapper.updateArtistValue("email", email, "img_url", imgUrl);
    }

    @Override
    public void deleteArtistByEmail(String email) {
        long id = artistMapper.getIdByEmail(email);
        artistMapper.deleteArtistById(id);
    }
}
