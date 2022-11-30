public class BankAccountTest{
    public static void main(String[] args){

        BankAccount bankAccount1 = new BankAccount(85.0, 200.50);
        BankAccount bankAccount2 = new BankAccount(800.0, 400.0);
        System.out.println(bankAccount1.displayCash());
        bankAccount1.depositCash(0.0, 50.0);
        System.out.println(bankAccount1.displayCash());
        System.out.println(BankAccount.createdAccounts);
        System.out.println(BankAccount.allMoneyInBank);
        bankAccount1.withdrawCash(40.0, 150.0);
        System.out.println(bankAccount1.displayCash());
        System.out.println(BankAccount.allMoneyInBank);
        // bankAccount1.withdrawSavings(150.0);
        // System.out.println(BankAccount.allMoneyInBank);
        System.out.println("account num " + bankAccount1.getAccountNumber());
    }
}
