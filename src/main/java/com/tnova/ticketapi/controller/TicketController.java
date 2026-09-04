package com.tnova.ticketapi.controller;

import com.tnova.ticketapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketController{

    @Autowired
    private TicketService ticketService;

    @GetMapping("/price")
    public  double getPrice(@RequestParam int age,@RequestParam boolean isStudent){
        return ticketService.calculatePrice(age,isStudent);
    }


}
