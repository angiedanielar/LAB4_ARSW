/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import edu.eci.arsw.cinema.persistence.CinemaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristian
 */
public class Cinema {

    private String name;
    private List<CinemaFunction> functions;

    public Cinema() {
    }

    public Cinema(String name, List<CinemaFunction> functions) {
        this.name = name;
        this.functions = functions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CinemaFunction> getFunctions() {
        return this.functions;
    }

    public List<CinemaFunction> getFunctionsDate(String date) throws CinemaException {
        List<CinemaFunction> functionsDate = new ArrayList<>();
        for (CinemaFunction func : functions) {
            if (func.getDate().equals(date)) {
                functionsDate.add(func);
            }
        }
        if (functionsDate.isEmpty()) {
            throw new CinemaException("No hay funciones en esta hora");
        }
        return functionsDate;
    }

    public void setSchedule(List<CinemaFunction> functions) {
        this.functions = functions;
    }

    public CinemaFunction existeFuncion(String name, String date) throws CinemaException {
        //para que no de error se deja null
        CinemaFunction funcion = null;
        for (CinemaFunction f : functions) {
            if ((f.getMovie().getName().equals(name)) && (f.getDate().equals(date))) {
                funcion = f;
                break;
            }
        }
        return funcion;
    }

    @Override
    public String toString() {
        return "Cinema{" + "name=" + name + ", functions=" + functions + '}';
    }
    
}
