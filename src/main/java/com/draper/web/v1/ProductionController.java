package com.draper.web.v1;

import com.draper.entity.Production;
import com.draper.entity.Showreel;
import com.draper.service.ProductionService;
import com.draper.service.ShowreelService;
import com.draper.web.ResponseTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("V1/ProductionController")
@RequestMapping("/v1")
public class ProductionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductionService productionService;

    @Autowired
    private ShowreelService showreelService;

    @Autowired
    private ResponseTo responseTo;

    @ResponseBody
    @RequestMapping(value = "/production", method = RequestMethod.POST)
    public Map insertProduction(@RequestBody Production production) {
        String msg = "success";
        try {
            Showreel showreel = new Showreel();
            showreel.setProductionId(production.getId());
            showreel.setEditorId(production.getEditorId());
            showreel.setState(production.getState());
            showreel.setName("默认合集");
            productionService.insertProduction(production);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production/{id}", method = RequestMethod.GET)
    public Map selectProductionById(@PathVariable int id) {
        String msg = "success";
        Production production = null;
        try {
            long productionId = Long.valueOf(id);
            production = productionService.selectProductionById(productionId);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            if (production == null) {
                return responseTo.msg(msg);
            } else {
                return responseTo.msg(msg, production);
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production/intro", method = RequestMethod.PUT)
    public Map updateProductionIntro(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            productionService.updateProductionIntro(Long.valueOf((int) map.get("id")), (String) map.get("intro"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production", method = RequestMethod.DELETE)
    public Map deleteProductionById(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            productionService.deleteProductionById(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production/up", method = RequestMethod.PUT)
    public Map setUpShow(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            productionService.setUpShow(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production/down", method = RequestMethod.PUT)
    public Map setDownShow(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            productionService.setDownShow(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production/banner/up", method = RequestMethod.PUT)
    public Map setUpBanner(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            productionService.setUpBanner(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production/banner/down", method = RequestMethod.PUT)
    public Map setDownBanner(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            productionService.setDownBanner(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/production/list/all", method = RequestMethod.GET)
    public Map sselectAllProduction() {
        logger.warn("TAG = request,接收到请求");
        String msg = "success";
        List<Production> productionList = null;
        try {
            productionList = productionService.selectAllProduction();
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

    @ResponseBody
    @RequestMapping(value = "/production/list/banner", method = RequestMethod.GET)
    public Map selectBannerProduction() {
        String msg = "success";
        List<Production> productionList = null;
        try {
            productionList = productionService.selectBannerProduction();
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

    @ResponseBody
    @RequestMapping(value = "/production/list/artist/{id}", method = RequestMethod.GET)
    public Map selectArtistProduction(@PathVariable int id) {
        List<Production> productionList = null;
        try {
            productionList = productionService.selectArtistProduction(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (productionList.size() == 0) {
                return responseTo.msg("failed");
            } else {
                return responseTo.msg("success", productionList);
            }
        }
    }
}
