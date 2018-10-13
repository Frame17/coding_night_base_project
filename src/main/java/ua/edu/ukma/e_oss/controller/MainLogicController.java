package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.ukma.e_oss.model.Answer;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.service.AnswerService;
import ua.edu.ukma.e_oss.service.SCMemberService;
import ua.edu.ukma.e_oss.service.TicketService;

import java.util.Optional;

@Controller
public class MainLogicController {

    private final SCMemberService scMemberService;
    private final TicketService ticketService;
    private final AnswerService answerService;

    @Autowired
    public MainLogicController(SCMemberService scMemberService, TicketService ticketService, AnswerService answerService) {
        this.scMemberService = scMemberService;
        this.ticketService = ticketService;
        this.answerService = answerService;
    }

    @GetMapping("/ticket")
    private String getTicketPage(@RequestParam(name = "id") int id, Model model) {
        Iterable<SCMember> SCmembers = scMemberService.findAll();
        Optional<Ticket> optionalTicket = ticketService.findById(id);
        if (!optionalTicket.isPresent())
            throw new ResourceNotFoundException();
        Ticket ticket = optionalTicket.get();
        Iterable<Answer> answers = answerService.findAllByTicket(ticket);

        model.addAttribute("ticket", ticket);
        model.addAttribute("SCmembers", SCmembers);
        model.addAttribute("answers", answers);
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
