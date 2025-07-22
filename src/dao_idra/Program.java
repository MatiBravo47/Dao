package dao_idra;

import dao_idra.model.Person;
import dao_idra.model.dao.PersonDao;
import dao_idra.model.dao.list.PersonDaoImpl; //A futuro se pueden cambiar la implementación a usar
import dao_idra.utils.DaoException;

public class Program {
    private static final System.Logger logger = System.getLogger(Program.class.getName());
    
    //Metodo helper para mostrar errores tanto en logger como en consola (para aprendizaje)
    
    private static void logError(String message, DaoException ex){
        //Logger profesional 
        logger.log(System.Logger.Level.ERROR, message, ex); //<-- Rojo
        
        //Tambien en consola para que veas el resultado(No profesional)
        //System.err.println("ERROR: " + message + " - " + ex.getMessage());
    }
    
    private static void logInfo(String message) {
        logger.log(System.Logger.Level.INFO, message); //<-- Gris
        
        //(No profesional)
        //System.out.println("INFO: "+ message); // <-- Negro normal
    }
    public static void main(String[] args) {
        
        //Quien hace las operaciones (dao.save(), dao.getAll(), dao.getById())
        PersonDao dao = new PersonDaoImpl(); //Se instancia contra una interfaz específica
        
        Person p = new Person();

        p.setFirstName("Esteban");
        p.setLastName("Santini");
        p.setDni(22334455L);

        try {
            logInfo("Guardar");
            dao.save(p);
            
            p = new Person();
            p.setFirstName("Laura");
            p.setLastName("Lerena");
            p.setDni(66554433L);
            dao.save(p);
            
            logInfo("Listar");
            for (Person q : dao.getAll()) {
                System.out.println(q);
            }
        } catch (DaoException ex) {
            logError("Error al guardar/listar personas", ex);
        }
        
        try {
            logInfo("Buscamos gente");
            System.out.println(dao.getById(1));
            System.out.println(dao.getById(10));
            System.out.println(dao.getById(0));
        } catch (DaoException ex) {
            logError("Error en busqueda", ex);
        }
        
        logInfo("Programa terminado con exito");
    }
}
