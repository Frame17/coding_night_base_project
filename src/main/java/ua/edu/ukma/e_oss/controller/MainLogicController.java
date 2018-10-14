package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.ukma.e_oss.model.Answer;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.model.User;
import ua.edu.ukma.e_oss.service.AnswerService;
import ua.edu.ukma.e_oss.service.SCMemberService;
import ua.edu.ukma.e_oss.service.TicketService;
import ua.edu.ukma.e_oss.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Controller
public class MainLogicController {

    private final SCMemberService scMemberService;
    private final TicketService ticketService;
    private final AnswerService answerService;
    private final UserService userService;


    @Autowired
    public MainLogicController(SCMemberService scMemberService, TicketService ticketService, AnswerService answerService, UserService userService) {
        this.scMemberService = scMemberService;
        this.ticketService = ticketService;
        this.answerService = answerService;
        this.userService = userService;
    }

    @GetMapping("/ticket")
    private String getTicketPage(@RequestParam(name = "id") int id, Model model, HttpServletRequest request) throws NoSuchFieldException {
        Iterable<SCMember> SCmembers = scMemberService.findAll();
        Optional<Ticket> optionalTicket = ticketService.findById(id);
        if (!optionalTicket.isPresent())
            throw new ResourceNotFoundException();
        Ticket ticket = optionalTicket.get();
        Iterable<Answer> answers = answerService.findAllByTicket(ticket);
        User user = null;
        if (request.getUserPrincipal() != null) {
            String username = request.getUserPrincipal().getName();
            Optional<User> userOptional = userService.findByName(username);
            if (!userOptional.isPresent())
                throw new NoSuchFieldException("No user with username :'" + username + "'");
            user = userOptional.get();
        }

        model.addAttribute("ticket", ticket);
        model.addAttribute("SCmembers", SCmembers);
        model.addAttribute("answers", answers);
        model.addAttribute("user", user);
        return "ticket";
    }

    @GetMapping("/userPage")
    private String getUserPage(Model model, HttpServletRequest request) throws NoSuchFieldException {
        String username = request.getUserPrincipal().getName();
        Optional<User> userOptional = userService.findByName(username);
        if (!userOptional.isPresent())
            throw new NoSuchFieldException("No user with username :'" + username + "'");
        Iterable<Ticket> tickets = ticketService.findAllByCreator(userOptional.get());

        model.addAttribute("tickets", tickets);
        return "userTickets";  // todo - implement
    }

    @GetMapping("/mainPage")
    private String getMainPage(Model model) {
        Iterable<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "allTickets";
    }

    @GetMapping("/addTicket")
    private String getAddTicket(HttpServletRequest request, Model model) throws NoSuchFieldException {
        String username = request.getUserPrincipal().getName();
        Optional<User> userOptional = userService.findByName(username);
        if (!userOptional.isPresent())
            throw new NoSuchFieldException("No user with username :'" + username + "'");
        model.addAttribute("user", userOptional.get());
        return "addTicket";
    }


    @PostMapping("/addTicket")
    public String getFromMainPage(HttpServletRequest request, Model model) throws NoSuchFieldException {
        String username = request.getUserPrincipal().getName();
        Optional<User> userOptional = userService.findByName(username);
        if (!userOptional.isPresent())
            throw new NoSuchFieldException("No user with username :'" + username + "'");
        Date date = new Date();
        Ticket ticket = new Ticket(request.getParameter("title"), request.getParameter("text"),
                userOptional.get(), date);
        ticketService.save(ticket);

        return "redirect:/ticket?id=" + ticket.getId();
    }
}
