package entities;

/**
 * Representa a entidade Departamento.
 * <p>
 * Esta é uma classe simples (Value Object) que armazena o nome do departamento
 * e será referenciada pelo objeto Worker (Composição).
 */

public class Department {


    // 1. ATRIBUTOS (Dados Internos)

    // O nome do departamento é privado, seguindo o princípio de Encapsulamento.
    private String name;

    // 2. CONSTRUTORES

    /**
     * Construtor padrão (vazio).
     * Necessário para frameworks de desserialização (ex: JSON/JPA), mas opcional aqui.
     */
    public Department() {
    }

    /**
     * Construtor que recebe o nome do departamento como argumento.
     * @param name Nome do departamento.
     */
    public Department(String name) {
        this.name = name;
    }


    // 3. GETTERS e SETTERS (Acesso Controlado)

    /**
     * Retorna o nome do departamento.
     * @return O nome do departamento.
     */
    public String getName() {
        return name;
    }

    /**
     * Define ou atualiza o nome do departamento.
     * @param name O novo nome do departamento.
     */
    public void setName(String name) {
        this.name = name;
    }
}
