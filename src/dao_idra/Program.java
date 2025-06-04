package dao_idra;

import dao_idra.model.Person;
import dao_idra.model.dao.PersonDao;
import dao_idra.model.dao.list.PersonDaoImpl; //A futuro se pueden cambiar la implementación a usar
import dao_idra.utils.DaoException;

public class Program {

    public static void main(String[] args) {
        PersonDao dao = new PersonDaoImpl(); //Se instancia contra una interfaz específica
        Person p = new Person();

        p.setFirstName("Esteban");
        p.setLastName("Santini");
        p.setDni(22334455L);

        try {
            System.out.println("Guardar");
            //System.out.println(p);
            dao.save(p);
            p = new Person();
            p.setFirstName("Laura");
            p.setLastName("Lerena");
            p.setDni(66554433L);
            dao.save(p);
            //System.out.println(p);
            System.out.println("Listar");
            for (Person q : dao.getAll()) {
                System.out.println(q);
            }
        } catch (DaoException ex) {
            System.getLogger(Program.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try {
            System.out.println("Buscamos gente");
            System.out.println(dao.getById(1));
            System.out.println(dao.getById(10));
            System.out.println(dao.getById(0));
        } catch (DaoException ex) {
            System.getLogger(Program.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        System.out.println("Programa terminado con exito");
    }

}
