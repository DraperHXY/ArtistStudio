package com.draper.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

@Component
public class ResponseTo {

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));


    @Autowired
    public MessageSource messageSource;

    public Map msg(String msg)  {

        //args 作为在 properties 文件中占位符的实际值，根据 locale 划分的地区找到指定 msg 将 args 填入
        //后面的这两个参数是用来配置占位符和国际化的
        String code = messageSource.getMessage(msg, null, Locale.US);
        logger.warn("code = {}", code);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = null;
        try {
            map = objectMapper.readValue(code, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map msg(String msg, Object data)  {
        String code = messageSource.getMessage(msg, null, Locale.US);
        logger.warn("code = {}", code);

        ObjectMapper objectMapper = new ObjectMapper();
        Map map = null;
        try {
            map = objectMapper.readValue(code, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("data", data);
        return map;

    }
}
