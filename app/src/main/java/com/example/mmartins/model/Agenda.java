package com.example.mmartins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mmartins on 23/05/2016.
 */
public class Agenda {
    final private ConfigAgenda config = new ConfigAgenda();
    private final Map<Date, DiaAgenda> dias = new HashMap<>();
    private Estabelecimento estabelecimento = null;

    public Agenda(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public ConfigAgenda getConfig() {
        return config;
    }

    public void setDiaAgenda(Date dia, DiaAgenda agenda) {
        dias.put(dia, agenda);
    }

    public DiaAgenda getDiaAgenda(Date dia) {
        return dias.get(dia);
    }
}
