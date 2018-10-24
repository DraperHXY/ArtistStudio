package com.draper.web;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetProperties() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("msg.properties"));
        String str = (String) properties.get("failed");
        logger.warn("get str = {}", str);
    }
}
