package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Party;
import com.boots.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PartyChangeController {
    @Autowired
    private PartyService partyService;
    @GetMapping(StringConstant.SLCHANGEPARTY)
    public String getParty(@PathVariable("id")Long id, Model model)
    {
        model.addAttribute("PartyForm",partyService.findPartyById(id));
        return StringConstant.CHANGEPARTY;
    }
    @PostMapping(StringConstant.SLCHANGEPARTY)
    public String changeParty(@ModelAttribute("PartyForm") @Valid Party party, BindingResult bindingResult)
    {
        try {
            if (bindingResult.hasErrors()) {
                return StringConstant.CHANGEPARTY;
            }
            partyService.save(party);
            return StringConstant.REDPARTY;
        }
        catch (Exception e)
        {
            bindingResult.addError(new FieldError("PartyForm","name","Такое название уже существует"));
            return StringConstant.CHANGEPARTY;
        }
    }
}
