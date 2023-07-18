package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PayPalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Numero: ");
        int numero = scan.nextInt();
        scan.nextLine();
        System.out.print("Data (dd/mm/yyyy): ");
        LocalDate date = LocalDate.parse(scan.next(), fmt);
        System.out.print("Valor do contrato: ");
        double valor = scan.nextDouble();
        System.out.print("Numero de parcelas: ");
        int numeroParcelas = scan.nextInt();
        scan.nextLine();
        Contract contract = new Contract(numero, date, valor);
        ContractService service = new ContractService(new PayPalService());
        service.processContract(contract, numeroParcelas);

        System.out.println("Parcelas: ");
        for(Installment i: contract.getInstallments()){
            System.out.println(i);
        }
    }
}
