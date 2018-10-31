package com.draper.web.v1;

import com.draper.entity.Production;
import com.draper.entity.Showreel;
import com.draper.service.ShowreelService;
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
public class ShowreelController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShowreelService showreelService;

    @Autowired
    private ResponseTo responseTo;

    @ResponseBody
    @RequestMapping(value = "/showreel", method = RequestMethod.POST)
    public Map insertShowreel(@RequestBody Showreel showreel) {
        String msg = "success";
        try {
            showreelService.insertShowreel(showreel);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showreel", method = RequestMethod.DELETE)
    public Map deleteShowreel(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            String name = (String) map.get("name");
            long productionId = Long.valueOf((int) map.get("productionId"));
            showreelService.deleteShowreel(name, productionId);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showreel/up", method = RequestMethod.PUT)
    public Map setUpShow(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            showreelService.setUpShow((String) map.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showreel/down", method = RequestMethod.PUT)
    public Map setDownShow(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            showreelService.setDownShow((String) map.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showreel/id", method = RequestMethod.POST)
    public Map getShowreelId(@RequestBody Map<String, Object> map) {
        String msg = "success";
        long id = 0;
        try {
            String name = (String) map.get("name");
            long productionId = Long.valueOf((int) map.get("productionId"));
            id = showreelService.getShowreelId(name, productionId);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            if ("success".equals(msg)) {
                return responseTo.msg(msg, id);
            } else {
                return responseTo.msg(msg);
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showreel/search", method = RequestMethod.POST)
    public Map searchByKey(@RequestBody Map<String, Object> map) {
        String msg = "success";
        List<Production> productionList = null;
        try {
            productionList = showreelService.searchByKey((String) map.get("key"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            if (productionList == null) {
                return responseTo.msg(msg);
            } else {
                return responseTo.msg(msg, productionList);
            }
        }
    }

}
