package Var10.Lab8;

//��������, ������� ��������� ����� ����� Account
public class UsualAccount extends Account {

    //����������� �� ���������
    public UsualAccount() {
    }

    //����������� � �����������
    public UsualAccount(String number, String pin_code, int balance) {
        super(number, pin_code, balance);
    }

    //���������� ������ ����� ������
    @Override
    public void Withdraw_from_the_account(int amount) {
        this.setBalance(getBalance() - amount);
    }



}
