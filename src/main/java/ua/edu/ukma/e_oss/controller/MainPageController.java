package ua.edu.ukma.e_oss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/ticket")
    public String getTicketPage(Model model) {
        return "ticket";
    }

    @GetMapping("/userPage")
    public String getUserPage(Model model) {
        return "";  // todo - implement
    }

    @GetMapping("/mainPage")
    public String getMainPage(Model model) {
        return "TicketsPage";
    }
}
