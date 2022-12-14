package Var10.Lab6;

import java.io.Serializable;

//��������� ��������� serializable, ���������� ��� ������������.
public class ATM implements Serializable {

    //��������� ����
    private int ID;
    private String address;

    //����������� �� ���������
    public ATM() {
    }

    //����������� � �����������
    public ATM(int ID, String address) {
        this.ID = ID;
        this.address = address;
    }

    //������� � �������

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //�������������� ����� toString ��� ������ ��������� � ����������� �������
    @Override
    public String toString() {
        return "ATM{" +
                "ID=" + ID +
                ", address='" + address + '\'' +
                '}';
    }
}

