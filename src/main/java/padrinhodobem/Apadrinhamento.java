package padrinhodobem;

import java.sql.Date;

public class Apadrinhamento {
    private int id;
    private Date tempo;
    private int crianca_id;
    private int necessidade_id;
    private int usuario_id;

    public Apadrinhamento(int id, Date tempo, int crianca_id, int necessidade_id, int usuario_id) {
        this.id = id;
        this.tempo = tempo;
        this.crianca_id = crianca_id;
        this.necessidade_id = necessidade_id;
        this.usuario_id = usuario_id;
    }

    public Apadrinhamento(Date tempo, int crianca_id, int necessidade_id, int usuario_id) {
        this.tempo = tempo;
        this.crianca_id = crianca_id;
        this.necessidade_id = necessidade_id;
        this.usuario_id = usuario_id;
    }

    public int getId() {
        return this.id;
    }

    public int getCriancaId() {
        return this.crianca_id;
    }

    public int getUsuarioId() {
        return this.usuario_id;
    }

    public int getNecessidadeId() {
        return this.necessidade_id;
    }

    public Date getTempo() {
        return this.tempo;
    }

    // adicionar o setters
}
