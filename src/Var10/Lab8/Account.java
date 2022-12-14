package Var10.Lab8;

import java.io.Serializable;

// Абстрактный класс реализующий интерфейс serializable
public abstract class Account implements Serializable {

    //Приватные поля
    private String number;
    private String pin_code;
    private int balance;

    //Конструктор по умолчанию
    public Account() {
    }

    //Конструктор с параметрами
    public Account(String number, String pin_code, int balance) {
        this.number = number;
        this.pin_code = pin_code;
        this.balance = balance;
    }

    //Абстрактный класс "списание со счета", реализуется в подклассах usual и preferential account
    public abstract void Withdraw_from_the_account(int amount);


    //Геттеры и сеттеры

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    //Переопределяем метод toString для вывода счета в читабельном формате
    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", pin_code='" + pin_code + '\'' +
                ", balance=" + balance +
                '}';
    }
}

