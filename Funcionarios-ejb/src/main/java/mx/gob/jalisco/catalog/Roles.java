
package mx.gob.jalisco.catalog;

/**
 *
 * @author Carlos Cesar Rosas
 */
public enum Roles {
        ADMINISTRADOR(1),
        FUNCIONARIO(2),
        USUARIO(3);
        private Integer value; // Variable interna donde almacenaremos

        // Nuestro constructor nos fuerza a pasar parámetros al definir un nuevo tipo
        Roles(Integer value) {
            this.value = value;
        }
        // Devuelve la capacidad del vaso
        public Integer getDato() {
            return value;
        }
}
