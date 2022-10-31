package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Party;
import com.boots.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddPartyController {
    @Autowired
    private PartyService partyService;

    @GetMapping(StringConstant.SLADDPARTY)
    public String party()
    {
        return StringConstant.ADDPARTY;
    }
    @PostMapping(StringConstant.SLADDPARTY)
    public String addParty(@RequestParam(name = "name" ,required = false )String name,@RequestParam(name = "course" ,required = false )String course)
    {
        partyService.save(new Party(name,course));
        return StringConstant.REDPARTY;
    }
}
