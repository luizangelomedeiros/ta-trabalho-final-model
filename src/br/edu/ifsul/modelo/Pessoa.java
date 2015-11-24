
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class Pessoa implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message="O nome não deve possuir mais de {max} caracteres")
    @Column(name = "nome",length = 50,nullable = false)
    private String nome;
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 50, message="O endereço não deve possuir mais de {max} caracteres")
    @Column(name = "endereco",length = 50,nullable = false)    
    private String endereco;
    @Email(message = "O email deve ser válido")
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 50, message="O email não deve possuir mais de {max} caracteres")
    @Column(name = "email",length = 50,nullable = false)    
    private String email;
    @NotBlank(message = "O bairro deve ser informado")
    @Length(max = 30, message="O bairro não deve possuir mais de {max} caracteres")
    @Column(name = "bairro",length = 30,nullable = false)    
    private String bairro;
    @NotBlank(message = "O cep deve ser informado")
    @Length(max = 9, message="O cep não deve possuir mais de {max} caracteres")
    @Column(name = "cep",length = 9,nullable = false)    
    private String cep;
    @NotBlank(message = "O complemento deve ser informado")
    @Length(max = 50, message="O complemento não deve possuir mais de {max} caracteres")
    @Column(name = "complemento",length = 50,nullable = false)    
    private String complemento;
    @NotNull(message = "O cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade",referencedColumnName = "id",nullable = false)
    private Cidade cidade;
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Telefone> telefones = new ArrayList<>();

    public Pessoa() {
    }
    
    public void adicionarTelefone(Telefone obj){
        obj.setPessoa(this);
        telefones.add(obj);
    }
    
    public void removerTelefone(int index){
        telefones.remove(index);
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nome ;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    
    
}
