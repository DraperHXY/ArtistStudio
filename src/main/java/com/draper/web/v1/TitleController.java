package com.draper.web.v1;

import com.draper.entity.Title;
import com.draper.service.TitleService;
import com.draper.web.ResponseTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1")
public class TitleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TitleService titleService;

    @Autowired
    private ResponseTo responseTo;

    @ResponseBody
    @RequestMapping(value = "/title", method = RequestMethod.POST)
    public Map insertTitle(@RequestBody Title title) {
        String msg = "success";
        try {
            titleService.insertTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/title/name", method = RequestMethod.PUT)
    public Map updateTitleName(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            titleService.updateTitleName((String) map.get("oldName"), (String) map.get("newName"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/title/url", method = RequestMethod.PUT)
    public Map updateTitleUrl(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            titleService.updateTitleUrl((String) map.get("name"), (String) map.get("url"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/title/level", method = RequestMethod.PUT)
    public Map updateTitleLevel(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            titleService.updateTitleLevel((String) map.get("name"), (int) map.get("level"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/title/list/all", method = RequestMethod.GET)
    public Map getTitleList() {
        List<Title> titleList = null;
        try {
            titleList = titleService.getTitleList();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (titleList.size() == 0){
                return responseTo.msg("failed");
            } else {
                return responseTo.msg("success", titleList);
            }
        }
    }
}
