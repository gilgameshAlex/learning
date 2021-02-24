package ru.javabegin.training.springlib.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javabegin.training.springlib.domain.Author;
import ru.javabegin.training.springlib.spring.repository.AuthorRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class RedirectController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        List<Author> authorList = authorRepository.findAll();
        return "ok";
    }
}
