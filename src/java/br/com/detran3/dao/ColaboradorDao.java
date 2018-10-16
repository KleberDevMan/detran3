/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran3.dao;

import br.com.detran3.model.Colaborador;
import br.com.detran3.model.Usuario;
import br.com.detran3.model.Veiculo;
import javax.persistence.EntityManager;

/**
 *
 * @author KLEBER
 */
public class ColaboradorDao{
    
    //busca um colaborador e o seu usuario
    public Colaborador getColaborador(Usuario usuario) {
        
//        EntityManager em = new JPAUtil().getEntityManager();
//
//        Colaborador result = null;
//        try {
//            result = (Colaborador) em.createQuery("Veiculo.findByPlacaRenavam", Veiculo.class)
//                    .setParameter("placa", placa).setParameter("renavam", renavam)
//                    .getSingleResult();
//        } catch (Exception e) {
//            System.out.println("erro: veiculo nao encontrado");
//        }
//
//        em.close();
//
//        return result;
        
        return null;
    }
    
}
