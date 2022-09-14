package com.example.jeong_repository.controller;

import com.example.jeong_repository.model.LogicTbModel;
import com.example.jeong_repository.service.LogicTbService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private static final Logger log = Logger.getLogger(com.example.jeong_repository.controller.HomeController.class.getName());

    @Autowired
    private LogicTbService logicTbService;

    @RequestMapping({"/"})
    public String index(Model model) {
        List<LogicTbModel> boardList = this.logicTbService.selectLogicTb();
        model.addAttribute("boardList", boardList);
        return "index";
    }
}
