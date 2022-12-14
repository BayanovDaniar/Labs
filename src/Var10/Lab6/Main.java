package Var10.Lab6;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //�������� ����
        Bank bank = createBank();

        //����������� ��� ����
        //����� ��������� �� ���� ���� ��� ���������� ����� � ��������� ������
        saveBank("C:\\Users\\dania\\Desktop\\code\\Labs\\src\\Var10\\Lab6\\ReportLibrary.xml", bank);


        //�������������
        Bank bank1 = getBank("C:\\Users\\dania\\Desktop\\code\\Labs\\src\\Var10\\Lab6\\ReportLibrary.xml");

        System.out.println(bank1);


    }

    //�������� ���� �� �����
    public static Bank getBank(String fileName) {

        //���������� try � ��������� ��� ��������������� �������� ������
        //C ������� ������ xmldecoder ������������� ������, ��������� �� ���� ������� �������� �����
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fileName))){
            //��������� ������ � �������� ��� � ������ Bank
            //������ ���, ����� readObject ���������� Object
            return (Bank) xmlDecoder.readObject();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //����� � ������� �� ����������� ������
    public static void saveBank(String fileName, Bank saveBank){

        //����� ���������� try c ��������� ��� ��������������� ��������
        //����� xml encoder ��������� ��� ������������ ��������� �� ���� �������� �������� �����
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName))){
            // � ������� ������ writeObject ����������(�����������) ������
            xmlEncoder.writeObject(saveBank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //�������� ����� �������� � �����
    public static Bank createBank(){
        Bank bank = new Bank("Sberbank");

        ATM atm = new ATM(111, "Eliseeva, 12");
        ATM atm1 = new ATM(222, "Usova, 34");
        ATM atm2 = new ATM(333, "Komarova, 4");

        Account account = new UsualAccount("00001", "0000", 12345 );
        Account account1 = new UsualAccount("00002", "1111", 654 );
        Account account2 = new UsualAccount("00003", "2222", 2341 );
        Account account3 = new UsualAccount("00004", "3333", 10345);
        Account account4 = new UsualAccount("00005", "4444", 10554 );
        Account account5 = new UsualAccount("00006", "5555", 123432 );

        Account account6 = new PreferentialAccount("00007", "6666", 2343);
        Account account7 = new PreferentialAccount("00008", "7777", 34543);
        Account account8 = new PreferentialAccount("00009", "8888", 87843);
        Account account9 = new PreferentialAccount("00010", "9999", 5673);


        bank.addATM(atm);
        bank.addATM(atm1);
        bank.addATM(atm2);

        bank.addAccount(account);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);
        bank.addAccount(account5);
        bank.addAccount(account6);
        bank.addAccount(account7);
        bank.addAccount(account8);
        bank.addAccount(account9);

        return bank;
    }


}


