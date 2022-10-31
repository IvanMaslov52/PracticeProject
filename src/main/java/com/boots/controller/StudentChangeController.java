package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.service.PartyService;
import com.boots.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentChangeController {


    @Autowired
    private StudentService studentService;
    @GetMapping(StringConstant.SLCHANGESTUDENT)
    public String getStudent(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("Student",studentService.findStudentById(id));
        return StringConstant.CHANGESTUDENT;
    }
    @PostMapping(StringConstant.SLCHANGESTUDENT)
    public String changeStudent(@PathVariable("id")Long id, @RequestParam(name = "party" ,required = false )Long partyid, @RequestParam(name = "fio" ,required = false )String fio,@RequestParam(name = "sticket" ,required = false )Long sticket,@RequestParam(name = "borndata" ,required = false )String borndata)
    {
        studentService.update(id,partyid,fio,sticket,borndata);
        return StringConstant.REDSTUDENT;
    }
}
