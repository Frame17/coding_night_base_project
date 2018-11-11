package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.service.TicketService;

import java.util.ArrayList;

@Controller
public class SearchController {

    private TicketService ticketService;

    @Autowired
    public SearchController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/searchResults")
    private String getSearchResults(@RequestParam(name = "search") String search, Model model) {
        Iterable<Ticket> matchingTickets = ticketService.findAllByTitleContains(search);
        int resultCount = 0;
        for (Ticket matchingTicket : matchingTickets)
            resultCount++;
        model.addAttribute("matchingTickets", matchingTickets);
        model.addAttribute("resultCount", resultCount);
        return "searchResults";
    }

    @GetMapping("/userTickets")
    private String getSearchResults(@RequestParam(name = "search") String search, @RequestParam(name = "id") int userId,
                                    Model model) {
        Iterable<Ticket> matchingTickets = ticketService.findAllByTitleContains(search);
        ArrayList<Ticket> userTickets = new ArrayList<>();
        for (Ticket matchingTicket : matchingTickets)
            if (matchingTicket.getCreator().getId() == userId)
                userTickets.add(matchingTicket);

        model.addAttribute("matchingTickets", userTickets);
        model.addAttribute("resultCount", userTickets.size());
        return "searchResults";
    }
}
