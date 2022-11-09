package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Teacher;
import com.boots.service.TeacherService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TeacherChangeController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping(StringConstant.SLCHANGETEACHER)
    public String getTeacher(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("TeacherForm",teacherService.findTeacherById(id));
        return StringConstant.CHANGETEACHER;
    }
    @PostMapping(StringConstant.SLCHANGETEACHER)
        public String changeTeacher(@ModelAttribute("TeacherForm")@Valid Teacher teacher, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return StringConstant.CHANGETEACHER;
        }
        teacherService.save(teacher);
        return StringConstant.REDTEACHER;
    }
}
