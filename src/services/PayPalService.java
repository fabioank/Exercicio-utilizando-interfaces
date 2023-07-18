package services;

public class PayPalService implements OnlinePaymentService{

    public double paymentFee(double amount){
        double valor = amount;
        valor += valor * 0.02;
        return valor;
    }
    public double interest(double amount, int months){
        double valor = amount;
        valor += valor * months/100;
        return valor;
    }

}
