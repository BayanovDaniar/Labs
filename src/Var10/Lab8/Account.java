package Var10.Lab8;

import java.io.Serializable;

// ����������� ����� ����������� ��������� serializable
public abstract class Account implements Serializable {

    //��������� ����
    private String number;
    private String pin_code;
    private int balance;

    //����������� �� ���������
    public Account() {
    }

    //����������� � �����������
    public Account(String number, String pin_code, int balance) {
        this.number = number;
        this.pin_code = pin_code;
        this.balance = balance;
    }

    //����������� ����� "�������� �� �����", ����������� � ���������� usual � preferential account
    public abstract void Withdraw_from_the_account(int amount);


    //������� � �������

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


    //�������������� ����� toString ��� ������ ����� � ����������� �������
    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", pin_code='" + pin_code + '\'' +
                ", balance=" + balance +
                '}';
    }
}

