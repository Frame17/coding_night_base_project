package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.service.TicketService;


@Controller
public class SearchController {

    @Autowired
    TicketService ticketService;

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
}
