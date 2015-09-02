/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.jalisco.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.jalisco.entity.Categorias;
import mx.gob.jalisco.facade.CategoriasFacadeLocal;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class CategoriasSession implements CategoriasSessionLocal {
    @EJB
    private CategoriasFacadeLocal categoriasFacade;

    @Override
    public void create(Categorias categorias) {
        categoriasFacade.create(categorias);
    }

    @Override
    public void edit(Categorias categorias) {
        categoriasFacade.edit(categorias);
    }

    @Override
    public void remove(Categorias categorias) {
        categoriasFacade.remove(categorias);
    }

    @Override
    public Categorias find(Object id) {
        return categoriasFacade.find(id);
    }

    @Override
    public List<Categorias> findAll() {
        return categoriasFacade.findAll();
    }

    @Override
    public List<Categorias> findRange(int[] range) {
        return categoriasFacade.findRange(range);
    }

    @Override
    public int count() {
        return categoriasFacade.count();
    }
}
