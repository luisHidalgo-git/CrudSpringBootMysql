package com.example.web;

import com.example.domain.Individuo;
import com.example.servicio.IndividuoServicio;
import java.util.List;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorREST {
    
    @Autowired
    private IndividuoServicio individuoServicio;
    
    @GetMapping("/")
    public String comienzo(Model model) {
        List<Individuo> individuos = individuoServicio.listaIndividuo();
        model.addAttribute("individuos", individuos);
        return "indice"; // Esto busca una vista llamada 'indice.html'
    }
    
    @GetMapping(("/anexar"))
    public String anexar(Individuo individuo){
        return "cambiar";
    }
    
    @PostMapping("/salvar")
    public String salvar(Individuo individuo){
        individuoServicio.salvar(individuo);
        return "redirect:/";
    }
    
    @GetMapping("/cambiar/{id_individuo}")
    public String cambiar(Individuo individuo, Model model){
        individuo = individuoServicio.localizarIndividuo(individuo);
        model.addAttribute("individuo", individuo);
        return "cambiar";
    }
    
    @GetMapping("/borrar/{id_individuo}")
    public String borrar(Individuo individuo){
        individuoServicio.borrar(individuo);
        return "redirect:/";
    }
}