package com.draper.web.v1;

import com.draper.entity.Artist;
import com.draper.service.ArtistService;
import com.draper.web.ResponseTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.Map;

@Controller
@RequestMapping("v1")
public class ArtistController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ResponseTo responseTo;

    @ResponseBody
    @RequestMapping(value = "/artist")
    public Map insertArtist(@RequestBody Artist artist) {
        String msg = "success";
        try {
            artistService.insertArtist(artist);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/artist/{email}", method = RequestMethod.GET)
    public Map selectArtist(@PathVariable String email) {
        logger.warn("email = {}", email);
        Artist artist = null;
        try {
            artist = artistService.selectArtist(email);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (artist == null) {
                return responseTo.msg("failed");
            } else {
                return responseTo.msg("success", artist);
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/artist/address", method = RequestMethod.PUT)
    public Map updateAddress(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String address = (String) map.get("address");
        try {
            artistService.updateAddress(email, address);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/artist/email", method = RequestMethod.PUT)
    public Map updateEmail(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String oldEmail = (String) map.get("oldEmail");
        String newEmail = (String) map.get("newEmail");
        try {
            artistService.updateEmail(oldEmail, newEmail);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist/phoneNumber", method = RequestMethod.PUT)
    public Map updatePhoneNumber(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String phoneNumber = (String) map.get("phoneNumber");
        try {
            artistService.updatePhoneNumber(email, phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist/career", method = RequestMethod.PUT)
    public Map updateCareer(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String career = (String) map.get("career");
        try {
            artistService.updateCareer(email, career);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist/imgUrl", method = RequestMethod.PUT)
    public Map updateImgUrl(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String imgUrl = (String) map.get("imgUrl");
        try {
            artistService.updateImgUrl(email, imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist", method = RequestMethod.DELETE)
    public Map deleteArtistByEmail(@RequestBody Map<String,Object> map){
        String msg = "success";
        String email = (String) map.get("email");
        try {
            artistService.deleteArtistByEmail(email);
        } catch (Exception e){
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }
}
