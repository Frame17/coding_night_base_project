package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.TicketRepository;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.model.User;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Iterable<Ticket> saveAll(Iterable<Ticket> tickets){
        return ticketRepository.saveAll(tickets);
    }

    public Optional<Ticket> findById(Integer id){
        return ticketRepository.findById(id);
    }

    public boolean existsById(Integer id){
        return ticketRepository.existsById(id);
    }

    public Iterable<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Iterable<Ticket> findAllById(Iterable<Integer> tickets){
        return ticketRepository.findAllById(tickets);
    }

    public long count(){
        return ticketRepository.count();
    }

    public void deleteById(Integer id){
        ticketRepository.deleteById(id);
    }

    public void delete(Ticket scMember){
        ticketRepository.delete(scMember);
    }

    public void deleteAll(Iterable<? extends Ticket> tickets){
        ticketRepository.deleteAll(tickets);
    }

    public void deleteAll(){
        ticketRepository.deleteAll();
    }

    public Iterable<Ticket> findAllBySolver(SCMember solver){
      return   ticketRepository.findAllBySolver(solver);
    }

    public Iterable<Ticket> findAllByCreator(User creator){
        return ticketRepository.findAllByCreator(creator);
    }

    public Iterable<Ticket> findAllByTitleContains(String title){
        return ticketRepository.findAllByTitleContains(title);
    }

    public Iterable<Ticket> findAllByStatus(byte status){
        return ticketRepository.findAllByStatus(status);
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
