package com.danilo.nascimento.learningspring.web;

import com.danilo.nascimento.learningspring.business.service.GuestService;
import com.danilo.nascimento.learningspring.data.entity.Guest;
import com.danilo.nascimento.learningspring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    private final GuestService guestService;

    @Autowired
    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuests(Model model) {
        Iterable<Guest> guests = this.guestService.getGuests();



        model.addAttribute("guests", guests);
        return "guests";
    }
}
