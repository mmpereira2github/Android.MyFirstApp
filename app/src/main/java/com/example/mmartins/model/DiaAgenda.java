package com.example.mmartins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mmartins on 23/05/2016.
 */
public class DiaAgenda {
    final Agenda agenda;
    final private Date data;
    final List<HorarioAgenda> horarios = new ArrayList();

    public DiaAgenda(Agenda agenda, Date data) {
        this.agenda = agenda;
        this.data = data;
    }

    public List<HorarioAgenda> getHorarios() {
        return this.horarios;
    }

    public void addHorario(HorarioAgenda novoHorario) {
        int location = 0;
        for (HorarioAgenda horarioExistente: horarios) {
            if (horarioExistente.getHora() > novoHorario.getHora()) {
                horarios.add(location, novoHorario);
                return;
            }
            else if (horarioExistente.getHora() == novoHorario.getHora()) {
                if (horarioExistente.getMinuto() > novoHorario.getMinuto()) {
                    horarios.add(location, novoHorario);
                    return;
                }
            }

            location++;
        }

        horarios.add(location, novoHorario);
    }
}
