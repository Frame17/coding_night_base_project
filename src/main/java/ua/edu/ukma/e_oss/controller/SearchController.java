package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.model.User;
import ua.edu.ukma.e_oss.service.TicketService;
import ua.edu.ukma.e_oss.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class SearchController {

    private TicketService ticketService;
    private UserService userService;

    @Autowired
    public SearchController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
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
    private String getSearchResults(@RequestParam(name = "search") String search, Model model,
                                    HttpServletRequest request) throws NoSuchFieldException {
        String username = request.getUserPrincipal().getName();
        Optional<User> userOptional = userService.findByName(username);
        if (!userOptional.isPresent())
            throw new NoSuchFieldException("No user with username :'" + username + "'");
        int userId = userOptional.get().getId();

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
