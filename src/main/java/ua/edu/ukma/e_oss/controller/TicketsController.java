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
public class TicketsController {
    private SCMemberService scMemberService;
    private TicketService ticketService;
    private AnswerService answerService;
    private UserService userService;

    @Autowired
    public TicketsController(SCMemberService scMemberService, TicketService ticketService, AnswerService answerService, UserService userService) {
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
            model.addAttribute("sc", request.isUserInRole("SC"));
        }

        model.addAttribute("ticket", ticket);
        model.addAttribute("SCmembers", SCmembers);
        model.addAttribute("answers", answers);
        model.addAttribute("user", user);
        return "ticket";
    }

    @PostMapping("/ticket")
    public String postTicketAnswer(@RequestParam(name = "id") int id, Model model, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        Optional<Ticket> optionalTicket = ticketService.findById(id);

        User user = userService.findByName(username).get();
        Optional<SCMember> scUser = scMemberService.findByUser(user);//todo from select

        Ticket ticket = optionalTicket.get();
        String reply = request.getParameter("comment");
        System.out.println(request.getParameter("status"));
        Byte status =Byte.parseByte( request.getParameter("status"));
        Date date = new Date();
        Answer answer;
        if (scUser.isPresent()&&request.getParameter("sc")!=null) {
            SCMember scMember = scMemberService.findById(Integer.parseInt(request.getParameter("sc"))).get();
            if (scMember.getId() == ticket.getSolver().getId()) scMember = null;
            if (status == ticket.getStatus()) status = null;
            answer = new Answer(ticket, user, scMember, status, reply, date);
        } else {
            answer = new Answer(ticket, user, reply, date);
        }
        answerService.save(answer);
        model.addAttribute("ticket", ticket);
        model.addAttribute("answer", answer);
        return "redirect:/ticket?id="+ticket.getId();
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
    public String postTicket(HttpServletRequest request, Model model) throws NoSuchFieldException {
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
