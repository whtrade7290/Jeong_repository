package com.example.jeong_repository.controller;

import com.example.jeong_repository.model.CommunityModel;
import com.example.jeong_repository.model.PaginationModel;
import com.example.jeong_repository.service.CommunityService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/community/*"})
public class CommunityController {
    private static final Logger log = Logger.getLogger(com.example.jeong_repository.controller.CommunityController.class.getName());

    @Autowired
    CommunityService communityService;

    @RequestMapping({"/communityList"})
    public String communityList(Model model, @RequestParam(defaultValue = "1") int pageNum) {
        int count = this.communityService.selectCount();
        int pageSize = 10;
        int startRow = (pageNum - 1) * pageSize;
        List<CommunityModel> communityList = null;

        if (count > 0){
            communityList = this.communityService.selectCommunity(startRow, pageSize);
        }

        PaginationModel pModel = new PaginationModel();
        if (count > 0) {
            int pageCount = count / pageSize + ((count % pageSize == 0) ? 0 : 1);
            int pageBlock = 5;
            int startPage = (pageNum / pageBlock - ((pageNum % pageBlock == 0) ? 1 : 0)) * pageBlock + 1;
            int endPage = startPage + pageBlock - 1;
            if (endPage > pageCount)
                endPage = pageCount;
            pModel.setCount(count);
            pModel.setPageCount(pageCount);
            pModel.setPageBlock(pageBlock);
            pModel.setStartPage(startPage);
            pModel.setEndPage(endPage);
            model.addAttribute("start", Integer.valueOf(startPage));
            model.addAttribute("end", Integer.valueOf(endPage));
            model.addAttribute("pageCount", Integer.valueOf(pageCount));
            model.addAttribute("communityList", communityList);
            model.addAttribute("pageNum", Integer.valueOf(pageNum));
        }
        return "/community/communityList";
    }
}
