package Var10.Lab9;

//��������� ����� Account
public class PreferentialAccount extends Account {


    //����������� �� ���������
    public PreferentialAccount() {
    }

    //����������� � �����������
    public PreferentialAccount(String number, String pin_code, int balance) {
        super(number, pin_code, balance);
    }

    //���������� ������ ����� ������
    @Override
    public void Withdraw_from_the_account(int amount) {
        this.setBalance(getBalance() - amount);
    }
}
