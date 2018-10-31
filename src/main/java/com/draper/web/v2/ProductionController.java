package com.draper.web.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("v2ProductionController")
@RequestMapping("/v2")
public class ProductionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/production/list/all", method = RequestMethod.GET)
    public String sselectAllProduction() {
        return "result";
    }


}
