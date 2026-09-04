package com.tnova.ticketapi.service;


import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public double calculatePrice(int age,boolean isStudent){
        if(age<12){
            return 0;
        }
        if(age<60 && isStudent){
            return 100;
        }
        if(age<60){
            return 200;
        }
        return 50;
    }
}
