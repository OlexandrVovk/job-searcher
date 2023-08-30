package com.webapp.view.controllers;

import com.webapp.store.dto.RequestDto;
import com.webapp.view.services.MainService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("emptyPageFlag", true);
        return "index";
    }

    @GetMapping("/test")
    public String test(@RequestParam("branch") String branch,
                       @RequestParam("employment") String employment,
                       @RequestParam("experience") String experience,
                       Model model,
                       HttpSession session
    ) {
        if (branch != null) session.setAttribute("selectedBranch", branch);
        if (experience != null) session.setAttribute("selectedExperience", experience);
        if (branch != null)  session.setAttribute("selectedEmployment", employment);

        model.addAttribute("emptyPageFlag", false);
        List<RequestDto> list = mainService.getData(branch, experience, employment);
        model.addAttribute("dtoList", list);
        return "index";
    }
}
