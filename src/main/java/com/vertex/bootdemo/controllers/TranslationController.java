package com.vertex.bootdemo.controllers;

import com.vertex.bootdemo.model.TranslationPair;
import com.vertex.bootdemo.services.TranslationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Log4j2
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @PostMapping("/translate")
    public ModelAndView translate(@ModelAttribute @Valid TranslationPair translationPair, BindingResult bindingResult){
        ModelAndView toReturn = new ModelAndView();

        if(bindingResult.hasErrors()) {
            toReturn.addObject("bindingResult", bindingResult);
            toReturn.addObject("translationPair", translationPair);
        } else {
            toReturn.addObject("translationPair", translationService.translate(translationPair.getWordFrom()));
        }

        log.error(bindingResult.getAllErrors());

        return toReturn;
    }

    @GetMapping("/translate")
    public ModelAndView showPage(){
        ModelAndView toReturn = new ModelAndView("translate");
        toReturn.addObject("translationPair", new TranslationPair());
        return toReturn;
    }

}
