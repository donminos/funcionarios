/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.gob.jalisco.entity.DatosFuncionarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class DatosFuncionariosFacade extends AbstractFacade<DatosFuncionarios> implements DatosFuncionariosFacadeLocal {
    @PersistenceContext(unitName = "Funcionarios-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosFuncionariosFacade() {
        super(DatosFuncionarios.class);
    }
    
}
