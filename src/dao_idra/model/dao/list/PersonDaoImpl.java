package dao_idra.model.dao.list;

import dao_idra.model.Person;
import dao_idra.model.dao.PersonDao;
import dao_idra.utils.DaoException;
import java.util.ArrayList;
import java.util.List;

/*
Implementación de PersonDao para trabajar con listas porque es lo más simple

TO-DO: implementar métodos faltantes. Pensar cuáles son las causas que lanzarían DaoException
*/
public class PersonDaoImpl implements PersonDao {
    //contador global para asignar IDs únicos a las personas. Cada vez que se guarda una persona nueva, se incrementa.
    protected static long nextId = 1;
    
    //Lista de gente que simula el almacén de datos
    protected List<Person> gente;

    //Inicializa la lista vacia cuando se crea la instancia del DAO
    public PersonDaoImpl() {
        this.gente = new ArrayList();
    }

    @Override
    public List<Person> getByLastName(String ln) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Person data) throws DaoException {
        if (data.getId() != 0) { 
            throw new DaoException("Ya estaba guardada");
        }
        data.setId(nextId++); //Asigna un nuevo ID 
        this.gente.add(data); //Agrega la persona a la lista
    }

    @Override
    public void update(Person data) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void delete(Person data) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> getAll() throws DaoException {
        if (this.gente == null) {
            throw new DaoException("Lista no inicializada");
        }
        return this.gente;
    }

    @Override
    public Person getById(long id) throws DaoException {
        Person salida = null;

        for (Person p : this.gente) {
            if (p.getId() == id) {
                salida = p;
                break;
            }
        }
        if (salida == null) {
            throw new DaoException("Persona no encontrada con Id: " + id);
        }
        return salida;
    }

}
