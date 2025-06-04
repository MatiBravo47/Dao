package dao_idra.model;

/*
Una clase del Modelo que se puede persistir se llama Entidad.
Las entidades necesitan un ID

TO-DO: completar equals y revisar toString
*/
public class Person {
    protected long id;
    protected String firstName;
    protected String lastName;
    protected long Dni;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String last) {
        this.lastName = last;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setDni(long dni) {
        this.Dni = dni;
    }

    public long getDni() {
        return this.Dni;
    }

    @Override
    public String toString() {
        return "Person{ id: " + this.id + ", firstName: " + this.firstName
                + ", lastName: " + this.lastName + ", Dni: " + this.Dni + "}";

    }
}
