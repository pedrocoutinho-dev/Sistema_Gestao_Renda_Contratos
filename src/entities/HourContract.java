package entities;

import java.util.Date;

/**
 * Representa um contrato por hora de um trabalhador.
 * <p>
 * Contém os dados necessários para calcular o valor de um contrato isolado:
 * data de início, valor por hora e horas trabalhadas.
 */
public class HourContract {

    // 1. ATRIBUTOS (Dados Internos do Contrato)

    // Data de início do contrato (usando java.util.Date conforme o código)
    private Date date;

    // Valor recebido por cada hora de trabalho
    private Double valuePerHour;

    // Total de horas trabalhadas neste contrato
    private Integer hours;

    // 2. CONSTRUTORES

    /**
     * Construtor padrão (vazio).
     */
    public HourContract() {
    }

    /**
     * Construtor completo para inicializar um novo contrato.
     * @param date Data de início do contrato.
     * @param valuePerHour Valor por hora de trabalho.
     * @param hours Duração em horas do contrato.
     */
    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    // 3. GETTERS e SETTERS (Acesso Controlado)

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    // 4. REGRA DE NEGÓCIO (Metodo)

    /**
     * Calcula o valor total do contrato.
     * @return O valor total (valor por hora * horas).
     */
    public double totalValue() {
        // Regra de negócio simples: Preço por hora multiplicado pelas horas.
        return valuePerHour * hours;
    }
}