package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PostRemove;
import java.rmi.MarshalledObject;


@Controller
public class PartyChangeController {
    @Autowired
    private PartyService partyService;
    @GetMapping(StringConstant.SLCHANGEPARTY)
    public String getParty(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("Party",partyService.findPartyById(id));
        return StringConstant.CHANGEPARTY;
    }
    @PostMapping(StringConstant.SLCHANGEPARTY)
    public String changeParty(@PathVariable("id")Long id, @RequestParam(name = "name" ,required = false )String name,@RequestParam(name = "course" ,required = false )String course)
    {
        partyService.update(id,name,course);
        return StringConstant.REDPARTY;
    }
}
