package com.example.jeong_repository.controller;

import com.example.jeong_repository.model.ProfileModel;
import com.example.jeong_repository.service.ProfileService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
@Log
@Controller
@RequestMapping({"/profile"})
public class ProfileController {


    @Autowired
    private ProfileService profileService;

    @Value("${aws.s3.upload.dir.partners}")
    private String UPLOAD_DIR_PARTNERS;

    @Value("${aws.s3.upload.url.partners}")
    private String PARTNERS_URL;

    @RequestMapping({"/profileList"})
    public String profileList(Model model) {
        List<ProfileModel> profileModels = this.profileService.selectProfile();
        log.info("profileModel == " + profileModels);
        model.addAttribute("profileModels", profileModels);
        return "/profile/profile_list";
    }

    @RequestMapping({"/profileForm"})
    public String profileForm(Model model) {
        model.addAttribute("menu", "profile");
        return "/profile/profile_form";
    }

    @RequestMapping(value = {"/profileInsert"}, method = {RequestMethod.POST})
    public String profileInsert(MultipartHttpServletRequest mhr, @RequestParam("profile") String profile, HttpServletResponse response) throws FileNotFoundException {
        long result = profileService.profileInsert(mhr, profile, PARTNERS_URL, UPLOAD_DIR_PARTNERS);
        if (result == 0L)
            try {
                response.resetBuffer();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script> alert(' history.back(); </script>");
                response.flushBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "redirect:/profile/profileList";
    }
}
