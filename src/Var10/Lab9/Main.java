package Var10.Lab9;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {


    static JFrame jFrame = getJFrame();
    //���������� ������� ��� ���������� ������
    static int numb_rows_panel = 2;

    //������� �������
    static JPanel jPanel = new JPanel(new GridLayout(numb_rows_panel, 2));
    static JPanel jPanel1 = new JPanel();

    //������� ���� ���
    static JMenuBar jMenuBar = new JMenuBar();

    //������� ��������� ������� ��� ���������� ������
    static JMenu jMenuFile = new JMenu("File");
    static JMenuItem jMenuItemNew = new JMenuItem("New");;
    static JMenuItem jMenuItemOpen = new JMenuItem("Open");
    static JMenuItem jMenuItemSave = new JMenuItem("Save");

    //���������� ��� �������� ���������� ������
    static Bank bank;

    //������� ������ ��������
    static JTabbedPane jTabbedPane = new JTabbedPane();

    public static void main(String[] args) {

        //�������� ����� ����������� ���������� ����
        start();

        //������� ��������� ��� ������� �������� ������ �����
        jMenuItemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��������� ����
                JTextField jTextField = new JTextField();

                //������ ���������
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Bank name: "),
                        jTextField
                };

                //�������� ������ ��� ����� ������
                int result = JOptionPane.showConfirmDialog(null, inputs, "Creating bank", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    //����� ������������ ����� ����
                    //������� ����� ���� � ����������� ��� ��������
                    bank = new Bank(jTextField.getText());
                    //������������� �������� ����
                    jFrame.setTitle(jTextField.getText());
                    //�������� ����� ����������� ��������� ������ �� ����. ����
                    show();
                }

            }
        });

        //������� ��������� ��� ������� "���������"
        jMenuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //������� ������� jFileChooser ��� ����������� ������ ���� � �����
                JFileChooser jFileChooser = new JFileChooser();

                //�������� ������ ����������
                int i = jFileChooser.showSaveDialog(null);
                if(i == JFileChooser.APPROVE_OPTION){
                    //���� ������������ ����� "��"
                    //�������� ���� ��������� ������������� � ���������� ��� � ���������� �������� � ����� ���������� �����
                    String filepath = jFileChooser.getSelectedFile().getPath() + ".xml";
                    //��������� ��� ���� ������� �����
                    saveBank(filepath,bank);
                }
            }
        });

        //������� ��������� ��� ������� "open"
        jMenuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ////������� ������� jFileChooser ��� ����������� ������ ����
                JFileChooser jFileChooser = new JFileChooser("C:\\Users\\dania\\IdeaProjects\\KATA\\src\\Labs\\Var2\\Lab9");
                //�������� ���������� ���� ��� �������� �����
                int i = jFileChooser.showOpenDialog(null);
                if(i == JFileChooser.APPROVE_OPTION){
                    //�������� ���� � �����
                    String filepath = jFileChooser.getSelectedFile().getPath() ;
                    //�������� ����� ������ � ���������� ���� ����������� ����� ����������
                    bank = getBank(filepath);
                    //������ ��������� ����
                    jFrame.setTitle(bank.getName());
                    show();
                }
            }
        });

    }




    //��� ����� ������ ��� ������������ �� ���� 6
    public static Bank getBank(String fileName) {
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fileName))){
            return (Bank) xmlDecoder.readObject();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void saveBank(String fileName, Bank saveBank){
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName))){
            xmlEncoder.writeObject(saveBank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //���� main �� ���������� ���� �������� � ���� �����
    static void show(){
        //������� ���� ���, ����� �������� �����������
        jMenuBar.removeAll();

        //����� ������� ��������� ��������, ��� ��� ���� ���� �������
        start();

        //����������� ������ � ����
        jFrame.add(jTabbedPane);
        //����������� ������� � ������
        jTabbedPane.add(jPanel, "ATM`s");
        jTabbedPane.add(jPanel1, "Info about account");

        //�������� ����� ����������� ������ �� �������
        setJPanelAccount(bank);
        //�������� ����� ����������� ������ � �����������
        setJPanelATM(bank);

        //����������� ���� ��� � ����
        jFrame.setJMenuBar(jMenuBar);

        //�������������� ����
        JMenu jMenu = new JMenu("Create");

        //������� ������� �������
        JMenuItem jMenuItem = new JMenuItem("Account");
        JMenuItem jMenuItem2 = new JMenuItem("ATM");

        //����������� ������� � ����
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        //����������� ���� � ���� ���
        jMenuBar.add(jMenu);

        //������� ��������� ��� �������
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //������� ��� ���� ��� ����� ������
                JTextField jTextField = new JTextField();
                JTextField jTextField1 = new JTextField();
                JTextField jTextField2 = new JTextField();

                //������� ����� ������ (�������������)
                JRadioButton jRadioButton = new JRadioButton("Usual");
                JRadioButton jRadioButton1 = new JRadioButton("Preferential");

                //���������� ������ � ������
                ButtonGroup buttonGroup = new ButtonGroup();
                buttonGroup.add(jRadioButton);
                buttonGroup.add(jRadioButton1);

                //���������� � ������ ��������� ��� �������� ����������� ����
                //� ����� ����������� ����
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("ID"),
                        jTextField,
                        new JLabel("Pin-code"),
                        jTextField1,
                        new JLabel("Balance"),
                        jTextField2,
                        new JLabel("Type"),
                        jRadioButton,
                        jRadioButton1
                };

                int result = JOptionPane.showConfirmDialog(null, inputs, "Creating account", JOptionPane.OK_CANCEL_OPTION);
                if(result ==0) {
                    if (jRadioButton.isSelected()) {
                        //���� ������ ������� ���� ������� ��������������� ����
                        //��������� � ����������� �������� �� ��������� �����
                        Account account =
                                new UsualAccount(jTextField.getText(),
                                        jTextField1.getText(),Integer.parseInt(jTextField2.getText()));

                        //��������� � ��� ���� ����� ����
                        bank.addAccount(account);

                    }else{

                        //���� ������ �������� ���� ������� ��������������� ����
                        //��������� � ����������� �������� �� ��������� �����

                        Account account = new PreferentialAccount(jTextField.getText(),
                                jTextField1.getText(),Integer.parseInt(jTextField2.getText()));


                        //��������� � ��� ���� ����� ����
                        bank.addAccount(account);
                    }

                    //�������� ����� ����������� ������ �� �������
                    setJPanelAccount(bank);
                    //�������� ����� ����������� ������ � �����������
                    setJPanelATM(bank);
                }
            }
        });

        //������� ��������� ��� �������
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //������� ��������� ���� �����
                JTextField jTextField = new JTextField();
                JTextField jTextField1 = new JTextField();

                //�������� ��� � ������ ��������� � �����������
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("ID"),
                        jTextField,
                        new JLabel("Address"),
                        jTextField1
                };

                //���������� ����������� ��������� �������� ���������� ����
                int result = JOptionPane.showConfirmDialog(null, inputs, "Creating ATM", JOptionPane.OK_CANCEL_OPTION);
                if(result == 0){

                    //������� ��������, ������� �������� ��������� �����, � �������� �� � �����������
                    ATM atm = new ATM(Integer.parseInt(jTextField.getText()), jTextField1.getText());

                    bank.addATM(atm);


                    //����� �������� ���� ������ ����� ���������� ����������
                    setJPanelAccount(bank);
                    setJPanelATM(bank);
                    //� ���������
                    jFrame.pack();
                }
            }
        });

    }

    //����� ��� ����������� ��������� ���������
    static void start(){
        //����������� ��������� ����� ���� ��� ����������� �������, ������� ��� ��������� ����
        jMenuFile.add(jMenuItemNew);
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.add(jMenuItemSave);
        jMenuBar.add(jMenuFile);
        jFrame.setJMenuBar(jMenuBar);
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



}


