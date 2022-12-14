package Var10.Lab6;

import java.io.Serializable;

//Реализует интерфейс serializable, необходимо для сериализации.
public class ATM implements Serializable {

    //Приватные поля
    private int ID;
    private String address;

    //Конструктор по умолчанию
    public ATM() {
    }

    //Конструктор с параметрами
    public ATM(int ID, String address) {
        this.ID = ID;
        this.address = address;
    }

    //Геттеры и сеттеры

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

    //Переопределяем метод toString для вывода банкомата в читабельном формате
    @Override
    public String toString() {
        return "ATM{" +
                "ID=" + ID +
                ", address='" + address + '\'' +
                '}';
    }
}

