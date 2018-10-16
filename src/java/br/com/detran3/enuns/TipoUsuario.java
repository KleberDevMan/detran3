/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran3.enuns;

/**
 *
 * @author KLEBER
 */
public enum TipoUsuario {
    ADM("ADM", "Administrador"), 
    COLABORADOR("COLABORADOR", "Colaborador");
    
    private String descricao;
    private String codigo;

    private TipoUsuario(String codigo, String label) {
        this.codigo = codigo;
        this.descricao = label;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return getCodigo();
    }
    
}
