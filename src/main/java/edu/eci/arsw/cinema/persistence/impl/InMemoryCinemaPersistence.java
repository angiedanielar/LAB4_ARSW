/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence.impl;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */

@Service("EnMemoria")
public class InMemoryCinemaPersistence implements CinemaPersitence{
    
    private final Map<String,Cinema> cinemas=new HashMap<>();

    public InMemoryCinemaPersistence() {
        //load stub data
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("cinemaX",functions);
        cinemas.put("cinemaX", c);
    }    

    /*La fila y columna no pueden menores de 1, y no pueden estar vacio el cinema, 
    la fecha y el nombre de la pelicula*/
    @Override
    @SuppressWarnings("empty-statement")
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaPersistenceException {
        if((row <= 0) || col <= 0){
            throw new CinemaPersistenceException("Fila invalida o clumna inválidas");
        };          
        if(cinema == null){
            throw new CinemaPersistenceException("El nombre del cine no puede estar vacio");
        };        
        if(date == null){
            throw new CinemaPersistenceException("La fecha puede estar vacia");
        };        
        if(movieName == null){
            throw new CinemaPersistenceException("El nombre de la pelicula no puede estar vacio");
        };        
        Cinema cine =getCinemaByName(cinema);
        if(cine == null){
            throw new CinemaPersistenceException("Este cinema no existe");
        }
        
        //la funcion debe existir para poder hacer la compra
        try {
            CinemaFunction funcion = cine.existeFuncion(movieName,date);
            funcion.buyTicket(row, col);
        } catch (CinemaException ex) {
            Logger.getLogger(InMemoryCinemaPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }

    //La fecha y el cine a buscar no pueden estar vacios. Y el cine debe existir.
    @Override
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) throws CinemaPersistenceException{
        if(cinema == null){
            throw new CinemaPersistenceException("El cinema a buscar no puede estar vacio");
        }
        
        if(date == null){
            throw new CinemaPersistenceException("La fecha a buscar no puede estar vacia");
        }

        Cinema cine =getCinemaByName(cinema);
        if(cine == null){
            throw new CinemaPersistenceException("El cinema que busca no existe");
        }
 
        try {
            return cine.getFunctionsDate(date);
        } catch (CinemaException ex) {
            throw new CinemaPersistenceException(ex.getMessage(), ex);
        }        
    }

    @Override
    public void saveCinema(Cinema c) throws CinemaPersistenceException {
        if (cinemas.containsKey(c.getName())){
            throw new CinemaPersistenceException("The given cinema already exists: "+c.getName());
        }
        else{
            cinemas.put(c.getName(),c);
        }   
    }

    //El nombre del cine a buscar no puede estar vacio y debe existir 
    @Override
    public Cinema getCinemaByName(String name) throws CinemaPersistenceException {
        if(name == null){
            throw new CinemaPersistenceException("El nombre del cinema a buscar no puede estar vacio");
        }
        if(!cinemas.containsKey(name)){
            throw new CinemaPersistenceException("El cinema que busca no existe");
        }        
        return cinemas.get(name);
    }
    
    //Para devolver el set que nos piden miramos en la libreria de hash un tipo set
    @Override
    public Set<Cinema> getCinemas() {
        return new HashSet(cinemas.values());
    }

}
