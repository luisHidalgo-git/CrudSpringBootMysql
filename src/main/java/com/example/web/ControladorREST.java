package com.example.web;

import com.example.dao.IndividuoDao;
import com.example.domain.Individuo;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorREST {
    
    @Autowired
    private IndividuoDao individuoDao;
    
    @GetMapping("/")
    public String comienzo(Model model) {
        Iterable<Individuo> individuos = individuoDao.findAll();
        model.addAttribute("individuos", individuos);
        return "indice"; // Esto busca una vista llamada 'indice.html'
    }
}