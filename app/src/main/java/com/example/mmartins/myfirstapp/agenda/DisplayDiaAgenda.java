package com.example.mmartins.myfirstapp.agenda;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mmartins.model.ConfigAgenda;
import com.example.mmartins.model.DiaAgenda;
import com.example.mmartins.model.Estabelecimento;
import com.example.mmartins.model.HorarioAgenda;

import java.util.Date;
import java.util.List;

/**
 * Created by mmartins on 23/05/2016.
 */
public class DisplayDiaAgenda {

    public static void createDiaAgenda(ViewGroup viewGroup, Estabelecimento estabelecimento, Date dia) {
        ConfigAgenda configAgenda = estabelecimento.getAgenda().getConfig();
        DiaAgenda diaAgenda = estabelecimento.getAgenda().getDiaAgenda(dia);
        HorarioAgenda lastHorario = null;
        if (diaAgenda != null) {
            for (HorarioAgenda horario : diaAgenda.getHorarios()) {
                createHorarioAgenda(viewGroup, lastHorario, horario, configAgenda);
                lastHorario = horario;
            }
        }

        createHorarioAgenda(viewGroup, lastHorario, null, configAgenda);
    }

    private static void createButtonVazio(ViewGroup viewGroup, int hora, int minuto, String text) {
        String titulo = Integer.toString(hora) + ":" + Integer.toString(minuto) + " " + text;
        Button button = new Button(viewGroup.getContext());
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText(titulo);
        viewGroup.addView(button);
    }

    private static void createHorarioAgenda(ViewGroup viewGroup, HorarioAgenda lastHorario, HorarioAgenda horario, ConfigAgenda configAgenda) {
        int lastHora = configAgenda.getHoraInicio();
        int lastMinuto = configAgenda.getMinutoInicio();
        int alvoHora = horario != null? horario.getHora(): configAgenda.getHoraFim();
        int alvoMinuto = horario != null? horario.getMinuto(): configAgenda.getMinutoFim();
        if (lastHorario != null) {
            lastHora = lastHorario.getHora();
            lastMinuto = lastHorario.getMinuto();
        }

        while (lastHora < alvoHora) {
            createButtonVazio(viewGroup, lastHora, lastMinuto, "VAZIO");
            int minuto = lastMinuto + configAgenda.getMinutosConsultaNormal();
            if (minuto >= 60) {
                lastHora += (minuto / 60);
                lastMinuto =  minuto % 60;
            }
            else {
                lastMinuto = minuto;
            }
        }

         while (lastHora == alvoHora && lastMinuto < alvoMinuto) {
            createButtonVazio(viewGroup, lastHora, lastMinuto, "VAZIO");
            int minuto = lastMinuto + configAgenda.getMinutosConsultaNormal();
            if (minuto > 60) {
                lastHora += (minuto / 60);
                lastMinuto =  minuto % 60;
            }
            else {
                lastMinuto = minuto;
            }
        }

        if (horario != null) {

        }
    }
}
