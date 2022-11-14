package com.boots.controller;

import com.boots.constant.StringConstant;
import com.boots.entity.Party;
import com.boots.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.xml.ws.Response;

@Controller
public class AddPartyController {
    @Autowired
    private PartyService partyService;

    @GetMapping(StringConstant.SLADDPARTY)
    public String party(Model model)
    {
        model.addAttribute("PartyForm",new Party());
        return StringConstant.ADDPARTY;
    }
    @PostMapping(StringConstant.SLADDPARTY)
    public String addParty(@ModelAttribute("PartyForm")@Valid Party party,BindingResult bindingResult)
    {
        try {
            if (bindingResult.hasErrors()) {
                return StringConstant.ADDPARTY;
            }
            partyService.save(party);
            return StringConstant.REDPARTY;
        }
        catch (Exception e)
        {
            System.out.println(e.getClass());
            bindingResult.addError(new FieldError("PartyForm","name","Такое название уже существует"));
            return StringConstant.ADDPARTY;
        }
    }




}
