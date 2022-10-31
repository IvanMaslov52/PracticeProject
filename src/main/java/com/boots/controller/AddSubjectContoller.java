package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Subject;
import com.boots.service.PartyService;
import com.boots.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddSubjectContoller {
    @Autowired
    private PartyService partyService;
    @Autowired
    private SubjectService subjectService;
    @GetMapping(StringConstant.SLADDSUBJECT)
    public String subject()
    {
        return StringConstant.ADDSUBJECT;
    }
    @PostMapping(StringConstant.SLADDSUBJECT)
    public String addSubject(@RequestParam(name = "party" ,required = false )Long id, @RequestParam(name = "name" ,required = false )String name, @RequestParam(name = "studyingtime" ,required = false )Long studyingtime)
    {
        subjectService.save(new Subject(partyService.findPartyById(id),name,studyingtime));
        return StringConstant.REDSUBJECT;
    }
}
