/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.Local;
import mx.gob.jalisco.entity.Categorias;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Local
public interface CategoriasSessionLocal {

    public void create(Categorias categorias);

    public void edit(Categorias categorias);

    public void remove(Categorias categorias);

    public Categorias find(Object id);

    public List<Categorias> findAll();

    public List<Categorias> findRange(int[] range);

    public int count();
}
