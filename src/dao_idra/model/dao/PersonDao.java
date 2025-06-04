package dao_idra.model.dao;

import dao_idra.model.Person;
import dao_idra.utils.Dao;
import dao_idra.utils.DaoException;
import java.util.List;

/*
Extender el DAO para una Entidad específica nos permite crear métodos para cosas de esa entidad
*/
public interface PersonDao extends Dao<Person> {
    public abstract List<Person> getByLastName(String ln) throws DaoException;
}
