package br.com.syncinfo.calendar.model;

/**
 * Created by mmartins on 23/05/2016.
 */
public class Calendar {
    private String id = "";
    private final long estabelecimentoId;

    public Calendar(long estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    public String getId(){
        return id;
    }

    public long getEstabelecimentoId() {
        return estabelecimentoId;
    }
}
