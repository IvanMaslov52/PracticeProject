package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Student;
import com.boots.service.PartyService;
import com.boots.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddStudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private PartyService partyService;
    @GetMapping(StringConstant.SLADDSTUDENT)
    public  String student()
    {return StringConstant.ADDSTUDENT;}
    @PostMapping(StringConstant.SLADDSTUDENT)
    public String addStudent(@RequestParam(name = "party" ,required = false )Long id, @RequestParam(name = "sticket" ,required = false )Long sticket,@RequestParam(name = "fio" ,required = false )String fio,@RequestParam(name = "borndata" ,required = false )String borndata)
    {
        studentService.save(new Student(partyService.findPartyById(id),fio,sticket,borndata));
        return StringConstant.REDSTUDENT;
    }
}
