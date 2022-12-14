package Var10.Lab8;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Класс имлементирует (реализует) интерфейс serializable
public class Bank implements Serializable {
    private String name;

    //Лист Банкоматов
    private List<ATM> atmList = new ArrayList<>();

    //Лист Счетов
    private List<Account> accountList = new ArrayList<>();


    //Конструктор с параметрами
    public Bank(String name) {
        this.name = name;
    }

    //Конструктор по умолчанию публичный
    public Bank() {
    }

    //Добавление банкомата в список
    public void addATM(ATM atm){
        atmList.add(atm);
    }

    //Добавление счета в список
    public void addAccount(Account account){
        accountList.add(account);
    }


    //Геттеры и сеттеры


    public List<ATM> getAtmList() {
        return atmList;
    }

    public void setAtmList(List<ATM> atmList) {
        this.atmList = atmList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Переопределяем метод toString для вывода банка в читабельном формате
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", atmList=" + atmList +
                ", accountList=" + accountList +
                '}';
    }
}
