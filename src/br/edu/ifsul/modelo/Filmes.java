package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "filme")
public class Filmes implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_filme", sequenceName = "gen_filme_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_filme", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 50, message = "O nome não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
   
    @Length(max = 100, message = "O idioma não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O idioma deve ser informada")
    @Column(name = "idioma", length = 100, nullable = false)
    private String idioma;
    
    @Length(max = 20, message = "A duracao não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "A duracao deve ser informada")
    @Column(name = "duracao", length = 20, nullable = false)
    private String duracao;
       
    @NotNull(message = "A data de Nascimento deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false)
    private Calendar data_nascimento;
    
    @Length(max = 20, message = "O numero de discos não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O numero de discos deve ser informado")
    @Column(name = "num_discos", length = 20, nullable = false)
    private int num_discos;
    
    public Filmes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getNum_discos() {
        return num_discos;
    }

    public void setNum_discos(int num_discos) {
        this.num_discos = num_discos;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Filmes other = (Filmes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
