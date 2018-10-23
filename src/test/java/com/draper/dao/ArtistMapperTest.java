package com.draper.dao;

import com.draper.BaseTest;
import com.draper.service.util.TimeUtil;
import com.draper.entity.Artist;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ArtistMapperTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArtistMapper artistMapper;

    @Test
    public void testInsertArtist() throws Exception {
        Artist artist = new Artist();
        artist.setCreateAt(TimeUtil.getNowTimeAsLong());
        artist.setEmail("我是邮箱");
        artist.setName("我是姓名");
        artist.setPhoneNumber("我是电话");
        artist.setAddress("我是地址");
        artist.setCareer("我是轨迹");
        artist.setImgUrl("我是 imgUrl");

        artistMapper.insertArtist(artist);
    }

    @Test
    public void testSelectArtistById(){
        Artist artist = artistMapper.selectArtistById(1);
        logger.warn("artist email = {}", artist.getEmail());
    }

    @Test
    public void testUpdateValueByKey(){
        artistMapper.updateArtistValueByKey(1, "email", "我是另外一个 email");
    }

    @Test
    public void testDeleteById(){
        artistMapper.deleteArtistById(1);
    }

    @Test
    public void testUpdateValue() throws Exception {
        artistMapper.updateArtistValue("email","我是邮箱", "name", "我是小名");
    }
}
