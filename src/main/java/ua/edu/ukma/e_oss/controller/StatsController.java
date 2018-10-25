package ua.edu.ukma.e_oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.service.TicketService;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class StatsController {

    private final TicketService ticketService;

    @Autowired
    public StatsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Stats are showing those people who actually completed the task
     * (solved the ticket). Also the stats include only solved tickets
     */
    // todo - verify the "grading" process
    // todo - possibly allow multiple solvers
    @GetMapping("/stats")
    public String getStatsPage(Model model) {
        HashMap<String, Integer> stats = new HashMap<>();

        List<Ticket> resolvedTickets = StreamSupport
                .stream(ticketService.findAllByStatus((byte) 3).spliterator(), false)
                .collect(Collectors.toList());
        resolvedTickets.forEach(ticket -> {
            String name = ticket.getSolver().getUser().getName();
            stats.compute(name, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        });

        // todo - consider sorting by value

        model.addAttribute("stats", stats);
        return "stats";
    }
}
