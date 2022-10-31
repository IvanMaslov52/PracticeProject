package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherChangeController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping(StringConstant.SLCHANGETEACHER)
    public String getTeacher(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("Teacher",teacherService.findTeacherById(id));
        return StringConstant.CHANGETEACHER;
    }
    @PostMapping(StringConstant.SLCHANGETEACHER)
        public String changeTeacher(@PathVariable("id")Long id, @RequestParam(name = "fio" ,required = false )String fio, @RequestParam(name = "borndate" ,required = false )String borndate, @RequestParam(name = "subjects" ,required = false )String  subjects, @RequestParam(name = "speciality" ,required = false )String  speciality)
    {
        teacherService.update(id,fio,borndate,subjects,speciality);
        return StringConstant.REDTEACHER;
    }
}
