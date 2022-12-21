package Var10.Lab7;

//Расширяет класс Account
public class PreferentialAccount extends Account {


    //Конструктор по умолчанию
    public PreferentialAccount() {
    }

    //Конструктор с параметрами
    public PreferentialAccount(String number, String pin_code, int balance) {
        super(number, pin_code, balance);
    }

    //Реализация метода супер класса
    @Override
    public void Withdraw_from_the_account(int amount) {
        this.setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return "PreferentialAccount{" + "number='" + getNumber() + '\'' +
                ", pin_code='" + getPin_code() + '\'' +
                ", balance=" + getBalance() +
                "}";
    }
}
