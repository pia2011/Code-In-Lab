package com.example.objects.ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bad_case_test {

    @Test
    void 정상_동작_테스트() throws Exception {

        // given
        Ticket ticket1 = new Ticket(100L);
        Ticket ticket2 = new Ticket(100L);
        TicketOffice ticketOffice = new TicketOffice(100L, ticket1, ticket2);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Bag bag = new Bag(100L);
        Audience audience = new Audience(bag);

        // when
        theater.enter(audience);

        // then
        Assertions.assertThat(audience.getBag().getTicket()).isNotNull();
    }
}
