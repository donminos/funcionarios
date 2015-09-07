package mx.gob.jalisco.DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mx.gob.jalisco.entity.Usuarios;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class UsuariosDAO implements UsuariosDAOLocal{

    @PersistenceContext(unitName = "Funcionarios-ejb_1.0-SNAPSHOTPU")
    protected EntityManager entityManager;

    @Override
    public Usuarios findEmailUser(String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
        Root<Usuarios> from = criteriaQuery.from(Usuarios.class);
        Predicate condition = criteriaBuilder.equal(from.get("privilegeLevel"), 5);
        criteriaQuery.select(from).where(condition).orderBy(criteriaBuilder.asc(from.get("userId")));
        
        Usuarios result = entityManager.createQuery(criteriaQuery).getSingleResult();
        /*Query query = entityManager.createQuery("SELECT u FROM Usuarios u WHERE u.usuario = :usuario", Usuarios.class);
        query.setParameter("usuario", usuario.getUsuario());
        Usuarios u = (Usuarios) query.getSingleResult();*/
        return result;
    }
}
