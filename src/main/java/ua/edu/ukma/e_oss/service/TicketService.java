package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.TicketRepository;
import ua.edu.ukma.e_oss.model.Ticket;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    Ticket save(Ticket ticket){
        Ticket savedTicked = ticketRepository.save(ticket);
        return savedTicked;
    }


    Iterable<Ticket> saveAll(Iterable<Ticket> tickets){
        Iterable savedIterable = ticketRepository.saveAll(tickets);
        return savedIterable;
    }

    Optional<Ticket> findByYd(Integer id){
        Optional<Ticket> foundMember = ticketRepository.findById(id);
        //TODO validation
        return foundMember;
    }

    boolean existsById(Integer id){
        boolean exists=ticketRepository.existsById(id);
        return exists;
    }

    Iterable<Ticket> findAll(){
        Iterable<Ticket> all = ticketRepository.findAll();
        return all;
    }

    Iterable<Ticket> findAllById(Iterable<Integer> tickets){
        Iterable<Ticket> allById = ticketRepository.findAllById(tickets);
        return allById;
    }

    long count(){
        long count = ticketRepository.count();
        return count;
    }

    void deleteById(Integer id){
        ticketRepository.deleteById(id);
    }

    void delete(Ticket scMember){
        ticketRepository.delete(scMember);
    }

    void deleteAll(Iterable<? extends Ticket> tickets){
        ticketRepository.deleteAll(tickets);
    }

    void deleteAll(){
        ticketRepository.deleteAll();
    }

//    public Ticket changeSCid(Ticket scMember, Ticket ticket){
//        int ticketID = ticket.getId();
//        Ticket newTicket = ticketRepository.updateSCidFor(scMember, ticketID);
//        return newTicket;
//    }
//
//    public byte changeStatus(byte status, Ticket ticket){
//        int ticketID = ticket.getId();
//        byte newStatus = ticketRepository.updateStatus(status, ticketID);
//        return newStatus;
//    }


}
