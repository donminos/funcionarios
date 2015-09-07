/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.gob.jalisco.entity.DatosUsuario;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class DatosUsuarioFacade extends AbstractFacade<DatosUsuario> implements DatosUsuarioFacadeLocal {
    @PersistenceContext(unitName = "Funcionarios-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosUsuarioFacade() {
        super(DatosUsuario.class);
    }
    
}
