package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.TicketRepository;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.Ticket;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    Ticket save(Ticket ticket){
        Ticket savedTicked = ticketRepository.save(ticket);
        return savedTicked;
    }

    public SCMember changeSCid(SCMember scMember, Ticket ticket){
        int ticketID = ticket.getId();
        SCMember newSCMember = ticketRepository.updateSCidFor(scMember, ticketID);
        return newSCMember;
    }

    public byte changeStatus(byte status, Ticket ticket){
        int ticketID = ticket.getId();
        byte newStatus = ticketRepository.updateStatus(status, ticketID);
        return newStatus;
    }


}
