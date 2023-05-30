package padrinhodobem;

public class Necessidade {

    // revisar
    private int id;
    private String tipo;
    private int crianca_id;
    
    
    public Necessidade(String tipo, int crianca_id) {
        this.tipo = tipo;
        this.crianca_id = crianca_id;
    }

    public Necessidade(int id, String tipo, int crianca_id) {
        this.id = id;
        this.tipo = tipo;
        this.crianca_id = crianca_id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int GetCriancaId() {
        return this.crianca_id;
    }

    public int getId() {
        return this.id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCriancaId(int crianca_id) {
        this.crianca_id = crianca_id;
    }

    @Override
    public String toString() {
        return "Tipo: " + this.tipo + "\nCrianca id: " + this.crianca_id + "\n Id: " + this.id;
    }
}
