package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){

        double quota = contract.getTotalValue() / months;

        for(int i = 1; i <= months; i ++){

            LocalDate dueDate = contract.getDate().plusMonths(i);

            double value = onlinePaymentService.interest(quota, i);
            double value1 = onlinePaymentService.paymentFee(value);
            contract.getInstallments().add(new Installment(dueDate, value1));
        }
    }
}
