package Var10.Lab8;

//Подкласс, который расширяет супер класс Account
public class UsualAccount extends Account {

    //Конструктор по умолчанию
    public UsualAccount() {
    }

    //Конструктор с параметрами
    public UsualAccount(String number, String pin_code, int balance) {
        super(number, pin_code, balance);
    }

    //Реализация метода супер класса
    @Override
    public void Withdraw_from_the_account(int amount) {
        this.setBalance(getBalance() - amount);
    }



}
