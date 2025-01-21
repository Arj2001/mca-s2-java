class BankAccount{

    double calculateInterest(int principal, double rate){
        return ((double)principal*rate)/100;
    }

    double calculateInterest(int principal, double rate, int time){
        return ((double)principal*rate*time)/100;
    }

    double calculateInterest(){
        return 0;
    }
}
public class OverloadingBank {

    public static void main(String[] args){

        BankAccount b = new BankAccount();
        System.out.println("Interest for savings :"+ b.calculateInterest(1000, 7.89));
        System.out.println("Interest for fixed :"+ b.calculateInterest(5000, 10, 3));
        System.out.println("Interest for savings :"+ b.calculateInterest());
    }
    
}
