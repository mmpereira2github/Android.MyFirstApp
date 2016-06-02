package com.example.mmartins.model;

/**
 * Created by mmartins on 19/05/2016.
 */
public class Estabelecimento {
    private Agenda agenda = new Agenda(this);

    public Agenda getAgenda() {
        return agenda;
    }
}
