package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cinema")
public class Cinema implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_cinema", sequenceName = "gen_cinema_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_cinema", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 100, message = "O Endereço não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O Endereço deve ser informado")
    @Column(name = "endereco", length = 100, nullable = false)
    private String endereco;
    
    @Length(max = 50, message = "O Horário de funcionamento não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O Horário de funcionamento deve ser informado")
    @Column(name = "horarioFunc", length = 50, nullable = false)
    private String horarioFunc;
    
    @NotNull(message = "A Quantidade de salas deve ser informado")
    @Column(name = "qtdSalas", nullable = false)
    private Integer qtdSalas;
   
    @NotNull(message = "A Capacidade total de clientes deve ser informado")
    @Column(name = "capacidadeTotal", nullable = false)
    private Integer capacidadeTotal;
   
    @NotNull(message = "A Quantidade de funcionários deve ser informado")
    @Column(name = "qtdFuncionarios",nullable = false)
    private Integer qtdFuncionarios;
    
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade",referencedColumnName = "id",nullable = false)
    private Cidade cidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorarioFunc() {
        return horarioFunc;
    }

    public void setHorarioFunc(String horarioFunc) {
        this.horarioFunc = horarioFunc;
    }

    public Integer getQtdSalas() {
        return qtdSalas;
    }

    public void setQtdSalas(Integer qtdSalas) {
        this.qtdSalas = qtdSalas;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public Integer getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(Integer qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Cinema other = (Cinema) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true; 
    }

    @Override
    public String toString() {
        return "Cinema{" + "id=" + id + ", endereco=" + endereco + ", horarioFunc=" + horarioFunc + ", qtdSalas=" + qtdSalas + ", capacidadeTotal=" + capacidadeTotal + ", qtdFuncionarios=" + qtdFuncionarios + ", cidade=" + cidade + '}';
    }
}
