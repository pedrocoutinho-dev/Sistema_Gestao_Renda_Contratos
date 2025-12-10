package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

/**
 * Representa a entidade principal do sistema: o Trabalhador (Worker).
 * <p>
 * O Worker gerencia seus dados pessoais, seu Departamento (Composição)
 * e a lista de seus contratos (Associação Um-para-Muitos).
 */
public class Worker {

    // 1. ATRIBUTOS BÁSICOS
    private String name;
    private WorkerLevel level; // Usa a enumeração WorkerLevel para garantir valores fixos
    private Double baseSalary;

    // 2. ATRIBUTOS DE COMPOSIÇÃO E ASSOCIAÇÃO

    // Composição (Associação 1 para 1): O Worker pertence a um Departamento.
    private Department department;

    // Associação (Associação 1 para N): Um Worker pode ter muitos contratos.
    // Inicialização imediata da lista para evitar NullPointerException.
    private List<HourContract> contracts = new ArrayList<>();

    // 3. CONSTRUTORES

    /**
     * Construtor padrão (vazio).
     */
    public Worker() {
    }

    /**
     * Construtor principal para inicializar um novo Trabalhador.
     * @param name Nome do trabalhador.
     * @param level Nível do trabalhador (ENUM).
     * @param baseSalary Salário base mensal.
     * @param department Objeto Department ao qual o trabalhador pertence.
     */
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    // 4. GETTERS E SETTERS (Métodos de acesso e mutação)
    // ... (Getters e Setters para name, level, baseSalary, department) ...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Retorna a lista de contratos (usada para leitura/iteração).
     * Nota: O 'setter' não é fornecido para proteger a lista de ser substituída totalmente.
     * @return Lista de HourContract.
     */
    public List<HourContract> getContracts() {
        return contracts;
    }

    // 5. MÉTODOS PARA GERENCIAR A LISTA DE CONTRATOS (Associação)

    /**
     * Adiciona um contrato à lista de contratos do trabalhador.
     * @param contract O objeto HourContract a ser adicionado.
     */
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    /**
     * Remove um contrato específico da lista de contratos do trabalhador.
     * @param contract O objeto HourContract a ser removido.
     */
    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    // 6. REGRA DE NEGÓCIO PRINCIPAL (Cálculo de Rendimento)

    /**
     * Calcula o rendimento total (income) do trabalhador para um determinado mês e ano.
     * O rendimento é o Salário Base mais a soma dos contratos concluídos no mês e ano especificados.
     * @param year Ano para o cálculo (ex: 2024).
     * @param month Mês para o cálculo (ex: 1 a 12).
     * @return O rendimento total (Salário Base + Contratos válidos).
     */
    public double income(int year, int month) {

        // Inicializa a soma com o Salário Base, pois ele é sempre pago.
        double sum = baseSalary;

        // Classe auxiliar (legada) para extrair o ano e mês de um objeto Date.
        Calendar cal = Calendar.getInstance();

        // Itera sobre todos os contratos para verificar quais se aplicam.
        for (HourContract c : contracts) {

            cal.setTime(c.getDate());

            // Extrai o ano e o mês do contrato atual.
            int c_year = cal.get(Calendar.YEAR);
            // O Calendar.MONTH retorna 0 para Janeiro, então somamos 1.
            int c_month = 1 + cal.get(Calendar.MONTH);

            // Verifica se o contrato pertence ao mês e ano solicitados
            if (year == c_year && month == c_month) {
                // Se sim, DELEGA o cálculo do valor total ao objeto HourContract.
                sum += c.totalValue();
            }
        }
        return sum;
    }
}