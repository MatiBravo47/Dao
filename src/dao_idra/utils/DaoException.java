package dao_idra.utils;

/*
Excepción específica para cuestiones de DAO
*/
public class DaoException extends Exception {
    public DaoException(String msg) {
        super(msg);
    }
}
