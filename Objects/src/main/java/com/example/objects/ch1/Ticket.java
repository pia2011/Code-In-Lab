package com.example.objects.ch1;

import lombok.Getter;

@Getter
public class Ticket {
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }
}
