package ua.edu.ukma.e_oss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @GetMapping("/searchResults")
    private String getSearchResults(Model model) throws NoSuchFieldException {
        return "searchResults";
    }
}
