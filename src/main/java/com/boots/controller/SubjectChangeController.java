package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubjectChangeController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping(StringConstant.SLCHANGESUBJECT)
    public String getSubject(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("Subject",subjectService.findSubjectsById(id));
        return StringConstant.CHANGESUBJECT;
    }
    @PostMapping(StringConstant.SLCHANGESUBJECT)
    public String changeSubject(@PathVariable("id")Long id, @RequestParam(name = "party" ,required = false )Long partyid, @RequestParam(name = "name" ,required = false )String name, @RequestParam(name = "studyingtime" ,required = false )Long studyingtime)
    {
       subjectService.update(id,partyid,name,studyingtime);
        return StringConstant.REDSUBJECT;
    }
}
