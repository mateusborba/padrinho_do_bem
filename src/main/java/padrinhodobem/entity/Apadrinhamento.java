package padrinhodobem.entity;

import java.sql.Date;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

public class Apadrinhamento {
    
    private static String PATTERN_FORMAT = "dd/MM/yyyy";
    private static ZoneId ZONA_SP = ZoneId.of("America/Sao_Paulo");
    private static Clock clock = Clock.system(ZONA_SP);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
            .withZone(ZoneId.systemDefault());
    
    private int id;
    
    private Instant tempoInicio; // Inicio do apadrinhamento
    private int duration; // Duração do apadrinhamento
    private int crianca_id;
    private int necessidade_id;
    private int usuario_id;

    public Apadrinhamento(int id, Instant data_inicio, int duracao, int crianca_id, int necessidade_id, int usuario_id) {
        this.id = id;
        this.tempoInicio = data_inicio;
        this.duration = duracao;
        this.crianca_id = crianca_id;
        this.necessidade_id = necessidade_id;
        this.usuario_id = usuario_id;
    }

    public Apadrinhamento(int crianca_id, int necessidade_id, int usuario_id, int tempoDuracao) {
        this.tempoInicio = Instant.now(clock); 
        this.duration = tempoDuracao;
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

    public Instant getDataInicio() {
        return tempoInicio;
    }
    
    public int getDuracao(){
        return this.duration;
    }
    
    public String getTempoString() {

        // Converte o Instant para LocalDateTime usando a zona de fuso horário
        LocalDateTime dataAtual = LocalDateTime.ofInstant(tempoInicio, ZONA_SP);

        // Adiciona 3 meses à data atual
        LocalDateTime novaData = dataAtual.plusMonths(duration);

        // Converte a nova data de LocalDateTime para Instant
        Instant novaInstant = novaData.atZone(ZONA_SP).toInstant();
        
        
        return String.format("%s - %s (%d %s)", formatter.format(tempoInicio), formatter.format(novaInstant), this.duration, (this.duration > 1)? "meses": "mes");
    }


}
