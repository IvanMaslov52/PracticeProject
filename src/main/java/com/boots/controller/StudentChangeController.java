package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Student;
import com.boots.service.PartyService;
import com.boots.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StudentChangeController {


    @Autowired
    private StudentService studentService;
    @GetMapping(StringConstant.SLCHANGESTUDENT)
    public String getStudent(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("StudentForm",studentService.findStudentById(id));
        return StringConstant.CHANGESTUDENT;
    }
    @PostMapping(StringConstant.SLCHANGESTUDENT)
    public String changeStudent(@ModelAttribute("StudentForm")@Valid Student student, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return StringConstant.CHANGESTUDENT;
        }
        studentService.save(student);
        return StringConstant.REDSTUDENT;
    }
}
