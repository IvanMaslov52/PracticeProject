package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Subject;
import com.boots.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SubjectChangeController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping(StringConstant.SLCHANGESUBJECT)
    public String getSubject(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("SubjectForm",subjectService.findSubjectsById(id));
        return StringConstant.CHANGESUBJECT;
    }
    @PostMapping(StringConstant.SLCHANGESUBJECT)
    public String changeSubject(@ModelAttribute("SubjectForm")@Valid Subject subject, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return StringConstant.CHANGESUBJECT;
        }

       subjectService.save(subject);
        return StringConstant.REDSUBJECT;
    }
}
