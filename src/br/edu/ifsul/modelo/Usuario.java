
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
@Table(name = "cliente")
public abstract class Usuario implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)   
    private Integer id;
    
    @NotNull(message = "O Cliente deve ser informado")
    @OneToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "id", nullable = false)
    private Cliente idcliente;
    
    @NotBlank(message = "O Usuario deve ser informado")
    @Length(max = 50, message="O Usuario não deve possuir mais de {max} caracteres")
    @Column(name = "usuario",length = 50,nullable = false)       
    private String usuario;    
           
    @NotBlank(message = "A Senha deve ser informado")
    @Length(max = 50, message="A Senha não deve possuir mais de {max} caracteres")
    @Column(name = "senha",length = 50,nullable = false)       
    private String senha;    
       
    public Usuario() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuario ;
    }

}
