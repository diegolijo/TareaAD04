package Tablas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "email")
    private String email;

    public Cliente( String nome, String apellidos, String email) {
        this.nome = nome;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Cliente() {

    }
    
     @Override
    public String toString() {
        String tenda = "(" + this.id  + ") " + this.nome  + " " + this.apellidos+ " " + this.email ;
        return tenda;
    }

    public String getName() {
        return this.nome +" "+ this.apellidos;
    }

    

}
