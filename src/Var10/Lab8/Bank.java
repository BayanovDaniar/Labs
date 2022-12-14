package Var10.Lab8;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//����� ������������� (���������) ��������� serializable
public class Bank implements Serializable {
    private String name;

    //���� ����������
    private List<ATM> atmList = new ArrayList<>();

    //���� ������
    private List<Account> accountList = new ArrayList<>();


    //����������� � �����������
    public Bank(String name) {
        this.name = name;
    }

    //����������� �� ��������� ���������
    public Bank() {
    }

    //���������� ��������� � ������
    public void addATM(ATM atm){
        atmList.add(atm);
    }

    //���������� ����� � ������
    public void addAccount(Account account){
        accountList.add(account);
    }


    //������� � �������


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


    //�������������� ����� toString ��� ������ ����� � ����������� �������
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", atmList=" + atmList +
                ", accountList=" + accountList +
                '}';
    }
}
