package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.service.TicketService;

import java.util.HashMap;

@Controller
public class StatsController {

    private final TicketService ticketService;

    @Autowired
    public StatsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Stats are showing those people who actually completed the task (solved the ticket).
     * Also the stats include only solved tickets
     */
    // todo - possibly allow multiple solvers
    @GetMapping("/stats")
    public String getStatsPage(Model model) {
        HashMap<String, Integer> stats = new HashMap<>();

        Iterable<Ticket> resolvedTickets = ticketService.findAllByStatus((byte) 3);
        resolvedTickets.forEach(ticket -> {
            String name = ticket.getSolver().getUser().getName();
            stats.compute(name, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        });

        model.addAttribute("stats", stats.entrySet());
        return "stats";
    }
}
