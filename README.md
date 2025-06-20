 # 📘 DAO – Patrón Data Access Object

## 1. Descripción general

Este repositorio implementa el patrón **DAO (Data Access Object)**, una capa intermedia entre la lógica de negocio y la fuente de datos (como una base de datos). Su propósito es abstraer y encapsular el acceso a los datos, facilitando la separación de responsabilidades y haciendo que la aplicación sea más mantenible, escalable y testeable.

**Ventajas del patrón DAO:**

- Encapsula las operaciones de acceso a datos (CRUD).
- Facilita el cambio de tecnología de persistencia sin afectar la lógica de negocio.
- Mejora la organización y mantenibilidad del código.
- Permite testear la lógica de negocio sin necesidad de acceder a una base de datos real (mocking).

## 2. Estructura del proyecto (ejemplo)

- /src
- /dao → Clases DAO con métodos CRUD
- /models → Clases que representan entidades del dominio (POJOs o DTOs)
- /services → Lógica de negocio que utiliza los DAOs
- /db → Configuración de conexión a la base de datos
- /tests → Pruebas de unidades y de integración
- README.md

csharp
Copiar
Editar

## 3. ¿Qué es el patrón DAO?

Un **DAO (Data Access Object)** es una clase que gestiona el acceso a los datos para una entidad específica. Proporciona métodos estándar como:

- `insert()` – Crear un nuevo registro.
- `getById()` – Buscar un registro por su ID.
- `findAll()` – Obtener todos los registros.
- `update()` – Actualizar un registro existente.
- `delete()` – Eliminar un registro.

### Ejemplo conceptual (Java):

```java
public class UserDao {
    public User getById(int id);
    public List<User> findAll();
    public void insert(User user);
    public void update(User user);
    public void delete(int id);
}
```
Esta clase puede ejecutar sentencias SQL o usar un ORM, pero la capa superior de la aplicación no necesita saber cómo se acceden los datos, sólo usa los métodos definidos.

4. DAO vs Repository
Si bien ambos conceptos son similares, hay una pequeña diferencia:

Característica	DAO	Repository
Enfoque	Acceso a datos por entidad	Agregados del dominio (más de una entidad)
Lógica	CRUD simple	Puede incluir reglas de negocio
Abstracción	Técnica	Más cercana al dominio (DDD)

En aplicaciones simples, DAO y Repository se usan como sinónimos. En arquitecturas complejas (como DDD), Repository encapsula varios DAOs.

5. Cómo usar este repositorio
Clonar el proyecto:

bash
Copiar
Editar
git clone https://github.com/MatiBravo47/Dao.git
cd Dao
Abrir en tu IDE (por ejemplo, NetBeans o Visual Studio Code).

Modificar o extender los DAOs existentes según las entidades que manejes.

Agregar lógica de negocio en la capa services.

6. Agregar una nueva entidad con DAO
Crear una clase modelo en /models (por ejemplo Producto.java).

Crear una clase DAO en /dao (por ejemplo ProductoDao.java) con los métodos CRUD.

Usar el DAO desde la capa de servicio o desde el controlador.

Agregar pruebas si es necesario.

7. Testing
Si tu proyecto está preparado para pruebas automatizadas, podés ejecutarlas con:

bash
Copiar
Editar
# Comando ejemplo, depende del lenguaje
npm test
# o
pytest
# o en Java
mvn test
8. Contribuciones
¡Las contribuciones son bienvenidas!

Hacé un fork del repositorio.

Creá una nueva rama:

bash
Copiar
Editar
git checkout -b feature/nueva-entidad
Realizá tus cambios y subilos.

Abrí un Pull Request con una descripción clara.













Si cambias de base de datos (ej. SQLite a MySQL), solo necesitás modificar la capa db y las implementaciones de los DAOs.
 
 
