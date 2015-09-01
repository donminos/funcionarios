/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.facade;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.DatosFuncionarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface DatosFuncionariosFacadeLocal {

    void create(DatosFuncionarios datosFuncionarios);

    void edit(DatosFuncionarios datosFuncionarios);

    void remove(DatosFuncionarios datosFuncionarios);

    DatosFuncionarios find(Object id);

    List<DatosFuncionarios> findAll();

    List<DatosFuncionarios> findRange(int[] range);

    int count();
    
}
