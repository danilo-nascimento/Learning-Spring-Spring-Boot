package com.danilo.nascimento.learningspring.business.service;

import com.danilo.nascimento.learningspring.data.entity.Guest;
import com.danilo.nascimento.learningspring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        for(Guest guest: guests) {
            guestList.add(guest);
        }

        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        return guestList;
    }
}
