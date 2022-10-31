package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Teacher;
import com.boots.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddTeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(StringConstant.SLADDTEACHER)
    public String teacher()
    {
        return StringConstant.ADDTEACHER;
    }
    @PostMapping(StringConstant.SLADDTEACHER)
    public String addTeacher(@RequestParam(name = "fio" ,required = false )String fio, @RequestParam(name = "borndate" ,required = false )String borndate, @RequestParam(name = "subjects" ,required = false )String subjects, @RequestParam(name = "speciality" ,required = false )String speciality)
    {

        teacherService.save(new Teacher(fio,borndate, teacherService.parsing(subjects),speciality));
        return StringConstant.REDTEACHER;
    }
}
