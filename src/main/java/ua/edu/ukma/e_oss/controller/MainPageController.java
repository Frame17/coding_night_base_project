package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.model.User;
import ua.edu.ukma.e_oss.service.TicketService;
import ua.edu.ukma.e_oss.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class MainPageController {

    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public MainPageController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping("/userPage")
    private String getUserPage(Model model, HttpServletRequest request) throws NoSuchFieldException {
        String username = request.getUserPrincipal().getName();
        Optional<User> userOptional = userService.findByName(username);
        if (!userOptional.isPresent())
            throw new NoSuchFieldException("No user with username :'" + username + "'");
        Iterable<Ticket> tickets = ticketService.findAllByCreator(userOptional.get());

        model.addAttribute("tickets", tickets);
        return "userTickets";
    }

    @GetMapping("/mainPage")
    private String getMainPage(Model model) {
        Iterable<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "allTickets";
    }

    @PostMapping("/mainPage")
    private String postMainPage(@RequestParam(name = "search") String search, HttpServletRequest request, Model model) {
        return "redirect:/searchResults?search="+search;
    }

}
