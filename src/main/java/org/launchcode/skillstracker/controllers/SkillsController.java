package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {
    @GetMapping("/")
    @ResponseBody
    public String renderHomePage() {
        return "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like you to learn. Here is the list: </h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>";
    }

    @GetMapping("/form")
    @ResponseBody
    public String manageUserInput() {
        return "<form action='/form' method='post'>" +
                "<label for='name'>Name: </label>" +
                "<input type='text' id='name' name='name'>" +
                "</label>" +
                "<br>" +
                "<label for='language1'>My favorite language:</label>" +
                "<br>" +
                "<select name='language1' id='language1'>" +
                createMenuOptions() +
                "</select>" +
                "<br>" +
                "<label for='language2'>My second favorite language:</label>" +
                "<br>" +
                "<select name='language2' id='language2'>" +
                createMenuOptions() +
                "</select>" +
                "<br>" +
                "<label for='language3'>My third favorite language:</label>" +
                "<br>" +
                "<select name='language3' id='language3'>" +
                createMenuOptions() +
                "</select>" +
                "<br>" +
                "<input type='submit' value='Submit'>" +
                "</form>";
    }

    @PostMapping("/form")
    @ResponseBody
    public String displayUserData(@RequestParam String name, String language1, String language2, String language3) {
        return "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + language1 + "</li>" +
                "<li>" + language2 + "</li>" +
                "<li>" + language3 + "</li>" +
                "</ol>";
    }

    public String createMenuOptions() {
        return "<option value='Java'>Java</option>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value='Python'>Python</option>";
    }
}
