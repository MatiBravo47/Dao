package dao_idra.utils;

import java.util.List;

/*
Interfaz DAO con los métodos básicos del CRUD
Todos los métodos pueden lanzar una excepción por alguna causa
*/
public interface Dao<T> {
    public abstract void save(T data) throws DaoException;
    public abstract void update(T data) throws DaoException;
    public abstract void delete(T data) throws DaoException;
    //public abstract void delete(long id) throws DaoException; //Este método sobrecargado es un ejemplo
    public abstract List<T> getAll() throws DaoException;
    public abstract T getById(long id) throws DaoException;
}
