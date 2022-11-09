package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Subject;
import com.boots.service.PartyService;
import com.boots.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddSubjectContoller {
    @Autowired
    private PartyService partyService;
    @Autowired
    private SubjectService subjectService;
    @GetMapping(StringConstant.SLADDSUBJECT)
    public String subject(Model model)
    {
        model.addAttribute("SubjectForm", new Subject());
        return StringConstant.ADDSUBJECT;
    }
    @PostMapping(StringConstant.SLADDSUBJECT)
    public String addSubject(@ModelAttribute("SubjectForm")@Valid Subject subject, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            System.out.println(bindingResult.hasErrors());
            return StringConstant.ADDSUBJECT;
        }
        subjectService.save(subject);

        return StringConstant.REDSUBJECT;
    }
}
