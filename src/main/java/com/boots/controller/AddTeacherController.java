package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Teacher;
import com.boots.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddTeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(StringConstant.SLADDTEACHER)
    public String teacher(Model model)
    {
        model.addAttribute("TeacherForm", new Teacher());
        return StringConstant.ADDTEACHER;
    }
    @PostMapping(StringConstant.SLADDTEACHER)
    public String addTeacher(@ModelAttribute("TeacherForm")@Valid Teacher teacher, BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {
            return StringConstant.ADDTEACHER;
        }
        teacherService.save(teacher);

        return StringConstant.REDTEACHER;
    }
}
