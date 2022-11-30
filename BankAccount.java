import java.util.Random;
public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber = randomAccountNum();
    public static int createdAccounts = 0;
    public static double allMoneyInBank = 0.0;

    public BankAccount(){
        createdAccounts++;
    }

    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        createdAccounts++;
        allMoneyInBank += ( this.checkingBalance + this.savingsBalance);
    }

    public String randomNum(){
        Random rand = new Random();
        String numString = "123456789";
        char randomNum = numString.charAt(rand.nextInt(9));
        return String.valueOf(randomNum);
    }

    private String randomAccountNum(){
        String accountNum = "";
        for(int i = 1; i <=10; i++){
            accountNum = accountNum + randomNum();
        }
        setAccountNumber(accountNum);
        return getAccountNumber();
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public void setCheckingBalance(double amount){
        this.checkingBalance = amount;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public void setSavingsBalance(double amount){
        this.savingsBalance = amount;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void setAccountNumber(String number){
        this.accountNumber = number;
    }

    public void depositCash(double checkingsAmount, double savingsAmount){
        setCheckingBalance((this.checkingBalance + checkingsAmount));
        setSavingsBalance((this.savingsBalance + savingsAmount));
        allMoneyInBank += (checkingsAmount + savingsAmount);
    }

    public void withdrawCash(double checkingsAmount, double savingsAmount){
        if(checkingsAmount > getCheckingBalance() || savingsAmount > getSavingsBalance()){
            System.out.println("Transaction failed, insufficient funds.");
        }
        else{
            setCheckingBalance((getCheckingBalance() - checkingsAmount));
            setSavingsBalance((getSavingsBalance() - savingsAmount));
            allMoneyInBank =  allMoneyInBank - (getCheckingBalance()+ getSavingsBalance());
            System.out.println("Transaction successful");
        }
    }

    // public void withdrawSavings(double savingsAmount){
    //     if(savingsAmount > this.savingsBalance){
    //         System.out.println("Transaction failed, insufficient funds.");
    //     }
    //     else{
    //         setSavingsBalance((this.savingsBalance - savingsAmount));
    //         allMoneyInBank -= (this.savingsBalance);
    //         System.out.println("Transaction successful");
    //     }
    // }

    public String displayCash(){
        return "Checkings Balance: " + getCheckingBalance() + "\n" + "Savings Balance: " + getSavingsBalance();
    }
}
