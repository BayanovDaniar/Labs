package Var10.Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    static JFrame jFrame = getJFrame();
    //���������� ������� ��� ���������� ������
    static int numb_rows_panel = 2;

    //������� �������
    static JPanel jPanel = new JPanel(new GridLayout(numb_rows_panel, 2));
    static JPanel jPanel1 = new JPanel();


    public static void main(String[] args) {
        //�������� ����
        Bank bank = createBank();

        //������� ������ ��������
        JTabbedPane jTabbedPane = new JTabbedPane();
        //����������� ������ � ����
        jFrame.add(jTabbedPane);
        //����������� ������� � ������
        jTabbedPane.add(jPanel, "ATM`s");
        jTabbedPane.add(jPanel1, "Info about account");

        //�������� ����� ����������� ������ �� �������
        setJPanelAccount(bank);
        //�������� ����� ����������� ������ � �����������
        setJPanelATM(bank);


        //���������
        jFrame.pack();
    }



    //����� ������� � ����������� � ������
    static void setJPanelAccount(Bank bank){
        //������� �� ����������, ����� �� ������������
        jPanel1.removeAll();


        //������� ���� ������� ��� �������� � jlist
        DefaultListModel<Account> defaultListModel = new DefaultListModel<>();
        //�������� ���� ������ ������
        defaultListModel.addAll(bank.getAccountList());

        //������� Jlist (������) ��� ������ �� ������
        JList<Account> jList = new JList<>(defaultListModel);
        //��������� ������ �� ������
        jPanel1.add(jList);

        //������� ������ ����� �� �����
        JButton jButton = new JButton("Withdraw");

        //������� ��������� ��� ������
        //��� ��������� ��������� � ��������� ������
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //�������� ��������� ������������� ���� �� ������
                Account account = jList.getSelectedValue();

                //������� ��������� ���� �����
                JTextField jTextField = new JTextField();

                //���������� � ������ ��������� ��� �������� ����������� ����
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Enter the debit amount"),
                        jTextField
                };

                //������� ���������� ����
                int result = JOptionPane.showConfirmDialog(null, inputs, "Withdrawing", JOptionPane.OK_CANCEL_OPTION);

                //��������� ��������� ������ ��������� ����
                if(result == 0){
                    //�������� �������������� ����� ��� �����
                    account.Withdraw_from_the_account(Integer.parseInt(jTextField.getText()));
                }

            }
        });

        //��������� ������ �� ������
        jPanel1.add(jButton);
        jFrame.pack();

    }

    //����� ������� � ����������� � ����������
    static void setJPanelATM(Bank bank) {
        //������� ������
        jPanel.removeAll();

        //�������� ����������, ���������� �� ���������� �� ������
        numb_rows_panel = bank.getAtmList().size();
        //������������� �����
        jPanel.setLayout(new GridLayout(numb_rows_panel, 2));


        for (ATM atm : bank.getAtmList()) {
            //������� ������� (�����) � ������� ���������
            JLabel jLabel = new JLabel(String.valueOf(atm.getID()));

            //������� ���� � ������� ���������
            JTextField jTextField = new JTextField(atm.getAddress());
            jPanel.add(jLabel);
            jPanel.add(jTextField);
        }
    }

    //��������� ������(������� �������)
    private static JFrame getJFrame() {
        //�������� ������
        JFrame jFrame = new JFrame() {};
        //������ ��� �������
        jFrame.setVisible(true);
        //������� ����������� ������� ����
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //�������� ����������� ����������� ��� ������ � �������(�����������)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //�������� ���������� ������
        Dimension dimension = toolkit.getScreenSize();
        //������������� ������� ����
        jFrame.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 500);
        //������ �������� ����
        jFrame.setTitle("My app");
        return jFrame;
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


