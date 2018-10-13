package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.service.SCMemberService;
import ua.edu.ukma.e_oss.service.TicketService;

import java.util.List;

@Controller
public class MainLogicController {

    private final SCMemberService scMemberService;
    private final TicketService ticketService;

    @Autowired
    public MainLogicController(SCMemberService scMemberService, TicketService ticketService) {
        this.scMemberService = scMemberService;
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket")
    private String getTicketPage(Model model){
        Iterable<SCMember> SCmembers = scMemberService.findAll();
        model.addAttribute("SCmembers", SCmembers);

        return "ticket";
    }

    @GetMapping("/userPage")
    private String getUserPage(Model model) {
        return "";  // todo - implement
    }

    @GetMapping("/mainPage")
    private String getMainPage(Model model) {
        Iterable<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets";
    }
}
