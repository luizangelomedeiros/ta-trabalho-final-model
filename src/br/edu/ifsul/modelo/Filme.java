package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "filme")
public class Filme implements Serializable {

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
       
    @NotNull(message = "A data de Lançamento deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_lancamento", nullable = false)
    private Calendar data_lancamento;
    
    @Length(max = 20, message = "O numero de discos não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O numero de discos deve ser informado")
    @Column(name = "num_discos", length = 20, nullable = false)
    private String num_discos;
    
    @OneToMany(mappedBy = "filme",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Genero> generos = new ArrayList<>();
    
    public Filme() {
    }
    
    public void adicionarGenero(Genero obj){
        obj.setFilme(this);
        this.generos.add(obj);
    }
    
    public void removerGenero(int index){
        this.generos.remove(index);
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

    public Calendar getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Calendar data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
    
    public String getNum_discos() {
        return num_discos;
    }

    public void setNum_discos(String num_discos) {
        this.num_discos = num_discos;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
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
        final Filme other = (Filme) obj;
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
