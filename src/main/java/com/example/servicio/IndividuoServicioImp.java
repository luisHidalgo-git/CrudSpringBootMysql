package com.example.servicio;

import com.example.dao.IndividuoDao;
import com.example.domain.Individuo;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@Service

public class IndividuoServicioImp implements IndividuoServicio{

    @Autowired
    private IndividuoDao individuoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Individuo> listaIndividuo() {
        return (List<Individuo>) individuoDao.findAll();
    }

    @Override
    @Transactional
    public void salvar(Individuo individuo) {
        individuoDao.save(individuo);
    }

    @Override
    @Transactional
    public void borrar(Individuo individuo) {
        individuoDao.delete(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo localizarIndividuo(Individuo individuo) {
        return individuoDao.findById(individuo.getId_individuo()).orElse(null);
    }
    
}
