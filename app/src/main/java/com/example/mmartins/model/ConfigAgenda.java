package com.example.mmartins.model;

/**
 * Created by mmartins on 23/05/2016.
 */
public class ConfigAgenda {
    int minutosConsultaNormal = 30;
    int horaInicio = 9;
    int minutoInicio = 0;
    int horaFim = 16;
    int minutoFim = 30;

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public int getMinutosConsultaNormal() {
        return minutosConsultaNormal;
    }

    public void setMinutosConsultaNormal(int minutosConsultaNormal) {
        this.minutosConsultaNormal = minutosConsultaNormal;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }

    public int getMinutoFim() {
        return minutoFim;
    }
}
