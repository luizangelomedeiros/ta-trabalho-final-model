package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_sessao", sequenceName = "sen_sessao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_sessao", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A data do filme deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @Length(max = 50, message = "A Hora não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "A hora deve ser informado")
    @Column(name = "hora", length = 50, nullable = false)
    private String hora;
    
    @NotNull(message = "O Valor do Ingresso inteiro deve ser informado")
    @Column(name = "valorInteiro",nullable = false, columnDefinition = "decimal(12,2)")       
    private Double valorInteiro; 
    
    @NotNull(message = "O Valor do Ingresso Meia deve ser informado")
    @Column(name = "valorMeia",nullable = false, columnDefinition = "decimal(12,2)")       
    private Double valorMeia; 
             
    @Length(max = 50, message = "O numero da Sala não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O numero da Sala deve ser informado")
    @Column(name = "numSala", length = 50, nullable = false)
    private String numSala;
    
    @NotNull(message = "O Cinema deve ser informado")
    @OneToOne
    @JoinColumn(name = "cinema", referencedColumnName = "id", nullable = false)
    private Cinema cinema;
    
    @ManyToOne
    @JoinColumn(name = "filme", referencedColumnName = "id")
    private Filme filme;
    
        
    public Sessao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getValorInteiro() {
        return valorInteiro;
    }

    public void setValorInteiro(Double valorInteiro) {
        this.valorInteiro = valorInteiro;
    }

    public Double getValorMeia() {
        return valorMeia;
    }

    public void setValorMeia(Double valorMeia) {
        this.valorMeia = valorMeia;
    }

    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessao other = (Sessao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sessao{" + "filme=" + filme + '}';
    }
       
}
