package entities.enums;

/**
 * Define os possíveis níveis de um trabalhador.
 * <p>
 * O uso de ENUM garante que o nível seja sempre um valor constante e válido
 * (JUNIOR, MID_LEVEL, SENIOR), garantindo a integridade dos dados na aplicação.
 */

public enum WorkerLevel {

    /** Nível inicial de experiência. */
    JUNIOR,

    /** Nível intermediário de experiência. */
    MID_LEVEL,

    /** Nível avançado de experiência. */
    SENIOR;

}
