package Var10.Lab7;

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

    @Override
    public String toString() {
        return "PreferentialAccount{" + "number='" + getNumber() + '\'' +
                ", pin_code='" + getPin_code() + '\'' +
                ", balance=" + getBalance() +
                "}";
    }
}
