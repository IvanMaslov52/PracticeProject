package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Party;
import com.boots.entity.Student;
import com.boots.service.PartyService;
import com.boots.service.StudentService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AddStudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private PartyService partyService;
    @GetMapping(StringConstant.SLADDSTUDENT)
    public  String student(Model model)
    {
        model.addAttribute("StudentForm",new Student());
        return StringConstant.ADDSTUDENT;
    }
    @PostMapping(StringConstant.SLADDSTUDENT)
    public String addStudent(@ModelAttribute("StudentForm")@Valid Student student, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return StringConstant.ADDSTUDENT;
        }


       studentService.save(student);
        return StringConstant.REDSTUDENT;
    }
}
