package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {
    
    @NotNull(message = "O Cinema deve ser informado")
    @OneToOne
    @JoinColumn(name = "idcinema", referencedColumnName = "id", nullable = false)
    private Cinema idcinema;
    
    @NotBlank(message = "O Usuario deve ser informado")
    @Length(max = 50, message="O Usuario não deve possuir mais de {max} caracteres")
    @Column(name = "usuario",length = 50,nullable = false)       
    private String usuario;    
           
    @NotBlank(message = "A Senha deve ser informado")
    @Length(max = 50, message="A Senha não deve possuir mais de {max} caracteres")
    @Column(name = "senha",length = 50,nullable = false)       
    private String senha;    
           
    @Column(name = "ativo")       
    private Boolean ativo;    
                  
    @NotNull(message = "O Salario deve ser informado")
    @Column(name = "salario",nullable = false, columnDefinition = "decimal(12,2)")       
    private Double salario; 
    
    public Funcionario() {
    }

    public Cinema getIdcinema() {
        return idcinema;
    }

    public void setIdcinema(Cinema idcinema) {
        this.idcinema = idcinema;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
      
}
