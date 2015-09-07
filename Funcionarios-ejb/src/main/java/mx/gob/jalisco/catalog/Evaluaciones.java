
package mx.gob.jalisco.catalog;

/**
 *
 * @author Carlos Cesar Rosas
 */
public enum Evaluaciones {
        SINREVISAR((short)1),
        ACEPTADO((short)2),
        RECHAZADO((short)3);
        private short value; // Variable interna donde almacenaremos

        // Nuestro constructor nos fuerza a pasar parámetros al definir un nuevo tipo
        Evaluaciones(short value) {
            this.value = value;
        }
        // Devuelve la capacidad del vaso
        public short getDato() {
            return value;
        }
}
