package br.com.detran3.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Kleber
 */
@Entity
class Role {
    
    @Id
    private String nome;

    @Deprecated
    public Role() {
    }
    
    public Role(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
