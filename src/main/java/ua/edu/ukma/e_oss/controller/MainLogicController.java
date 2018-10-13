package ua.edu.ukma.e_oss.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainLogicController {

    @GetMapping("/ticket")
    private String getTicketPage(Model model){
        return "ticket";
    }

    @GetMapping("/userPage")
    private String getUserPage(Model model) {
        return "";  // todo - implement
    }

    @GetMapping("/mainPage")
    private String getMainPage(Model model) {
        return "TicketsPage";
    }
}
