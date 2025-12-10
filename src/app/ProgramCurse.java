package app;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramCurse {
    public static void main(String[] args) throws ParseException {

        // Configura o idioma padrão para o ponto decimal (EUA: 10.50)
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Define o formato padrão para leitura e escrita de datas (DD/MM/YYYY)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // 1. DADOS DE ENTRADA DO TRABALHADOR E DEPARTAMENTO

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level: ");
        String workerLevel = sc.nextLine(); // A entrada do nível é uma String

        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        // 2. INSTANCIAÇÃO DOS OBJETOS

        // Cria o objeto Worker, fazendo a COMPOSIÇÃO:
        // 1. Converte a String lida para o ENUM WorkerLevel.
        // 2. Cria e associa um novo objeto Department ao Worker.
        Worker worker = new Worker(
                workerName,
                WorkerLevel.valueOf(workerLevel), // Conversão de String para ENUM
                baseSalary,
                new Department(departmentName)); // Cria o Department (Composição)

        // 3. REGISTRO DE CONTRATOS (Loop de Repetição)

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i + 1) +  " data:");


            System.out.print("Date (DD/MM/YYYY): ");
            // Lê a data como String e usa o SimpleDateFormat para convertê-la em objeto Date
            Date contractDate = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration(Hours): ");
            int hours = sc.nextInt();

            // Cria a instância do contrato
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);

            // Adiciona o contrato à lista interna do objeto Worker (Metodo addContract)
            worker.addContract(contract);
        }

        // 4. CÁLCULO DE RENDIMENTO (Income)

        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();

        // Extrai o mês (primeiros 2 caracteres) e o ano (após o separador '/')
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        // 5. EXIBIÇÃO DO RESULTADO FINAL

        System.out.println("Name: " + worker.getName());
        // Acessa o objeto Department que está DENTRO do objeto Worker para obter o nome
        System.out.println("Department: " + worker.getDepartment().getName());

        // Chama o metodo 'income' do objeto Worker, passando o ano e mês para o cálculo.
        // A lógica de soma dos contratos está encapsulada dentro do Worker.
        System.out.println("Income for " + monthAndYear + ": "
                + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}





