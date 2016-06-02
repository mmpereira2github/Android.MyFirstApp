package com.example.mmartins.model;

/**
 * Created by mmartins on 19/05/2016.
 */
public class HorarioAgenda {
    public static interface Visitor {
        void setVazio(VazioHorarioAgenda horarioAgenda);
    }

    final int hora;
    final int minuto;

    public HorarioAgenda(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
}
