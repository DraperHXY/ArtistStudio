package com.draper.dao;

import com.draper.BaseTest;
import com.draper.service.util.TimeUtil;
import com.draper.entity.Showreel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShowreelMapperTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShowreelMapper showreelMapper;

    @Test
    public void testInsertShowreel() throws Exception {
        Showreel showreel = new Showreel();
        showreel.setCreateAt(TimeUtil.getNowTimeAsLong());
        showreel.setName("我是作品集名");
        showreel.setState(1);
        showreel.setEditorId(3);
        showreel.setProductionId(1);

        showreelMapper.insertShowreel(showreel);
    }

    @Test
    public void testDeleteShowreel() throws Exception {
        showreelMapper.deleteShowreel(1);
    }

    @Test
    public void testSetUpShow() throws Exception {
        showreelMapper.setUpShow("我是作品集名");
    }

    @Test
    public void testSetDownShow() throws Exception {
        showreelMapper.setDownShow("我是作品集名");
    }

    @Test
    public void testSelectShowreelListByName() throws Exception {
        List<Showreel> showreelList = showreelMapper.selectShowreelListByName("我是作品集名");
        for (int i = 0; i < showreelList.size(); i++) {
            logger.warn("showreel productionId = {}", showreelList.get(i).getProductionId());
        }
    }

    @Test
    public void testUpdateShowreelValue() throws Exception {
        showreelMapper.updateShowreelValue(4, "state", 0);
    }

    @Test
    public void testGetShowreelId() throws Exception {
        logger.warn("id = {}", showreelMapper.getShowreelId("我是作品集名", 1));
    }
}
